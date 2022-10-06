package com.microservices.customer.dto.request

import javax.validation.constraints.NotBlank

data class CreateCustomerRequest(
        @field:NotBlank(message = "Cuustomer name must not be empty")
        val name: String,
        @field:NotBlank(message = "Customer surname must not be empty")
        val surname: String
)
{
    constructor() : this("", "")
}