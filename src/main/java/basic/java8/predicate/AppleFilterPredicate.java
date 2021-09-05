package basic.java8.predicate;

import basic.java8.predicate.constant.Color;
import basic.java8.predicate.pojo.Apple;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * predicate:谓词，可以做为参数进行传递
 *
 */
public class AppleFilterPredicate {
    public static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> predicate) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            // 看来是Predicate的固定写法
            if (predicate.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Apple> inventory = new ArrayList<>();
        inventory.add(new Apple(Color.GREEN, 180));
        inventory.add(new Apple(Color.RED, 100));
        inventory.add(new Apple(Color.YELLOW, 200));

        // 【新特性】将谓词传入函数中，调用test方法执行
        System.out.println("Green apples: " + filterApples(inventory, Apple::isGreenApple));
        System.out.println("Heavy apples: " + filterApples(inventory, Apple::isHeavyApple));
        System.out.println("Red and light apples: "
                + filterApples(inventory, (Apple a) -> Color.RED.equals(a.getColor()) && a.getWeight() < 150));
    }
}
