package nn.ru.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "departments")
@Data
@NoArgsConstructor
@AllArgsConstructor
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


    // AllArgsConstructor - id
    public Department(String name, Integer salaryMin, Integer salaryMax) {
        this.name = name;
        this.salaryMin = salaryMin;
        this.salaryMax = salaryMax;
    }


    // @OneToOne: - Department-Leader
    @OneToOne(
//            mappedBy = "department",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    @JoinColumn(name = "leader_id")
    private Leader leader;

    public void setLeader(Leader leader) {
        this.leader = leader;
        if (leader != null && leader.getDepartment() != this) {
            leader.setDepartment(this);
        }
    }


    // @OneToMany: Department-Employee
    @OneToMany(
            mappedBy = "department",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
//    @JoinColumn(
//            name = "employee_id",
//            nullable = false)
    private List<Employee> employeeList;


    public void addEmployeeToDepartment(Employee employee) {
        if (employeeList == null) {
            employeeList = new ArrayList<>();
        }
        employeeList.add(employee);
        employee.setDepartment(this);
    }

//    // @ManyToMany: Department-Trip
//    @ManyToMany(
//            mappedBy = "departmentSet",
//            fetch = FetchType.LAZY,
//            cascade = CascadeType.ALL)
//    @JoinTable(
//            name = "deps_trips",
//            joinColumns = @JoinColumn(name = "department_id"),
//            inverseJoinColumns = @JoinColumn(name = "trip_id"))
//    private Set<Trip> tripSet;


    // equals & hashCode

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(salaryMin, that.salaryMin) && Objects.equals(salaryMax, that.salaryMax) && Objects.equals(leader, that.leader) && Objects.equals(employeeList, that.employeeList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, salaryMin, salaryMax, leader, employeeList);
    }
}
