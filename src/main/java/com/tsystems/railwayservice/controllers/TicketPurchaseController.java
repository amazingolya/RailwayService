package com.tsystems.railwayservice.controllers;

import com.tsystems.railwayservice.services.TicketPurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/buyTicket")
public class TicketPurchaseController {

    @Autowired
    TicketPurchaseService ticketPurchaseService;

   /* @RequestMapping(value = "/ticket", method = RequestMethod.POST)
    public String buyTicket() {

    }*/

}
