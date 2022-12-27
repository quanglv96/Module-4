package guang.xia.controller;


import guang.xia.model.SmartPhone;
import guang.xia.service.ISmartphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/smartphones")
public class SmartphoneController {
    @Autowired
    private ISmartphoneService smartphoneService;

    @PostMapping
    public ResponseEntity<SmartPhone> createSmartphone(@RequestBody SmartPhone smartphone) {
        return new ResponseEntity<>(smartphoneService.save(smartphone), HttpStatus.CREATED);
    }

    @GetMapping("/list")
    public ModelAndView getAllSmartphonePage() {
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("smartphones", smartphoneService.findAll());
        return modelAndView;
    }
    @GetMapping
    public ResponseEntity<Iterable<SmartPhone>> allPhones() {
        return new ResponseEntity<>(smartphoneService.findAll(), HttpStatus.OK);
    }
    @DeleteMapping
    public ResponseEntity<Iterable<SmartPhone>> deletePhone(@RequestBody Long id){
        smartphoneService.remove(id);
        return new ResponseEntity<>(smartphoneService.findAll(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<SmartPhone>findById(@PathVariable Long id){
        return new ResponseEntity<>(smartphoneService.findById(id).get(), HttpStatus.OK);
    }
    @PutMapping
    public ResponseEntity<Iterable<SmartPhone>> deletePhone(@RequestBody SmartPhone smartphone){
        smartphoneService.save(smartphone);
        return new ResponseEntity<>(smartphoneService.findAll(), HttpStatus.OK);
    }

}