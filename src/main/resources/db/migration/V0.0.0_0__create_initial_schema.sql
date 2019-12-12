
  CREATE TABLE IF NOT EXISTS ANSWER (
    ID                                      BIGINT(19)      NOT NULL AUTO_INCREMENT ,
    MAIL                                    VARCHAR(255)    NOT NULL UNIQUE         ,
    PHONE_NUMBER                            VARCHAR(255)                            ,
    FULL_NAME                               VARCHAR(255)                            ,
    AGE                                     BIGINT(19)                              ,
    LAST_UPDATED                            TIMESTAMP       DEFAULT NOW()           ,
    CONSTRAINT ANSWER_PK PRIMARY KEY (ID)
  );

CREATE INDEX ANSWER_MAIL_INDEX ON ANSWER(MAIL);