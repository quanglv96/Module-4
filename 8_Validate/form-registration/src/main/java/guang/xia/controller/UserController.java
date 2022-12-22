package guang.xia.controller;

import guang.xia.model.User;
import guang.xia.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Objects;
import java.util.Optional;

@Controller
public class UserController {
    @Autowired
    private IUserService iUserService;
    private long num = 2L;

    @RequestMapping("/home")
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView("list");
        Iterable<User> listUser = iUserService.findAll();
        modelAndView.addObject("listUser", listUser);
        return modelAndView;
    }

    @GetMapping("/form/{id}")
    public ModelAndView form(@PathVariable("id") String id) {
        ModelAndView modelAndView = new ModelAndView("form");

        if (Objects.equals(id, "create")) {
            User user = new User();
            num++;
            user.setId(num);
            modelAndView.addObject("newUser", user);
            modelAndView.addObject("title", "ADD NEW USER");
        } else {
            try {
                long index = Long.parseLong(id);
                Optional<User> user= iUserService.findById(index);
                modelAndView.addObject("newUser", user);
                modelAndView.addObject("title", "UPDATE USER");
            } catch (Exception e) {
                return new ModelAndView("redirect:/home");
            }
        }
        return modelAndView;
    }

    @PostMapping("/save")
    public String save(@Validated @ModelAttribute("newUser") User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "form";
        }
        iUserService.save(user);
        return "redirect: /home";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") long id) {
        iUserService.remove(id);
        return "redirect: /home";
    }


}
