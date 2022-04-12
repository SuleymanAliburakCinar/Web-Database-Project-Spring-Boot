package databaseweb.saka.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "_characters")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","account"})
public class Character {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "character_id")
    private int id;

    //@Column(name = "account_name")
    //private String accountName;

    @Column(name = "character_name")
    private String characterName;

    @Column(name = "character_level")
    private Integer characterLevel;

    @Column(name = "last_login_date")
    private java.util.Date lastLoginDate;

    @Column(name = "delete_date")
    private java.util.Date deleteDate;

    @Column(name = "is_in_academy")
    private Boolean isInAcademy;

    @Column(name = "is_graduated")
    private Boolean isGraduated;

    @JoinColumn(name = "account_name")
    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    private Account account;

}
