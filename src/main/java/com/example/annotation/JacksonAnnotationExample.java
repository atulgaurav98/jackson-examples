package com.example.annotation;

import com.example.Person;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Date;

public class JacksonAnnotationExample {
    public static void main(String[] args) throws IOException, JsonProcessingException {
        // Create an ObjectMapper
        ObjectMapper objectMapper = new ObjectMapper();

        // Serialize a Person object to JSON
        Person person = new Person();
        person.setFullName("John Doe");
        person.setBirthDate(new Date());
        person.setSsn("123-45-6789");

        String json = objectMapper.writeValueAsString(person);
        System.out.println("Serialized JSON: " + json);

        // Deserialize JSON into a Person object
        String jsonInput = "{\"full_name\":\"Jane Smith\",\"birthDate\":\"2020-01-15\"}";
        Person deserializedPerson = objectMapper.readValue(jsonInput, Person.class);
        System.out.println("Deserialized Person: " + deserializedPerson);
    }
}
