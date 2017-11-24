package Model.DataStructures;

public interface MyIStack<T> {
    T pop();
    void push(T el);
    boolean isEmpty();
}
