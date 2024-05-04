package com.quest.demographic.controller;

import com.quest.demographic.dto.UserDTO;
import com.quest.demographic.service.UserService;
import com.quest.demographic.utils.CommonConstant;
import com.quest.demographic.utils.CommonUtils;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@Controller
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private CommonUtils commonUtils;


    @PostMapping("/save")
    public String save(@Valid @ModelAttribute UserDTO user, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("msg", this.commonUtils.prepareErrorMessage(bindingResult));
            return "recordform";
        }
        String message = userService.userRegister(user);
        return "redirect:/viewall?msg=" + message;
    }


    @GetMapping("/viewall")
    public String viewall(Model model) {

        List<UserDTO> users = userService.viewall();
        if (users.isEmpty())
            model.addAttribute("msg", CommonConstant.NO_RECORD_FOUND);

        model.addAttribute("user", users);

        return "records";
    }
}
