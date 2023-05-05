package demo;

public class MyBatis implements IPersistance<Employee>{
    @Override
    public void persist(Employee employee) {
        System.out.println("MyBatis :: persist");
    }

    @Override
    public void delete(int id) {
        System.out.println("MyBatis :: delete");
    }

    @Override
    public Employee get() {
        System.out.println("MyBatis :: get");
        return null;
    }
}
