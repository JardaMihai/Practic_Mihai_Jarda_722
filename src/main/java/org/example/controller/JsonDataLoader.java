package org.example.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

/**
 * Handles the business logic of loading data from JSON files.
 */
public class JsonDataLoader {

    private final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * A generic method to load a list of objects from a JSON file in the resources folder.
     *
     * @param resourceFileName The name of the file (e.g., "tributes.json").
     * @param typeReference    The TypeReference for the list (e.g., new TypeReference<List<Tribute>>() {}).
     * @param <T>              The type of objects in the list.
     * @return A list of objects, or an empty list if an error occurs.
     */
    public <T> List<T> loadData(String resourceFileName, TypeReference<List<T>> typeReference) {
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(resourceFileName)) {
            if (inputStream == null) {
                System.err.println("Resource file not found: " + resourceFileName);
                return Collections.emptyList();
            }
            return objectMapper.readValue(inputStream, typeReference);
        } catch (IOException e) {
            System.err.println("Error reading or parsing JSON file: " + resourceFileName);
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
}

