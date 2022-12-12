package cg.wbd.grandemonstration.servlet;

import cg.wbd.grandemonstration.model.Customer;
import cg.wbd.grandemonstration.service.CustomerService;
import cg.wbd.grandemonstration.service.CustomerServiceFactory;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomerServlet extends HttpServlet {
    private CustomerService customerService = CustomerServiceFactory.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String action=req.getParameter("action");
        if(action==null){
            action="";
        }
        if(action.equals("")){
            Customer customer = new Customer();
            customer.setName(req.getParameter("name"));
            customer.setEmail(req.getParameter("email"));
            customer.setAddress(req.getParameter("address"));
            Long id = Long.valueOf(req.getParameter("id"));
            customer.setId(id);
            customerService.save(customer);
            resp.sendRedirect("/customers/list.jsp");
//        }else {
//            Long id= Long.valueOf(req.getParameter("id"));
//            Customer customer=customerService.findOne(id);
//            req.setAttribute("customers",customer);
//            resp.sendRedirect("/customers/info.jsp");
        }

    }
}
