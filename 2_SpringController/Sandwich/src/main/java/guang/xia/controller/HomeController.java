package guang.xia.controller;

import guang.xia.model.Menu;
import guang.xia.service.impl.SimpleMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {
    @Autowired
    SimpleMenu simpleMenu;
    @PostMapping("/home")
    public ModelAndView home(@RequestParam(name = "checkbox", required = false, defaultValue = "") ArrayList<String> list){
        List<Menu> menuList=simpleMenu.findAll();
        ModelAndView modelAndView=new ModelAndView("index");
        modelAndView.addObject("menu",menuList);
        modelAndView.addObject("option",list);
        return modelAndView;
    }
}
