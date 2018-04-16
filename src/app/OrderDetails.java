package app;

import dao.EmployeeDAO;
import dao.OrderDAO;
import dao.VehicleDAO;
import model.Employee;
import model.Order;
import model.Vehicle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/OrderDetails")
public class OrderDetails extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        VehicleDAO vehicleDAO = VehicleDAO.getInstance();
        List<Vehicle> vehicles = vehicleDAO.getAllVehicles();

        Integer id = Integer.parseInt(request.getParameter("id"));
        OrderDAO orderDAO = OrderDAO.getInstance();
        Order order = orderDAO.getOrderById(id);

        EmployeeDAO employeeDAO = EmployeeDAO.getInstance();
        List<Employee> employees = employeeDAO.getAllEmployees();

        request.setAttribute("employeesList", employees);
        request.setAttribute("order", order);
        request.setAttribute("vehiclesList", vehicles);
        getServletContext().getRequestDispatcher("/WEB-INF/ViewsJSP/orderDetails.jsp").forward(request,response);
    }
}
