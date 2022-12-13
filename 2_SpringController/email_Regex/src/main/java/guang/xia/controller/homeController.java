package guang.xia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
public class homeController {
    private static final String EMAIL_REGEX = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
    private static Pattern pattern;
    private static Matcher matcher;

    @GetMapping("/home")
    public String home() {
        return "index";
    }

    @PostMapping("/email")
    public ModelAndView resultValidate(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("index");
        String email = request.getParameter("email");
        Boolean result = checkValidate(email);
        modelAndView.addObject("email", email);
        if (result) {
            modelAndView.addObject("result", "success");
        } else {
            modelAndView.addObject("result", "Email is invalid");
        }
        return modelAndView;
    }

    public Boolean checkValidate(String email) {
        pattern = Pattern.compile(EMAIL_REGEX);
        matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
