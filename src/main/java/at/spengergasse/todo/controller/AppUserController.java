package at.spengergasse.todo.controller;

import at.spengergasse.todo.model.AppUser;
import at.spengergasse.todo.service.AppUserService;
import at.spengergasse.todo.viewmodel.AppUserJobTitleRequest;
import at.spengergasse.todo.viewmodel.AppUserRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/appusers")
@RequiredArgsConstructor
public class AppUserController {
    private final AppUserService appUserService;

    @GetMapping
    public List<AppUser> ListAll(){

        return appUserService.listAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AppUser> GetById(@PathVariable Long id){
        return appUserService.getById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public AppUser Insert(@Valid @RequestBody AppUserRequest request)
    {
        return appUserService.save(request);
    }

    @PutMapping
    public AppUser Update(@RequestBody AppUser appUser){

        return appUserService.save(appUser);
    }

    @PatchMapping
    public ResponseEntity<AppUser> UpdateJobTitle(@Valid @RequestBody AppUserJobTitleRequest request){
        return appUserService.updateJobTitle(request)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public void Delete(@PathVariable Long id){
        appUserService.delete(id);
    }
}
