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
        return new ResponseEntity<>(eventService.getAllEvents(), HttpStatus.OK);
    }

    @GetMapping(path = "/{eventID}")
    public ResponseEntity<Event> getEventByID(@PathVariable("eventID") Integer eventID) {
        return new ResponseEntity<>(eventService.getEventByID(eventID), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{eventID}")
    public ResponseEntity<Event> deleteEvent(@PathVariable("eventID") Integer eventID) {
        eventService.deleteEvent(eventID);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(path = "/{eventID}")
    public ResponseEntity<Event> updateEvent(@PathVariable("eventID") Integer eventID,
                                             @RequestBody Event event) {
        eventService.updateEvent(eventID, event);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
