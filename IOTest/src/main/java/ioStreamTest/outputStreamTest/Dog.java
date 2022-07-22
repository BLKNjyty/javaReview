package ioStreamTest.outputStreamTest;

import java.io.Serializable;

/**
 * @Description
 * @Author yu.jin
 * @Date 2022-07-22 16:48
 */
public class Dog implements Serializable {

    String name;
    String breed;

    public Dog(String name, String breed) {
        this.name = name;
        this.breed = breed;
    }
}
