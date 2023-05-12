package com.brillio.SpringbootWebMonitoringAPIService.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table
public class Website {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int websiteId;
    @Column
    private String websiteName;
    @Column
    private String url;
    @Column
    private int monitoring_frequency;
    @Column
    private String status;

}
