
package Convex;
import java.awt.*;

//Тест для выпуклой оболочки.
class ConvexTest{
    public static void main(String[] args) throws Exception{
        Convex convex = new Convex();
        
        ConvexWindow window = new ConvexWindow(convex);

        while(true){
            convex.add(new R2Point());
            window.add();
            System.out.println("S = " + convex.area()+ ", P = " + convex.perimeter());
        }
    }
}
