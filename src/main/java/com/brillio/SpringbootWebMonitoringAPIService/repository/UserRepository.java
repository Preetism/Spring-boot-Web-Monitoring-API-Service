package com.brillio.SpringbootWebMonitoringAPIService.repository;

import com.brillio.SpringbootWebMonitoringAPIService.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
