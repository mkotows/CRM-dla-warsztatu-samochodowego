package app;


import dao.VehicleDAO;
import model.Vehicle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/UpdateVehicle")
public class UpdateVehicle extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Integer id = Integer.parseInt(request.getParameter("id"));
        String brand =  request.getParameter("brand");
        String model =  request.getParameter("model");
        String production_year = request.getParameter("production_year");
        String number = request.getParameter("number");
        Integer client_id = Integer.parseInt(request.getParameter("client_id"));
        String next_serviceParam = request.getParameter("next_service");
        LocalDate next_service = LocalDate.parse(next_serviceParam);

        Vehicle vehicle = new Vehicle(id,brand,model,production_year,number,next_service, client_id);
        VehicleDAO vehicleDAO = VehicleDAO.getInstance();
        vehicleDAO.update(vehicle);

        String info="Dane pojazdu zostały zmienione";
        request.setAttribute("info", info);
        getServletContext().getRequestDispatcher("/WEB-INF/info.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/Vehicles/updateVehicle.jsp").forward(request,response);

    }
}
