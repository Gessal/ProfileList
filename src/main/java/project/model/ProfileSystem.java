package project.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "profile_system")
public class ProfileSystem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String altName;

    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "profiles_systems", joinColumns = @JoinColumn(name = "system_id"), inverseJoinColumns = @JoinColumn(name = "profile_id"))
    private Set<Profile> profiles;

    public ProfileSystem(String name, String altName) {
        this.name = name;
        this.altName = altName;
    }
}
