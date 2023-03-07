package com.geekster.doctorapp.service;

import com.geekster.doctorapp.dao.DoctorRepository;
import com.geekster.doctorapp.dao.PatientRepository;
import com.geekster.doctorapp.dto.PatientRequest;
import com.geekster.doctorapp.model.Doctor;
import com.geekster.doctorapp.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private DoctorRepository doctorRepository;

    // createPatient
    public Map<Object, Object> createPatient(PatientRequest patientRequest){
        Map<Object, Object> resMap = new HashMap<>();
        Doctor doctor = doctorRepository.findById(patientRequest.getDoctorId()).get();

        Patient patient = Patient.build(0,patientRequest.getName(),patientRequest.getMobile(), patientRequest.getGender(), patientRequest.getAge(),doctor,null,null);
        Patient savedPatient = patientRepository.save(patient);
        resMap.put("body", savedPatient);
        return resMap;
    }


    // getAllPatient
    public Map<Object, Object> getAllPatient(){
        Map<Object, Object> resMap = new HashMap<>();
        List<Patient> patients = patientRepository.findAll();
        resMap.put("body", patients);
        return resMap;
    }

    // getPatientById
    public Map<Object, Object> getPatientById(int id) throws Exception{
        Map<Object, Object> resMap = new HashMap<>();
        Patient patient = patientRepository.findById(id).get();
        resMap.put("body", patient);
        return resMap;
    }

    // updatePatient
    public Map<Object, Object> updatePatient(int id, PatientRequest patientRequest) throws Exception{
        Map<Object, Object> resMap = new HashMap<>();

        Doctor doctor = doctorRepository.findById(patientRequest.getDoctorId()).get();
        Patient oldPatient = patientRepository.findById(id).get();
        oldPatient.setName(patientRequest.getName());
        oldPatient.setMobile(patientRequest.getMobile());
        oldPatient.setGender(patientRequest.getGender());
        oldPatient.setAge(patientRequest.getAge());

        Patient updatedPatient = patientRepository.save(oldPatient);
        resMap.put("body", updatedPatient);
        return resMap;
    }

    // deletePatient
    public Map<Object, Object> deletePatient(int id) throws Exception{
        Map<Object, Object> resMap = new HashMap<>();
        Patient patient = patientRepository.findById(id).get();
        doctorRepository.deleteById(id);
        resMap.put("body", patient);
        return resMap;
    }
}
