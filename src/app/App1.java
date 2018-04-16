package app;

import dao.CustomerDAO;
import dao.EmployeeDAO;
import dao.VehicleDAO;
import model.Customer;
import model.Employee;
import model.Vehicle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

@WebServlet("/App1")
public class App1 extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        writer.append("test przed połączeniem <br>");


        VehicleDAO dao = VehicleDAO.getInstance();

        Vehicle v1 = new Vehicle(1,"Ford", "Focus", "2007", "PWL6644", LocalDate.parse("2019-11-11") , 1);

        writer.append("OK!!");
        List<Vehicle> listOfVehicles = dao.getAllVehicles();
        for (Vehicle vehicle: listOfVehicles){
            writer.append(vehicle.getId()+ ": " +vehicle+"<br>");
        }
        boolean isOk = dao.update(v1);
        if(isOk){
            writer.append("Tak!!");
        } else {
            writer.append("Nie!!");
        }






//        if(dao.delete(5)){
//            writer.append("<br> skasowano");
//        } else{
//            writer.append("<br> nie skasowano");
//        }

        
        
//        LocalDate localDate = LocalDate.of(2014,02,02);
//        Customer customer = new Customer("Michał", "Ławecki");
//        boolean isSaved = dao.save(customer);
//        if(isSaved){
//            writer.append("zapisany");
//        }else {
//            writer.append("nie zapisany");
//        }

//        try {
//            Connection conn = DBUtil.getConn();
//            writer.append("Udało się połączyć");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }
    }



//        try {
//            DriverManager.registerDriver(new com.mysql.jdbc.Driver ());
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        try (Connection conn = DriverManager.getConnection(
//                    "jdbc:mysql://localhost:3306/warsztat_samochodowy?useSSL=false&characterEncoding=utf8", "root", "coderslab")){
//        writer.append("1111");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }