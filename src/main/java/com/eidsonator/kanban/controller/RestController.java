package com.eidsonator.kanban.controller;

import com.eidsonator.kanban.mapper.CardMapper;
import com.eidsonator.kanban.mapper.KanbanListMapper;
import com.eidsonator.kanban.mapper.TaskMapper;
import com.eidsonator.kanban.model.KanbanList;
import com.eidsonator.kanban.model.Task;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@CrossOrigin(origins = {"http://127.0.0.1:3000", "http://localhost:3000", "https://crud-react-eidsonator.herokuapp.com"})
@org.springframework.web.bind.annotation.RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE, value = "/")
public class RestController {

    @Autowired
    private TaskMapper taskMapper;
    private KanbanListMapper kanbanListMapper;
    private CardMapper cardMapper;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<KanbanList>> get () {
        HttpHeaders headers = new HttpHeaders();
        List<KanbanList> all = kanbanListMapper.findAll();
        for (KanbanList item : all ) {
            item.setCards(cardMapper.findAll(item.getId()));
            item.getCards();
        }
        return new ResponseEntity<>(all, headers, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Task post(@RequestBody String body) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Task task =  objectMapper.readValue(body, Task.class);
        taskMapper.insert(task);
        return task;
    }

    @RequestMapping(path = "/{task}", method = RequestMethod.PUT)
    public Task put(@PathVariable("task")long id, @RequestBody String body) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Task task =  objectMapper.readValue(body, Task.class);
        taskMapper.update(task);
        return task;
    }

    @RequestMapping(path="/{task}", method = RequestMethod.DELETE)
    public String delete(@PathVariable("task")long id) {
        taskMapper.delete(id);
        return "OK";
    }


}
