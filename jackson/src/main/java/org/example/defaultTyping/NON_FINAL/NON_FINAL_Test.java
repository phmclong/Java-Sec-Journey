package org.example.defaultTyping.NON_FINAL;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.Person;
import org.example.MySex;
import org.example.Hacker;

public class NON_FINAL_Test {
    public static void main(String[] args) throws Exception {
        Person p = new Person();
        p.age = 26;
        p.name = "Sheon";
        p.object = new Hacker();
        p.sex = new MySex();
        p.hacker = new Hacker();
        ObjectMapper mapper = new ObjectMapper();
        // Thiết lập NON_FINAL
        mapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);

        String json = mapper.writeValueAsString(p);
        System.out.println(json);

        Person p2 = mapper.readValue(json, Person.class);
        System.out.println(p2);
    }
}