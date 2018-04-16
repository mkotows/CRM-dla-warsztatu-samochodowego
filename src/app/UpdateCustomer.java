package app;

import dao.CustomerDAO;
import model.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/UpdateCustomer")
public class UpdateCustomer extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Customer customer;

        int id = Integer.parseInt(request.getParameter("id"));
        String name =  request.getParameter("name");
        String surname =  request.getParameter("surname");
        String birth_dateParam = request.getParameter("birth_date");
        if(birth_dateParam!=null && !birth_dateParam.equals("")){
            LocalDate birth_date =  LocalDate.parse(birth_dateParam);
            customer=new Customer(id,name,surname,birth_date);
        } else{
//            LocalDate birth_date=null;
            customer=new Customer(id,name,surname);

        }
        CustomerDAO customerDAO = CustomerDAO.getInstance();
        customerDAO.update(customer);

        String info = "Wpis zmieniony, nowa wartość to: " + customer;
        request.setAttribute("info", info);
        getServletContext().getRequestDispatcher("/WEB-INF/info.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/Customers/updateCustomer.jsp").forward(request,response);

    }
}
