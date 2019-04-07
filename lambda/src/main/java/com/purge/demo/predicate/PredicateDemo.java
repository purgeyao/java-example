package com.purge.demo.predicate;

import java.util.*;
import java.util.function.Predicate;

/**
 * {@link Predicate}
 *
 * @author purgeyao
 * @version 1.0
 * @date 2019-04-07
 */
public class PredicateDemo {

    /**
     * @param source    源集合
     * @param predicate Predicate
     * @param <E>       类型
     * @return 过滤后集合
     */
    private static <E> Collection<E> filter(Collection<E> source, Predicate<E> predicate) {
        // 集合类操作，请不要直接利用参数
        List<E> copyList = new ArrayList<>(source);

        Iterator<E> iterator = copyList.iterator();

        while (iterator.hasNext()) {
            E element = iterator.next();

            // test() 根据给定的参数计算此谓词。 条件为predicate 自定义函数
            if (!predicate.test(element)) {
                iterator.remove();
            }
        }
        return Collections.unmodifiableList(copyList);
    }

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        // 过滤偶数 保留奇数
        Collection<Integer> even = filter(numbers, num -> num % 2 == 0);

        // 过滤奇数 保留偶数
        Collection<Integer> odd = filter(numbers, num -> num % 2 != 0);

        System.out.println(odd);

        System.out.println(even);
    }
}
