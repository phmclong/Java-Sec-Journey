package org.example.defaultTyping.OBJECT_AND_NON_CONCRETE;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.Person;
import org.example.Hacker;
import org.example.MySex;

public class OBJECT_AND_NON_CONCRETE_Test {
    public static void main(String[] args) throws Exception {
        Person p = new Person();
        p.age = 26;
        p.name = "Sheon";
        p.object = new Hacker();
        p.sex = new MySex();
        ObjectMapper mapper = new ObjectMapper();
        // Thiết lập OBJECT_AND_NON_CONCRETE
        mapper.enableDefaultTyping(ObjectMapper.DefaultTyping.OBJECT_AND_NON_CONCRETE);
        // Hoặc gọi trực tiếp không tham số, output giống nhau
        // mapper.enableDefaultTyping();

        String json = mapper.writeValueAsString(p);
        System.out.println(json);

        Person p2 = mapper.readValue(json, Person.class);
        System.out.println(p2);
    }
}
