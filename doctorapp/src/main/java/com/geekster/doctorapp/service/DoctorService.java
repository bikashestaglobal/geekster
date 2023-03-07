package com.geekster.doctorapp.service;

import com.geekster.doctorapp.dao.DoctorRepository;
import com.geekster.doctorapp.dto.DoctorRequest;
import com.geekster.doctorapp.model.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;

    // createDoctor
    public Map<Object, Object> createDoctor(DoctorRequest doctorRequest){
        Map<Object, Object> resMap = new HashMap<>();
        Doctor doctor = Doctor.build(0,doctorRequest.getName(), doctorRequest.getMobile(), doctorRequest.getSpeciality(),null,null);
        Doctor savedDoctor = doctorRepository.save(doctor);
        resMap.put("body", savedDoctor);
        return resMap;
    }


    // getAllDoctors
    public Map<Object, Object> getAllDoctors(){
        Map<Object, Object> resMap = new HashMap<>();
        List<Doctor> doctors = doctorRepository.findAll();
        resMap.put("body", doctors);
        return resMap;
    }

    // getDoctorById
    public Map<Object, Object> getDoctorById(int id) throws Exception{
        Map<Object, Object> resMap = new HashMap<>();
        Doctor doctor = doctorRepository.findById(id).get();
        resMap.put("body", doctor);
        return resMap;
    }

    // updateDoctor
    public Map<Object, Object> updateDoctor(int id, DoctorRequest doctorRequest) throws Exception{
        Map<Object, Object> resMap = new HashMap<>();

        Doctor doctor = doctorRepository.findById(id).get();
        doctor.setName(doctorRequest.getName());
        doctor.setMobile(doctorRequest.getMobile());
        doctor.setSpeciality(doctorRequest.getSpeciality());

        Doctor updatedDoctor = doctorRepository.save(doctor);
        resMap.put("body", updatedDoctor);
        return resMap;
    }

    // deleteDoctor
    public Map<Object, Object> deleteDoctor(int id) throws Exception{
        Map<Object, Object> resMap = new HashMap<>();
        Doctor doctor = doctorRepository.findById(id).get();
        doctorRepository.deleteById(id);
        resMap.put("body", doctor);
        return resMap;
    }
}
