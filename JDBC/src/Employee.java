import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class Employee implements UserDAO {
	private int id;
	private String first_name;
	private String last_name;
	private String email;
	private String department;
	private double salary;
	
	public Employee(int id, String first_name, String last_name, String email, String department, double salary) {
		super();
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.department = department;
		this.salary = salary;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	private Employee extractEmployeeFromResultSet(ResultSet rs) throws SQLException {
		Employee employee = new Employee(id, first_name, last_name, email, department, salary);

		employee.setId(rs.getInt("id"));
		employee.setFirst_name(rs.getString("first_name"));
		employee.setLast_name(rs.getString("last_name"));
		employee.setEmail(rs.getString("email"));
		employee.setDepartment(rs.getString("department"));
		employee.setSalary(rs.getDouble("salary"));
		System.out.println(employee.getFirst_name() + "\t" + employee.getLast_name() + "\t" + employee.getEmail() + "\t"
				+ employee.getDepartment() + "\t" + employee.getSalary());
		return employee;
	}

	public Set<Employee> getAllEmployees() {
		Connection connection = ConnectionFactory.getConnection();
		try {
			java.sql.Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM employees");
			Set<Employee> employees = new HashSet<Employee>();
			while (rs.next()) {
				Employee employee = extractEmployeeFromResultSet(rs);
				employees.add(employee);
			}
			return employees;
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public Employee getEmployee(int id) {
		Connection connection = ConnectionFactory.getConnection();
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM employees WHERE id=" + id);
			if (rs.next()) {
				return extractEmployeeFromResultSet(rs);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	public boolean insertEmployee(Employee employee) {
		Connection connection = ConnectionFactory.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("INSERT INTO employees VALUES (NULL, ?, ?, ?, ?, ?)");
			ps.setString(1, employee.getFirst_name());
			ps.setString(2, employee.getLast_name());
			ps.setString(3, employee.getEmail());
			ps.setString(4, employee.getDepartment());
			ps.setDouble(5, employee.getSalary());
			int i = ps.executeUpdate();
			if (i == 1) {
				return true;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return false;
	}
	

}
