package nn.ru.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "leaders")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Leader {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "salary")
    private Integer salary;


    // @OneToOne: Leader-Department
    @OneToOne()
    @JoinColumn( name = "department_id")
    private Department department;

    public void setDepartment(Department department) {
        this.department = department;
        department.setLeader(this);
//        if (department != null && department.getLeader() != this) {

//        }
    }


    // AllArgsConstructor - id
    public Leader(String name, Integer salary) {
        this.name = name;
        this.salary = salary;
    }

    // equals & hashCode


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Leader leader = (Leader) o;
        return Objects.equals(id, leader.id) && Objects.equals(name, leader.name) && Objects.equals(salary, leader.salary) && Objects.equals(department, leader.department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, salary, department);
    }
}
