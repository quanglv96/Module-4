package guang.xia.controller;

import guang.xia.model.Category;
import guang.xia.service.category.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;
    @GetMapping
    public ResponseEntity<Iterable<Category>> listCategory(){
        return new ResponseEntity<>(categoryService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Category>> findById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(categoryService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Iterable<Category>> save(@RequestBody Category category) {
        categoryService.save(category);
        return new ResponseEntity<>(categoryService.findAll(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Iterable<Category>> delete(@PathVariable("id") Long id) {
        categoryService.remove(id);
        return new ResponseEntity<>(categoryService.findAll(), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Iterable<Category>> update(@RequestBody String nameCategory) {
        categoryService.save(new Category(nameCategory));
        return new ResponseEntity<>(categoryService.findAll(), HttpStatus.OK);
    }
}
