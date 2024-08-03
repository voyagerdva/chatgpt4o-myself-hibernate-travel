package nn.ru.entity4;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "items")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;


    // @OneToOne: Item-Order - прямая
//    @OneToOne(
//            fetch = FetchType.LAZY)
//    @JoinColumn(
//            name = "group_id",
//            unique = true,
//            nullable = false)
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
