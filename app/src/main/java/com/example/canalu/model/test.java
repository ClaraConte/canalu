package com.example.canalu.model;

public class test {
    private static final test ourInstance = new test();

    public static test getInstance() {
        return ourInstance;
    }

    private test() {
    }
}
