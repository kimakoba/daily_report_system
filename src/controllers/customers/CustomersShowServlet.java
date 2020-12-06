package controllers.customers;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Customer;
import utils.DBUtil;


/**
 * Servlet implementation class CustomersShowServlet
 */
@WebServlet("/customers/show")
public class CustomersShowServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomersShowServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManager em = DBUtil.createEntityManager();

        Customer c = em.find(Customer.class, Integer.parseInt(request.getParameter("id")));

        em.close();

        request.setAttribute("customer", c);

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/customers/show.jsp");
        rd.forward(request, response);
    }

}