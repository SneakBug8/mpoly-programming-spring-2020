package RecursCompf;

//Рекурсивный компилятор формул.
public class RecursCompf {
    private static final int DEFSIZE = 255;
    private char[] str;
    private int index;

    // Обработка плюса и минуса
    private void compileF() {
        // System.out.println(str[index] + " compileF");
        // System.out.println(str[index]);
        // System.out.println(isOperation(index - 1));

        if (isOperation(index - 1)) {
            // this is unary

            if (str[index] == '-') {
                System.out.print("-1*");

                index++;
                compileF();
                
                return;
            }
            if (str[index] == '+') {
                index++;
                compileF();
                return;
            }
        }

        compileT();

        if (index >= str.length)
            return;

        if (str[index] == '+') {
            index++;
            compileF();
            System.out.print("+ ");
            return;
        }

        if (str[index] == '-') {
            index++;
            compileF();
            System.out.print("- ");
        }
    }

    // Обработка деления и умножения
    private void compileT() {
        // System.out.println(str[index] + " compileT");

        compileM();

        if (index >= str.length)
            return;

        if (str[index] == '*') {
            index++;
            compileT();
            System.out.print("*");
            return;
        }

        if (str[index] == '/') {
            index++;
            compileT();
            System.out.print("/");
        }
    }

    // Обработка скобок
    private void compileM() {
        // System.out.println(str[index] + " compileM");

        if (str[index] == '(') {
            index++;
            compileF();
            index++;
        } else
            compileV();
    }

    private void compileV() {
        // System.out.println(str[index] + " compileV");

        System.out.print("" + str[index]);
        index++;
        if (index < str.length && (str[index] + "").matches("([0-9]|[a-z])+"))
            compileV();
        else
            System.out.print(" ");
    }

    public void RecursCompf() {
        str = new char[DEFSIZE];
    }

    public void compile(char[] str) {
        this.str = str;
        index = 0;

        compileF();
        System.out.print("\n");
    }

    public boolean isNumber(int index) {
        if (index < 0) {
            return false;
        }

        if ((str[index] + "").matches("([0-9]|[a-z])")) {
            return true;
        }

        return false;
    }

    public boolean isOperation(int index) {
        if (index < 0) {
            return true;
        }

        if ((str[index] + "").matches("[\\+\\-\\*\\/]")) {
            return true;
        }

        return false;
    }
}

/*
 * compile -> compileF -> compileT (возвращаемся к compileF, если условие) ->
 * compileV -> вывод (чисел до ~ знаков)
 */