package app;

import dao.EmployeeDAO;
import model.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;

@WebServlet("/AddEmployee")
public class AddEmployee extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name =  request.getParameter("name");
        String surname =  request.getParameter("surname");
        String adderss =  request.getParameter("adderss");
        String phone =  request.getParameter("phone");
        String note =  request.getParameter("note");
        String salaryParam =  request.getParameter("salary_per_hour");
        BigDecimal salary_per_hour = BigDecimal.valueOf(Double.parseDouble(salaryParam));

        Employee employee = new Employee(name, surname, adderss, phone, note, salary_per_hour);
        EmployeeDAO employeeDAO = EmployeeDAO.getInstance();
        employeeDAO.save(employee);

        String info = "Dodano nowego użytkownika: " + employee;
        request.setAttribute("info", info);
        getServletContext().getRequestDispatcher("/WEB-INF/info.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("Employees/addEmployee.jsp");
    }
}
