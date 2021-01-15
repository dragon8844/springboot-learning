package com.dragon.javaspi;

import java.util.ServiceLoader;

/**
 * Create By IntelliJ IDEA
 *
 * @author LiLong
 * @date 2021/1/6
 */
public class SpiTest {
    public static void main(String[] args) {
        ServiceLoader<IAnimal> animals = ServiceLoader.load(IAnimal.class);
        for (IAnimal animal : animals) {
            animal.shout();
        }
    }
}
