package at.spengergasse.nvsproject.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table (name = "User")
public class User extends AbstractPersistable<Long> {

    @Column (name = "name")
    private String username;
    @Column (name = "password")
    private String password;
    @Column (name = "email")
    private String email;
    @ManyToOne (cascade = CascadeType.PERSIST)
    private Calendar calendar;
}

