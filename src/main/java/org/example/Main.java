package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost/test?user=postgres&password=alamakota123&ssl=false");
            String createDB = "CREATE TABLE IF NOT EXISTS OWNER (\n" +
                    "    ID SERIAL PRIMARY KEY,\n" +
                    "    FIRSTNAME CHARACTER VARYING(255) NOT NULL,\n" +
                    "    LASTNAME CHARACTER VARYING(255) NOT NULL,\n" +
                    "    EMAIL CHARACTER VARYING(255) NOT NULL\n" +
                    ");";
            String insertValue = "INSERT INTO OWNER(FIRSTNAME, LASTNAME, EMAIL) \n" +
                    "VALUES('ADAM', 'KOWALSKI', 'adam.kowalski@gmail.com')";

            String updateValue = "UPDATE OWNER \n" +
                    "SET FIRSTNAME = 'Alan', LASTNAME = 'Nowak', EMAIL = 'alan.nowak@gmail.com'\n" +
                    "WHERE id = 3";
            String deleteValue = "DELETE FROM OWNER\n" +
                    "WHERE ID = 5";
            String selectAll = "SELECT * FROM OWNER";
            Statement statement = connection.createStatement();
            //statement.execute(createDB);
            //statement.execute(updateValue);
            //statement.execute(deleteValue);

            //statement.execute(selectAll);
            //ResultSet resultSet = statement.getResultSet();
            List<Owner> owners = new ArrayList<>();

            ResultSet resultSet = statement.executeQuery(selectAll);
            while(resultSet.next()){
                int id = resultSet.getInt("ID");
                String firstname = resultSet.getString("FIRSTNAME");
                String lastname = resultSet.getString("LASTNAME");
                String email = resultSet.getString("EMAIL");
                owners.add(new Owner(id,firstname,lastname,email));
            }

            owners.forEach(owner -> System.out.println(owner));


            statement.close();
            statement.cancel();

        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}