package Compf;

// Калькулятор арифметических формул.
public class Calc extends Compf {
    private StackInt s;

    private static int String2int(String c) {
        return Integer.parseInt(c + "");
        // return (int) c - (int) '0';
    }

    protected int symOther(String c) {
        return SYM_OTHER;
    }

    protected void nextOper(String c) {
        int second = s.pop();
        int first = s.pop();
        switch (c) {
            case "+":
                s.push(first + second);
                break;
            case "-":
                s.push(first - second);
                break;
            case "*":
                s.push(first * second);
                break;
            case "/":
                s.push(first / second);
                break;
        }
    }

    protected void nextOther(String c) {
        s.push(String2int(c));
    }

    public Calc() {
        s = new StackInt();
    }

    public final void compile(String[] str) {
        super.compile(str);
        System.out.println("" + s.top());
    }
}