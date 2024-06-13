package com.bewell.api.entity;
import com.bewell.api.entity.enums.Gender;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="users")
@AllArgsConstructor
@NoArgsConstructor

@Data

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;
    /*Önemli not: Eğer ki bir değişkenin veritabnında karşılık geldiği değer ismi
    ile @Column altında belirtildiği değer ismi aynı ise;
    @Column bölgesine (name="Değer Adı") olarak belirtilmesi gerekmiyor.
    Öteki türlü belirtilmesi gerekmekte.
     */

    @Column(name = "identity_no", length = 11, unique = true)
    private String identityNo;

    @Column
    private String name;
    @Column
    private String surname;

    @Column
    @Enumerated (EnumType.STRING)
    private Gender gender;
    @Column(name ="urole")
    @Enumerated (EnumType.STRING)
    private Gender role;
}
