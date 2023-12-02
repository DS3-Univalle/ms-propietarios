package com.proyectocabin.proyectojpa.controller;

import com.proyectocabin.proyectojpa.model.Cabin;
import com.proyectocabin.proyectojpa.service.CabinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CabinController {
    private final CabinService cabinService;

    @Autowired
    public CabinController(CabinService cabinService) {
        this.cabinService = cabinService;
    }
    //Insert a cabin into the database
    @PostMapping("/create-cabin")
    public ResponseEntity<Cabin> sabeCabin(@RequestBody Cabin cabin){
        Cabin saveCabin = cabinService.saveCabin(cabin);
        return new ResponseEntity<>(saveCabin, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<String> getCabinEndpoint() {
        String message = "Se conectó bien";
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
    //Get a cabin by your ID
    @GetMapping("/cabin")
    public ResponseEntity<Cabin>getCabin(@RequestParam (name = "cabinID") long cabinID){
        Cabin cabin = cabinService.getCabin(cabinID);
        return  new ResponseEntity<>(cabin, HttpStatus.OK);
    }
    //Get all the cabins in the table in our database
    @GetMapping("/cabins")
    public List<Cabin> getCabins(){
        return cabinService.getCabins();
    }
    //Update an existing cabin in the database
    @PatchMapping("/cabin")
    public ResponseEntity<Cabin> updateCabin(@RequestParam(name = "cabinID") long cabinID, @RequestBody Cabin cabin){
        Cabin upadteCabin = cabinService.updateCabin(cabinID, cabin);
        return new ResponseEntity<>(upadteCabin, HttpStatus.OK);
    }

    //Delete an existing cabins in the database
    @DeleteMapping("/cabin")
    public  ResponseEntity<Cabin> deleteCabin(@RequestParam(name = "cabinID") long cabinID){
        Cabin deleteCabin = cabinService.deleteCabin(cabinID);
        return new ResponseEntity<>(deleteCabin, HttpStatus.OK);
    }
    //Get cabin by name usin a raw SQL statement
    @GetMapping("/cabins-by-name")
    public List<Cabin> getCabinByName(@RequestParam(name = "cabinName") String cabinName){
        return cabinService.getCabinByName(cabinName);
    }
}
