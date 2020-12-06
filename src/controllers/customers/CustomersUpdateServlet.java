package controllers.customers;


import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Customer;
import models.validators.CustomerValidator;
import utils.DBUtil;

/**
 * Servlet implementation class CustomersUpdateServlet
 */
@WebServlet("/customers/update")
public class CustomersUpdateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomersUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String _token = (String)request.getParameter("_token");
        if(_token != null && _token.equals(request.getSession().getId())) {
            EntityManager em = DBUtil.createEntityManager();

            Customer c = em.find(Customer.class, (Integer)(request.getSession().getAttribute("customer_id")));

            c.setCompany(request.getParameter("company"));
            c.setName(request.getParameter("name"));
            String gender = request.getParameter("gender");
            c.setGender(gender);
            c.setEmail(request.getParameter("email"));
            c.setPhone(request.getParameter("phone"));
            c.setMemo(request.getParameter("memo"));

            c.setUpdated_at(new Timestamp(System.currentTimeMillis()));

            List<String> errors = CustomerValidator.validate(c);
            if(errors.size() > 0) {
                em.close();

                request.setAttribute("_token", request.getSession().getId());
                request.setAttribute("customer", c);
                request.setAttribute("errors", errors);

                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/customers/edit.jsp");
                rd.forward(request, response);
            } else {
                em.getTransaction().begin();
                em.getTransaction().commit();
                em.close();
                request.getSession().setAttribute("flush", "更新が完了しました。");

                request.getSession().removeAttribute("customer_id");

                response.sendRedirect(request.getContextPath() + "/customers/index");
            }
        }
    }

}