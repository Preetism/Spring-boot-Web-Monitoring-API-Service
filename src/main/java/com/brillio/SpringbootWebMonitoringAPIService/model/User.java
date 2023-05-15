package com.brillio.SpringbootWebMonitoringAPIService.model;

import lombok.*;

import javax.persistence.*;

@Data

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name="user")
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
//    @OneToMany (mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private int user_id;


//    @OneToMany (mappedBy = "user")
//    private Set<Website> websites = new HashSet<>();

    @Column
    private String username;
    @Column
    private String password;
    @Column
    private String email;
}
