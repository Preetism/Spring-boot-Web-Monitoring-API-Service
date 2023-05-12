package com.brillio.SpringbootWebMonitoringAPIService.service;

import com.brillio.SpringbootWebMonitoringAPIService.model.Website;
import com.brillio.SpringbootWebMonitoringAPIService.repository.WebCheckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class WebCheckServiceImpl implements WebCheckService{

    @Autowired
    private WebCheckRepository webCheckRepository;


    public WebCheckServiceImpl(WebCheckRepository webCheckRepository) {
        this.webCheckRepository = webCheckRepository;
    }

    @Override
    public List<Website> getAllWebsites(String username){
        List<Website> websiteList = new ArrayList<>();
        webCheckRepository.findAll().forEach(websiteList::add);
        return websiteList;
    }

    @Override
    public Website addWebsiteCheck(Website website) {
        return webCheckRepository.save(website);
    }




}
