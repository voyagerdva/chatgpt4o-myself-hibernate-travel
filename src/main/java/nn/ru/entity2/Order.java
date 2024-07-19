package nn.ru.entity2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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

    // @OneToOne: Order-Item обратная
    @OneToOne(
            fetch = FetchType.LAZY,
            mappedBy = "order")
    private Item item;

    // @OneToOne: Order-Company - прямая
    @OneToOne(
            fetch = FetchType.LAZY)
    @JoinColumn(
            name = "company_id",
            unique = true,
            nullable = false)
    private Company company;

    // equals & hashCode
    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", item=" + (item != null ? "Item{id=" + item.getId() + "}" : "null") +
                ", company=" + (company != null ? "Company{id=" + company.getId() + "}" : "null") +
                '}';
    }





}
