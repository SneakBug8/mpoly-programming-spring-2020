package Calc;

import java.util.Scanner;

//Тест для калькулятора формул.
public class CalcTest{
    public static void main(String[] args) throws Exception{
        Calc c = new Calc();
//Compf c = new Compf();

        Scanner in = new Scanner(System.in);
        while(true){
            System.out.print("Введите формулу -> ");
            c.compile(in.next().toCharArray());
            System.out.print("\n");
        }
    }
}