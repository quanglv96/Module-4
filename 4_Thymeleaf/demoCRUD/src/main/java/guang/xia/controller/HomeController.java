package guang.xia.controller;

import guang.xia.model.Product;
import guang.xia.model.ProductForm;
import guang.xia.service.IProductService;
import guang.xia.service.ProductService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/product")
public class HomeController {
    @Value("${file-upload}")
    private String fileUpload;
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
        model.addAttribute("productForm",new ProductForm());
        return "/create";
    }
//    @PostMapping("/save")
//    public String saveCreate( Product product){
//        key++;
//        product.setId(key);x3
//        productService.save(product);
//        return "redirect:/product";
//    }
    @PostMapping("/save")
    public String saveProduct(@ModelAttribute ProductForm productForm) {
        MultipartFile multipartFile = productForm.getImage();
        String fileName = multipartFile.getOriginalFilename();
        try {
            FileCopyUtils.copy(productForm.getImage().getBytes(), new File(fileUpload + fileName));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        Product product = new Product(productForm.getId(), productForm.getName(),
                productForm.getPrice(), fileName);
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
