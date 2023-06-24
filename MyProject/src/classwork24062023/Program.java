package classwork24062023;

import java.util.Arrays;

/*1. Напишите метод, который заполнит массив из 99 элементов случайными цифрами от 0 до 50.

2. Создайте метод, в который передайте заполненный выше массив и с помощью Set вычислите процент уникальных
 значений в данном массиве и верните его в виде числа с плавающей запятой.

Для вычисления процента используйте формулу:

процент уникальных чисел = количество уникальных чисел * 100 / общее количество чисел в массиве. */

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Program {
  public static void main(String[] args) {
    System.out.println(Peredacha(Fun1()));
  }

  public static Integer[] Fun1() {
    Integer[] nums = new Integer[99];
    Random random = new Random();
    for (Integer i = 0; i < 99; i++) {
      int randomNum = random.nextInt(50);
      nums[i] = randomNum;
    }
    return nums;
  }

  public static float Peredacha(Integer[] nums) {
    Set<Integer> Unikum = new HashSet<Integer>(Arrays.asList(nums));
    float ProcentUCh = (float) Unikum.size() * (float)100 / nums.length;
    return ProcentUCh;
  }

}
