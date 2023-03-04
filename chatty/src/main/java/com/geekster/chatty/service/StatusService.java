package com.geekster.chatty.service;

import com.geekster.chatty.dao.StatusRepository;
import com.geekster.chatty.dto.StatusRequest;
import com.geekster.chatty.model.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class StatusService {
    @Autowired
    private StatusRepository statusRepository;

    // createStatus
    public Status createStatus(StatusRequest statusRequest){
        Status status = Status.build(null,statusRequest.getName(), statusRequest.getDescription(), null, null);
        return statusRepository.save(status);
    }

    // getStatusById
    public Status getStatusById(int id) throws NoSuchElementException {
        Status status = statusRepository.findById(id).get();
        return statusRepository.save(status);
    }

    // getAllStatus
    public List<Status> getAllStatus() {
        List<Status> statusList = statusRepository.findAll();
        return statusList;
    }
}
