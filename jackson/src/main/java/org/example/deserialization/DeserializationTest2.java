package org.example.deserialization;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.Person3;

public class DeserializationTest2 {
    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
//        mapper.enableDefaultTyping();

        String json = "{\"age\":26,\"name\":\"sheon\",\"sex\":[\"org.example.MySex2\",{\"sex\":1}]}";
        Person3 p2 = mapper.readValue(json, Person3.class);
        System.out.println(p2);
    }
}
