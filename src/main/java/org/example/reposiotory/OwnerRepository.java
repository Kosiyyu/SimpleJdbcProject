package org.example.reposiotory;

import org.example.database.Constants;
import org.example.database.Database;
import org.example.model.Owner;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OwnerRepository {
    Database database = null;

    public OwnerRepository(Database database) {
        this.database = database;
    }

    public Owner addOwner(Owner owner){
        if(database.checkDatabaseConnection()){
            int id = owner.getId();
            String firstname = owner.getFirstname();
            String lastname = owner.getLastname();
            String email = owner.getEmail();
            String sqlCode = "INSERT INTO " + Constants.OWNER_TABLE_NAME + "(" + Constants.OWNER_FIRSTNAME + ", "+ Constants.OWNER_LASTNAME +", " + Constants.OWNER_EMAIL + ") \n" +
                    "VALUES" + "('" + firstname + "', '"+ lastname +"', '" + email + "')";
            Statement statement = database.createAndExecuteStatement(sqlCode);
            if(database.checkStatement(statement)){
                database.closeAndCancelStatement(statement);
            }
            else {
                return null;
            }
        }
        return owner;
    }

    public List<Owner> getAllOwners(){
        List<Owner> owners = new ArrayList<>();
        if(database.checkDatabaseConnection()){
            String sqlCode = "SELECT * FROM " + Constants.OWNER_TABLE_NAME;
            Statement statement = database.createAndExecuteStatement(sqlCode);
            if(database.checkStatement(statement)){
                ResultSet resultSet = database.handleQuery(statement);
                if(database.checkResultSet(resultSet)){
                    try{
                        while(resultSet.next()){
                            int id = resultSet.getInt(Constants.OWNER_ID);
                            String firstname = resultSet.getString(Constants.OWNER_FIRSTNAME);
                            String lastname = resultSet.getString(Constants.OWNER_LASTNAME);
                            String email = resultSet.getString(Constants.OWNER_EMAIL);
                            owners.add(new Owner(firstname,lastname,email));
                        }
                    }catch (Exception e){

                    }
                    database.closeResultSet(resultSet);
                }
                database.closeAndCancelStatement(statement);
            }
        }
        return owners;
    }

}
