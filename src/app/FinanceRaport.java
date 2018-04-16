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
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@WebServlet("/FinanceRaport")
public class FinanceRaport extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String startDateParam = request.getParameter("startDate");
        LocalDate startDate = LocalDate.parse(startDateParam);
        String endDateParam = request.getParameter("endDate");
        LocalDate endDate = LocalDate.parse(endDateParam);

        request.setAttribute("startDate", startDate);
        request.setAttribute("endDate", endDate);
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LocalDate startDate = (LocalDate) request.getAttribute("startDate");
        LocalDate endDate = (LocalDate) request.getAttribute("endDate");
        Date startDateSQL = Date.valueOf(startDate);
        Date endDateSQL = Date.valueOf(endDate);

        OrderDAO orderDAO = OrderDAO.getInstance();
        List<Order> orders = orderDAO.getOrdersByDate(startDateSQL, endDateSQL);

        request.setAttribute("ordersList", orders);
        getServletContext().getRequestDispatcher("/WEB-INF/ViewsJSP/financeRaport.jsp").forward(request,response);

    }
}
