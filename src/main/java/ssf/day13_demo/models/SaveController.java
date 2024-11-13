package ssf.day13_demo.models;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping
public class SaveController {

    @PostMapping("/exit")
    public String postExit(HttpSession sess, Model model) {

        List<Registration> regList = (List<Registration>)sess.getAttribute(RegistrationController.REG_LIST);

        // Returns registrations accumulated from the session
        System.out.printf(">>> regList: %s\n", regList);

        // Destroy session
        sess.invalidate();

        model.addAttribute("reg", new Registration());

        return "index";
    }
    
}
