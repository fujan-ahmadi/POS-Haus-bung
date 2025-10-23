package at.spengergasse.todo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;

@Entity
@Table(name = "appUser")

@Getter
@Setter
@ToString(callSuper = true)
public class AppUser extends BaseEntity {

    @Column(name = "firstName", unique = false, nullable = false, length = 100)
    @NotBlank @Size(max = 100)
    private String firstName;


    @Column(name = "lastName", unique = false, nullable = false, length = 100)
    @NotBlank @Size(max = 100)
    private String lastName;

    @Column(name = "jobTitle", unique = false, nullable = false, length = 100)
    @NotBlank @Size(max = 100)
    private String jobTitle;

    protected AppUser() {}

    public AppUser(String firstName, String lastName, String jobTitle) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.jobTitle = jobTitle;
    }
}
