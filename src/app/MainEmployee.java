package app;

import dao.EmployeeDAO;
import model.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/MainEmployee")
public class MainEmployee extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EmployeeDAO employeeDAO = EmployeeDAO.getInstance();
        List<Employee> employees = employeeDAO.getAllEmployees();

        request.setAttribute("employeesList", employees);
        getServletContext().getRequestDispatcher("/Employees/mainEmployee.jsp").forward(request,response);
    }
}
