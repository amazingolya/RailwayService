package com.tsystems.railwayservice.controllers;

import com.google.gson.Gson;
import com.tsystems.railwayservice.entities.Station;
import com.tsystems.railwayservice.entities.Train;
import com.tsystems.railwayservice.services.EditingService;
import com.tsystems.railwayservice.services.ViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

import java.io.IOException;

import static com.tsystems.railwayservice.utils.Utils.readToString;

@Controller
@RequestMapping("/admin")
public class AdministrationController {

    @Autowired
    private EditingService editingService;

    @Autowired
    private ViewService viewService;

    @RequestMapping(value = "/train", method = RequestMethod.POST)
    public String addTrain(HttpServletRequest request) {
        try {
            String requestBody = readToString(request.getInputStream());
            Gson gson = new Gson();
            Train train = gson.fromJson(requestBody, Train.class);
            editingService.add(train);
        } catch (IOException e) {
            return "error";
        }
        return "success";
    }

    @RequestMapping(value = "/addStation", method = RequestMethod.POST)
    public String addStation(HttpServletRequest request) {
        try {
            String requestBody = readToString(request.getInputStream());
            Gson gson = new Gson();
            Station station = gson.fromJson(requestBody, Station.class);
            editingService.add(station);
        } catch (IOException e) {
            return "error";
        }
        return "success";
    }

    @RequestMapping(value = "/passengersRegisteredOnTrain/{trainId}", method = RequestMethod.GET)
    public String seeAllPassengersForTrain(@PathVariable long trainId, ModelMap model) {
        model.addAttribute(viewService.seeAllPassengersForTrain(trainId));
        return "passengersForTrain";
    }

    @RequestMapping("/allTrainsInSystem")
    public String seeAllTrains(ModelMap model) {
        model.addAttribute(viewService.seeAllTrains());
        return "trains";
    }
}
