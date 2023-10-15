package com.example;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * json to object, object to json
 */
public class Jackson1 {
    public static void main(String args[]) {

        ObjectMapper mapper = new ObjectMapper();
        String jsonString = "{\"name\":\"Mahesh\", \"age\":21}";

        // map json to student
        try {
            Student student = mapper.readValue(jsonString, Student.class);

            System.out.println(student);

            jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(student);

            System.out.println(jsonString);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

