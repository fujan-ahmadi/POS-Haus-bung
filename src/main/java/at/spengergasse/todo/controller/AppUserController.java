package at.spengergasse.todo.controller;

import at.spengergasse.todo.model.AppUser;
import at.spengergasse.todo.service.AppUserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/appusers")
public class AppUserController {
    private final AppUserService appUserService;

    public AppUserController(AppUserService appUserService)
    {
        this.appUserService = appUserService;
    }

    @GetMapping
    public List<AppUser> ListAll(){

        return appUserService.listAll();
    }

    @GetMapping("/{id}")
    public Optional<AppUser> GetById(@PathVariable Long id){
        return appUserService.getById(id);
    }

    @PostMapping
    public AppUser Insert(@RequestBody AppUser entity){
        return appUserService.save(entity);
    }

    @PutMapping
    public AppUser Update(@RequestBody AppUser entity){
        return appUserService.save(entity);
    }

    @DeleteMapping("/{id}")
    public void Delete(@PathVariable Long id){
        appUserService.delete(id);
    }
}
