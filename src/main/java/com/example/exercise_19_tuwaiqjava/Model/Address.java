package com.example.exercise_19_tuwaiqjava.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Address {


    //Address Class :
    //area , street , buildingNumber ( Add all required validation )
    @Id
    private Integer id;
    @Column(columnDefinition = "varchar(20)")
    private String area;
    @Column(columnDefinition = "varchar(20)")
    private String street;
    @Column(columnDefinition = "int")
//    @Positive(message = "cannot be negative or zero")
    private Integer building_number;


    @OneToOne
    @MapsId
    @JsonIgnore
    private Teacher teacher;
}
