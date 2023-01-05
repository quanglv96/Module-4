package guang.xia.controller;


import guang.xia.model.Product;
import guang.xia.service.category.ICategoryService;
import guang.xia.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.io.File;
import java.util.Objects;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private IProductService productService;
    @Autowired
    private ICategoryService categoryService;
    @Value("${upload.path}")
    private String fileUpload_IMG;


    @GetMapping
    public ResponseEntity<Iterable<Product>> listProduct() {
        return new ResponseEntity<>(productService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Product>> findById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(productService.findById(id), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Iterable<Product>> save(@ModelAttribute Product product) {
        MultipartFile file = product.getImg();
        String fileName = file.getOriginalFilename();
        try {
            file.transferTo(new File(fileUpload_IMG + fileName));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        productService.save(new Product(product.getName(), product.getPrice(), fileName, categoryService.findById(product.getId_category()).get()));
        return new ResponseEntity<>(productService.findAll(), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Iterable<Product>> delete(@PathVariable("id") Long id) {
        productService.remove(id);
        return new ResponseEntity<>(productService.findAll(), HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<Iterable<Product>> update(@ModelAttribute Product product) {
        try {
            MultipartFile file = product.getImg();
            String fileName = file.getOriginalFilename();
            if (Objects.equals(fileName, "")) {
                fileName = productService.findById(product.getId_product()).get().getImage();
            } else {
                file.transferTo(new File(fileUpload_IMG + fileName));
            }
            productService.save(new Product(product.getId_product(), product.getName(), product.getPrice(), fileName, categoryService.findById(product.getId_category()).get()));
            return new ResponseEntity<>(productService.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @GetMapping("/search")
    public ResponseEntity<Iterable<Product>> search(@RequestParam("search") String text){
        productService.search(text);
        return new ResponseEntity<>(productService.search(text), HttpStatus.OK);
    }

}
