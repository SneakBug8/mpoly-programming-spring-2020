package l1;

import java.util.Random;

public class App {
    public static void main(String[] args) throws Exception {
        Deq deq = new Deq();

        Random rand = new Random();

        for (int i = 0; i < 10; i ++) {
            int r = rand.nextInt(100);
            System.out.println(r);
            deq.pushFront(new R2Point(r, 1));
        }
        System.out.println("===");
        System.out.println(deq.length());
        System.out.println("===");


        for (int i = 0; i < 10; i ++) {
            System.out.println(deq.popFront().x);
            deq.popBack();
        }
    }
}

class Stack {
    private static final int DEFSIZE = 5;
    private int[] array;
    private int head;

    public Stack() {
        this(DEFSIZE);
    }

    public Stack(int size) {
        array = new int[size];
        head = 0;
    }

    public boolean empty() {
        return head == 0;
    }

    public void clear() {
        head = 0;
    }

    public void push(int val) throws Exception {
        if (head < DEFSIZE) {
            array[head++] = val;
        } else {
            System.out.println("Stack out of size");
        }
    }

    public int pop() throws Exception {
        return array[--head];
    }

    public int top() throws Exception {
        return array[head - 1];
    }
}

class Queue {
    private int[] array;
    private int size, head, tail;

    private int forward(int index) {
        return ++index < array.length ? index : 0;
    }

    public Queue(int size) {
        array = new int[size];
        clear();
    }

    public boolean empty() {
        return size == 0;
    }

    public void clear() {
        size = head = 0;
        tail = array.length - 1;
    }

    public void push(int val) throws Exception {
        if (++size >= array.length)
            throw new Exception();
        array[tail = forward(tail)] = val;
    }

    public int pop() throws Exception {
        int val = front();
        head = forward(head);
        size -= 1;
        return val;
    }

    public int front() throws Exception {
        if (empty())
            throw new Exception();
        return array[head];
    }

}

class R2Point {
    public double x, y;

    public R2Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public static double dist(R2Point a, R2Point b) {
        return Math.sqrt((a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y));
    }

    public static double area(R2Point a, R2Point b, R2Point c) {
        return 0.5 * ((a.x - c.x) * (b.y - c.y) - (a.y - c.y) * (b.x - c.x));
    }

    public static boolean equal(R2Point a, R2Point b) {
        return a.x == b.x && a.y == b.y;
    }

    public static boolean isTriangle(R2Point a, R2Point b, R2Point c) {
        return area(a, b, c) != 0.0;
    }

    public boolean inside(R2Point a, R2Point b) {
        return (a.x <= x && x <= b.x || a.x >= x && x >= b.x) && (a.y <= y && y <= b.y || a.y >= y && y >= b.y);
    }

    public boolean light(R2Point a, R2Point b) {
        double s = area(a, b, this);
        return s < 0.0 || (s == 0.0 && !inside(a, b));
    }

}

// Непрерывная реализация дека.
class Deq {
    private final static int DEFSIZE = 16;
    private R2Point[] array;
    private int size, head, tail;

    private int forward(int index) {
        return ++index < array.length ? index : 0;
    }

    private int backward(int index) {
        return --index >= 0 ? index : array.length - 1;
    }

    public Deq(int size) {
        array = new R2Point[size];
        this.size = head = 0;
        tail = array.length - 1;
    }

    public Deq() {
        this(DEFSIZE);
    }

    public int length() {
        return size;
    }

    public void pushFront(R2Point p) {
        array[head = backward(head)] = p;
        size += 1;
    }

    public void pushBack(R2Point p) {
        array[tail = forward(tail)] = p;
        size += 1;
    }

    public R2Point popFront() {
        R2Point p = front();
        head = forward(head);
        size -= 1;
        return p;
    }

    public R2Point popBack() {
        R2Point p = back();
        tail = backward(tail);
        size -= 1;
        return p;
    }

    public R2Point front() {
        return array[head];
    }

    public R2Point back() {
        return array[tail];
    }
}