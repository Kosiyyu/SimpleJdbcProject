package org.example.database;

import java.sql.Connection;
import java.sql.SQLException;

public class Database {
    private Connection connection = null;

    public Database() {
    }

    public boolean databaseConnection(Connection connection){
        //returns true if database connection exists and false if it doesn't
        try {
            if(connection.isClosed() || connection != null){
                return true;
            }
            else{
                return false;
            }
        }
        catch (SQLException sqlException){
            return false;
        }
    }
}
