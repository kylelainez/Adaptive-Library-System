package database;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.Books;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileManagerBooks {
    private final String FILE_NAME = "book_database.json";

    public void saveDatabase(List<Books> bookList) {
        try (FileWriter writer = new FileWriter(FILE_NAME)) {
            writer.write("[");
            if (!bookList.isEmpty()) {
                for (int i = 0; i < bookList.size(); i++) {
                    writer.write(" " + bookList.get(i).toJson());
                    if (i < bookList.size() - 1) {
                        writer.write(',');
                    }
                }
            }
            writer.write("\n]\n");
            System.out.println(
                    "System State: Data successfully persisted to " + FILE_NAME
            );
        } catch (IOException e) {
            System.err.println("Failed to save data: " + e.getMessage());
        }
    }

    public List<Books> loadDatabase() {
        List<Books> list = new ArrayList<>();
        try {
            ObjectMapper mapper = new ObjectMapper();
            File jsonFile = new File(FILE_NAME);

            list = mapper.readValue(jsonFile, new TypeReference<List<Books>>() {}
            );
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}
