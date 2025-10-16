package at.spengergasse.todo.repository;

import at.spengergasse.todo.model.AppUser;
import at.spengergasse.todo.model.BillingInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillingInfoRepository extends JpaRepository<BillingInfo, Long> {
}
