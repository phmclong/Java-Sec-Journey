package org.example.defaultTyping.JAVA_LANG_OBJECT;

import org.example.Person;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.Hacker;

public class JAVA_LANG_OBJECT_Test {
    public static void main(String[] args) throws Exception {
        Person p = new Person();
        p.age = 26;
        p.name = "Sheon";
        p.object = new Hacker();
        ObjectMapper mapper = new ObjectMapper();
        // Thiết lập JAVA_LANG_OBJECT
        mapper.enableDefaultTyping(ObjectMapper.DefaultTyping.JAVA_LANG_OBJECT);

        String json = mapper.writeValueAsString(p);
        System.out.println(json);

        Person p2 = mapper.readValue(json, Person.class);
        System.out.println(p2);
    }
}