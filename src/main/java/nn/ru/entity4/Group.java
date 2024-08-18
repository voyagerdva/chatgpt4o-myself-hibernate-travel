package nn.ru.entity4;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "groups")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;


    // @OneToOne: Group-Company - прямая
    @OneToOne(
            fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(
            name = "company_id")
    private Company company;


    // @OneToOne: Group-Item - обратная
    @OneToOne(
            fetch = FetchType.EAGER,
            mappedBy = "group")
    @JoinColumn(name = "item_id")
    private Item item;

    // equals & hashCode
    @Override
    public String toString() {

        return "Group{" +
                  "id=" + id +
                ", item=" + (item != null ? "Item{id=" + item.getId() + "}" : "null") +
                ", company=" + (company != null ? "Company{id=" + company.getId() + "}" : "null") +
                '}';
    }
}
