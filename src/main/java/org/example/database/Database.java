package org.example.database;

import java.sql.*;

public class Database {

    private Connection connection = null;

    public Database() {

    }

    public Connection connectToDatabase(){
        String DatabaseUrl = "jdbc:" + Constants.DATABASE_TYPE + "://" + Constants.DATABASE_HOST + "/" + Constants.DATABASE_NAME + "?user=" + Constants.DATABASE_OWNER_LOGIN + "&password=" + Constants.DATABASE_OWNER_PASSWORD+ "&ssl="+ Constants.DATABASE_SSL;
        try{
            connection = DriverManager.getConnection(DatabaseUrl);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return connection;
    }

    public Connection disconnectFromDatabase(){
        try {
            connection.close();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }

    public Statement createAndExecuteStatement(String sqlCode){
        Statement statement = null;
            try {
                statement = connection.createStatement();
                statement.execute(sqlCode);
            }
            catch (Exception e) {
                System.out.println("createAndExecuteStatement(): " + e.getMessage());
            }
        return statement;
    }

    public Statement closeAndCancelStatement(Statement statement){
        try {
            statement.close();
            statement.cancel();
        }
        catch (Exception e) {
            System.out.println("closeAndCancelStatement(Statement statement): " + e.getMessage());
        }
        return statement;
    }

    public ResultSet closeResultSet(ResultSet resultSet){
        try {
            resultSet.close();
        }
        catch (Exception e) {
            System.out.println("closeResultSet(ResultSet resultSet): " + e.getMessage());
        }
        return resultSet;
    }

    public ResultSet handleQuery(Statement statement){
        ResultSet resultSet = null;
        try {
            resultSet = statement.getResultSet();
        }
        catch (Exception e) {
            System.out.println("handleQuery(Statement statement): " + e.getMessage());
        }
        return resultSet;
    }

    public boolean checkDatabaseConnection(){
        //returns true if database connection exists and false if it doesn't
        try {
            System.out.println("Connection is: " + (connection.isClosed() || connection != null));
            return connection.isClosed() || connection != null;
        }
        catch (Exception e){
            System.out.println("checkDatabaseConnection(): " + e.getMessage());
        }
        return false;
    }

    public boolean checkStatement(Statement statement){
        try {
            System.out.println("Statement is: " + (statement.isClosed() || statement != null));
            return statement.isClosed() || statement != null;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    public boolean checkResultSet(ResultSet resultSet){
        try {
            System.out.println("ResultSet is: " + (resultSet.isClosed() || resultSet != null));
            return resultSet.isClosed() || resultSet != null;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return false;
    }
}