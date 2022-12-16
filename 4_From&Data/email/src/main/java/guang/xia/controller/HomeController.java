package guang.xia.controller;

import guang.xia.model.Email;
import guang.xia.service.EmailService;
import guang.xia.service.IEmailService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/home")
public class HomeController {
    private IEmailService iEmailService=new EmailService();
    @RequestMapping
    public ModelAndView home(){
        ModelAndView modelAndView=new ModelAndView("home");
        modelAndView.addObject("email",new Email());
        return modelAndView;
    }
}
