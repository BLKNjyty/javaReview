package readAndWriteTset;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * @Description
 * @Author yu.jin
 * @Date 2022-07-22 17:16
 */
public class FileWriteDemo {
    public static void main(String[] args) {


    }

    public static  void test() throws IOException {
        try (Writer writer = new FileWriter("readme.txt")) {
            writer.write('H'); // 写入单个字符
            writer.write("Hello".toCharArray()); // 写入char[]
            writer.write("Hello"); // 写入String
        }
    }

    /**
     * CharArrayWriter可以在内存中创建一个Writer，它的作用实际上是构造一个缓冲区，
     * 可以写入char，最后得到写入的char[]数组，这和ByteArrayOutputStream非常类似
     *
     * StringWriter同理
     * StringWriter也是一个基于内存的Writer，它和CharArrayWriter类似。实际上，
     * StringWriter在内部维护了一个StringBuffer，并对外提供了Writer接口。
     *
     *
     */
    public static  void test1() throws IOException {
        try (CharArrayWriter writer = new CharArrayWriter()) {
            writer.write(65);
            writer.write(66);
            writer.write(67);
            char[] data = writer.toCharArray(); // { 'A', 'B', 'C' }
        }
    }

    /**
     *除了CharArrayWriter和StringWriter外，普通的Writer实际上是基于OutputStream构造的，它接收char，
     * 然后在内部自动转换成一个或多个byte，并写入OutputStream。因此，OutputStreamWriter就是一个将任意的
     * OutputStream转换为Writer的转换器：
     *
     */
    public static  void test2() throws IOException {
        try (Writer writer = new OutputStreamWriter(new FileOutputStream("readme.txt"), "UTF-8")) {
            // TODO:
        }
    }

}
