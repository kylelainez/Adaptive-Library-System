package database;

import accounts.RegisteredUsers;
import com.fasterxml.jackson.core.type.TypeReference;
import models.Users;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FileManagerAccounts {
    private final String FILE_NAME = "account_database.json";

    public void saveDatabase(List<Users> userList) {
        try(FileWriter writer = new FileWriter(FILE_NAME)){
            writer.write("[");
            if(!userList.isEmpty()){
                for (int i=0; i < userList.size(); i++){
                    writer.write(" " + userList.get(i).toJson());
                    if (i < userList.size() - 1){
                        writer.write(',');
                    }
                }
                writer.write("\n]\n");
                System.out.println("System State: Data successfully persisted to " + FILE_NAME);
            }
        } catch (IOException e){
            System.err.println("Failed to save data: " + e.getMessage());
        }
    }
    public List<Users> loadDatabase(){
        List<Users> list = new ArrayList<>();
        try {
            ObjectMapper mapper = new ObjectMapper();
            File jsonFile = new File(FILE_NAME);
            list = mapper.readValue(jsonFile, new TypeReference<List<Users>>() {
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
