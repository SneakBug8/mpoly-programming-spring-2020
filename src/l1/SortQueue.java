package l1;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

public class SortQueue extends Stack {
    Scanner in = new Scanner(System.in);

    private final static int DEFSIZE = 16;
    private int[] array;
    private int size, head, tail;

    public SortQueue(int size) {
        array = new int[size];
        this.size = head = 0;
        tail = array.length - 1;
    }

    public SortQueue() {
        this(DEFSIZE);
    }

    private int forward(int index) {
        return ++index < array.length ? index : 0;
    }

    private int backward(int index) {
        return --index >= 0 ? index : array.length - 1;
    }

    public int front() {
        return array[head];
    }

    public int back() {
        return array[tail];
    }

    public int length() {
        return size;
    }

    public void pushFront(int p) {
        array[head = backward(head)] = p;
        size += 1;
    }

    public void pushBack(int p) {
        array[tail = forward(tail)] = p;
        size += 1;
    }

    public int popFront() {
        int p = front();
        head = forward(head);
        size -= 1;
        return p;
    }

    public int popBack() {
        int p = back();
        tail = backward(tail);
        size -= 1;
        return p;
    }

    public boolean blocked(int index) {
        if (index < head || index > tail) {
            return true;
        }
        return false;
    }

    public int biggerind() {
        return tail > head ? tail : head;
    }

    public int smallerind() {
        return tail > head ? head : tail;
    }

    public void sort() {
        boolean isSorted = false;
        int fbuf;
        int sbuf;
        int mbuf;

        System.out.println("Smallerind " + smallerind());
        System.out.println("Biggerind " + biggerind());

        for (int i = smallerind(); i < biggerind(); i++) {

            System.out.println("Smallerind " + smallerind());
            System.out.println("Biggerind " + biggerind());
            mbuf = popFront();
            for (int j = i + 1; j < biggerind(); j++) {
                fbuf = popFront();
                sbuf = popFront();

                if (fbuf > sbuf) {
                    pushBack(sbuf);
                    pushBack(fbuf);
                } else {
                    pushBack(fbuf);
                    pushBack(sbuf);
                }
            }
            pushBack(mbuf);
        }

        System.out.println("===");
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    /*
     * while (!isSorted) { isSorted = true; for (int i = smallerind(); i <=
     * biggerind(); i++) { int biggerindex = i + 1;
     * 
     * if (blocked(biggerindex)) { continue; }
     * 
     * if (array[i] > array[biggerindex]) { isSorted = false;
     * 
     * buf = array[i]; array[i] = array[biggerindex]; array[biggerindex] = buf; } }
     * }
     * 
     * }
     */

    public static void main(String[] args) {
        SortQueue qu = new SortQueue(10);
        for (int i = 0; i < 10; i++) {
            qu.pushFront((int) (Math.random() * 10));
        }

        qu.popFront();
        qu.popBack();

        for (int i = 0; i < qu.array.length; i++) {
            System.out.println(qu.array[i]);
        }

        System.out.println("===");

        qu.sort();

        /*
         * System.out.println("===");
         * 
         * for (int i = qu.smallerind(); i <= qu.biggerind(); i++) {
         * System.out.println(qu.array[i]); }
         */
    }
}