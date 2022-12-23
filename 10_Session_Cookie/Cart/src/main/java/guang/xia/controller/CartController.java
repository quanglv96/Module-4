package guang.xia.controller;

import guang.xia.model.Cart;
import guang.xia.model.OderDetail;
import guang.xia.model.Product;
import guang.xia.service.orderDetail.IOrderDetailService;
import guang.xia.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;
import java.util.Random;


@Controller
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private IOrderDetailService orderDetailService;

    @GetMapping("/listCart")
    public ModelAndView listCart(@SessionAttribute("cart") Cart cart) {
        ModelAndView modelAndView = new ModelAndView("cart/list");
        for (Map.Entry<Product, Integer> entry : cart.getProducts().entrySet()) {
            if (entry.getValue() == 0) {
                cart.getProducts().remove(entry.getKey());
                break;
            }
        }
        modelAndView.addObject("cart", cart);
        return modelAndView;
    }

    @PostMapping("/payment")
    public ModelAndView formPayment() {
        ModelAndView modelAndView = new ModelAndView("cart/payment");
        modelAndView.addObject("userOrder", new OderDetail());
        return modelAndView;
    }

    @PostMapping("/submitPay")
    private ModelAndView submitPay(@ModelAttribute("userOrder") OderDetail oderDetail, @SessionAttribute("cart") Cart cart) {
        Random random=new Random();
        StringBuilder code= new StringBuilder();
        for (int i = 0; i < 5; i++) {
            int num=random.nextInt(9);
            code.append(num);
        }
        for (Map.Entry<Product, Integer> entry : cart.getProducts().entrySet()) {
            orderDetailService.save(new OderDetail(code.toString(),oderDetail.getNameUser(),oderDetail.getPhone(),oderDetail.getAddress(),entry.getKey(),entry.getValue()));
        }
        ModelAndView modelAndView=new ModelAndView("/cart/orderDetail");
        oderDetail.setCodeOrder(code.toString());
        modelAndView.addObject("info",oderDetail);
        modelAndView.addObject("orderDetail",orderDetailService.findAll());
        modelAndView.addObject("totalPayment",cart.countTotalPayment());
        return modelAndView;
    }

}
