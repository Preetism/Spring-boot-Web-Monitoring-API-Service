package com.brillio.SpringbootWebMonitoringAPIService.service;

import com.brillio.SpringbootWebMonitoringAPIService.model.User;
import com.brillio.SpringbootWebMonitoringAPIService.model.Website;
import com.brillio.SpringbootWebMonitoringAPIService.repository.WebCheckRepository;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class WebCheckServiceImpl implements WebCheckService{

    @Autowired
    private WebCheckRepository webCheckRepository;

    public WebCheckServiceImpl(WebCheckRepository webCheckRepository) {
        this.webCheckRepository = webCheckRepository;
    }




 /* public List<Website> getByUserId(String user_id) {

      List<Website> websiteList = webCheckRepository.findByUserId(user_id);
      return websiteList;
  }*/
      public List<Website> getAllTheWebsites() {
          List<Website> websiteList = webCheckRepository.findAll();

          webCheckRepository.findAll().forEach(websiteList::add);
          return websiteList;
      }

    public List<Website> getWebsitesByUsername(String username) {
        //return webCheckRepository.findWebsitesByUsername(username);
        return webCheckRepository.findByusername(username);
    }
//        @Override
//            public void deleteWebsiteById(int websiteId) {
//        webCheckRepository.deleteById(websiteId);
//}


    @Override
    public Website addWebsiteCheck(Website website) {
        return webCheckRepository.save(website);
    }

    @Override
    public Website deleteWebsiteByName(Website website) {
        webCheckRepository.delete(website);

        return website;
    }

    //@Override
    public void deleteWebsiteById(int websiteId) {
        webCheckRepository.deleteById(websiteId);
    }

    @Override
    public List<Website> getByUserId(String user_id) {
        return null;
    }


   // @Override
//    public Website getByWebsiteId(int websiteId) {
//        Optional<Website> website = webCheckRepository.findById(websiteId);
//        if (website.isPresent()) {
//            return website.get();
//        } else return null;
//    }

    //put Mapping
    public Website updateWebsite(int websiteId, Website updatedWebsite) {
        Website existingWebsite = webCheckRepository.findById(websiteId).orElse(null);

        if (existingWebsite != null) {
            existingWebsite.setUrl(updatedWebsite.getUrl());
            existingWebsite.setMonitoring_frequency(updatedWebsite.getMonitoring_frequency());
            return webCheckRepository.save(existingWebsite);
        }

        return null;
    }

    @Override
    public List<Website> getWebsitesByUserId(int userId) {
        return null;
    }

    //get Mapping
//    @Override
//    public List<Website> getWebsitesByUserId(int userId) {
//        return webCheckRepository.findByUserId(userId);
//    }


}




