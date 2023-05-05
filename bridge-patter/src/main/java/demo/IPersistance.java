package demo;

public interface IPersistance<T> {

    void persist(T t);
    void delete(int id);
    T get();

//    void test();
}
