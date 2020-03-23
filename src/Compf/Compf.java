package Compf;

import java.util.regex.Pattern;

//Стековый компилятор формул.
public class Compf extends Stack {
    // Типы символов (скобки, знаки операций, иное).
    protected final static int SYM_LEFT = 0, SYM_RIGHT = 1, SYM_OPER = 2, SYM_OTHER = 3;

    private int symType(String c) {
        switch (c) {
            case "(":
                return SYM_LEFT;
            case ")":
                return SYM_RIGHT;
            case "+":
            case "-":
            case "*":
            case "/":
                return SYM_OPER;
            default:
                return symOther(c);
        }
    }

    String symCache = "";

    private void processSymbol(String c) {
        System.out.println(c + " | " + symType(c) + " | " + symCache);

        if (symType(c) == SYM_OTHER) {
            symCache += c;
            return;
        } else if (symCache != "") {
            nextOther(symCache);
            symCache = "";
        }

        switch (symType(c)) {
            case SYM_LEFT:
                push(c);
                break;
            case SYM_RIGHT:
                processSuspendedSymbols(c);
                pop();
                break;
            case SYM_OPER:
                processSuspendedSymbols(c);
                push(c);
                break;
        }
    }

    private void processSuspendedSymbols(String c) {
        while (precedes(top(), c))
            nextOper(pop());
    }

    private int priority(String c) {
        return c == "+" || c == "-" ? 1 : 2;
    }

    private boolean precedes(String a, String b) {
        if (symType(a) == SYM_LEFT)
            return false;
        if (symType(b) == SYM_RIGHT)
            return true;

        return priority(a) >= priority(b);
    }

    protected int symOther(String c) {
        if (Pattern.compile("[0-9]").matcher(c).matches()) {
            return SYM_OTHER;
        }

        System.out.println("Недопустимый символ: " + c);
        System.exit(0);
        return 0;
    }


    protected void nextOper(String c) {
        System.out.print(c);
    }

    protected void nextOther(String c) {
        nextOper(c);
    }

    public void compile(String[] str) {
        processSymbol("(");

        for (int i = 0; i < str.length; i++)
            processSymbol(str[i]);

        processSymbol(")");

        System.out.print("\n");
    }
}
