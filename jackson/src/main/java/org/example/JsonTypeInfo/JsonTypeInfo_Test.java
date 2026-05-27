package org.example.JsonTypeInfo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.Hacker;
import org.example.Person2;

public class JsonTypeInfo_Test {
    public static void main(String[] args) throws Exception {
        Person2 p = new Person2();
        p.age = 26;
        p.name = "Sheon";
        p.object = new Hacker();
        ObjectMapper mapper = new ObjectMapper();

        String json = mapper.writeValueAsString(p);
        System.out.println(json);

        Person2 p2 = mapper.readValue(json, Person2.class);
        System.out.println(p2);
    }
}
