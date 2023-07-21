package com.uas027.uas_prg7_20222_027.repository;

import com.uas027.uas_prg7_20222_027.model.Detail;
import com.uas027.uas_prg7_20222_027.model.Lapangan;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface LapanganRepository extends CrudRepository<Lapangan, Integer> {
    List<Lapangan> findAll();
}
