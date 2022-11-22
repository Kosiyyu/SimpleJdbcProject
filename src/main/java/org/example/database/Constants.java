package org.example.database;

public class Constants {
    //DATABASE
    public static final String DATABASE_NAME = "test";
    public static final String DATABASE_TYPE = "postgresql";
    public static final String DATABASE_HOST = "localhost";
    public static final String DATABASE_OWNER_LOGIN = "postgres";//(DO NOT MISTAKE WITH MODEL)
    public static final String DATABASE_OWNER_PASSWORD = "alamakota123";//(DO NOT MISTAKE WITH MODEL)
    public static final String DATABASE_SSL = "false";

    //OWNER
    public static final String OWNER_TABLE_NAME = "OWNER";
    public static final String OWNER_ID = "ID";
    public static final String OWNER_FIRSTNAME = "FIRSTNAME";
    public static final String OWNER_LASTNAME = "LASTNAME";
    public static final String OWNER_EMAIL = "EMAIL";
    public static final String[] OWNER_TABLE_MODEL = {OWNER_ID, OWNER_FIRSTNAME, OWNER_LASTNAME, OWNER_EMAIL};

}
