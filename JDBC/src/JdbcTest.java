import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcTest {

	public static String URL = null;
	public static String USER = null;
	public static String PASS = null;

	public static void main(String[] args) throws SQLException, IOException {
		
		Properties defaultProps = new Properties();
		FileInputStream propFile = new FileInputStream("demo.properties");
		defaultProps.load(propFile);
		
		URL = defaultProps.getProperty("DB_URL");
		USER = defaultProps.getProperty("USER");
		PASS = defaultProps.getProperty("PASS");
		
		propFile.close();

		Employee employee = new Employee(0, null, null, null, null, 0);
		System.out.println("get all employees");
		employee.getAllEmployees();
		System.out.println("get employee with id = 1");
		employee.getEmployee(1);
		
//		System.out.println("add new employee");
//		Employee newEmployee = new Employee (0, "hubert", "george", "ghubert@confluent.io", "IT", 60000.00);
//		employee.insertEmployee(newEmployee);
//		System.out.println("get all employees");
//		employee.getAllEmployees();
		
//		Employee updateEmployee = new Employee (1, "Doe", "John", "john.doe@foo.io", "HR", 60000.00);
//		employee.updateEmployee(updateEmployee);
		
//		employee.deleteEmployee(13);
//		System.out.println("get all employees");
//		employee.getAllEmployees();
	}

}
