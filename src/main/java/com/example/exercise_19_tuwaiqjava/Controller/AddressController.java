package com.example.exercise_19_tuwaiqjava.Controller;


import com.example.exercise_19_tuwaiqjava.ApiResponse.ApiResponse;
import com.example.exercise_19_tuwaiqjava.DTO.AddressDTO;
import com.example.exercise_19_tuwaiqjava.Service.AddressService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/address")
@RequiredArgsConstructor
public class AddressController {

    // dependency injection
    private final AddressService addressService;

    // Read
    @GetMapping("/get")
    public ResponseEntity getAllAddresses(){
        return ResponseEntity.status(200).body(addressService.getAllAddresses());
    }

    // Create
    @PostMapping("/add")
    public ResponseEntity addAddress(@RequestBody@Valid AddressDTO addressDTO){
        addressService.addAddress(addressDTO);
        return ResponseEntity.status(200).body(new ApiResponse("address created"));
    }

    // Update
    @PutMapping("/update")
    public ResponseEntity updateAddress(@RequestBody@Valid AddressDTO addressDTO){
        addressService.updateAddress(addressDTO);
        return ResponseEntity.status(200).body(new ApiResponse("address is updated"));
    }

    // Delete
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteAddress(@PathVariable Integer id){
        addressService.deleteAddress(id);
        return ResponseEntity.status(200).body(new ApiResponse("address is deleted"));
    }

}
