package dao;

import app.DBUtil;
import model.Employee;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {
    private static EmployeeDAO instance;

    public static EmployeeDAO getInstance() {

        if (instance == null) {
            instance = new EmployeeDAO();
        }

        return instance;
    }

    private EmployeeDAO(){

    }

    public boolean save(Employee employee){
        try (Connection conn = DBUtil.getConn();
             PreparedStatement statement = conn.prepareStatement
                     ("INSERT INTO Employees (name, surname, address, phone, note, salary_per_hour) VALUES (?,?,?,?,?,?) ")){

            statement.setString(1, employee.getName());
            statement.setString(2, employee.getSurname());
            statement.setString(3, employee.getAddress());
            statement.setString(4, employee.getPhone());
            statement.setString(5, employee.getNote());
            statement.setBigDecimal(6, employee.getSalary_per_hour());

            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Employee> getAllEmployees (){
        List<Employee> list = new ArrayList<>();
        try (Connection conn = DBUtil.getConn();
             Statement statement = conn.createStatement())
            {
            ResultSet rs = statement.executeQuery("SELECT * FROM Employees");
            while(rs.next()){
                Integer id = rs.getInt("id");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                String address = rs.getString("address");
                String phone = rs.getString("phone");
                String note = rs.getString("note");
                BigDecimal salary_per_hour = rs.getBigDecimal("salary_per_hour");
                    list.add(new Employee(id,name, surname, address, phone, note, salary_per_hour));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public Employee getEmployeeById(int id){
        try ( Connection conn = DBUtil.getConn();
              PreparedStatement statement = conn.prepareStatement
                      ("SELECT *  FROM Employees WHERE id=?")){
            statement.setInt(1,id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                Integer employeeId = rs.getInt("id");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                String address = rs.getString("address");
                String phone = rs.getString("phone");
                String note = rs.getString("note");
                BigDecimal salary_per_hour = rs.getBigDecimal("salary_per_hour");

                return new Employee(employeeId,name, surname, address, phone, note, salary_per_hour);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean update(Employee employee){
        try (Connection conn = DBUtil.getConn();
             PreparedStatement statement = conn.prepareStatement
                     ("UPDATE Employees SET name=?, surname=?, address=?, phone=?, note=?, salary_per_hour=? WHERE id=? ")){

            statement.setString(1,employee.getName());
            statement.setString(2,employee.getSurname());
            statement.setString(3,employee.getAddress());
            statement.setString(4,employee.getPhone());
            statement.setString(5,employee.getNote());
            statement.setBigDecimal(6,employee.getSalary_per_hour());
            statement.setInt(7,employee.getId());

            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(int id){
        try(Connection conn = DBUtil.getConn();
            PreparedStatement statement = conn.prepareStatement
                    ("DELETE FROM Employees WHERE id=?")) {
            statement.setInt(1,id);
            int numRowsAffected = statement.executeUpdate();
            return numRowsAffected>0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }
}

