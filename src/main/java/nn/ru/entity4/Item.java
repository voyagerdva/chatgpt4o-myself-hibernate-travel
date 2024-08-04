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

    // @OneToOne: Item-Group - прямая
    @OneToOne(
            fetch = FetchType.LAZY)
    @JoinColumn(
            name = "group_id")
    private Group group;

    // equals & hashCode
    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", group=" + (group != null ? "Group{id=" + group.getId() + "}" : "null") +
                '}';
    }

}
