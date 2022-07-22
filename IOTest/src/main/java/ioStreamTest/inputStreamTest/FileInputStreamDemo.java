package ioStreamTest.inputStreamTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @Description
 * @Author yu.jin
 * @Date 2022-07-22 14:54
 */

/**
 * Inputstream的api介绍：
 * read() - 从输入流中读取一个字节的数据
 *
 * read(byte[] array) - 从流中读取字节并存储在指定的数组中
 *
 * available() - 返回输入流中可用的字节数
 *
 * mark() - 标记输入流中数据所在的位置
 *
 * reset() -将控制点返回到流中设置标记的点
 *
 * markSupported()- 检查流中是否支持mark()和reset()方法
 *
 * skips() - 跳过和丢弃输入流中的指定字节数
 *
 * close() - 关闭输入流
 */
public class FileInputStreamDemo {
    public static void main(String[] args) throws IOException {
        readFile();
        readFile1();
        readFile2();
    }

    /**
     * 如果打开了一个文件进行读写，完成后要及时地关闭，以便让操作系统把资源释放掉，否
     * 则，应用程序占用的资源会越来越多，不但白白占用内存，还会影响其他应用程序的运行。
     *
     */
    public static  void readFile() throws IOException {
        InputStream input = null;
        try {
            input = new FileInputStream("src/readme.txt");
            int n;
            //这个方法会读取输入流的下一个字节，并返回字节表示的int值（0~255）。如果已读到末尾，返回-1表示不能继续读取了。
            while ((n = input.read()) != -1) { // 利用while同时读取并判断
                System.out.println(n);
            }
        } finally {
            if (input != null) { input.close(); }
        }
    }

    /**
     *
     * 利用Java 7引入的新的try(resource)的语法，只需要编写try语句，让编译器自动为我们关闭资源。
     */
    public static  void readFile1() throws IOException {
        try (InputStream input = new FileInputStream("src/readme.txt")) {
            int n;
            while ((n = input.read()) != -1) {
                System.out.println(n);
            }
        }
        // 编译器在此自动为我们写入finally并调用close()
    }
    /**
     * 指定缓冲区，多字节读取
     * int read(byte[] b)：读取若干字节并填充到byte[]数组，返回读取的字节数
     * int read(byte[] b, int off, int len)：指定byte[]数组的偏移量和最大填充数
     */
    public static void readFile2() throws IOException {
        try (InputStream input = new FileInputStream("src/readme.txt")) {
            // 定义1000个字节大小的缓冲区:
            byte[] buffer = new byte[1000];
            int n;
            // 读取到缓冲区
            while ((n = input.read(buffer)) != -1) {
                System.out.println("read " + n + " bytes.");
            }
        }
    }
}
