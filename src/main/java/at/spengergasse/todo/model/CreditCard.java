package at.spengergasse.todo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;

import static at.spengergasse.todo.validation.Guard.creditCard;

@Embeddable
@Getter
public class CreditCard {
    public static final String MSG = String.format("Credit Card is not Valid");

    @Column(name = "creditCard", nullable = false)
    private String creditCard;

    protected CreditCard() {}

    public CreditCard(String value) {
        this.creditCard = creditCard(value, MSG);
    }
}
