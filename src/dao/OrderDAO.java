package dao;

import model.Order;

import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO {
    private static OrderDAO instance;

    public static OrderDAO getInstance() {

        if (instance == null) {
            instance = new OrderDAO();
        }

        return instance;
    }

    private OrderDAO(){

    }

    public boolean save(Order order){
        try (Connection conn = DBUtil.getConn();
             PreparedStatement statement = conn.prepareStatement
                     ("INSERT INTO Orders (date, planing_date, end_date, employee_id, problem_description, " +
                             "repair_description, status, vehicle_id, total_cost, elements_cost, hour_cost, " +
                             "repair_hours) VALUES (?,?,?,?,?,?,?,?,?,?,?,?) ")){

            statement.setDate(1, Date.valueOf(order.getDate()));
            statement.setDate(2, Date.valueOf(order.getPlaning_date()));
            statement.setDate(3, Date.valueOf(order.getEnd_date()));
            statement.setInt(4, order.getEmployee_id());
            statement.setString(5, order.getProblem_description());
            statement.setString(6,order.getRepair_description());
            statement.setString(7,order.getStatus());
            statement.setInt(8, order.getVehicle_id());
            statement.setBigDecimal(9, order.getTotal_cost());
            statement.setBigDecimal(10, order.getElements_cost());
            statement.setBigDecimal(11, order.getHour_cost());
            statement.setBigDecimal(12, order.getRepair_hours());

            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

//    public List<Order> getAllOrders (){
//        return getOrdersBySQL("SELECT * FROM Orders");
//    }
//    public List<Order> getActiveOrders (){
//        return getOrdersBySQL("SELECT * FROM Orders WHERE status='adopted' OR status='accepted' OR status='repairing'");
//    }
//    public List<Order> getVehicleOrders (int vehicle_id){
//        return getOrdersBySQL("SELECT * FROM Orders WHERE vehicle_id="+vehicle_id);
//    }
//    public List<Order> getEmployeeOrders (int employee_id){
//        return getOrdersBySQL("SELECT * FROM Orders WHERE employee_id="+employee_id);
//    }
//
//    private List<Order> getOrdersBySQL(String sql) {
//        List<Order> list = new ArrayList<>();
//        try(Connection conn = DBUtil.getConn();
//            Statement statement = conn.createStatement())
//        {
//            ResultSet rs = statement.executeQuery(sql);
//            while(rs.next()){
//
//                Integer id = rs.getInt("id");
//                LocalDate date = rs.getDate("date").toLocalDate();
//                LocalDate planing_date = rs.getDate("planing_date").toLocalDate();
//                LocalDate end_date = rs.getDate("end_date").toLocalDate();
//                Integer employee_id = rs.getInt("employee_id");
//                String problem_description = rs.getString("problem_description");
//                String repair_description = rs.getString("repair_description");
//                String status = rs.getString("status");
//                Integer vehicle_id = rs.getInt("vehicle_id");
//                BigDecimal total_cost = rs.getBigDecimal("total_cost");
//                BigDecimal elements_cost = rs.getBigDecimal("elements_cost");
//                BigDecimal hour_cost = rs.getBigDecimal("hour_cost");
//                BigDecimal repair_hours = rs.getBigDecimal("repair_hours");
//
//                list.add(new Order(id, date, planing_date, end_date, employee_id, problem_description, repair_description,
//                        status, vehicle_id, total_cost, elements_cost, hour_cost, repair_hours));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return list;
//    }

    public List<Order> getAllOrders (){
        return getOrdersBySQL("SELECT * FROM Orders");
    }
    public List<Order> getActiveOrders (){
        return getOrdersBySQL("SELECT * FROM Orders WHERE status='adopted' OR status='accepted' OR status='repairing'");
    }
    public List<Order> getVehicleOrders (int vehicle_id){
        return getOrdersBySQL("SELECT * FROM Orders WHERE vehicle_id="+vehicle_id);
    }
    public List<Order> getEmployeeOrders (int employee_id){
        return getOrdersBySQL("SELECT * FROM Orders WHERE employee_id="+employee_id);
    }
    public List<Order> getOrdersByDate (Date startDate, Date endDate){
        return getOrdersBySQL("SELECT * FROM Orders WHERE end_date BETWEEN '"+startDate+"' AND '"+endDate+"'");
    }

    private List<Order> getOrdersBySQL(String sql) {
        List<Order> list = new ArrayList<>();
        try(Connection conn = DBUtil.getConn();
            Statement statement = conn.createStatement())
        {
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()){

                Integer id = rs.getInt("id");
                LocalDate date = rs.getDate("date").toLocalDate();
                LocalDate planing_date = rs.getDate("planing_date").toLocalDate();
                LocalDate end_date = rs.getDate("end_date").toLocalDate();
                Integer employee_id = rs.getInt("employee_id");
                String problem_description = rs.getString("problem_description");
                String repair_description = rs.getString("repair_description");
                String status = rs.getString("status");
                Integer vehicle_id = rs.getInt("vehicle_id");
                BigDecimal total_cost = rs.getBigDecimal("total_cost");
                BigDecimal elements_cost = rs.getBigDecimal("elements_cost");
                BigDecimal hour_cost = rs.getBigDecimal("hour_cost");
                BigDecimal repair_hours = rs.getBigDecimal("repair_hours");

                list.add(new Order(id, date, planing_date, end_date, employee_id, problem_description, repair_description,
                        status, vehicle_id, total_cost, elements_cost, hour_cost, repair_hours));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public Order getOrderById(int id){
        try ( Connection conn = DBUtil.getConn();
              PreparedStatement statement = conn.prepareStatement
                      ("SELECT *  FROM Orders WHERE id=?")){
            statement.setInt(1,id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                Integer orderID = rs.getInt("id");
                LocalDate date = rs.getDate("date").toLocalDate();
                LocalDate planing_date = rs.getDate("planing_date").toLocalDate();
                LocalDate end_date = rs.getDate("end_date").toLocalDate();
                Integer employee_id = rs.getInt("employee_id");
                String problem_description = rs.getString("problem_description");
                String repair_description = rs.getString("repair_description");
                String status = rs.getString("status");
                Integer vehicle_id = rs.getInt("vehicle_id");
                BigDecimal total_cost = rs.getBigDecimal("total_cost");
                BigDecimal elements_cost = rs.getBigDecimal("elements_cost");
                BigDecimal hour_cost = rs.getBigDecimal("hour_cost");
                BigDecimal repair_hours = rs.getBigDecimal("repair_hours");

                return new Order(orderID, date, planing_date, end_date, employee_id, problem_description, repair_description,
                        status, vehicle_id, total_cost, elements_cost, hour_cost, repair_hours);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean update(Order order){
        try (Connection conn = DBUtil.getConn();
             PreparedStatement statement = conn.prepareStatement
                     ("UPDATE Orders SET date=?, planing_date=?, end_date=?, employee_id=?, problem_description=?," +
                             " repair_description=?, status=?, vehicle_id=?, total_cost=?, " +
                             "elements_cost=?, hour_cost=?, repair_hours=? WHERE id=? ")){

            statement.setDate(1, Date.valueOf(order.getDate()));
            statement.setDate(2, Date.valueOf(order.getPlaning_date()));
            statement.setDate(3, Date.valueOf(order.getEnd_date()));
            statement.setInt(4, order.getEmployee_id());
            statement.setString(5, order.getProblem_description());
            statement.setString(6,order.getRepair_description());
            statement.setString(7,order.getStatus());
            statement.setInt(8, order.getVehicle_id());
            statement.setBigDecimal(9, order.getTotal_cost());
            statement.setBigDecimal(10, order.getElements_cost());
            statement.setBigDecimal(11, order.getHour_cost());
            statement.setBigDecimal(12, order.getRepair_hours());
            statement.setInt(13,order.getId());

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
                    ("DELETE FROM Orders WHERE id=?")) {
            statement.setInt(1,id);
            int numRowsAffected = statement.executeUpdate();
            return numRowsAffected>0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }
}
