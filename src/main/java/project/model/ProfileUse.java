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
@Table(name = "profile_use")
public class ProfileUse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;
    
    @Column
    private String altName;

    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "profiles_uses", joinColumns = @JoinColumn(name = "use_id"), inverseJoinColumns = @JoinColumn(name = "profile_id"))
    private Set<Profile> profiles;
}
