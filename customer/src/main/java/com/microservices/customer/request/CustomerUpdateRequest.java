package com.microservices.customer.request;

public record CustomerUpdateRequest
        (Integer id, String firstName, String lastName, String email) {

}