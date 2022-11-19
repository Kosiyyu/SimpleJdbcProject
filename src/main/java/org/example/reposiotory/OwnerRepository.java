package org.example.reposiotory;

import org.example.database.Constants;
import org.example.database.Database;
import org.example.model.Owner;

import java.util.ArrayList;
import java.util.List;

public class OwnerRepository {
    Database database = new Database();

    public Owner addOwner(Owner owner){
        database.connectToDatabase();
        if(database.checkDatabaseConnection()){
            database.createAndExecuteStatement(
                    "INSERT INTO " + Constants.OWNER_TABLE_NAME + "(FIRSTNAME, LASTNAME, EMAIL) \n" +
                            "VALUES('ADAM', 'KOWALSKI', 'adam.kowalski@gmail.com')"
            );
        }
        throw new RuntimeException();//not implemented yet!!!
        //return owner;
    }

    public List<Owner> getAllOwners(){
        List<Owner> owners = new ArrayList<>();
        throw new RuntimeException();//not implemented yet!!!
    }

}
