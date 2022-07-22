package ioStreamTest.outputStreamTest;

/**
 * @Description
 * @Author yu.jin
 * @Date 2022-07-22 16:43
 */

import java.io.*;
import java.util.Arrays;

/**
 * ObjectOutputStream使用类名和对象值对Java对象进行编码。 并且，因此生成相应的流。 此过程称为序列化。
 * 这些转换后的流可以存储在文件中，并且可以在网络之间传输。
 * ObjectOutputStream类仅写入那些实现Serializable接口的对象。 这是因为对象在写入流时需要序列化
 *
 * api：
 * write() - 将字节数据写入输出流
 *
 * writeBoolean() - 以布尔形式写入数据
 *
 * writeChar() - 以字符形式写入数据
 *
 * writeInt() - 以整数形式写入数据
 *
 * writeObject() - 将对象写入输出流
 */
public class ObjectOutputStreamDemo {
    public static void main(String[] args) throws IOException {
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        try (ObjectOutputStream output = new ObjectOutputStream(buffer)) {
            // 写入int:
            output.writeInt(12345);
            // 写入String:
            output.writeUTF("Hello");
            // 写入Object:
            output.writeObject(Double.valueOf(123.456));
        }
        System.out.println(Arrays.toString(buffer.toByteArray()));
    }
    public static void test2(){
        int data1 = 5;
        String data2 = "This is nhooo";

        try {

            FileOutputStream file = new FileOutputStream("file.txt");

            //创建一个ObjectOutputStream
            ObjectOutputStream output = new ObjectOutputStream(file);

            //将对象写入输出流
            output.writeInt(data1);
            output.writeObject(data2);

            //使用ObjectInputStream读取数据
            FileInputStream fileStream = new FileInputStream("file.txt");
            ObjectInputStream objStream = new ObjectInputStream(fileStream);

            System.out.println("Integer data :" + objStream.readInt());
            System.out.println("String data: " + objStream.readObject());

            output.close();
            objStream.close();
        }

        catch (Exception e) {
            e.getStackTrace();
        }
    }

    public static  void test3(){
        //创建一个Dog类的对象
        Dog dog1 = new Dog("泰里", "拉布拉多猎犬");

        try {
            FileOutputStream fileOut = new FileOutputStream("file.txt");

            //创建一个ObjectOutputStream
            ObjectOutputStream objOut = new ObjectOutputStream(fileOut);

            //将对象写入输出流
            objOut.writeObject(dog1);

            //读取对象
            FileInputStream fileIn = new FileInputStream("file.txt");
            ObjectInputStream objIn = new ObjectInputStream(fileIn);

            // 读取对象
            Dog newDog = (Dog) objIn.readObject();

            System.out.println("狗名: " + newDog.name);
            System.out.println("犬种: " + newDog.breed);

            objOut.close();
            objIn.close();
        }

        catch (Exception e) {
            e.getStackTrace();
        }
    }
}
