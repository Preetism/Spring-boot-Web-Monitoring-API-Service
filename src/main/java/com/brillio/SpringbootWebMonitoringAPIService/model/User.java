package com.brillio.SpringbootWebMonitoringAPIService.model;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Table
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int userId;
    @Column
    private String username;
    @Column
    private String password;
    @Column
    private String email;
}
