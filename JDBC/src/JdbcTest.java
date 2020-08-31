import java.sql.SQLException;

public class JdbcTest {

	public static void main(String[] args) throws SQLException {
		Employee employee = new Employee(0, null, null, null, null, 0);
		System.out.println("get all employees");
		employee.getAllEmployees();
		System.out.println("get employee with id = 1");
		employee.getEmployee(1);
//		System.out.println("add new employee");
//		Employee newEmployee = new Employee (0, "George", "hubert", "ghubert@confluent.io", "IT", 60000.00);
//		employee.insertEmployee(newEmployee);
//		System.out.println("get all employees");
//		employee.getAllEmployees();
	}

}
