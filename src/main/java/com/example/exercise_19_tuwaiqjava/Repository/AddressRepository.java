package com.example.exercise_19_tuwaiqjava.Repository;

import com.example.exercise_19_tuwaiqjava.Model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

    // find address by address id (teacher id)
    Address findAddressById(Integer id);

}
