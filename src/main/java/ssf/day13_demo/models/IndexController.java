package ssf.day13_demo.models;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path={"/", "index.html"})
public class IndexController {

    @GetMapping
    public String getIndex(Model model) {

        model.addAttribute("reg", new Registration());
        
        return "index";
    }
    
}
