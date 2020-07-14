package io.dz.librarydb.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PropertiesConfig {
    @Value("${REST_CLIENT_MEMBER_URL}")
    public static String memberServiceUrl;

    @Value("${REST_CLIENT_USER_LIMIT}")
    public static String userLimitUrl;

    @Value("${spring.datasource.driver-class-name}")
    public static String DB_DRIVER;

    @Value("${spring.datasource.password}")
    public static String DB_PASSWORD;

    @Value("${spring.datasource.url}")
    public static String DB_URL;

    @Value("${spring.datasource.username}")
    public static String DB_USERNAME;

    @Value("${spring.application.jpa.properties.hibernate.dialect}")
    public static String HIBERNATE_DIALECT;

    @Value("${hibernate.show_sql}")
    public static String HIBERNATE_SHOW_SQL;

    @Value("${hibernate.hbm2ddl.auto}")
    public static String HIBERNATE_HBM2DDL_AUTO;


    public String getDB_DRIVER() {
        return DB_DRIVER;
    }

    public void setDB_DRIVER(String DB_DRIVER) {
        this.DB_DRIVER = DB_DRIVER;
    }

    public String getDB_PASSWORD() {
        return DB_PASSWORD;
    }

    public void setDB_PASSWORD(String DB_PASSWORD) {
        this.DB_PASSWORD = DB_PASSWORD;
    }

    public String getDB_URL() {
        return DB_URL;
    }

    public void setDB_URL(String DB_URL) {
        this.DB_URL = DB_URL;
    }

    public String getDB_USERNAME() {
        return DB_USERNAME;
    }

    public void setDB_USERNAME(String DB_USERNAME) {
        this.DB_USERNAME = DB_USERNAME;
    }

    public String getHIBERNATE_DIALECT() {
        return HIBERNATE_DIALECT;
    }

    public void setHIBERNATE_DIALECT(String HIBERNATE_DIALECT) {
        this.HIBERNATE_DIALECT = HIBERNATE_DIALECT;
    }

    public String getHIBERNATE_SHOW_SQL() {
        return HIBERNATE_SHOW_SQL;
    }

    public void setHIBERNATE_SHOW_SQL(String HIBERNATE_SHOW_SQL) {
        this.HIBERNATE_SHOW_SQL = HIBERNATE_SHOW_SQL;
    }

    public String getHIBERNATE_HBM2DDL_AUTO() {
        return HIBERNATE_HBM2DDL_AUTO;
    }

    public void setHIBERNATE_HBM2DDL_AUTO(String HIBERNATE_HBM2DDL_AUTO) {
        this.HIBERNATE_HBM2DDL_AUTO = HIBERNATE_HBM2DDL_AUTO;
    }

    public String getUserLimitUrl() {
        return userLimitUrl;
    }

    public void setUserLimitUrl(String userLimitUrl) {
        this.userLimitUrl = userLimitUrl;
    }

    public String getMemberServiceUrl() {
        return memberServiceUrl;
    }

    public void setMemberServiceUrl(String memberServiceUrl) {
        this.memberServiceUrl = memberServiceUrl;
    }
}
