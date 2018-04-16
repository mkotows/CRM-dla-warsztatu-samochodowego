package app;

import dao.CustomerDAO;
import dao.VehicleDAO;
import model.Customer;
import model.Vehicle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

@WebServlet("/AddVehicle")
public class AddVehicle extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String brand =  request.getParameter("brand");
        String model =  request.getParameter("model");
        String production_year = request.getParameter("production_year");
        String number = request.getParameter("number");
        Integer client_id = Integer.parseInt(request.getParameter("client_id"));
        String next_serviceParam = request.getParameter("next_service");
        LocalDate next_service = LocalDate.parse(next_serviceParam);

        CustomerDAO customerDAO = CustomerDAO.getInstance();
        List<Customer> customers = customerDAO.getAllCustomers();
        boolean isContain = false;
        for(Customer customer:  customers){
            if(customer.getId()==client_id){
                isContain=true;
            }
        }

        String info;

        if(isContain){
            Vehicle vehicle = new Vehicle(brand,model,production_year,number,next_service,client_id);
            VehicleDAO vehicleDAO = VehicleDAO.getInstance();
            vehicleDAO.save(vehicle);
            info = "Dodano nowy samochód" + vehicle;

        } else{
            info = "Nie udało się dodać pojazdu, podano zły nr klienta ";
        }

        request.setAttribute("info", info);
        getServletContext().getRequestDispatcher("/WEB-INF/info.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        CustomerDAO customerDAO = CustomerDAO.getInstance();
        List<Customer> customers = customerDAO.getAllCustomers();
        customers.sort(Comparator.comparing(Customer::getSurname));
        request.setAttribute("list", customers);
        request.setAttribute("date", LocalDate.now().plusYears(1));
        getServletContext().getRequestDispatcher("/Vehicles/addVehicle.jsp").forward(request,response);




    }
}
