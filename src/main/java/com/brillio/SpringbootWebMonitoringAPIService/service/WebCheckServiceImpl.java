package com.brillio.SpringbootWebMonitoringAPIService.service;

import com.brillio.SpringbootWebMonitoringAPIService.model.Website;
import com.brillio.SpringbootWebMonitoringAPIService.repository.WebCheckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WebCheckServiceImpl implements WebCheckService{

    @Autowired
    private WebCheckRepository webCheckRepository;

//    @Autowired
//    private UserRepository userRepository;


//    public WebCheckServiceImpl(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }

    public WebCheckServiceImpl(WebCheckRepository webCheckRepository) {
        this.webCheckRepository = webCheckRepository;
    }



  @Override
  public Optional<Website> getAllWebsites(int user_id) {

      Optional<Website> websiteList = webCheckRepository.findById(user_id);
      return websiteList;

//
//      List<Website> websiteList = new ArrayList<>();
//      webCheckRepository.findById(user_id).forEach(websiteList::add);
//      return websiteList;
  }

//    public List<Website> getAllWebsites(int user_id){
//        return webCheckRepository.findDataByUserId(user_id);
//    }



    @Override
    public Website addWebsiteCheck(Website website) {
        return webCheckRepository.save(website);
    }

    @Override
    public Website deleteWebsiteByName(Website website) {
        webCheckRepository.delete(website);

        return website;
    }
    public Website updateByMonitoringDetails(Website website) {
        Website website1 = webCheckRepository.save(website);
        return website1;
    }

    @Override
    public Website getByWebsiteId(int websiteId) {
        Optional<Website> website = webCheckRepository.findById(websiteId);
        if (website.isPresent()) {
            return website.get();
        } else return null;
    }


}






//    @Override
//    public User getByUserId(int user_id) {
//        User user= webCheckRepository.findById(user_id);
//        if (user.equals()){
//            return user.get();
//        }
//        else {
//            return null;
//        }
//
//    }



