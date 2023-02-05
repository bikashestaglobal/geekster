package com.geekster.resturent.controller;

import com.geekster.resturent.model.Resturent;
import com.geekster.resturent.service.ResturentService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/resturents")
public class ResturentController {
    @Autowired
    private ResturentService resturentService;



    // getAllResturents
    @GetMapping("")
    public List<Resturent> getAllResturents() {
        return resturentService.getAllRestunts();
    }
    // getResturentById
    @GetMapping("/{id}")
    public Resturent getResturentById(@PathVariable int id) {
        return resturentService.getResturentById(id);
    }

    // createResturent
    @PostMapping("")
    public ResponseEntity<Resturent> createResturent(@RequestBody Resturent newResturent){
        Resturent addedResturent =  resturentService.createResturent(newResturent);
        return new ResponseEntity<>(addedResturent, HttpStatus.CREATED);
    }

    // updateResturent
    @PutMapping("/{id}")
    public Resturent updateResturent(@PathVariable int id, @RequestBody Resturent body) {
        return resturentService.updateResturent(id, body);
    }

    // deleteResturent
    @DeleteMapping("/{id}")
    public ResponseEntity<Resturent> deleteResturent(@PathVariable int id) {
        Resturent deletedResturent =  resturentService.deleteResturent(id);
        return new ResponseEntity<>(deletedResturent, HttpStatus.OK);
    }


}
