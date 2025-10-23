package at.spengergasse.todo.viewmodel;

import jakarta.validation.constraints.NotBlank;

public record AppUserRequest(
        @NotBlank String firstName,
        @NotBlank String lastName,
        @NotBlank String jobTitle
) { }