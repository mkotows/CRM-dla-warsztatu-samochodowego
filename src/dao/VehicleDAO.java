package dao;

import model.Vehicle;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class VehicleDAO {
    private static VehicleDAO instance;

    public static VehicleDAO getInstance() {

        if (instance == null) {
            instance = new VehicleDAO();
        }

        return instance;
    }

    private VehicleDAO(){

    }

    public boolean save(Vehicle vehicle){
        try (Connection conn = DBUtil.getConn();
             PreparedStatement statement = conn.prepareStatement
                     ("INSERT INTO Vehicles (brand, model, production_year, number, next_service, client_id) VALUES (?,?,?,?,?,?) ")){

            statement.setString(1, vehicle.getBrand());
            statement.setString(2, vehicle.getModel());
            statement.setString(3, vehicle.getProduction_year());
            statement.setString(4, vehicle.getNumber());
//            Date next_service = Date.valueOf(vehicle.getNext_service();
            statement.setDate(5, Date.valueOf(vehicle.getNext_service()));
            statement.setInt(6,vehicle.getClient_id());

            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Vehicle> getAllVehicles (){
        return getVehiclesBySQL("SELECT * FROM Vehicles");
    }

    public List<Vehicle> getCustomerVehicles (int id){
        return getVehiclesBySQL("SELECT * FROM Vehicles WHERE client_id="+id);
    }

    private List<Vehicle> getVehiclesBySQL(String sql) {
        List<Vehicle> list = new ArrayList<>();
        try(Connection conn = DBUtil.getConn();
            Statement statement = conn.createStatement())
            {
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()){
                Integer id = rs.getInt("id");
                String brand = rs.getString("brand");
                String model = rs.getString("model");
                String production_year = rs.getString("production_year");
                String number = rs.getString("number");
                LocalDate next_service = rs.getDate("next_service").toLocalDate();
                Integer client_id = rs.getInt("client_id");

                list.add(new Vehicle(id, brand, model, production_year,number, next_service, client_id));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public Vehicle getVehicleById(int id){
        try (Connection conn = DBUtil.getConn();
             PreparedStatement statement = conn.prepareStatement
                      ("SELECT * FROM Vehicles WHERE id=?")){
            statement.setInt(1,id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                Integer vehicleID = rs.getInt("id");
                String brand = rs.getString("brand");
                String model = rs.getString("model");
                String production_year = rs.getString("production_year");
                String number = rs.getString("number");
                LocalDate next_service = rs.getDate("next_service").toLocalDate();
                Integer client_id = rs.getInt("client_id");

                return new Vehicle(vehicleID, brand, model, production_year,number, next_service, client_id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean update(Vehicle vehicle){
        try (Connection conn = DBUtil.getConn();
             PreparedStatement statement = conn.prepareStatement
                     ("UPDATE Vehicles SET brand=?, model=?, production_year=?, number=?, next_service=?, client_id=? WHERE id=? ")){

            statement.setString(1, vehicle.getBrand());
            statement.setString(2, vehicle.getModel());
            statement.setString(3, vehicle.getProduction_year());
            statement.setString(4, vehicle.getNumber());
//            Date next_service = Date.valueOf(vehicle.getNext_service();
            statement.setDate(5, Date.valueOf(vehicle.getNext_service()));
            statement.setInt(6,vehicle.getClient_id());
            statement.setInt(7,vehicle.getId());

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
                    ("DELETE FROM Vehicles WHERE id=?")) {
            statement.setInt(1,id);
            int numRowsAffected = statement.executeUpdate();
            return numRowsAffected>0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }
}
