package com.brillio.SpringbootWebMonitoringAPIService.service;

import com.brillio.SpringbootWebMonitoringAPIService.model.Website;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface WebCheckService {



    //Optional<Website> getAllWebsites(int user_id);

    public List<Website> getAllTheWebsites();

    Website addWebsiteCheck(Website website);

      Website deleteWebsiteByName(Website website);

   // public Website getByWebsiteId(String websiteId);
    public List<Website> getByUserId(String user_id);



    //public void deleteWebsiteById(int websiteid);

    public Website updateWebsite(int websiteId, Website updatedWebsite);

    public List<Website> getWebsitesByUserId(int userId);






//    User getByUserId(int userId);
}
