package nn.ru.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "trips")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "date")
    private String date;



    // @ManyToMany: Trip-Department
    @ManyToMany(
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    @JoinTable(
            name = "deps_trips",
            joinColumns = @JoinColumn(name = "trip_id"),
            inverseJoinColumns = @JoinColumn(name = "department_id"))
    private Set<Department> departmentSet;

}