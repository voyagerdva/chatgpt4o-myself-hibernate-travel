package nn.ru.entity1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToOne(
            fetch = FetchType.LAZY,
            mappedBy = "order")
    @JoinColumn(name = "item_id")
    private Item item;

//    @OneToOne(
//            fetch = FetchType.LAZY)
//    @JoinColumn(
//            name = "item1_id",
//            unique = true,
//            nullable = false)
//    private Item item1;

    // AllArgsConstructor - id

    // equals & hashCode
    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", item=" + (item != null ? "Item{id=" + item.getId() + "}" : "null") +
                '}';
    }



}
