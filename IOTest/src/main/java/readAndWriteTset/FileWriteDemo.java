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
     *  * StringWriter同理
     *      * StringWriter也是一个基于内存的Writer，它和CharArrayWriter类似。实际上，
     *      * StringWriter在内部维护了一个StringBuffer，并对外提供了Writer接口。
     * @throws IOException
     */
    public static  void test11() throws IOException {

        String data = "This is the original data";

        try {
            //创建具有默认字符串缓冲区容量的StringWriter
            StringWriter output = new StringWriter();

            //将数据写入字符串缓冲区
            output.write(data);

            //打印字符串写入器
            System.out.println("StringWriter中的数据: " + output);
            //返回字符串缓冲区
            StringBuffer stringBuffer = output.getBuffer();
            System.out.println("StringBuffer: " + stringBuffer);

            //以字符串形式返回字符串缓冲区
            String string = output.toString();
            System.out.println("String: " + string);

            output.close();
        }

        catch(Exception e) {
            e.getStackTrace();
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

    /**
     * BufferedWriter维护一个内部的8192个字符缓冲器。
     *
     * 在写操作期间，字符将被写入内部缓冲区而不是磁盘。 一旦缓冲区被填充或关闭写入器，缓冲区中的所有字符将被写入磁盘。
     *
     * 因此，减少了与磁盘的通信次数。这就是为什么使用BufferedWriter写入字符更快的原因。
     */
    public static  void test3() throws IOException {
        String data = "This is a demo of the flush method";

        try {
            //创建 FileWriter
            FileWriter file = new FileWriter(" flush.txt");

            //创建 BufferedWriter
            BufferedWriter output = new BufferedWriter(file);

            //将数据写入文件
            output.write(data);

            //将数据刷新到目标
            output.flush();
            System.out.println("数据被刷新到文件中。");

            output.close();
        }

        catch(Exception e) {
            e.getStackTrace();
        }    }


}
