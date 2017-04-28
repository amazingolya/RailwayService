package com.tsystems.railwayservice.controllers;

import com.tsystems.railwayservice.services.ViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")

public class MainController {
    @Autowired
    private ViewService viewService;

    @RequestMapping(method = RequestMethod.GET)
    public String showMainPage(ModelMap model) {
        /*UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Iterator<? extends GrantedAuthority> iterator = userDetails.getAuthorities().iterator();
        while (iterator.hasNext()) {
            GrantedAuthority authority = iterator.next();
            System.out.println(authority.getAuthority());
        }*/
        model.addAttribute("trains", viewService.seeAllTrains());
        return "main";
    }


}