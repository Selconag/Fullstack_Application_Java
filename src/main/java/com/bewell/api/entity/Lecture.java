package com.bewell.api.entity;
import com.bewell.api.entity.enums.Gender;
import jakarta.persistence.*;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name="lectures")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Lecture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;
    /*Önemli not: Eğer ki bir değişkenin veritabnında karşılık geldiği değer ismi
    ile @Column altında belirtildiği değer ismi aynı ise;
    @Column bölgesine (name="Değer Adı") olarak belirtilmesi gerekmiyor.
    Öteki türlü belirtilmesi gerekmekte.
     */

    @Column
    private String name;

    public Integer getTeacherId(){
        return teacher.getId();
    }

    //Normalde One to Many olarak ttanımlanan bir yapıyı burada
    //ManyToOne tanımladık çünkü One olan ucu burasını görsün diye
    @ManyToOne
    //Join Column maplenecek değeri belirttiğimiz kısım
    @JoinColumn(name = "teacher_id")
    private User teacher;

    @ManyToMany
    //İlişkiye gireceği tabloyu belirtmemiz gerekiyor, bu durumda foreign key tablosu
    @JoinTable(name ="user_lectures",
    joinColumns = {@JoinColumn(name="lectures_id", referencedColumnName = "id")},
    inverseJoinColumns = {@JoinColumn(name="user_id", referencedColumnName = "id")})
    private List<User> student;



}
