package demo;

public class JpaPersistance implements IPersistance<Employee>{
    @Override
    public void persist(Employee employee) {
        System.out.println("JpaPersistance :: persist");
    }

    @Override
    public void delete(int id) {
        System.out.println("JpaPersistance :: delete");
    }

    @Override
    public Employee get() {
        System.out.println("JpaPersistance :: get");
        return null;
    }
}
