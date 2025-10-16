package at.spengergasse.todo.controller;

import at.spengergasse.todo.model.AppUser;
import at.spengergasse.todo.repository.AppUserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/appusers")
public class AppUserController {
    private final AppUserRepository appUserRepository;

    public AppUserController(AppUserRepository appUserRepository){
        this.appUserRepository = appUserRepository;
    }

    @GetMapping
    public List<AppUser> ListAll(){
        return appUserRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<AppUser> GetById(@PathVariable Long id){
        return appUserRepository.findById(id);
    }

    @PostMapping
    public AppUser Insert(@RequestBody AppUser entity){
        return appUserRepository.save(entity);
    }

    @PutMapping
    public AppUser Update(@RequestBody AppUser entity){
        return appUserRepository.save(entity);
    }

    @DeleteMapping("/{id}")
    public void Delete(@PathVariable Long id){
        appUserRepository.deleteById(id);
    }
}
