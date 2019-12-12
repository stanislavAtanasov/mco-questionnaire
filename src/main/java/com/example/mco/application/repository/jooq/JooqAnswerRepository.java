package com.example.mco.application.repository.jooq;

import com.example.mco.core.model.Answer;
import com.example.mco.core.repository.AnswerRepository;
import com.example.mco.db.Tables;
import com.example.mco.db.tables.records.AnswerRecord;
import lombok.extern.slf4j.Slf4j;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.tools.StringUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Slf4j
@Repository
public class JooqAnswerRepository implements AnswerRepository {

    private final DSLContext create;

    public JooqAnswerRepository(DSLContext create) {
        this.create = create;
    }

    @Override
    public Optional<Answer> getByMail(String mail) {

        if (StringUtils.isBlank(mail)) {
            log.debug("Skipping answer.getByMail. Reason: mail  is Blank.");
            return Optional.empty();
        }
        log.debug("Getting answer with mail: {}  ", mail);
        Optional<Answer> answer = create
                .select(Tables.ANSWER.fields())
                .from(Tables.ANSWER)
                .where(Tables.ANSWER.MAIL.eq(mail))
                .fetchOptionalInto(Answer.class);
        return answer;
    }

    @Override
    @Transactional
    public int create(Answer model) {
        if (Objects.isNull(model)) {
            log.debug("Skipping create answer is null.");
            return 0;
        }
        AnswerRecord record = create.newRecord(Tables.ANSWER, model);
        return record.store();
    }

    @Override
    public int update(Answer model) {
        if (Objects.isNull(model)) {
            log.debug("Skipping update answer is null.");
            return 0;
        }
        if (Objects.isNull(model.getId())) {
            log.debug("Skipping update answer. Reason: id is null.");
            return 0;
        }
        if (StringUtils.isBlank(model.getMail())) {
            log.debug("Skipping update answer. Reason: Mail is null.");
            return 0;
        }

        AnswerRecord record = create.newRecord(Tables.ANSWER, model);
        record.setLastUpdated(LocalDateTime.now());
        return record.update();
    }

    @Override
    public List<Answer> getAllAnswers() {
        return create.select(Tables.ANSWER.fields())
                .from(Tables.ANSWER)
                .fetchInto(Answer.class);
    }

    @Override
    public int deleteByMail(String mail) {
        return create.delete(Tables.ANSWER).where(Tables.ANSWER.MAIL.eq(mail)).execute();
    }
}
