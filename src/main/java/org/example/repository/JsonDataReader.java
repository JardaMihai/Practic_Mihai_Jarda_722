package org.example.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

public class JsonDataReader {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static <T> List<T> readJsonFileToList(String fileName, TypeReference<List<T>> typeReference) {
        try (InputStream inputStream = JsonDataReader.class.getClassLoader().getResourceAsStream(fileName)) {
            if (inputStream == null) {
                System.err.println("File not found: " + fileName);
                return Collections.emptyList();
            }
            return objectMapper.readValue(inputStream, typeReference);
        } catch (IOException e) {
            System.err.println("Error reading or parsing file: " + fileName);
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
}

