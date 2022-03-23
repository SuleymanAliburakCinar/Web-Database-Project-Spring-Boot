package databaseweb.saka.dataAccess.abstracts;

import databaseweb.saka.entities.concretes.CharacterWithAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacterWithAccountDao extends JpaRepository<CharacterWithAccount, Integer> {
}
