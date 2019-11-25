package com.harshit.springbootmicroservices.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Setter
@EqualsAndHashCode
public class Todo {

    @Id
    private Integer id;
    
    @Column(name = "summary")
    private String summary;
    
    @Column(name = "description")
    private String description;
}