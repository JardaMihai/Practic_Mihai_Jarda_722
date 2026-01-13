package org.example.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class JsonDataReader {
    private final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * Reads a list of objects from a JSON file in the resources folder.
     * @param filePath The path to the file within the resources folder.
     * @param typeReference The TypeReference for the list, e.g., new TypeReference<List<Tribut>>() {}.
     * @return A list of deserialized objects.
     * @throws IOException if the file is not found or cannot be read.
     */
    public <T> List<T> readListFromJsonFile(String filePath, TypeReference<List<T>> typeReference) throws IOException {
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(filePath)) {
            if (inputStream == null) {
                throw new IOException("File not found in resources: " + filePath);
            }
            return objectMapper.readValue(inputStream, typeReference);
        }
    }
}
