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
            String sqlCode = "INSERT INTO " + Constants.OWNER_TABLE_NAME + "(" + Constants.OWNER_FIRSTNAME + ", "+ Constants.OWNER_LASTNAME +", " + Constants.OWNER_EMAIL + ") \n" +
                    "VALUES" + "('" + firstname + "', '"+ lastname +"', '" + email + "')";
            String sqlCode1 = "INSERT INTO OWNER(FIRSTNAME, LASTNAME, EMAIL) \n" +
                    "VALUES('Anna', 'Kowalski', 'anna.kowalska@gmail.com')";
            Statement statement = database.createAndExecuteStatement(sqlCode1);
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
