package com.tsystems.railwayservice.controllers;

import com.tsystems.railwayservice.services.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/schedule")
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getTrainsByStation(@PathVariable long id, ModelMap model) {
        model.addAttribute("schedule", scheduleService.getScheduleByStation(id));
        return "schedule";
    }

}
