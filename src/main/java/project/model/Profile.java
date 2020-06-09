package project.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "profile")
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private float weight;

    @Column
    private float perimeter;

    @Column
    private float jx;

    @Column
    private float wx;

    @Column
    private float jy;

    @Column
    private float wy;

    @Column
    private String image;

    @ManyToMany
    @JoinTable(name = "profiles_systems", joinColumns = @JoinColumn(name = "profile_id"), inverseJoinColumns = @JoinColumn(name = "system_id"))
    private Set<ProfileSystem> profileSystems;

    @ManyToMany
    @JoinTable(name = "profiles_uses", joinColumns = @JoinColumn(name = "profile_id"), inverseJoinColumns = @JoinColumn(name = "use_id"))
    private Set<ProfileUse> uses;

    public Profile(String name, float weight, Set<ProfileSystem> profileSystems, Set<ProfileUse> uses) {
        this.name = name;
        this.weight = weight;
        this.profileSystems = profileSystems;
        this.uses = uses;
    }
}
