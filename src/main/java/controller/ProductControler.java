package controller;

import model.Catergory;
import model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import service.ProductService;

@Controller
public class ProductControler {
    ProductService productService = new ProductService();

    @GetMapping("/products")
    public ModelAndView show() {
        ModelAndView modelAndView = new ModelAndView("show");
        modelAndView.addObject("listProduct",productService.list);
        return modelAndView;
    }

    @GetMapping("/delete")
    public String delete(@RequestParam int index) {
        productService.delete(index);
        return "redirect:/products";
    }

    @GetMapping("/edit")
    public ModelAndView edit(@RequestParam int index) {
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("product",productService.list.get(index));
        return modelAndView;
    }

    @PostMapping("/edit")
    public String editPost(@RequestParam int index, @ModelAttribute Product product,@RequestParam("catergory.id") int catergoryId) {
        Catergory catergory = new Catergory(catergoryId,"abc");
        product.setCatergory(catergory);
        productService.edit(product,index);
        return "redirect:/products";
    }

}
