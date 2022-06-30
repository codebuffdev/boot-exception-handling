package raghu.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import raghu.boot.exception.UserNotFoundException;

import java.util.Random;

@Controller
@RequestMapping("/web")
public class BasicController {

    @GetMapping("/")
    public String displayHomePage(){
        if(new Random().nextInt(10) > 2){
            throw new RuntimeException("SAMPLE!!");
        }
        return "home";
    }

    @GetMapping("/uex/{uid}")
    public String displayUserDetails(@PathVariable String uid){
        if(true)
            throw new UserNotFoundException("FORCED Exception" + uid);
        return "home";
    }

    @GetMapping("/show")
    public String show(){
        if(true)
            throw new UserNotFoundException("FORCED Exception show/");
        return "home";
    }
}
