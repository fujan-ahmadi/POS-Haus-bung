package at.spengergasse.todo.repository;

import at.spengergasse.todo.model.Address;
import at.spengergasse.todo.model.BillingInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
