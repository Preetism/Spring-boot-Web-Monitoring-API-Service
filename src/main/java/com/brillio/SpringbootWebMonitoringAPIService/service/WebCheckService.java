package com.brillio.SpringbootWebMonitoringAPIService.service;

import com.brillio.SpringbootWebMonitoringAPIService.model.Website;
import com.brillio.SpringbootWebMonitoringAPIService.model.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface WebCheckService {

    List<Website> getAllWebsites(String username);

    Website addWebsiteCheck(Website website);

//    void updateWebsite(Website website);
//
//    void deleteWebsite(String websiteName);

}
