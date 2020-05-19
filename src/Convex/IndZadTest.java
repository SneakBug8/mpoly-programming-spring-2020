package Convex;

public class IndZadTest {
    public static void main(String[] args) throws Exception {
        Convex convex = new Convex();

        ConvexWindow window = new ConvexWindow(convex);

        var p1 = new R2Point();
        var pfirst = p1;
        convex.add(p1);

        var count = 0;

        while (true) {
            var p2 = new R2Point();
            convex.add(p2);

            if (CheckPrerequisites(p1, p2)) {
                count++;
            }

            if (convex.area() > 0 && CheckPrerequisites(pfirst, p2)) {
                System.out.println("count: " + (count + 1));
            } else {
                System.out.println("count: " + count);
            }

            p1 = p2;

        }
    }

    public static boolean CheckPrerequisites(R2Point p1, R2Point p2) {
        // bounds: (0, 3), (0, 3)
        var bound1 = 0;
        var bound2 = 30;

        if (p1.getX() > bound1 && p1.getX() < bound2 && p1.getY() > bound1 && p1.getY() < bound2 && p2.getX() > bound1
                && p2.getX() < bound2 && p2.getY() > bound1 && p2.getY() < bound2) {
            return true;
        }

        return false;
    }
}