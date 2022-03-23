package databaseweb.saka.entities.concretes;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "accounts")
public class Account {

    @Id
    @Column(name = "account_name")
    private String accountName;

    @Column(name = "is_in_game")
    private Boolean isInGame;

    @Column(name = "character_counter")
    private Integer count;

    @OneToMany(mappedBy = "account")
    private List<Character> characters;
}
