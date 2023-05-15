package com.brillio.SpringbootWebMonitoringAPIService.repository;

import com.brillio.SpringbootWebMonitoringAPIService.model.Website;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WebCheckRepository extends JpaRepository<Website, Integer> {
//    @Query("select w from website w where w.user_id=:user_id")
//    Optional<Website> findByUserId(@Param("user_id") int user_id);

//    List<Website> findByUserID(Optional<User> user);




//    @Query("select w from website w where w.user_id=:user_id")
//   List<Website> findDataByUserId(int user_id);
}


