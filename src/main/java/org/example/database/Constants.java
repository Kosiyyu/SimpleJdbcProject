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
    public static final String OWNER_ID = "OWNER_ID";
    public static final String OWNER_FIRSTNAME = "OWNER_FIRSTNAME";
    public static final String OWNER_LASTNAME = "OWNER_LASTNAME";
    public static final String OWNER_EMAIL = "OWNER_EMAIL";
    public static final String[] OWNER_TABLE_MODEL = {OWNER_ID, OWNER_FIRSTNAME, OWNER_LASTNAME, OWNER_EMAIL};

}
