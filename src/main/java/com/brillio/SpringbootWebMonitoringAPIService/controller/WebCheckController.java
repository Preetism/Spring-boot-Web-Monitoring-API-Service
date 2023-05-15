package com.brillio.SpringbootWebMonitoringAPIService.controller;

import com.brillio.SpringbootWebMonitoringAPIService.model.Website;
import com.brillio.SpringbootWebMonitoringAPIService.repository.UserRepository;
import com.brillio.SpringbootWebMonitoringAPIService.service.WebCheckServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/monitor")
public class WebCheckController {

    @Autowired
    private WebCheckServiceImpl webCheckServiceimpl;

    @Autowired
    private UserRepository userRepository;


    public WebCheckController(WebCheckServiceImpl webCheckServiceimpl) {
        this.webCheckServiceimpl = webCheckServiceimpl;
    }

    @GetMapping("/webcheck/{user_id}")
    public ResponseEntity<Object> getAllWebsites(@PathVariable int user_id) {
//        Website website1=webCheckServiceimpl.getByWebsiteId(user_id);
//            Optional<Website> website = userRepository.findById(user_id);

            return new ResponseEntity<>(webCheckServiceimpl.getAllWebsites(user_id), HttpStatus.OK);




    }

    @PostMapping("/webcheck")
    public ResponseEntity<Website> addWebsiteCheck(@RequestBody Website website) {
        Website website1=webCheckServiceimpl.getByWebsiteId(website.getWebsiteid());
        return new ResponseEntity<>(webCheckServiceimpl.addWebsiteCheck(website), HttpStatus.CREATED);
    }

    @DeleteMapping("/webdelete")
    public ResponseEntity<?> deleteWebsiteByName(@RequestBody Website website) {
        Website website1=webCheckServiceimpl.getByWebsiteId(website.getWebsiteid());
        if(website1!=null){
        return new ResponseEntity<>(webCheckServiceimpl.deleteWebsiteByName(website), HttpStatus.OK);}
        else {
            return new ResponseEntity<>("Website Not Found",HttpStatus.CONFLICT);
        }
    }




    @PutMapping("/updateMonitoring")
    public ResponseEntity<Object> updateByUrl( @RequestBody Website website){
        Website website1=webCheckServiceimpl.getByWebsiteId(website.getWebsiteid());
        if (website1!=null){
        return new ResponseEntity<>(webCheckServiceimpl.updateByMonitoringDetails(website),HttpStatus.OK);

    }
        else
        {
            return new ResponseEntity<>("No Website Details Updated",HttpStatus.CONFLICT);
        }

}
}


