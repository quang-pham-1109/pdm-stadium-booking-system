package com.example.demo.event;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

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

    public void deleteEvent(Integer eventID) {
        boolean exists = eventRepository.existsById(eventID);
        if (!exists) {
            throw new IllegalStateException(
                    "event with id " + eventID + "does not exist");
        }
        eventRepository.deleteById(eventID);
    }

    @Transactional
    public void updateEvent(Integer eventID, Event event) {
        Event editedEvent = eventRepository.findById(eventID).
                orElseThrow(() -> new IllegalStateException(
                        "event with id " + eventID + "does not exist"));
        //Check and edit event name
        if (event.getEventTitle() != null &&
                event.getEventTitle().length() > 0 &&
                !Objects.equals(editedEvent.getEventTitle(), event.getEventTitle())) {
            editedEvent.setEventTitle(event.getEventTitle());
        }
        //Check and edit event date
        if (event.getEventDate() != null &&
                !Objects.equals(editedEvent.getEventDate(), event.getEventDate())) {
            editedEvent.setEventDate(event.getEventDate());
        }
        //Check and edit event time
        if (event.getEventTime() != null &&
                !Objects.equals(editedEvent.getEventTime(), event.getEventTime())) {
            editedEvent.setEventTime(event.getEventTime());
        }
        //Check and edit event capacity
        if (event.getAvailableSeats() != null &&
                event.getAvailableSeats() > 0 &&
                !Objects.equals(editedEvent.getAvailableSeats(), event.getAvailableSeats())) {
            editedEvent.setAvailableSeats(event.getAvailableSeats());
        }
    }
}
