package ssf.day13_demo.models;

import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    @PostMapping("/obj")
    public String postRegistrationObj(
        @ModelAttribute Registration registration,
        Model model) {

            System.out.printf("registration: %s\n", registration);

            // Add model attribute to be referenced in registered.html
            model.addAttribute("reg", registration);

            return "registered";
        }

    // POST /registration
    @PostMapping
    public String postRegistration(
        @RequestBody MultiValueMap<String, String> form,
        @RequestBody String rawBody,
        Model model) {

            Registration reg = new Registration();
            reg.setName(form.getFirst("name"));

            System.out.printf("form: %s\n", form);
            System.out.printf("name: %s\n", rawBody);

            return "registered";
        }

    
}
