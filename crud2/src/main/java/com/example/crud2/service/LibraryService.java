package com.example.crud2.service;


import com.example.crud2.model.Library;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class LibraryService {

    static List<Library> libraryList = new ArrayList<>();
    static int id=0;
    // getAllLibrary
    public List<Library> getAllLibrary(){
        return libraryList;
    }

    // getLibraryById
    public Library getLibraryById() {
        Predicate<? super Library> predicate = data->data.getId()==id;
        return libraryList.stream().filter(predicate).findFirst().get();
    }

    public void createLibrary(Library library) {
        library.setId(++id);
        libraryList.add(library);
    }
}
