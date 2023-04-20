package com.example.demo.event;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/event")
public class EventController {
    public final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping
    public ResponseEntity<List<Event>> getEvents() {
        return new ResponseEntity<List<Event>>(eventService.getAllEvents(), HttpStatus.OK);
    }

    @GetMapping(path = "/{eventID}")
    public ResponseEntity<Event> getEventByID(@PathVariable("eventID") Integer eventID) {
        return new ResponseEntity<Event>(eventService.getEventByID(eventID), HttpStatus.OK);
    }
}
