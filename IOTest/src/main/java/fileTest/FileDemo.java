package fileTest;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

/**
 * @Description
 * @Author yu.jin
 * @Date 2022-07-22 14:24
 */
public class FileDemo {
    public static void main(String[] args) throws IOException {
        /**
         *   构造函数：既可以传入绝对路径，也可以传入相对路径
         *         注意Windows平台使用\作为路径分隔符，在Java字符串中需要用\\表示一个\。Linux平台使用/作为路径分隔符
         */
        File f = new File("C:\\Windows\\notepad.exe");
        /**
         *  调用isFile()，判断该File对象是否是一个已存在的文件;
         *         调用isDirectory()，判断该File对象是否是一个已存在的目录
         */
        System.out.println(f.isFile());
        System.out.println(f.isDirectory());


        File f1 = new File("..");
        /**
         * getPath()，返回构造方法传入的路径
         * getAbsolutePath()，返回绝对路径
         * getCanonicalPath，它和绝对路径类似，但是返回的是规范路径，即把.和..转换成标准的绝对路径后的路径
         */
        System.out.println(f1.getPath());
        System.out.println(f1.getAbsolutePath());
        System.out.println(f1.getCanonicalPath());

        /**
         * boolean canRead()：是否可读；
         * boolean canWrite()：是否可写；
         * boolean canExecute()：是否可执行；
         * long length()：文件字节大小。
         */

        /**
         * 创建、删除
         */
        File file2 = new File("/path/to/file");
        if (file2.createNewFile()) {
            // 文件创建成功:
            // TODO:
            if (file2.delete()) {
                // 删除文件成功:
            }
        }
        /**
         * 临时文件的创建和删除
         */
        File file3 = File.createTempFile("tmp-", ".txt"); // 提供临时文件的前缀和后缀
        file3.deleteOnExit(); // JVM退出时自动删除
        System.out.println(file3.isFile());
        System.out.println(file3.getAbsolutePath());

        /**
         * 遍历文件
         */
        File file4 = new File("C:\\Windows");
        File[] files4 = file4.listFiles(); // 列出所有文件和子目录
        printFiles(files4);
        File[] files5 = f.listFiles(new FilenameFilter() { // 仅列出.exe文件
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".exe"); // 返回true表示接受该文件
            }
        });
        printFiles(files5);


    }
    static void printFiles(File[] files) {
        System.out.println("==========");
        if (files != null) {
            for (File f : files) {
                System.out.println(f);
            }
        }
        System.out.println("==========");
    }
}
