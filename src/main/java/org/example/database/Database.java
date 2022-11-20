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
        catch (SQLException sqlException){
            return connection;
        }
        return connection;
    }

    public Connection disconnectFromDatabase(){
        try {
            connection.close();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

    public Statement createAndExecuteStatement(String sqlCode){
        Statement statement = null;
        try {
            statement = connection.createStatement();
            statement.execute(sqlCode);
        }
        catch (SQLException e) {

        }
        return statement;
    }

    public Statement closeAndCancelStatement(Statement statement){
        try {
            statement.close();
            statement.cancel();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return statement;
    }

    public ResultSet closeResultSet(ResultSet resultSet){
        try {
            resultSet.close();
        } catch (SQLException e) {

        }
        return resultSet;
    }

    public ResultSet handleQuery(Statement statement){
        ResultSet resultSet = null;
        try {
            resultSet = statement.getResultSet();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultSet;
    }

    public boolean checkDatabaseConnection(){
        //returns true if database connection exists and false if it doesn't
        try {
            return connection.isClosed() || connection != null;
        }
        catch (SQLException sqlException){
            return false;
        }
    }

    public boolean checkStatement(Statement statement){
        try {
            System.out.println(statement.isClosed() || statement != null);
            return statement.isClosed() || statement != null;
        }
        catch (SQLException sqlException){
            return false;
        }
    }

    public boolean checkResultSet(ResultSet resultSet){
        try {
            return resultSet.isClosed() || resultSet != null;
        }
        catch (SQLException sqlException){
            return false;
        }
    }
}
