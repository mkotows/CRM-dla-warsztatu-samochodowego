package app;

import dao.OrderDAO;
import model.Order;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/WorkingHoursRaport")
public class WorkingHoursRaport extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String startDateParam = request.getParameter("startDate");
        LocalDate startDate = LocalDate.parse(startDateParam);
        String endDateParam = request.getParameter("endDate");
        LocalDate endDate = LocalDate.parse(endDateParam);

        request.setAttribute("startDate", startDate);
        request.setAttribute("endDate", endDate);
        doGet(request, response);
//        getServletContext().getRequestDispatcher("/WorkingHoursRaport").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        LocalDate startDate = (LocalDate) request.getAttribute("startDate");
        LocalDate endDate = (LocalDate) request.getAttribute("endDate");
        Date startDateSQL = Date.valueOf(startDate);
        Date endDateSQL = Date.valueOf(endDate);

        OrderDAO orderDAO = OrderDAO.getInstance();
        List<Order> orders = orderDAO.getOrdersByDate(startDateSQL, endDateSQL);

        Map<Integer, BigDecimal> map = new HashMap<>();

        for (Order order : orders) {
            Integer employee_id = order.getEmployee_id();
            BigDecimal repair_hours = order.getRepair_hours();

            if(map.containsKey(employee_id)){
                BigDecimal value = map.get(employee_id);
                map.put(employee_id, value.add(repair_hours));
            } else {
                map.put(employee_id,repair_hours);
            }
        }

        request.setAttribute("map", map);
        getServletContext().getRequestDispatcher("/WEB-INF/ViewsJSP/workingHoursRaport.jsp").forward(request,response);
    }
}
