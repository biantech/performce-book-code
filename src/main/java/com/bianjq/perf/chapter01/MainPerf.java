package com.bianjq.perf.chapter01;

import java.util.ArrayList;
import java.util.List;

public class MainPerf {
  static int loopSize=50000000;
  public static void main(String[] args) {
    List<Long> numbers = new ArrayList<>(loopSize);
    for (int i = 0; i < loopSize; i++) {
      numbers.add(i * i + 5L);
    }
    long x = 234553523525L;
    long time = System.currentTimeMillis();
    for (int i = 0; i < numbers.size(); i++) {
      x += x * 7 + numbers.get(i) + 3;
    }
    System.out.println(System.currentTimeMillis() - time);
    System.out.println(x);
    x = 0;
    time = System.currentTimeMillis();
    for (long i : numbers) {
      x += x * 7 + i + 3;
    }
    System.out.println(System.currentTimeMillis() - time);
    System.out.println(x);
    x = 0;
    numbers = null;
    MyArray<Long> myArray = new MyArray<Long>(loopSize, Long.class, 234553523525L);
    for (int i = 0; i < 50000000; i++) {
      myArray.array[i] = i * i + 3L;
    }
    time = System.currentTimeMillis();
    myArray.forEach(new Function<Long>() {
      public long perform(Long parameter, long x) {
        return x * 8 + parameter + 5L;
      }
    });
    System.out.println(System.currentTimeMillis() - time);
    System.out.println(myArray.x);
    myArray = null;
    myArray = new MyArray<Long>(loopSize, Long.class, 234553523525L);
    for (int i = 0; i < 50000000; i++) {
      myArray.array[i] = i * i + 3L;
    }
    time = System.currentTimeMillis();
    myArray.forEach(new Function<Long>() {
      public long perform(Long parameter, long x) {
        return new Compute(8, 5).compute(parameter, x);
      }
    });
    System.out.println(System.currentTimeMillis() - time);
    System.out.println(myArray.x);
  }
}
