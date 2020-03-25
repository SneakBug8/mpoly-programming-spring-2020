package Convex;

import java.util.Scanner;

//Тест для выпуклой оболочки.
class ConvexTest {
    public static void main(String[] args) throws Exception {
        Convex convex = new Convex();

        while (true) {                                                   
            Scanner in = new Scanner(System.in);
            System.out.print("x -> ");
            var x = in.nextDouble();
            System.out.print("y -> ");
            var y = in.nextDouble();

            convex.add(new R2Point(x, y));

            System.out.println("S = " + convex.area() + ", P = " + convex.perimeter());
        }
    }
}
