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

@WebServlet("/ShowVehicleOrders")
public class ShowVehicleOrders extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        VehicleDAO vehicleDAO = VehicleDAO.getInstance();
        int vehicleId = Integer.parseInt(request.getParameter("id"));
        Vehicle vehicle = vehicleDAO.getVehicleById(vehicleId);

        OrderDAO orderDAO = OrderDAO.getInstance();
        List<Order> orders =  orderDAO.getVehicleOrders(vehicleId);


        request.setAttribute("vehicle", vehicle);
        request.setAttribute("ordersList", orders);
        getServletContext().getRequestDispatcher("/Vehicles/showVehicleOrders.jsp").forward(request,response);

    }
}
