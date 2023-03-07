package com.geekster.todo.controller;

import com.geekster.todo.dto.TodoRequest;
import com.geekster.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/v1/todo")
public class TodoController {
    @Autowired
    private TodoService todoService;

    // createTodo
    @PostMapping("")
    public ResponseEntity<Object> createTodo(@Valid @RequestBody TodoRequest todoRequest){
        Map<Object, Object> resMap = new HashMap<>();
        resMap.put("body", todoService.createTodo(todoRequest));
        resMap.put("status",HttpStatus.CREATED);
        resMap.put("message","Todo Created Successfully");
        return new ResponseEntity<>(resMap, HttpStatus.CREATED);
    }

    // getAllTodo
    @GetMapping("")
    public ResponseEntity<Object> getAllTodo(){
        Map<Object, Object> resMap = new HashMap<>();
        resMap.put("body", todoService.getAllTodo());
        resMap.put("status",HttpStatus.OK);
        resMap.put("message","Todo Fetched Successfully");
        return new ResponseEntity<>(resMap, HttpStatus.OK);
    }

    // getTodoById
    @GetMapping("/{id}")
    public ResponseEntity<Object> getTodoById(@PathVariable(required = true) int id) throws NoSuchElementException {
        Map<Object, Object> resMap = new HashMap<>();
        resMap.put("body", todoService.getTodoById(id));
        resMap.put("status",HttpStatus.OK);
        resMap.put("message","Todo Fetched Successfully");
        return new ResponseEntity<>(resMap, HttpStatus.OK);
    }

    // updateTodo
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateTodo(@PathVariable(required = true) int id, @Valid @RequestBody TodoRequest todoRequest) throws Exception {
        Map<Object, Object> resMap = new HashMap<>();
        resMap.put("body", todoService.updateTodo(id, todoRequest));
        resMap.put("status",HttpStatus.OK);
        resMap.put("message","Todo Updated Successfully");
        return new ResponseEntity<>(resMap, HttpStatus.OK);
    }

    // deleteTodo
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteTodo(@PathVariable(required = true) int id) throws Exception {
        Map<Object, Object> resMap = new HashMap<>();
        todoService.deleteTodo(id);
        resMap.put("body", null);
        resMap.put("status",HttpStatus.NO_CONTENT);
        resMap.put("message","Todo Deleted Successfully");
        return new ResponseEntity<>(resMap, HttpStatus.OK);
    }

}
