package Compf;

//Непрерывная реализация стека символов.
class Stack{
    private static final int DEFSIZE = 16;
    private String[] array;
    private int head;

    public Stack(){
        array = new String[DEFSIZE];
        head = 0;
    }

    public final void push(String c){
        array[head++]= c;
    }

    public final String pop(){
        return array[--head];
    }

    public final String top(){
        return array[head-1];
    }
}