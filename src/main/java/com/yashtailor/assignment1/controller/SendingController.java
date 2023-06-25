package com.yashtailor.assignment1.controller;

import com.yashtailor.assignment1.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SendingController {

    @ModelAttribute
    public void commonData(Model model) {
        model.addAttribute("Header", "Yash Tailor's Website.");
        model.addAttribute("Desc", "This is Programmer's place to code better");
    }
    @RequestMapping("/signup")
    public String signup(Model model) {
        return "signup";
    }

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String login(@ModelAttribute User user,
                        Model model) {
        if(user.getEmail().isBlank()) return "redirect:/signup";
        return "login";
    }
}
