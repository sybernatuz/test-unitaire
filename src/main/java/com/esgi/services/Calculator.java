package com.esgi.services;

import java.util.stream.IntStream;

public class Calculator {

    public int add(int a, int b) {
        return a + b;
    }

    public int sub(int a, int b) {
        return a - b;
    }

    public int mul(int a, int b) {
        return a * b;
    }

    public float div(int a, int b) {
        return a / b;
    }

    public float avg(int[] tab) {
        if (tab.length == 0)
            return 0;

        int sum = IntStream.of(tab).sum();
        return sum / tab.length;
    }

}
