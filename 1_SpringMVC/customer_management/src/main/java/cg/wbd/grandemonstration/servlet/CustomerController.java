package cg.wbd.grandemonstration.servlet;

import cg.wbd.grandemonstration.model.Customer;
import cg.wbd.grandemonstration.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/customers")
    public ModelAndView showlist() {
        ModelAndView modelAndView = new ModelAndView("customers/list.jsp");
        List<Customer> customers = customerService.findAll();
        modelAndView.addObject("customers", customers);
        return modelAndView;
    }
    @GetMapping("/infoAccount")
    public ModelAndView infoAccount(@RequestParam(value="id") long id) {
        ModelAndView modelAndView = new ModelAndView("customers/info.jsp");
        Customer customers = customerService.findOne(id);
        modelAndView.addObject("customers", customers);
        return modelAndView;

    }
    @PostMapping(value="/saveInfo")
    public ModelAndView saveInfo(HttpServletRequest request){
        ModelAndView modelAndView=new ModelAndView("customers/list.jsp");
        Long id= Long.valueOf(request.getParameter("id"));
        String name=request.getParameter("name");
        String email=request.getParameter("email");
        String address=request.getParameter("address");
        Customer customer=new Customer(id,name,email,address);
        customerService.save(customer);
        List<Customer> customers = customerService.findAll();
        modelAndView.addObject("customers", customers);
        return modelAndView;
    }
}
