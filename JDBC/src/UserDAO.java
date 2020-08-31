import java.util.Set;

public interface UserDAO {
	Set<Employee> getAllEmployees();
    Employee getEmployee(int id);
    boolean insertEmployee(Employee employee);
}
