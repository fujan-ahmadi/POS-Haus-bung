package at.spengergasse.todo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import jakarta.persistence.Embeddable;

import java.util.Objects;

@Entity
@Table(name = "billingInfo")

@Getter
@ToString(callSuper = true)
public class BillingInfo extends BaseEntity {

    @Column(name = "city", unique = false, nullable = false, length = 100)
    @NotBlank @Size(max = 100)
    private String city;

    @Column(name = "address", unique = false, nullable = false, length = 200)
    @NotBlank @Size(max = 200)
    private String address;

    @Embedded
    private CreditCard creditCard;

    protected BillingInfo() {}

    public BillingInfo(String city, String address, CreditCard creditCard) {
        this.city = city;
        this.address = address;
        this.creditCard = creditCard;
    }
}
