package app;

import dao.CustomerDAO;
import model.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/MainCustomer")
public class MainCustomer extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        CustomerDAO customerDAO = CustomerDAO.getInstance();
        List<Customer> customers = customerDAO.getAllCustomers();

        request.setAttribute("list", customers);
        getServletContext().getRequestDispatcher("/Customers/mainCustomer.jsp").forward(request,response);

    }
}
