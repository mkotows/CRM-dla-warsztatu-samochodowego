package app;

import dao.CustomerDAO;
import dao.VehicleDAO;
import model.Customer;
import model.Vehicle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/MainVehicle")
public class MainVehicle extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        VehicleDAO vehicleDAO = VehicleDAO.getInstance();
        List<Vehicle> vehicles = vehicleDAO.getAllVehicles();

        CustomerDAO customerDAO = CustomerDAO.getInstance();
        List<Customer> customers = customerDAO.getAllCustomers();

        request.setAttribute("customersList", customers);
        request.setAttribute("vehiclesList", vehicles);
        getServletContext().getRequestDispatcher("/Vehicles/mainVehicle.jsp").forward(request,response);
    }
}
