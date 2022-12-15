package guang.xia.controller;

import guang.xia.model.Product;
import guang.xia.service.IProductService;
import guang.xia.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/product")
public class HomeController {
    private final IProductService productService = new ProductService();
    private int key=4;

    @GetMapping("")
    public String displayList(Model model) {
        List<Product> productList = productService.findAll();
        model.addAttribute("productList", productList);
        return "/index";
    }
    @GetMapping("/create")
    public String formCreate(Model model){
        model.addAttribute("product",new Product());
        return "/create";
    }
    @PostMapping("/save")
    public String saveCreate( Product product){
        key++;
        product.setId(key);
        productService.save(product);
        return "redirect:/product";
    }
    @GetMapping("{id}/view")
    public String viewProduct(Model model, @PathVariable int id){
        model.addAttribute("product",productService.findById(id));
        return "/view";
    }
    @GetMapping("{id}/edit")
    public String formEdit(Model model,@PathVariable int id){
        model.addAttribute("product",productService.findById(id));
        return "/edit";
    }
    @PostMapping("update")
    public String update(Product product){
        productService.update(product.getId(),product);
        return "redirect: /product";
    }
    @GetMapping("{id}/delete")
    public String delete(@PathVariable int id){
        productService.remove(id);
        return "redirect: /product";
    }
}
