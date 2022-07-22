package ioStreamTest.inputStreamTest;

/**
 * @Description
 * @Author yu.jin
 * @Date 2022-07-22 16:50
 */

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * ObjectInputStream类可用于读取ObjectOutputStream先前编写的对象。
 *
 *具体见ObjectOutputStreamDemo的test3
 * api：
 * read() - 从输入流中读取一个字节的数据
 *
 * readBoolean() - 以布尔形式读取数据
 *
 * readChar() - 以字符形式读取数据
 *
 * readInt() - 以整数形式读取数据
 *
 * readObject() - 从输入流中读取对象
 */
public class ObjectInputStreamDemo {
    public static void main(String[] args) {

        int data1 = 5;
        String data2 = "This is nhooo";

        try {
            FileOutputStream file = new FileOutputStream("file.txt");
            ObjectOutputStream output = new ObjectOutputStream(file);

            //使用ObjectOutputStream写入文件
            output.writeInt(data1);
            output.writeObject(data2);

            FileInputStream fileStream = new FileInputStream("file.txt");
            //创建对象输入流
            ObjectInputStream objStream = new ObjectInputStream(fileStream);

            //使用readIng()方法
            System.out.println("整数数据 :" + objStream.readInt());

            //使用readObject()方法
            System.out.println("字符串数据: " + objStream.readObject());

            output.close();
            objStream.close();
        }
        catch (Exception e) {
            e.getStackTrace();
        }
    }


}
