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
@Table(name = "connection")
public class Connection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private String image;

    @OneToOne
    private ConnectionType type;

    @OneToOne
    private Profile profileOne;

    @OneToOne
    private Profile profileTwo;

    @OneToMany
    @JoinColumn(name = "connection_id", referencedColumnName = "id")
    private Set<ConnectionQuantity> quantity;
}
