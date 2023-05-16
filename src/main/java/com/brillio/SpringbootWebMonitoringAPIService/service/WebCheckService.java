package com.brillio.SpringbootWebMonitoringAPIService.service;

import com.brillio.SpringbootWebMonitoringAPIService.model.Website;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface WebCheckService {



    Optional<Website> getAllWebsites(int user_id);

    Website addWebsiteCheck(Website website);

      Website deleteWebsiteByName(Website website);

    public Website getByWebsiteId(int websiteId);

    public Website updateByMonitoringDetails(Website website);


//    User getByUserId(int userId);
}
