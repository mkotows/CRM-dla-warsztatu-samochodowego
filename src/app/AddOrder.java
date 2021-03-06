package app;

import dao.EmployeeDAO;
import dao.OrderDAO;
import model.Employee;
import model.Order;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;

@WebServlet("/AddOrder")
public class AddOrder extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        LocalDate date = LocalDate.parse(request.getParameter("date"));
        LocalDate planing_date = LocalDate.parse(request.getParameter("planing_date"));
        LocalDate end_date = LocalDate.parse(request.getParameter("end_date"));
        Integer employee_id = Integer.parseInt(request.getParameter("employee_id"));
        String problem_description =  request.getParameter("problem_description");
        String repair_description =  request.getParameter("repair_description");
        String status =  request.getParameter("status");
        Integer vehicle_id = Integer.parseInt(request.getParameter("vehicle_id"));
        BigDecimal elements_cost = BigDecimal.valueOf(Double.parseDouble(request.getParameter("elements_cost")));
        BigDecimal repair_hours = BigDecimal.valueOf(Double.parseDouble(request.getParameter("repair_hours")));

        EmployeeDAO  employeeDAO = EmployeeDAO.getInstance();
        Employee employee = employeeDAO.getEmployeeById(employee_id);
        BigDecimal hour_cost = employee.getSalary_per_hour();

        BigDecimal total_cost = hour_cost.multiply(repair_hours).add(elements_cost);

        Order order = new Order(date, planing_date, end_date, employee_id, problem_description, repair_description,
                status, vehicle_id, total_cost, elements_cost, hour_cost, repair_hours);
        OrderDAO orderDAO = OrderDAO.getInstance();
        orderDAO.save(order);

        String info = "Dodano nowe zamówienie: " + order;
        request.setAttribute("info", info);
        getServletContext().getRequestDispatcher("/WEB-INF/info.jsp").forward(request,response);
        
    }

//    private String getStatus(String status) {
//        if (status.equals("adopted"))
//            return "Przyjęty";
//        else if(status.equals("accepted"))
//            return "Zatwiedzone koszty naprawy";
//        else if(status.equals("repairing"))
//            return "W naprawie";
//        else if(status.equals("repaired"))
//            return "Gotowy do odbioru";
//        else
//            return "Rezygnacja";
//    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("today", LocalDate.now());
        getServletContext().getRequestDispatcher("/WEB-INF/ViewsJSP/addOrder.jsp").forward(request,response);
//        response.sendRedirect("WEB-INF/ViewsJSP/addOrder.jsp");
    }
}
