package com.example.exercise_19_tuwaiqjava.Service;

import com.example.exercise_19_tuwaiqjava.ApiResponse.ApiException;
import com.example.exercise_19_tuwaiqjava.DTO.AddressDTO;
import com.example.exercise_19_tuwaiqjava.Model.Address;
import com.example.exercise_19_tuwaiqjava.Model.Teacher;
import com.example.exercise_19_tuwaiqjava.Repository.AddressRepository;
import com.example.exercise_19_tuwaiqjava.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressService {

    // dependency injection
    private final AddressRepository addressRepository;
    private final TeacherRepository teacherRepository;


    public List<Address> getAllAddresses(){
        return addressRepository.findAll();
    }

    public void addAddress(AddressDTO addressDTO){
        Teacher teacher = teacherRepository.findTeacherById(addressDTO.getTeacher_id());

        if (teacher==null)
            throw new ApiException("teacher not found to add address");

        Address address = new Address(null,addressDTO.getArea(),addressDTO.getStreet(),addressDTO.getBuilding_number(),teacher);
        addressRepository.save(address);
    }

    public void updateAddress(AddressDTO addressDTO){
        Address address = addressRepository.findAddressById(addressDTO.getTeacher_id());
        if (address==null)
            throw new ApiException("not found");

        address.setArea(addressDTO.getArea());
        address.setStreet(addressDTO.getStreet());
        address.setBuilding_number(addressDTO.getBuilding_number());
        addressRepository.save(address);
    }

    public void deleteAddress(Integer id){
        Address address = addressRepository.findAddressById(id);
        Teacher teacher = teacherRepository.findTeacherById(id);
        if (address==null||teacher==null)
            throw new ApiException("teacher not found to remove address");
        teacher.setAddress(null);
        teacherRepository.save(teacher);
        addressRepository.delete(address);
    }


}
