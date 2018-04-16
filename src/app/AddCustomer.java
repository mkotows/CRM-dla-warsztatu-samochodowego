package app;

import dao.CustomerDAO;
import model.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

@WebServlet("/AddCustomer")
public class AddCustomer extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Customer customer;

        String name =  request.getParameter("name");
        String surname =  request.getParameter("surname");
        String birth_dateParam = request.getParameter("birth_date");
        if(!birth_dateParam.equals("") && birth_dateParam!=null){
            LocalDate birth_date =  LocalDate.parse(birth_dateParam);
            customer=new Customer(name,surname,birth_date);
        } else{
//            LocalDate birth_date=null;
            customer=new Customer(name,surname);

        }
        CustomerDAO customerDAO = CustomerDAO.getInstance();
        customerDAO.save(customer);

        String info = "Dodano nowego użytkownika: " + customer;
        request.setAttribute("info", info);
        getServletContext().getRequestDispatcher("/WEB-INF/info.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("Customers/addCustomer.jsp");
    }
}
