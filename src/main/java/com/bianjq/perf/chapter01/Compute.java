package com.bianjq.perf.chapter01;

public class Compute {
    int factor;
    final long constant;

    public Compute(int factor, long constant) {
        this.factor = factor;
        this.constant = constant;
    }

    public long compute(long parameter, long x) {
        return x * factor + parameter + constant;
    }
}
