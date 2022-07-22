package pathTest;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @Description
 * @Author yu.jin
 * @Date 2022-07-22 14:42
 */
public class PathDemo {
    public static void main(String[] args) {
        // 构造一个Path对象
        Path p1 = Paths.get(".", "project", "study");
        System.out.println(p1);
        // 转换为绝对路径
        Path p2 = p1.toAbsolutePath();
        System.out.println(p2);
        // 转换为规范路径
        Path p3 = p2.normalize();
        System.out.println(p3);
        // 转换为File对象
        File f = p3.toFile();
        System.out.println(f);
        // 可以直接遍历Path
        for (Path p : Paths.get("..").toAbsolutePath()) {
            System.out.println("  " + p);
        }
    }
}
