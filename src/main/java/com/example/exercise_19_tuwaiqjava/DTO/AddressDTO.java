//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++


// Date Transfer Object
// to catch json body and transfer it to address table in database
// to avoid the complicated or infinity loop of creating this object
// because address had connected to teacher class in one-to-one relation

//---------------------------------------------------------------------------
//***************************************************************************
// please let me know if this description incorrect at any situation 
//***************************************************************************
//---------------------------------------------------------------------------
//                             ^
//                            / \
//                           / ^ \
//                          / / \ \
//                         / /   \ \
//                           |   |
//                           |   |
//                           |   |
//                           |   |
//                           |   |
//                           |   |
package com.example.exercise_19_tuwaiqjava.DTO;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddressDTO {

    @NotNull
    private Integer teacher_id;
    private String area;
    private String street;
    @Positive(message = "cannot be negative or zero")
    private Integer building_number;

}
