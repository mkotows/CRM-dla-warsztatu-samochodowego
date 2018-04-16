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

@WebServlet("/ShowCustomerVehicles")
public class ShowCustomerVehicles extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Integer id = Integer.parseInt(request.getParameter("id"));

        CustomerDAO customerDAO = CustomerDAO.getInstance();
        Customer customer = customerDAO.getCustomerById(id);
        VehicleDAO vehicleDAO = VehicleDAO.getInstance();
        List<Vehicle> vehicles = vehicleDAO.getCustomerVehicles(id);

        request.setAttribute("customer", customer);
        request.setAttribute("vehiclesList", vehicles);
        getServletContext().getRequestDispatcher("/Customers/showCustomerVehicles.jsp").forward(request,response);

    }
}
