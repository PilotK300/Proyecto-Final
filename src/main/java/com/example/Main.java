package com.example;

import com.example.vista.TestConsola;

public class Main {
    private static final TestConsola t = new TestConsola();

    public static void main(String[] args) {
        startUi();
    }

    public static void startUi() {
        t.loadSystem();

        t.menu();
    }
}