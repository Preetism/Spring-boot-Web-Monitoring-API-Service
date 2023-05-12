package com.brillio.SpringbootWebMonitoringAPIService.repository;

import com.brillio.SpringbootWebMonitoringAPIService.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WebCheckRepository extends JpaRepository<Website, Integer>{
}
