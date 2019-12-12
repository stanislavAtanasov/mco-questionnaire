/*
 * This file is generated by jOOQ.
 */
package com.example.mco.db.tables.pojos;


import java.io.Serializable;
import java.time.LocalDateTime;

import javax.annotation.Generated;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.5"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class FlywaySchemaHistory implements Serializable {

    private static final long serialVersionUID = -1518161898;

    private Integer       installedRank;
    private String        version;
    private String        description;
    private String        type;
    private String        script;
    private Integer       checksum;
    private String        installedBy;
    private LocalDateTime installedOn;
    private Integer       executionTime;
    private Boolean       success;

    public FlywaySchemaHistory() {}

    public FlywaySchemaHistory(FlywaySchemaHistory value) {
        this.installedRank = value.installedRank;
        this.version = value.version;
        this.description = value.description;
        this.type = value.type;
        this.script = value.script;
        this.checksum = value.checksum;
        this.installedBy = value.installedBy;
        this.installedOn = value.installedOn;
        this.executionTime = value.executionTime;
        this.success = value.success;
    }

    public FlywaySchemaHistory(
        Integer       installedRank,
        String        version,
        String        description,
        String        type,
        String        script,
        Integer       checksum,
        String        installedBy,
        LocalDateTime installedOn,
        Integer       executionTime,
        Boolean       success
    ) {
        this.installedRank = installedRank;
        this.version = version;
        this.description = description;
        this.type = type;
        this.script = script;
        this.checksum = checksum;
        this.installedBy = installedBy;
        this.installedOn = installedOn;
        this.executionTime = executionTime;
        this.success = success;
    }

    public Integer getInstalledRank() {
        return this.installedRank;
    }

    public void setInstalledRank(Integer installedRank) {
        this.installedRank = installedRank;
    }

    public String getVersion() {
        return this.version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getScript() {
        return this.script;
    }

    public void setScript(String script) {
        this.script = script;
    }

    public Integer getChecksum() {
        return this.checksum;
    }

    public void setChecksum(Integer checksum) {
        this.checksum = checksum;
    }

    public String getInstalledBy() {
        return this.installedBy;
    }

    public void setInstalledBy(String installedBy) {
        this.installedBy = installedBy;
    }

    public LocalDateTime getInstalledOn() {
        return this.installedOn;
    }

    public void setInstalledOn(LocalDateTime installedOn) {
        this.installedOn = installedOn;
    }

    public Integer getExecutionTime() {
        return this.executionTime;
    }

    public void setExecutionTime(Integer executionTime) {
        this.executionTime = executionTime;
    }

    public Boolean getSuccess() {
        return this.success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("FlywaySchemaHistory (");

        sb.append(installedRank);
        sb.append(", ").append(version);
        sb.append(", ").append(description);
        sb.append(", ").append(type);
        sb.append(", ").append(script);
        sb.append(", ").append(checksum);
        sb.append(", ").append(installedBy);
        sb.append(", ").append(installedOn);
        sb.append(", ").append(executionTime);
        sb.append(", ").append(success);

        sb.append(")");
        return sb.toString();
    }
}
