package exer2_12_02_2025.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table (name = "tb_category")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@ToString (of = {"id", "name"})

public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}