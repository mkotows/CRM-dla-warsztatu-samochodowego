package app;

import dao.CustomerDAO;
import dao.OrderDAO;
import dao.VehicleDAO;
import model.Customer;
import model.Order;
import model.Vehicle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/ShowCustomerOrders")
public class ShowCustomerOrders extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // TODO dokończyć pokazywanie zamówień dla klientów, klient może mieć kilka samochodów
        Integer client_id = Integer.parseInt(request.getParameter("client_id"));
        VehicleDAO vehicleDAO = VehicleDAO.getInstance();
        List<Vehicle> vehicles = vehicleDAO.getCustomerVehicles(client_id);

        OrderDAO orderDAO = OrderDAO.getInstance();
        List<Order> clientOrders=new ArrayList<>();
        for (Vehicle vehicle: vehicles){
            clientOrders.addAll(orderDAO.getVehicleOrders(vehicle.getId()));
        }

        CustomerDAO customerDAO = CustomerDAO.getInstance();
        Customer customer = customerDAO.getCustomerById(client_id);

        request.setAttribute("customer", customer);
        request.setAttribute("clientOrders", clientOrders);
        getServletContext().getRequestDispatcher("/Customers/showCustomerOrders.jsp").forward(request, response);
    }
}
