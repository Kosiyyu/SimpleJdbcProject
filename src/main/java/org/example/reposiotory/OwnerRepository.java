package org.example.reposiotory;

import org.example.database.Constants;
import org.example.database.Database;
import org.example.model.Owner;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OwnerRepository {
    Database database = new Database();

    public Owner addOwner(Owner owner){
        database.connectToDatabase();
        if(database.checkDatabaseConnection()){
            int id = owner.getId();
            String firstname = owner.getFirstname();
            String lastname = owner.getLastname();
            String email = owner.getEmail();
            Statement statement = database.createAndExecuteStatement(
                    "INSERT INTO " + Constants.OWNER_TABLE_NAME + "(" + Constants.OWNER_FIRSTNAME + ", "+ Constants.OWNER_LASTNAME +", " + Constants.OWNER_EMAIL + ") \n" +
                            "VALUES" + "('" + firstname + "', '"+ lastname +"', '" + email + "')"
            );
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
        throw new RuntimeException();//not implemented yet!!!
    }

}
