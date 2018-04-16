package app;

import dao.OrderDAO;
import dao.VehicleDAO;
import model.Order;
import model.Vehicle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/MainPage")
public class MainPage extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        VehicleDAO vehicleDAO = VehicleDAO.getInstance();
        List<Vehicle> vehicles = vehicleDAO.getAllVehicles();
        OrderDAO orderDAO = OrderDAO.getInstance();
        List<Order> orders =  orderDAO.getActiveOrders();

        request.setAttribute("ordersList", orders);
        request.setAttribute("vehiclesList", vehicles);
        getServletContext().getRequestDispatcher("/index.jsp").forward(request,response);
    }
}
