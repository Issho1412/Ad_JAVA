package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Vector;

public class EmployeeDaoImpl implements EmployeeDao{

    public EmployeeDaoImpl() {

        Database db = new Database();
        String SQL_CREATE_EMPLOYEE_TABLE = "CREATE TABLE IF NOT EXISTS EmployeesTable (\n"
                + "    ID integer PRIMARY KEY,\n"
                + "    FullName text NOT NULL,\n"
                + "    Gender text\n"
                + ");";
        try {
            Statement statement = db.getConnection().createStatement();
            statement.execute(SQL_CREATE_EMPLOYEE_TABLE);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        db.close();
    }
    @Override
    public void insertDEmployee(Employee employee) {
        Database db = new Database();
        final String SQL_CREATE_EMPLOYEE = "INSERT INTO EmployeesTable(FullName, Gender)" +
                "VALUES(?,?)";

        try {
            PreparedStatement ps = db.getConnection().prepareStatement(SQL_CREATE_EMPLOYEE, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, employee.getM_fullName());
            ps.setString(2, employee.isM_gender());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                employee.setM_id(id);
                System.out.println("Inserted id: " + id);
                System.out.println("Gender: "+ employee.isM_gender());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        db.close();
    }

    @Override
    public Employee getEmployeeById(int id) {
        return null;
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> employees = new Vector<>();

        Database db = new Database();

        final String SQL_SELECT_ALL_EMPLOYEES = "SELECT * FROM EmployeesTable";
        try {
            Statement statement = db.getConnection().createStatement();

            ResultSet rs = statement.executeQuery(SQL_SELECT_ALL_EMPLOYEES);
            while (rs.next()) {

                int id = rs.getInt(1);
                String fullName = rs.getString(2);
                String gender = rs.getString(3);

                Employee employee = new Employee(id, fullName, gender);

                employees.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        db.close();
        return employees;
    }

    @Override
    public void updateDEmployee(Employee employee) {
       // List<Employee> employees = new Vector<>();
        Database db = new Database();
        final String SQL_UPDATE_EMPLOYEE = "UPDATE EmployeesTable SET FullName = ?, Gender = ?"
                + "WHERE ID = ?;";
        try {
            PreparedStatement ps = db.getConnection().prepareStatement(SQL_UPDATE_EMPLOYEE);
            ps.setString(1, employee.getM_fullName());
            ps.setString(2, employee.isM_gender());
            ps.setInt(3, employee.getM_id());
            ps.executeUpdate();
            System.out.println("Updated ID: " + employee.getM_id());
            System.out.println("Updated Gender: " + employee.isM_gender());
            System.out.println("Updated FullName: " + employee.getM_fullName());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        db.close();
    }

    @Override
    public void deleteDEmployee(int id) {
        Database db = new Database();
        final String SQL_DELETE_EMPLOYEE = "DELETE FROM EmployeesTable WHERE id=?";

        try {
            PreparedStatement ps = db.getConnection().prepareStatement(SQL_DELETE_EMPLOYEE, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        db.close();
    }
}
