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

        if (prevSymbol() != null) {
            if (symType(prevSymbol()) == SYM_OPER && symType(c) == SYM_OPER && c.equals("-")) {
                symCache = "-" + symCache;
                return;
            }

            if (symType(prevSymbol()) == SYM_LEFT && symType(c) == SYM_OPER && c.equals("-")) {
                symCache = "-" + symCache;
                return;
            }
        }

        if (symType(c) == SYM_OTHER) {
            symCache += c;
        }

        if (nextSymbol() != null) {
            if (symType(c) == SYM_OTHER && symType(nextSymbol()) != SYM_OTHER) {
                nextOther(symCache);
                symCache = "";
                return;
            }
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
            /*case SYM_OTHER:
                nextOther(symCache);
                break;*/
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

    String[] symbols;
    int currentSymbol = 0;

    private String prevSymbol() {
        if (currentSymbol > 0) {
            return symbols[currentSymbol - 1];
        }

        return null;
    }

    private String nextSymbol() {
        if (currentSymbol < symbols.length - 1) {
            return symbols[currentSymbol + 1];
        }

        return null;
    }

    public void compile(String[] str) {
        symbols = new String[str.length + 2];

        symbols[0] = "(";
        symbols[str.length + 1] = ")";

        for (int i = 1; i < symbols.length - 1; i++) {
            symbols[i] = str[i - 1];
        }

        for (int i = 0; i < symbols.length; i++) {
            currentSymbol = i;
            processSymbol(symbols[i]);
        }

        System.out.print("\n");
    }
}
