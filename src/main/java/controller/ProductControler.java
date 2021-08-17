package controller;

import model.Catergory;
import model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import service.ProductService;

import java.io.File;
import java.io.IOException;

@Controller
public class ProductControler {
    @Autowired
    ProductService productService;

    @GetMapping("/products")
    public ModelAndView show() {
        ModelAndView modelAndView = new ModelAndView("show");
        productService.findAll();
        modelAndView.addObject("listProduct", productService.list);
        return modelAndView;
    }

    @GetMapping("/delete")
    public String delete(@RequestParam int index) {
        productService.delete(index);
        return "redirect:/products";
    }

    @GetMapping("/create")
    public String getCreate() {
        return "create";
    }

    @GetMapping("/edit")
    public ModelAndView edit(@RequestParam int index) {
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("p", productService.list.get(index));
        return modelAndView;
    }

    @PostMapping("/edit")
    public String editPost(@RequestParam MultipartFile uppImg, @RequestParam int index, @ModelAttribute("p") Product product) {
        String nameImg = uppImg.getOriginalFilename();
        try {
            FileCopyUtils.copy(uppImg.getBytes(), new File("/Users/johntoan98gmail.com/Desktop/project/Module4/BTVN_Module4_Tuan1/src/main/webapp/file/" + nameImg));
            String urlImg = "/i/file/" + nameImg;
            product.setImg(urlImg);
        } catch (IOException e) {
            System.err.println("chưa uppload file");
        }

        productService.edit(product);
        return "redirect:/products";
    }

    @PostMapping("/create")
    public String create(@RequestParam MultipartFile uppImg, @ModelAttribute Product product) {
        String nameImg = uppImg.getOriginalFilename();
        try {
            FileCopyUtils.copy(uppImg.getBytes(), new File("/Users/johntoan98gmail.com/Desktop/project/Module4/BTVN_Module4_Tuan1/src/main/webapp/file/" + nameImg));
            String urlImg = "/i/file/" + nameImg;
            product.setImg(urlImg);
        } catch (IOException e) {
            System.err.println("chưa uppload file");
        }

        productService.seve(product);
        return "redirect:/products";
    }




    @PostMapping("/uppFile")
    public String uppFile(@RequestParam MultipartFile uppImg) {
        String fileName = uppImg.getOriginalFilename();
        try {
            FileCopyUtils.copy(uppImg.getBytes(), new File("/Users/johntoan98gmail.com/Desktop/project/Module4/BTVN_Module4_Tuan1/src/main/webapp/file/" + fileName));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "redirect:/products";

    }

}
