package readAndWriteTset;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * @Description
 * @Author yu.jin
 * @Date 2022-07-22 16:59
 */

/**
 * Reader是Java的IO库提供的另一个输入流接口。和InputStream的区别是，InputStream是一个字节流，
 * 即以byte为单位读取，而Reader是一个字符流，即以char为单位读取：
 *
 * Reader和InputStream有什么关系？
 * 除了特殊的CharArrayReader和StringReader，普通的Reader实际上是基于InputStream构造的，
 * 因为Reader需要从InputStream中读入字节流（byte），然后，根据编码设置，再转换为char就可以实现字符流
 */
public class FileReadDemo {
    public static void main(String[] args) {

    }
    public static void readFile() throws IOException {
        try (Reader reader = new FileReader("src/readme.txt")) {
            char[] buffer = new char[1000];
            int n;
            while ((n = reader.read(buffer)) != -1) {
                System.out.println("read " + n + " chars.");
            }
        }
    }

    /**
     * CharArrayReader可以在内存中模拟一个Reader，它的作用实际上是把一个char[]数组变成一个Reader，
     * 这和ByteArrayInputStream非常类似：
     * StringReader同理
     */
    public static void readFile1() throws IOException {
        try (Reader reader = new CharArrayReader("Hello".toCharArray())) {
            char[] buffer = new char[1000];
            int n;
            while ((n = reader.read(buffer)) != -1) {
                System.out.println("read " + n + " chars.");
            }
        }
        try (Reader reader = new StringReader("Hello")) {
            char[] buffer = new char[1000];
            int n;
            while ((n = reader.read(buffer)) != -1) {
                System.out.println("read " + n + " chars.");
            }
        }
    }

    /**除了特殊的CharArrayReader和StringReader，普通的Reader实际上是基于InputStream构造的，
     * 因为Reader需要从InputStream中读入字节流（byte），然后，根据编码设置，再转换为char就可以实现字符流。
     * 如果我们查看FileReader的源码，它在内部实际上持有一个FileInputStream。
     * 如果我们已经有一个InputStream，想把它转换为Reader，是完全可行的。InputStreamReader就是这样一个转换器
     */
    public static void readFile2() throws IOException {
        // 持有InputStream:
        InputStream input = new FileInputStream("src/readme.txt");
    // 变换为Reader:
        Reader reader = new InputStreamReader(input, "UTF-8");

    }

    /**
     * BufferedReader维护一个内部的8192个字符缓冲器。
     *
     * 在BufferedReader中进行读取操作期间，将从磁盘读取一部分字符并将其存储在内部缓冲区中。 并且从内部缓冲区中单独读取字符。
     *
     * 因此，减少了与磁盘的通信次数。这就是使用BufferedReader可以更快地读取字符的原因。
     * 创建一个具有指定大小的内部缓冲区的BufferdReader
     * BufferedReader buffer = new BufferedReader(file, int size);
     */
    public static void readFile3() throws IOException {
        //创建一个字符数组
        char[] array = new char[100];

        try {
            //创建 FileReader
            FileReader file = new FileReader("input.txt");

            //创建 BufferedReader
            BufferedReader input = new BufferedReader(file);

            //读取字符
            input.read(array);
            System.out.println("文件中的数据: ");
            System.out.println(array);

            //关闭 reader
            input.close();
        }

        catch(Exception e) {
            e.getStackTrace();
        }

    }

}
