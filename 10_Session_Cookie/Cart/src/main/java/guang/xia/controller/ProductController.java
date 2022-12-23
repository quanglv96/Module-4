package guang.xia.controller;

import guang.xia.model.Cart;
import guang.xia.model.Product;
import guang.xia.repository.IProductRepository;
import guang.xia.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.ManyToOne;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
@SessionAttributes("cart")
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService productService;

    @ModelAttribute("cart")
    public Cart setupCart() {
        return new Cart();
    }

    @Value("${fileUpload}")
    private String fileUpload_IMG;

    @GetMapping()
    public ModelAndView listProduct(@ModelAttribute Cart cart) {
        ModelAndView modelAndView = new ModelAndView("product/list");
        modelAndView.addObject("listProduct", productService.findAll());
        if (cart.countProductQuantity() > 0) {
            modelAndView.addObject("countCart", cart.countProductQuantity());
        }
        return modelAndView;
    }

    @GetMapping("/form")
    public ModelAndView openForm() {
        ModelAndView modelAndView = new ModelAndView("/product/form");
        modelAndView.addObject("product", new Product());
        return modelAndView;
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("product") Product product) {
        MultipartFile image = product.getImage();
        String name = image.getOriginalFilename();
        try {
            FileCopyUtils.copy(image.getBytes(), new File(fileUpload_IMG + name));
        } catch (Exception e) {
            e.printStackTrace();
        }
        product.setImg(name);
        productService.save(new Product(product.getName(), product.getPrice(), name));
        return "redirect:/product/";
    }

    @GetMapping("/addToCart")
    public ModelAndView addToCart(@RequestParam("id") Long id, @ModelAttribute Cart cart) {
        ModelAndView modelAndView = new ModelAndView("/product/list");
        Optional<Product> productOptional = productService.findById(id);
        if (!productOptional.isPresent()) {
            return modelAndView;
        }
        cart.addProduct(productOptional.get());
        modelAndView.addObject("listProduct", productService.findAll());
        modelAndView.addObject("countCart", cart.countProductQuantity());
        return modelAndView;
    }

    @GetMapping("/editCart")
    public String editCart(@RequestParam("action") String action, @RequestParam("id") long id, @ModelAttribute Cart cart) {
        Product product = productService.findById(id).get();
        Map<Product, Integer> products = cart.getProducts();
        int quantity = 0;
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            if (entry.getKey().getId_product()==(product.getId_product())) {
                quantity=entry.getValue();
                switch (action) {
                    case "'increase'":
                        quantity+=1 ;
                        break;
                    case "'decrease'":
                        quantity-=1;
                        break;
                }
                cart.getProducts().replace(entry.getKey(), quantity);
            }
        }
        return "redirect: /cart/listCart";
    }
}
