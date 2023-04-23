package com.guptaji.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.AttributeConverter;
import java.util.HashMap;
import java.util.Map;

@ApplicationScoped
public class HashMapConverter implements AttributeConverter<Map<String, Object>, String> {

    @Inject
    public ObjectMapper objectMapper;

    @Override
    public String convertToDatabaseColumn(Map<String, Object> attribute) {

        String convertedStringValue = new String();
        try {
            convertedStringValue = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(attribute);
        } catch (JsonProcessingException e) {
            System.out.println(e.getMessage());
        }
        return convertedStringValue;
    }

    @Override
    public Map<String, Object> convertToEntityAttribute(String dbData) {
        Map<String, Object> convertedMap = new HashMap<>();
        try {
            convertedMap = objectMapper.readValue(dbData, new TypeReference<HashMap<String, Object>>() {});
        } catch (JsonProcessingException e) {
            System.out.println(e.getMessage());
        }
        return convertedMap;
    }
}
