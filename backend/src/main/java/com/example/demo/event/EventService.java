package com.example.demo.event;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {
    public final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public Event getEventByID(Integer eventID) {
        return eventRepository.findById(eventID).
                orElseThrow(() -> new IllegalStateException("Event does not exist"));
    }
}
