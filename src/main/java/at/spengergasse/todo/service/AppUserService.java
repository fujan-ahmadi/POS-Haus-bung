package at.spengergasse.todo.service;

import at.spengergasse.todo.model.AppUser;

import java.util.List;
import java.util.Optional;

public interface AppUserService{
    List<AppUser> listAll();

    AppUser save(AppUser appUser);

    Optional<AppUser> getById(Long id);

    void delete(Long id);
}