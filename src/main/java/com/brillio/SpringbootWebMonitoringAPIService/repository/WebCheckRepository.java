package com.brillio.SpringbootWebMonitoringAPIService.repository;

import com.brillio.SpringbootWebMonitoringAPIService.model.Website;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WebCheckRepository extends JpaRepository<Website, Integer> {
    List<Website> findByusername(String username);


    // @Query("SELECT w FROM Website w INNER JOIN User u ON u.username = w.username WHERE u.username = :username")
    //List<Website> findWebsitesByUsername(String username);

}


