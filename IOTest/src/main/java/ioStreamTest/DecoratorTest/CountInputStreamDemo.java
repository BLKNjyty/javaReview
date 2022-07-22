package ioStreamTest.DecoratorTest;

import java.io.*;

/**
 * @Description
 * @Author yu.jin
 * @Date 2022-07-22 15:55
 */

/**
 * 装饰者模式在流中的运用：
 * 1.当我们需要给一个“基础”InputStream附加各种功能时，我们先确定这个能提供数据源的InputStream，
 * InputStream file = new FileInputStream("test.gz");
 * 2.希望FileInputStream能提供缓冲的功能来提高读取的效率，因此我们用BufferedInputStream包装这个InputStream，
 * 得到的包装类型是BufferedInputStream，但它仍然被视为一个InputStream
 * InputStream buffered = new BufferedInputStream(file);
 * 3.假设该文件已经用gzip压缩了，我们希望直接读取解压缩的内容，就可以再包装一个GZIPInputStream
 * InputStream gzip = new GZIPInputStream(buffered);
 *
 * 自己写的话贼费事，如下：编写一个CountInputStream，它的作用是对输入的字节进行计数
 */
public class CountInputStreamDemo {
    public static void main(String[] args) throws IOException {
        byte[] data = "hello, world!".getBytes("UTF-8");
        try (CountInputStream input = new CountInputStream(new ByteArrayInputStream(data))) {
            int n;
            while ((n = input.read()) != -1) {
                System.out.println((char)n);
            }
            System.out.println("Total read " + input.getBytesRead() + " bytes");
        }
    }
    static class CountInputStream extends FilterInputStream {
        private int count = 0;

        CountInputStream(InputStream in) {
            super(in);
        }

        public int getBytesRead() {
            return this.count;
        }

        @Override
        public int read() throws IOException {
            int n = in.read();
            if (n != -1) {
                this.count ++;
            }
            return n;
        }

        @Override
        public int read(byte[] b, int off, int len) throws IOException {
            int n = in.read(b, off, len);
            if (n != -1) {
                this.count += n;
            }
            return n;
        }
    }


}
