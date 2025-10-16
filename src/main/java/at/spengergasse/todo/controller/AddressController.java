package at.spengergasse.todo.controller;

import at.spengergasse.todo.model.Address;
import at.spengergasse.todo.repository.AddressRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/addresses")
public class AddressController {
    private final AddressRepository addressRepository;

    public AddressController(AddressRepository appUserRepository){
        this.addressRepository = appUserRepository;
    }

    @GetMapping
    public List<Address> ListAll(){
        return addressRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Address> GetById(@PathVariable Long id){
        return addressRepository.findById(id);
    }

    @PostMapping
    public Address Insert(@RequestBody Address entity){
        return addressRepository.save(entity);
    }

    @PutMapping
    public Address Update(@RequestBody Address entity){
        return addressRepository.save(entity);
    }

    @DeleteMapping("/{id}")
    public void Delete(@PathVariable Long id){
        addressRepository.deleteById(id);
    }
}
