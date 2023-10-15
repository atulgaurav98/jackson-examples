package com.example.TreeModel;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Iterator;

/**
 * ObjectMapper provides a pointer to
 * root node of the tree after reading the JSON.
 * Root Node can be used to traverse the complete tree.
 */
public class TreeModel {
    public static void main(String args[]){

        try {
            ObjectMapper mapper = new ObjectMapper();
            String jsonString = "{\"name\":\"Mahesh Kumar\",  \"age\":21,\"verified\":false,\"marks\": [100,90,85]}";
            JsonNode rootNode = mapper.readTree(jsonString);

            JsonNode nameNode = rootNode.path("name");
            System.out.println("Name: "+ nameNode.textValue());

            JsonNode ageNode = rootNode.path("age");
            System.out.println("Age: " + ageNode.intValue());

            JsonNode verifiedNode = rootNode.path("verified");
            System.out.println("Verified: " + (verifiedNode.booleanValue() ? "Yes":"No"));

            JsonNode marksNode = rootNode.path("marks");
            Iterator<JsonNode> iterator = marksNode.elements();
            System.out.print("Marks: [ ");

            while (iterator.hasNext()) {
                JsonNode marks = iterator.next();
                System.out.print(marks.intValue() + " ");
            }

            System.out.println("]");
        }
        catch (Exception e) { e.printStackTrace(); }
    }
}
