package com.brillio.SpringbootWebMonitoringAPIService.controller;

import com.brillio.SpringbootWebMonitoringAPIService.model.Website;
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

    public WebCheckController(WebCheckServiceImpl webCheckServiceimpl) {
        this.webCheckServiceimpl = webCheckServiceimpl;
    }

    @GetMapping("/webcheck/{username}")
    public ResponseEntity<?> getAllWebsites(@PathVariable String username){
        return new ResponseEntity<>(webCheckServiceimpl.getAllWebsites(username), HttpStatus.OK);
    }

    @PostMapping("/webcheck")
    public ResponseEntity<Website> addWebsiteCheck(@RequestBody Website website) {
        return new ResponseEntity<>(webCheckServiceimpl.addWebsiteCheck(website), HttpStatus.CREATED);
    }
}
