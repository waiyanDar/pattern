package demo;

public class Hibernate implements IPersistance<Employee>{
    @Override
    public void persist(Employee employee) {
        System.out.println("Hibernate :: persist");
    }

    @Override
    public void delete(int id) {
        System.out.println("Hibernate :: delete");
    }

    @Override
    public Employee get() {
        System.out.println("Hibernate :: get");
        return null;
    }
}
