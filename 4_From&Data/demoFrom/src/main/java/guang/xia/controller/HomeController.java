package guang.xia.controller;

import guang.xia.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/home")
public class HomeController {
    @RequestMapping(value = "/showForm", method = RequestMethod.GET)
    public String showForm(ModelMap model) {
        model.addAttribute("employee", new Employee());
        return "/create";
    }

    @RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
    public String submit(@ModelAttribute("employee") Employee employee, ModelMap model) {
        model.addAttribute("employee", employee);
        return "/info";
    }
}
