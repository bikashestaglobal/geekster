package com.example.eventmanagement.controller;

import com.example.eventmanagement.model.Event;
import com.example.eventmanagement.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class EventController {

    @Autowired
    EventService eventService;

    // getAllEvents
    @GetMapping("/events")
    public List<Event> getAllEvents(){
        return eventService.getAllEvents();
    }
    // getEventById
    @GetMapping("/events/{id}")
    public Event getEventById(@PathVariable int id){
        return eventService.getEventById(id);
    }
    // createEvent
    @PostMapping("/events")
    public ResponseEntity<Event> createEvent(@RequestBody Event event){
        return new ResponseEntity<>(eventService.createEvent(event), HttpStatus.CREATED);
    }
    // updateEvent
    @PutMapping("/events/{id}")
    public ResponseEntity<Event> updateEvent(@RequestBody Event event, @PathVariable int id){
        return new ResponseEntity<>(eventService.updateEvent(event, id), HttpStatus.OK);
    }
    // deleteEvent
    @DeleteMapping("/events/{id}")
    public ResponseEntity<String> deleteEvent(@PathVariable int id){
        eventService.deleteEvent(id);
        return new ResponseEntity<String>("Event Deleted Successfully", HttpStatus.OK);
    }
}
