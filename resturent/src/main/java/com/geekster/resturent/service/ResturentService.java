package com.geekster.resturent.service;

import com.geekster.resturent.model.Resturent;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ResturentService {
    private static List<Resturent> resturentList = new ArrayList<>();
    private static int id = 0;

    // add some value to the resturentList
   static {
        resturentList.add(new Resturent(++id,
                5,
                "My Wife",
                "This resturent is specially for the married couple",
                "Radio Station Road",
                "9117162463",
                "Chicken Tikka",
                "Chicken Tikka, Chicken Fried, Chicken Kadhi"
                ));
        resturentList.add(new Resturent(++id,
                5,
                "The Girlfriend",
                "This resturent is specially for the unmarried couple",
                "Radio Station Road",
                "9117162463",
                "Coffee",
                "Coffee, Chicken Fried, Chicken Kadhi"
        ));
    }

    // getAllResturents
    public List<Resturent> getAllRestunts(){
        return resturentList;
    }

    // getResturentById
    public Resturent getResturentById(int id){
       Resturent foundResturent=null;
       for(Resturent res:resturentList){
           if(res.getId() == id)
               foundResturent = res;
       }
       return foundResturent;
    }

    // createResturent
    public Resturent createResturent(Resturent newResturent){
       resturentList.add(newResturent) ;
       return newResturent;
    }

    // updateResturent
    public Resturent updateResturent(int id, Resturent body){
        Resturent foundResturent=null;
        for(Resturent res:resturentList){
            if(res.getId() == id)
                foundResturent = res;
        }
        foundResturent.setId(body.getId());
        foundResturent.setTotalStaffs(body.getTotalStaffs());
        foundResturent.setName(body.getName());
        foundResturent.setAbout(body.getAbout());
        foundResturent.setAddress(body.getAddress());
        foundResturent.setMobile(body.getMobile());
        foundResturent.setSpeciality(body.getSpeciality());
        foundResturent.setMenu(body.getMenu());
        return foundResturent;
    }


    // deleteResturent
    public Resturent deleteResturent(int id){
        Resturent foundResturent=null;
        int i=0;
        for(Resturent res:resturentList){
            if(res.getId() == id)
                foundResturent = res;
            else i++;
        }
        resturentList.remove(i);
        return foundResturent;
    }

}
