package com.tsystems.railwayservice.controllers;

import com.tsystems.railwayservice.services.ScheduleService;
import com.tsystems.railwayservice.services.TrainSearchService;
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

    @Autowired
    private TrainSearchService trainSearchService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getTrainsByStation(@PathVariable long id, ModelMap model) {
        model.addAttribute("schedule", scheduleService.getScheduleByStation(id));
        return "schedule";
    }

    @RequestMapping("/findTrains")
    public String getTrainsByRouteAndTime(ModelMap model, HttpServletRequest request) {
        model.addAttribute("trains",
                trainSearchService.getTrainsByRouteAndTime(
                Long.parseLong(request.getParameter("departure_station_id")),
                Long.parseLong(request.getParameter("arrival_station_id")),
                Long.parseLong(request.getParameter("departure_date")),
                Long.parseLong(request.getParameter("arrival_date"))));
        return "trains";
    }

}
