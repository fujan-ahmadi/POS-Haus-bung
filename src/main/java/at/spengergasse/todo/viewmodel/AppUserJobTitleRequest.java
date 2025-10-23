package at.spengergasse.todo.viewmodel;

import jakarta.validation.constraints.NotBlank;

public record AppUserJobTitleRequest(
        Long id,
        @NotBlank String jobTitle
) { }