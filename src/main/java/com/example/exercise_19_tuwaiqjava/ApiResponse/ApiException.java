package com.example.exercise_19_tuwaiqjava.ApiResponse;

// to throw error messages
public class ApiException extends RuntimeException{

    public ApiException (String message){
        super(message);
    }
}
