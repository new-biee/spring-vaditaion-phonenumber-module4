package com.codegym.controller;

import com.codegym.model.PhoneNumber;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class PhoneNumberController {

    @GetMapping("/phone-number")
    public ModelAndView showForm() {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("phonenumber", new PhoneNumber());
        return modelAndView;
    }

    @PostMapping("/phone-number")
    public ModelAndView checkValidation(@Valid @ModelAttribute("phonenumber") PhoneNumber phoneNumber, BindingResult bindingResult) {
        new PhoneNumber().validate(phoneNumber, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            ModelAndView modelAndView = new ModelAndView("index");
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("result");
            modelAndView.addObject("phonenumber", phoneNumber.getNumber());
            return modelAndView;
        }
    }
}
