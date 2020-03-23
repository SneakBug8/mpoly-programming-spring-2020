package Compf;

import java.util.Scanner;

public class CalcTest {
    public static void main(String[] args) throws Exception {
        Calc c = new Calc();
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.print("Введите формулу -> ");
            var chararray = in.next().toCharArray();
            var stringarray = new String[chararray.length];

            for (int i = 0; i < chararray.length; i++) {
                stringarray[i] = chararray[i] + "";
            }

            c.compile(stringarray);
            System.out.print("\n");
        }
    }
}
