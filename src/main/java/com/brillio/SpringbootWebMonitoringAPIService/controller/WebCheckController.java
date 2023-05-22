package com.brillio.SpringbootWebMonitoringAPIService.controller;

import com.brillio.SpringbootWebMonitoringAPIService.model.Website;
import com.brillio.SpringbootWebMonitoringAPIService.repository.UserRepository;
import com.brillio.SpringbootWebMonitoringAPIService.repository.WebCheckRepository;
import com.brillio.SpringbootWebMonitoringAPIService.service.JWTUtil;
import com.brillio.SpringbootWebMonitoringAPIService.service.WebCheckServiceImpl;
//import org.apache.commons.codec.binary.Base64;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.util.Base64Utils;

import java.nio.charset.StandardCharsets;
import java.util.*;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;


import java.util.List;

@RestController
//@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/v1/monitor")
public class WebCheckController {

    @Autowired
    private WebCheckServiceImpl webCheckServiceimpl;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private WebCheckRepository webCheckRepository;


    public WebCheckController(WebCheckServiceImpl webCheckServiceimpl) {
        this.webCheckServiceimpl = webCheckServiceimpl;
    }

   /* @PostMapping("/webAdd")
    public ResponseEntity<Website> addWebsiteCheck(@RequestBody Website website) {
        // Website website1=webCheckServiceimpl.getByWebsiteId(website.getWebsiteid());
        return new ResponseEntity<>(webCheckServiceimpl.addWebsiteCheck(website), HttpStatus.CREATED);
    }*/

    @PostMapping("/webAddWebsite")
    public ResponseEntity<Website> createUser(@RequestBody Website website,@RequestHeader(value = "Authorization") String authorizationHeader) {
        String[] pieces = authorizationHeader.split("\\.");
        String encodedPayload = pieces[1].replaceAll("\\s", "");
        String decodedPayload = new String(Base64.getUrlDecoder().decode(encodedPayload));
        System.out.println("Decoded Payload: " + decodedPayload);
        JWTUtil jwtUtil = new JWTUtil();
        String username = jwtUtil.fetchSubjectFromDecodedPayload(decodedPayload);
        website.setUsername(username);
        website.setStatus(null);
        Website savedWebsite = webCheckRepository.save(website);
        return ResponseEntity.ok(savedWebsite);
    }

    @DeleteMapping("/webdelete/{websiteId}")
    public void deleteById(@PathVariable int websiteId){
        webCheckServiceimpl.deleteWebsiteById(websiteId);
    }

    @GetMapping("/webcheck")
    public ResponseEntity<?> getWebsitesByUsername(@RequestHeader(value = "Accept") String acceptHeader,
                                               @RequestHeader(value = "Authorization") String authorizationHeader) {

        System.out.println(acceptHeader);
        System.out.println(authorizationHeader);

        String[] pieces = authorizationHeader.split("\\.");
        System.out.println("pieces done");

        String encodedHeader = pieces[0].replaceAll("\\s", "");
        String encodedPayload = pieces[1].replaceAll("\\s", "");

        System.out.println("Decoding JWT...");

        String decodedHeader = new String(Base64.getUrlDecoder().decode(encodedHeader));
        String decodedPayload = new String(Base64.getUrlDecoder().decode(encodedPayload));

        System.out.println("Decoded Header: " + decodedHeader);
        System.out.println("Decoded Payload: " + decodedPayload);

        JWTUtil jwtUtil = new JWTUtil();
        String username = jwtUtil.fetchSubjectFromDecodedPayload(decodedPayload);

        System.out.println(username);

        return new ResponseEntity<>(webCheckServiceimpl.getWebsitesByUsername(username), HttpStatus.OK);
    }
    @PutMapping("webCheckUpdate/{websiteId}")

    public ResponseEntity<Website> updateWebsite(@PathVariable int websiteId, @RequestBody Website updatedWebsite) {
        Website updatedSite = webCheckServiceimpl.updateWebsite(websiteId, updatedWebsite);

        if (updatedSite != null) {
            return ResponseEntity.ok(updatedSite);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }



}


