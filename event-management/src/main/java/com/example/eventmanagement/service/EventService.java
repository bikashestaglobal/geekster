package com.example.eventmanagement.service;

import com.example.eventmanagement.dao.EventRepository;
import com.example.eventmanagement.model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {
    @Autowired
    EventRepository eventRepository;

    // getAllEvents
    public List<Event> getAllEvents(){
        return eventRepository.findAll();
    }

    // getEventById
    public Event getEventById(int id){
        return eventRepository.findById(id).get();
    }

    // createEvent
    public Event createEvent(Event event){
        return eventRepository.save(event);
    }


    // updateEvent
    public Event updateEvent(Event event, int id){
        Event oldEvent =  eventRepository.findById(id).get();
        oldEvent.setEventName(event.getEventName());
        oldEvent.setEventLocation(event.getEventLocation());
        oldEvent.setDate(event.getDate());
        oldEvent.setStartTime(event.getStartTime());
        oldEvent.setEndTime(event.getEndTime());
        oldEvent.setImageUrl(event.getImageUrl());
        return eventRepository.save(oldEvent);
    }


    // deleteEvent
    public void deleteEvent(int id) {
        eventRepository.deleteById(id);
    }

}
