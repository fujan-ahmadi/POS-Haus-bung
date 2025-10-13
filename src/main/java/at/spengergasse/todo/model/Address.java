package at.spengergasse.todo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.ToString;

@Entity
@Table(name = "address")

@Getter
@ToString(callSuper = true)
public class Address extends BaseEntity{
    @Column(name = "country", unique = false, nullable = false, length = 100)
    @NotBlank
    @Size(max = 100)
    private String country;

    @Column(name = "city", unique = false, nullable = false, length = 100)
    @NotBlank @Size(max = 100)
    private String city;

    @Column(name = "address", unique = false, nullable = false, length = 200)
    @NotBlank @Size(max = 200)
    private String address;

    protected Address(){

    }

    public Address(String country, String city, String address){
        this.country = country;
        this.city = city;
        this.address = address;
    }
}
