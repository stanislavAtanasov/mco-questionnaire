/*
 * This file is generated by jOOQ.
 */
package com.example.mco.db;


import com.example.mco.db.tables.Answer;
import com.example.mco.db.tables.FlywaySchemaHistory;

import javax.annotation.Generated;


/**
 * Convenience access to all tables in dev_mco
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.5"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Tables {

    /**
     * The table <code>dev_mco.ANSWER</code>.
     */
    public static final Answer ANSWER = com.example.mco.db.tables.Answer.ANSWER;

    /**
     * The table <code>dev_mco.flyway_schema_history</code>.
     */
    public static final FlywaySchemaHistory FLYWAY_SCHEMA_HISTORY = com.example.mco.db.tables.FlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY;
}