package at.spengergasse.todo.viewmodel;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record BillingInfoRequest(
        @NotBlank @Size(max = 100) String city,
        @NotBlank @Size(max = 200) String address,
        @NotBlank String creditCard
) {}
