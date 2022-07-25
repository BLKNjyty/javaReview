package ioStreamTest.outputStreamTest;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * @Description
 * @Author yu.jin
 * @Date 2022-07-22 15:39
 */

/**
 * ByteArrayOutputStream可以在内存中模拟一个OutputStream：
 * 多在测试的时候使用
 */
public class ByteArrayOutputStreamDemo {
    public static void main(String[] args) throws IOException, IOException {
        byte[] data;
        try (ByteArrayOutputStream output = new ByteArrayOutputStream()) {
            output.write("Hello ".getBytes("UTF-8"));
            output.write("world!".getBytes("UTF-8"));
            data = output.toByteArray();

        }

        System.out.println(new String(data, "UTF-8"));
    }
}
