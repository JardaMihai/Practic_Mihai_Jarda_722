package org.example.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

public class JsonDataReader {

    private final ObjectMapper objectMapper = new ObjectMapper();

    public <T> List<T> readData(String resourceFileName, TypeReference<List<T>> typeReference) {
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(resourceFileName)) {
            if (inputStream == null) {
                System.err.println("Resource file not found: " + resourceFileName);
                return Collections.emptyList();
            }
            return objectMapper.readValue(inputStream, typeReference);
        } catch (IOException e) {
            System.err.println("Error reading or parsing file: " + resourceFileName);
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
}

