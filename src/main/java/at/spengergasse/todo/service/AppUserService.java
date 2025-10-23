package at.spengergasse.todo.service;

import at.spengergasse.todo.model.AppUser;
import at.spengergasse.todo.viewmodel.AppUserJobTitleRequest;
import at.spengergasse.todo.viewmodel.AppUserRequest;

import java.util.List;
import java.util.Optional;

public interface AppUserService{
    List<AppUser> listAll();

    AppUser save(AppUser appUser);

    AppUser save(AppUserRequest appUserRequest);

    Optional<AppUser> getById(Long id);

    void delete(Long id);

    Optional<AppUser> updateJobTitle(AppUserJobTitleRequest request);
}