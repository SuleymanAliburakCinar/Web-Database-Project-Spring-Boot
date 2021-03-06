package databaseweb.saka.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "_characters")
public class CharacterWithAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "character_id")
    private int id;

    @Column(name = "account_name")
    private String accountName;

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

}
