package app;

import dao.OrderDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/DeleteOrder")
public class DeleteOrder extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        String idParam = request.getParameter("id");

        if(idParam==null || idParam.equals("")){
            writer.append("Brak podanego id");
        } else{
            String sureParam = request.getParameter("sure");
            if(sureParam==null){
                writer.append("Czy jesteś pewien  że chcesz usunąć zlecenie: ...");
                writer.append("<br> <a href=DeleteOrder?id=").append(idParam).append("&sure=yes> Tak</a> ");
                writer.append("<br> <a href='MainOrder'> Nie</a> ");
            } else{
                int id =Integer.parseInt(idParam);
                OrderDAO orderDAO = OrderDAO.getInstance();
                orderDAO.delete(id);
                response.sendRedirect("MainOrder");
            }

        }
    }
}
