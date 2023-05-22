package com.kemal.spring.web.controllers.viewControllers;

import com.kemal.spring.domain.User;
import com.kemal.spring.service.UserService;
import com.kemal.spring.web.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;

/**
 * Created by Keno&Kemo on 30.09.2017..
 */

@Controller
@RequestMapping("")
public class IndexController {

    @Autowired
    UserService userService;

    @GetMapping(value = {"/", "/index"})
    public String index (){
        return "website/index";
    }

    @GetMapping(value = "/login")
    public String login (){
        return "website/login";
    }

    @GetMapping(value = "/register")
    public String showRegistrationForm(WebRequest request, Model model) {
        UserDto userDto = new UserDto();
        model.addAttribute("userDto", userDto);
        return "website/register";
    }

    @GetMapping(value = "/leaderboard/{name}")
    public String leaderboard(@PathVariable String name, Model model) {
        User user = userService.findByUsername(name);
        model.addAttribute("user", user);
        return "website/leaderboard";
    }
}
