package l1;
/*
class LList {
    // массив элементов
    private Object[] array; // массив ссылок.
    private int[] next; // "нил" списка.
    private int nilList; // "нил" свободного места.
    private int nilFree; // индексы элементов до и после указателя
    private int before, after; // связать два элемента, заданные индексами.

    public LList(int size) {
        array = new Object[size];
        next = new int[size + 2];
        nilList = size;
        nilFree = size + 1;
        link(nilList, nilList);
        link(nilFree, 0);
        for (int i = 0; i < size - 1; i++)
            link(i, i + 1);
        link(size - 1, nilFree);
        before = after = nilList;
    }

    private void link(int first, int second) {
        next[first] = second;
    } // захватить место.

    private int mallocIndex() {
        int index = next[nilFree];
        link(nilFree, next[index]);
        return index;
    } // освободить место.

    private void freeIndex(int index) {
        link(index, next[nilFree]);
        link(nilFree, index);
    }
    /// За указателем некуда двигаться
    public boolean empty() {
        return next[nilList] == nilList;
    }

    public void clear() {
        try {
            toFront();
            while (true)
                erase();
        } catch (Exception e) {
            ;
        }
    }

    public void toFront() {
        before = nilList;
        after = next[nilList];
    }

    // Последний ли это элемент
    public boolean end() {
        return after == nilList;
    }

    // Передвинуть указатель на 1
    public void forward() throws Exception {
        if (after == nilList)
            throw new Exception();
        before = after;
        after = next[after];
    }

    // Значение следующего элемента
    public int after() throws Exception {
        return array[after];
    }

    public void insert(int val) throws Exception {
        int index = mallocIndex();
        link(before, index);
        link(index, after);
        after = index;
        array[index] = val;
    }

    // Удалить элемент, следующий за указателем
    public int erase() throws Exception {
        int val = array[after];
        int index = after;
        after = next[index];
        link(before, after);
        freeIndex(index);
        return val;
    }

    public static void main(String[] args) throws Exception {
        LList l = new LList(5);

        l.insert(1);
        l.toFront();
        l.erase();

        System.out.println("===");

        l.toFront();

        for (int i = 0; i < 5; i++) {
            System.out.println(l.array[i]);
        }
    }
}
*/