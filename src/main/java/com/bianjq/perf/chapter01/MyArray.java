package com.bianjq.perf.chapter01;

import java.lang.reflect.Array;

interface Function<T> {
    long perform(T parameter, long x);
}

public class MyArray<T> {
    T[] array;
    long x;

    public MyArray(int size, Class<T> type, long x) {
        array = (T[]) Array.newInstance(type, size);
        this.x = x;
    }

    public void forEach(Function<T> function) {
        for (T element : array) {
            x = function.perform(element, x);
        }
    }
}
