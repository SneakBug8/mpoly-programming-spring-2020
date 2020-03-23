package Compf;

import java.util.Scanner;

//Тест для компилятора формул.
public class CompfTest{
    public static void main(String[] args) throws Exception {
        Compf c = new Compf();

        Scanner in = new Scanner(System.in);
        while(true){
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