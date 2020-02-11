package l1;

public class App {
    public static void main(String[] args) {
        int[] a = new int[] { 30, 2, 5 };
        int[] b = a;
        a[1] = 1000;
        System.out.println(b[1]);
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
        array[head++] = val;
    }

    public int pop() throws Exception {
        return array[--head];
    }

    public int top() throws Exception {
        return array[head - 1];
    }
}