package ioStreamTest.DecoratorTest;

import java.io.*;
import java.nio.file.Files;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/**
 * @Description
 * @Author yu.jin
 * @Date 2022-07-22 16:13
 */
public class ZipStreamDemo {
    public static void main(String[] args) {

    }

    /**
     * 我们要创建一个ZipInputStream，通常是传入一个FileInputStream作为数据源，然后，
     * 循环调用getNextEntry()，直到返回null，表示zip流结束
     */
    public  static void testinput() throws IOException {
        try (ZipInputStream zip = new ZipInputStream(new FileInputStream("abc.zip"))) {
            ZipEntry entry = null;
            while ((entry = zip.getNextEntry()) != null) {
                String name = entry.getName();
                if (!entry.isDirectory()) {
                    int n;
                    while ((n = zip.read()) != -1) {
                        System.out.println(n);
                    }
                }
            }
        }
    }

    public static void testoutput() throws IOException {
        File file1 = new File("das.txt");
        File file2 = new File("ddd.txt");

        try (ZipOutputStream zip = new ZipOutputStream(new FileOutputStream("bcd.zip"))) {
            File[] files = new File[]{file1,file2};
            for (File file : files) {
                zip.putNextEntry(new ZipEntry(file.getName()));
                zip.write(Files.readAllBytes(file.toPath()));
                zip.closeEntry();
            }
        }
    }
}
