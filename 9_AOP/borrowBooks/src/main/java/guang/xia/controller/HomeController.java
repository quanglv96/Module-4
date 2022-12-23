package guang.xia.controller;


import guang.xia.model.Book;
import guang.xia.service.BookService.IBookService;
import guang.xia.service.UserService.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingErrorProcessor;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/home")
public class HomeController {
    @Autowired
    private IBookService bookService;
    @Autowired
    private IUserService userService;
    @GetMapping("")
    public ModelAndView home(){
        ModelAndView modelAndView=new ModelAndView("home");
        modelAndView.addObject("listBook",bookService.findAll());
        return modelAndView;
    }
    @RequestMapping("/form")
    public ModelAndView openForm(){
        ModelAndView modelAndView=new ModelAndView("form");
        modelAndView.addObject("book",new Book());
        modelAndView.addObject("title","ADD NEW BOOK");
        return modelAndView;
    }
    @PostMapping("/save")
    public String save(@Validated @ModelAttribute("book") Book book, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return "form";
        }
        Book book1=new Book(book.getNameBook(), book.getQuantity());
        bookService.save(book1);
        return "redirect: /home";
    }
    @PostMapping("/borrowBook")
    public ModelAndView borrowBook(){
        ModelAndView modelAndView=new ModelAndView("home");
        return modelAndView;
    }
}
