package com.geekster.todo.service;

import com.geekster.todo.dao.TodoRepository;
import com.geekster.todo.dto.TodoRequest;
import com.geekster.todo.model.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TodoService {
    @Autowired
    private TodoRepository todoRepository;

    // createTodo
    public Todo createTodo(TodoRequest todoRequest){
        Todo todo = Todo.build(0,todoRequest.getTitle(),todoRequest.getDescription(), true,null,null);
        return todoRepository.save(todo);
    }

    // getAllTodo
    public List<Todo> getAllTodo(){
        return todoRepository.findAll();
    }

    // getTodoById
    public Todo getTodoById(int id) throws NoSuchElementException {
        return todoRepository.findById(id).get();
    }

    // updateTodo
    public Todo updateTodo(int id, TodoRequest todoRequest) throws Exception {
        Todo todo = todoRepository.findById(id).get();
        todo.setTitle(todoRequest.getTitle());
        todo.setDescription(todoRequest.getDescription());
        todo.setStatus(todoRequest.getStatus());
        return todoRepository.save(todo);
    }


    // deleteTodo
    public void deleteTodo(int id) throws Exception {
        todoRepository.deleteById(id);
    }

}
