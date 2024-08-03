package nn.ru.entity4;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "companies")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    // @OneToOne: Company-Order - обратная
//    @OneToOne(
//            fetch = FetchType.LAZY,
//            mappedBy = "company")
//    private Group group;

    // equals & hashCode
//    @Override
//    public String toString() {
//        return "Item{" +
//                "id=" + id +
//                ", group=" + (group != null ? "Order{id=" + group.getId() + "}" : "null") +
//                '}';
//    }


}
