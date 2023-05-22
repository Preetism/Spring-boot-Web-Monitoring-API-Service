package com.brillio.SpringbootWebMonitoringAPIService.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name="website")
public class Website {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int websiteid;
    private String website_name;
    private String url;
    private int monitoring_frequency;
    private String status;
    private String username;


//    public Website(String url, String google) {
//    }
}
