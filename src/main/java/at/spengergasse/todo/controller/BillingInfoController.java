package at.spengergasse.todo.controller;

import at.spengergasse.todo.model.BillingInfo;
import at.spengergasse.todo.viewmodel.BillingInfoRequest;
import at.spengergasse.todo.model.CreditCard;
import at.spengergasse.todo.repository.BillingInfoRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/billingInfos")
public class BillingInfoController {
    private final BillingInfoRepository billingInfoRepository;

    public BillingInfoController(BillingInfoRepository appUserRepository){
        this.billingInfoRepository = appUserRepository;
    }

    @GetMapping
    public List<BillingInfo> ListAll(){
        return billingInfoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<BillingInfo> GetById(@PathVariable Long id){
        return billingInfoRepository.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BillingInfo Insert(@Valid @RequestBody BillingInfoRequest req) {
        var entity = new BillingInfo(
                req.city(),
                req.address(),
                new CreditCard(req.creditCard())
        );
        return billingInfoRepository.save(entity);
    }

    @PutMapping
    public BillingInfo Update(@RequestBody BillingInfo entity){
        return billingInfoRepository.save(entity);
    }

    @DeleteMapping("/{id}")
    public void Delete(@PathVariable Long id){
        billingInfoRepository.deleteById(id);
    }
}
