package me.opopescu.test_octane_github_actions;

public class Calculator {
    private int result = 0;

    public void add(int a, int b) {
        result = a + b;
    }

    public void sub(int a, int b) {
        result = a - b;
    }

    public void multiply(int a, int b) {
        result = a * b;
    }

    public void divide(int a, int b) {
        if (b != 0) {
            result = a / b;
        } else {
            result = 0;
        }
    }

    public int getResult() {
        return result;
    }
}
