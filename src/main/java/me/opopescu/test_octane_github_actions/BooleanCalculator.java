package me.opopescu.test_octane_github_actions;

public class BooleanCalculator {
    private boolean result = false;

    public void or(boolean a, boolean b) {
        result = a || b;
    }

    public void and(boolean a, boolean b) {
        result = a && b;
    }

    public boolean getResult() {
        return result;
    }
}
