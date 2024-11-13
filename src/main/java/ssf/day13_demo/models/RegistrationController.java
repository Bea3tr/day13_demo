package ssf.day13_demo.models;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

import java.util.LinkedList;
import java.util.List;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    public static final String REG_LIST = "regList";

    // @Valid to validate the form (activate constraints), @ModelAttribute to bind object to the form
    // Binding results must immediately follow valid
    @PostMapping("/obj")
    public String postRegistrationObj(Model model,
        @Valid @ModelAttribute("reg") Registration registration,
        BindingResult bindings, HttpSession sess) {

            if(bindings.hasErrors()) 
                return "index";

            if("fred".equals(registration.getName().toLowerCase())) {
                FieldError err = new FieldError("reg", "name", "You cannot use the name Fred");
                bindings.addError(err);
                ObjectError objErr = new ObjectError("globalError", "error 1");
                bindings.addError(objErr);
                objErr = new ObjectError("globalError", "error 2");
                bindings.addError(objErr);
                return "index";
            }

            // Check if the session has the list
            List<Registration> regList = (List<Registration>) sess.getAttribute(REG_LIST);

            if(regList == null) {
                // if new session then regList is null
                // Initialize session by creating a list
                regList = new LinkedList<>();
                // Add to session
                sess.setAttribute(REG_LIST, regList);
            }

            regList.add(registration);

            System.out.printf("registration: %s\n", registration);
            System.out.printf("bindings: %b\n", bindings.hasErrors());

            // Add model attribute to be referenced in registered.html
            model.addAttribute("reg", registration);
            model.addAttribute(REG_LIST, regList);

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
