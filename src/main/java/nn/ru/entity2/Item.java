package nn.ru.entity2;

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


    // @OneToOne: Leader-Department
    @OneToOne(
            fetch = FetchType.LAZY)
    @JoinColumn(
            name = "order_id",
            unique = true,
            nullable = false)
    private Order order;


//    private Order order1;


    // AllArgsConstructor - id

    // equals & hashCode

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", order=" + (order != null ? "Order{id=" + order.getId() + "}" : "null") +
                '}';
    }
}
