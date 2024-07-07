package nn.ru.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "departments")
@Data
//@NoArgsConstructor
//@AllArgsConstructor
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "salary_min")
    private Integer salaryMin;

    @Column(name = "salary_max")
    private Integer salaryMax;


    public Department(Long id, String name, Integer salaryMin, Integer salaryMax, Leader leader, Set<Employee> employeeSet, Set<Trip> tripSet) {
        this.id = id;
        this.name = name;
        this.salaryMin = salaryMin;
        this.salaryMax = salaryMax;
        this.leader = leader;
        this.employeeSet = employeeSet;
        this.tripSet = tripSet;
    }

    // @OneToOne: - Department-Leader
    @OneToOne(
            mappedBy = "department",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    @JoinColumn(
            name = "leader_id",
            nullable = false)
    private Leader leader;


    // @OneToMany: Department-Employee
    @OneToMany(
            mappedBy = "department",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    @JoinColumn(
            name = "employee_id",
            nullable = false)
    private Set<Employee> employeeSet;



    // @ManyToMany: Department-Trip
    @ManyToMany(
            mappedBy = "departmentSet",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    @JoinTable(
            name = "deps_trips",
            joinColumns = @JoinColumn(name = "department_id"),
            inverseJoinColumns = @JoinColumn(name = "trip_id"))
    private Set<Trip> tripSet;

    public Department() {

    }


    // equals & hashCode
    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department department = (Department) o;
        return Objects.equals(id, department.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


    // ArgsConstructor
    public Department(String name, Integer salaryMin, Integer salaryMax) {
        this.name = name;
        this.salaryMin = salaryMin;
        this.salaryMax = salaryMax;
    }

}
