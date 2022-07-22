package ioStreamTest.outputStreamTest;

/**
 * @Description
 * @Author yu.jin
 * @Date 2022-07-22 15:29
 */

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 * outputStreamde api
 * write() - 将指定的字节写入输出流
 *
 * write(byte[] array) - 将指定数组中的字节写入输出流
 *
 * flush() -  强制将输出流中存在的所有数据写入目标
 *
 * close() - 关闭输出流
 */
public class FileOutputStreamDemo {
    public static void main(String[] args) {
        String data = "这是文件内的一行文本。";

        try {
            OutputStream out = new FileOutputStream("output.txt");

            //将字符串转换为字节
            byte[] dataBytes = data.getBytes();

            //将数据写入输出流
            out.write(dataBytes);
            System.out.println("数据被写入文件。");

            //关闭输出流
            out.close();
        }

        catch (Exception e) {
            e.getStackTrace();
        }
    }

    /**
     * 两种创建FileOutputStream方式
     * 在这里，我们创建了一个输出流，该输出流将链接到所指定的文件路径。
     *
     * 另外，value是可选的布尔参数。如果将其设置为true，则新数据将追加到文件中现有数据的末尾。
     * 否则，新数据将覆盖文件中的现有数据。
     *
     * write() - 将单写到byte文件输出流
     *
     * write(byte[] array) - 将指定数组中的字节写入输出流
     *
     * write(byte[] array, int start, int length)-从位置start开始将等于length的字节数写入数组的输出流
     */
    public static void test1() throws FileNotFoundException {
        String  path="output.txt";
        //包括布尔型参数
        FileOutputStream output = new FileOutputStream( path,  true);

        //不包括布尔型参数
        FileOutputStream output1 = new FileOutputStream( path);
    }
    /**
     * 关于flush方法的介绍
     * 因为向磁盘、网络写入数据的时候，出于效率的考虑，操作系统并不是输出一个字节就立刻写入到文件或者发送到网络，
     * 而是把输出的字节先放到内存的一个缓冲区里（本质上就是一个byte[]数组），等到缓冲区写满了，再一次性写入文件或者网络。
     *
     * 通常情况下，我们不需要调用这个flush()方法，因为缓冲区写满了OutputStream会自动调用它，并且，
     * 在调用close()方法关闭OutputStream之前，也会自动调用flush()方法。
     *
     * 但是一些特殊的情况需要手动flush：
     * 比如聊天软件，缓冲区大小是4K，则发送方要敲几千个字符后，操作系统才会把缓冲区的内容发送出去，这个时候，接收方会一次性收到大量消息
     * 解决办法就是每输入一句话后，立刻调用flush()
     */
    public static void test2(){
        FileOutputStream out = null;
        String data = "这是flush方法的演示";

        try {
            out = new FileOutputStream(" flush.txt");

            //使用write()方法
            out.write(data.getBytes());

            //使用flush()方法
            out.flush();
            out.close();
        }
        catch(Exception e) {
            e.getStackTrace();
        }
    }
}

