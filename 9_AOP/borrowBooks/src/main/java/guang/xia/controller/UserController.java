package guang.xia.controller;

import guang.xia.model.Book;
import guang.xia.model.User;
import guang.xia.service.BookService.IBookService;
import guang.xia.service.UserService.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;
import java.util.Random;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IBookService bookService;
    @Autowired
    private IUserService userService;

    @GetMapping("/detailBook")
    public ModelAndView detailBook(@RequestParam("id") long id) {
        ModelAndView modelAndView = new ModelAndView("detail");
        Optional<Book> book=bookService.findById(id);
            modelAndView.addObject("book",book );
        if(book.get().getQuantity()>0){
            modelAndView.addObject("checkQuantity",true);
            modelAndView.addObject("submit", false);
        }else {
            modelAndView.addObject("checkQuantity",false);
        }
        return modelAndView;
    }

    @PostMapping("/borrowBook")
    public ModelAndView borrowBook(@ModelAttribute("book") Optional<Book> book) {
        ModelAndView modelAndView = new ModelAndView("detail");
        modelAndView.addObject("book", book);
        modelAndView.addObject("checkQuantity",true);
        modelAndView.addObject("submit", true);
       Random random=new Random();
       StringBuilder code= new StringBuilder();
        for (int i = 0; i < 5; i++) {
            int num=random.nextInt(9);
            code.append(num);
        }
        modelAndView.addObject("code",code);
        book.get().setQuantity(book.get().getQuantity() - 1);
        bookService.save(book.get());
        userService.save(new User(code.toString(),book.get()));
        return modelAndView;
    }
    @GetMapping("/listCode")
    public ModelAndView listCode(){
        ModelAndView modelAndView=new ModelAndView("/listCode");
        modelAndView.addObject("listCode",userService.findAll());
        return modelAndView;
    }
    @PostMapping("/checkCode")
    public ModelAndView checkCode(@RequestParam("enterCode")String enterCode){
        ModelAndView modelAndView=new ModelAndView("/home");
        Optional<User> user=userService.findUserByCode(enterCode);
        if(user.isPresent()){
            Book book=bookService.findById(user.get().getBook().getBook_id()).get();
            book.setQuantity(book.getQuantity()+1);
            bookService.save(book);
            modelAndView.addObject("checkNoCode", false);
            modelAndView.addObject("listBook",bookService.findAll());
        }else {
            modelAndView.addObject("checkCode", false);
        }
        return modelAndView;
    }
}
