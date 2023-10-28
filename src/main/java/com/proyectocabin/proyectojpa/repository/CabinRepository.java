package com.proyectocabin.proyectojpa.repository;

import com.proyectocabin.proyectojpa.model.Cabin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CabinRepository  extends JpaRepository<Cabin, Long> {
    @Query(value = "select * from cabins where  name = ?", nativeQuery = true)
    List<Cabin> getCabinByName(String cabinName);
}
