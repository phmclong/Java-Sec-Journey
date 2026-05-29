package org.example.defaultTyping.NON_CONCRETE_AND_ARRAYS;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.Person;
import org.example.MySex;
import org.example.Hacker;

public class NON_CONCRETE_AND_ARRAYS_Test {
    public static void main(String[] args) throws Exception {
        Person p = new Person();
        p.age = 26;
        p.name = "Sheon";
        Hacker[] hackers = new Hacker[2];
        hackers[0] = new Hacker();
        hackers[1] = new Hacker();
        p.object = hackers;
        p.sex = new MySex();
        ObjectMapper mapper = new ObjectMapper();
        // Thiết lập NON_CONCRETE_AND_ARRAYS
        mapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_CONCRETE_AND_ARRAYS);

        String json = mapper.writeValueAsString(p);
        System.out.println(json);

        Person p2 = mapper.readValue(json, Person.class);
        System.out.println(p2);
    }
}
