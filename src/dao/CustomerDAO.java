package dao;

import model.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;


public class CustomerDAO {

    private static CustomerDAO instance;

    public static CustomerDAO getInstance() {

        if (instance == null) {
            instance = new CustomerDAO();
        }

        return instance;
    }

    private CustomerDAO(){

    }

    public boolean save(Customer customer){
        try (Connection conn = DBUtil.getConn();
             PreparedStatement statement = conn.prepareStatement
                    ("INSERT INTO Customers (name, surname, birth_date) VALUES (?,?,?) ")){

            statement.setString(1, customer.getName());
            statement.setString(2, customer.getSurname());
            LocalDate birth_date = customer.getBirth_date();
            if(birth_date==null || birth_date.equals("") ){
                statement.setDate(3, null);
            } else{
                statement.setDate(3, Date.valueOf(customer.getBirth_date()));
            }
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List <Customer> getAllCustomers (){
        List<Customer> list = new ArrayList<>();
        try (Connection conn = DBUtil.getConn();
             Statement statement = conn.createStatement())
            {
            ResultSet rs = statement.executeQuery("SELECT * FROM Customers");
            while(rs.next()){
                Integer id = rs.getInt("id");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                Date birth_date = rs.getDate("birth_date");
                if (birth_date==null){
                    list.add(new Customer(id,name, surname));
                } else {
                    list.add(new Customer(id,name, surname, birth_date.toLocalDate()));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public Customer getCustomerById(int id){
        try ( Connection conn = DBUtil.getConn();
                PreparedStatement statement = conn.prepareStatement
                        ("SELECT *  FROM Customers WHERE id=?")){
            statement.setInt(1,id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                Date birth_date = rs.getDate("birth_date");
                Integer customerId = rs.getInt("id");
                if(birth_date==null){
                    return new Customer(id,name, surname);
                } else{
                    return new Customer(id,name, surname,birth_date.toLocalDate());
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean update(Customer customer){
        try (Connection conn = DBUtil.getConn();
            PreparedStatement statement = conn.prepareStatement
                    ("UPDATE Customers SET name=?, surname=?, birth_date=? WHERE id=? ")){

            statement.setString(1,customer.getName());
            statement.setString(2,customer.getSurname());
            LocalDate localDate = customer.getBirth_date();
            if(localDate!=null && !localDate.equals("")){
                statement.setDate(3, Date.valueOf(customer.getBirth_date()));
            } else{
                statement.setDate(3, null);
            }
            statement.setInt(4,customer.getId());

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
                    ("DELETE FROM Customers WHERE id=?")) {
            statement.setInt(1,id);
            int numRowsAffected = statement.executeUpdate();
            return numRowsAffected>0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }
}
