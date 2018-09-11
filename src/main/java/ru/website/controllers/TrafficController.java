package ru.website.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.website.data.AsyncSaver;
import ru.website.data.TrafficService;
import ru.website.data.model.Feedback;

/**
 * Created by libragimov on 15.03.2018.
 */
@RestController
public class TrafficController {

    @Autowired
    TrafficService trafficService;

    @Autowired
    AsyncSaver saver;

    @PostMapping(value = "/feedback")
    public void feedback(@RequestBody Feedback feedback) {
        saver.saveFeedback(feedback);
    }
}
