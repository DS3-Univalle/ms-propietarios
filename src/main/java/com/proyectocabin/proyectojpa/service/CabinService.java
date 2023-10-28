package com.proyectocabin.proyectojpa.service;

import com.proyectocabin.proyectojpa.model.Cabin;
import com.proyectocabin.proyectojpa.repository.CabinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CabinService {
    private final CabinRepository cabinRepository;

    @Autowired
    public CabinService(CabinRepository cabinRepository) {
        this.cabinRepository = cabinRepository;
    }
    public Cabin saveCabin(Cabin cabin){
        return cabinRepository.save(cabin);
    }

    public Cabin getCabin(long cabinID){
        return cabinRepository.findById(cabinID).orElseThrow(()-> new RuntimeException("not found"));
    }

    public List<Cabin> getCabins(){
        return cabinRepository.findAll();
    }

    public  Cabin updateCabin(long cabinID, Cabin cabin){
        Cabin existingCabin = cabinRepository.findById(cabinID).orElseThrow(()-> new RuntimeException("not found"));
        existingCabin.setName(cabin.getName());
        existingCabin.setDescription(cabin.getDescription());
        existingCabin.setLocation(cabin.getLocation());
        existingCabin.setPrice(cabin.getPrice());
        existingCabin.setBathrooms(cabin.getBathrooms());
        existingCabin.setLegal_information(cabin.getLegal_information());
        existingCabin.setNumber_people(cabin.getNumber_people());
        existingCabin.setId_state(cabin.getId_state());
        cabinRepository.save(existingCabin);
        return existingCabin;
    }
    public Cabin deleteCabin(long cabinID){
        Cabin existingCabin = cabinRepository.findById(cabinID).orElseThrow(()-> new RuntimeException("not found"));
        cabinRepository.deleteById(cabinID);
        return existingCabin;
    }

    public List<Cabin> getCabinByName(String cabinName){
        return cabinRepository.getCabinByName(cabinName);
    }
}
