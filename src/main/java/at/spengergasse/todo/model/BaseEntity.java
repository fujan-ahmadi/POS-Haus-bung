package at.spengergasse.todo.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.ToString;

import java.util.Objects;

@MappedSuperclass
@ToString
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Override
    public boolean equals(Object o)
    {
        if (o == null || getClass() != o.getClass())
            return false;

        BaseEntity other = (BaseEntity) o;

        if (isTransient())
            return false;

        return Objects.equals(id, other.id);
    }

    @Override
    public int hashCode()
    {
        return Objects.hashCode(id);
    }

    public boolean isTransient() {
        return id == null;
    }
}
