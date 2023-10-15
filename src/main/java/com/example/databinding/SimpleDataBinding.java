package com.example.databinding;

import com.example.Student;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 *      JSON                Java Data Type
 * 1	object	            LinkedHashMap<String,Object>
 * 2	array	            ArrayList<Object>
 * 3	string	            String
 * 4	complete number	    Integer, Long or BigInteger
 * 5	fractional number	Double / BigDecimal
 * 6	true | false	    Boolean
 * 7	null	            null
 */
public class SimpleDataBinding {
    public static void main(String args[]){
        SimpleDataBinding tester = new SimpleDataBinding();
        try {
            ObjectMapper mapper = new ObjectMapper();

            Map<String,Object> studentDataMap = new HashMap<String,Object>();
            int[] marks = {1,2,3};

            Student student = new Student();
            student.setAge(10);
            student.setName("Mahesh");
            // JAVA Object
            studentDataMap.put("student", student);
            // JAVA String
            studentDataMap.put("name", "Mahesh Kumar");
            // JAVA Boolean
            studentDataMap.put("verified", Boolean.FALSE);
            // Array
            studentDataMap.put("marks", marks);

            mapper.writeValue(new File("student.json"), studentDataMap);
            //result student.json
            //{
            //   "student":{"name":"Mahesh","age":10},
            //   "marks":[1,2,3],
            //   "verified":false,
            //   "name":"Mahesh Kumar"
            //}
            studentDataMap = mapper.readValue(new File("student.json"), Map.class);

            System.out.println(studentDataMap.get("student"));
            System.out.println(studentDataMap.get("name"));
            System.out.println(studentDataMap.get("verified"));
            System.out.println(studentDataMap.get("marks"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
