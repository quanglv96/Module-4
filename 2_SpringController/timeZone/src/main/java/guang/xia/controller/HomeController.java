package guang.xia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.TimeZone;

@Controller
public class HomeController {
    @GetMapping("/home")
    public ModelAndView home( @RequestParam(name = "city", required = false, defaultValue = "Asia/Ho_Chi_Minh") String city){
        ModelAndView modelAndView=new ModelAndView("index");
        Date date=new Date();
        TimeZone timeZone=TimeZone.getDefault();
        TimeZone local=TimeZone.getTimeZone(city);
        long locale_time = date.getTime() + (timeZone.getRawOffset() - local.getRawOffset());
        date.setTime(locale_time);
        modelAndView.addObject("city", city);
        modelAndView.addObject("date", date);
       return modelAndView;
    }
}
