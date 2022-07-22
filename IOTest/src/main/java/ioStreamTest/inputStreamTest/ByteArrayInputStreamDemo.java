package ioStreamTest.inputStreamTest;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @Description
 * @Author yu.jin
 * @Date 2022-07-22 15:10
 */
public class ByteArrayInputStreamDemo {
    /**
     *ByteArrayInputStream类可用于读取输入数据数组（以字节为单位）。
     * ByteArrayInputStream实际上是把一个byte[]数组在内存中变成一个InputStream，
     * 虽然实际应用不多，但测试的时候，可以用它来构造一个InputStream。
     */
    public static void main(String[] args) throws IOException {
        String s = readFromFile("C:\\test\\README.txt");
        System.out.println(s);
        byte[] data = { 72, 101, 108, 108, 111, 33 };
        String s1 = readAsString(data);
        System.out.println(s1);
    }
    /**
     * 我们想从文件中读取所有字节，并转换成char然后拼成一个字符串
     */
    public static  String readFromFile(String path){
        String s=null;
        try (InputStream input = new FileInputStream("C:\\test\\README.txt")) {
            int n;
            StringBuilder sb = new StringBuilder();
            while ((n = input.read()) != -1) {
                sb.append((char) n);
            }
            s = sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return s;
    }
    /**
     * 当我们不想创建一个真实文件，只是想模拟一下，则
     */
    public static String readAsString(byte[] data) throws IOException {
        StringBuilder sb = new StringBuilder();
        try (InputStream input = new ByteArrayInputStream(data)) {
            int n;
            while ((n = input.read()) != -1) {
                sb.append((char) n);
            }
        }

        return sb.toString();
    }
}
