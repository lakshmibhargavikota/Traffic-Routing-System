package com.example.trafficrouting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.trafficrouting.service.TrafficService;

@Controller
public class TrafficController {

    @Autowired
    private TrafficService trafficService;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("locations", trafficService.getLocations());
        return "index";
    }

    @PostMapping("/route")
    public String findRoute(@RequestParam int start,
                            @RequestParam int end,
                            Model model) {

        System.out.println("Start = " + start);
        System.out.println("End = " + end);

        String route = trafficService.findShortestPath(start, end);

        System.out.println("Route = " + route);

        model.addAttribute("route", route);
        model.addAttribute("locations", trafficService.getLocations());

        return "index";
    }

    @PostMapping("/traffic")
    public String updateTraffic(@RequestParam int src,
                                @RequestParam int dest,
                                @RequestParam int level) {

        trafficService.updateTraffic(src, dest, level);

        return "redirect:/";
    }
}