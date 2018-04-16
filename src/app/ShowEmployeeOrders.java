package app;

import dao.OrderDAO;
import dao.EmployeeDAO;
import model.Order;
import model.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/ShowEmployeeOrders")
public class ShowEmployeeOrders extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        EmployeeDAO employeeDAO = EmployeeDAO.getInstance();
        int employeeId = Integer.parseInt(request.getParameter("id"));
        Employee employee = employeeDAO.getEmployeeById(employeeId);

        OrderDAO orderDAO = OrderDAO.getInstance();
        List<Order> orders =  orderDAO.getEmployeeOrders(employeeId);


        request.setAttribute("employee", employee);
        request.setAttribute("ordersList", orders);
        getServletContext().getRequestDispatcher("/Employees/showEmployeeOrders.jsp").forward(request,response);
    }
}
