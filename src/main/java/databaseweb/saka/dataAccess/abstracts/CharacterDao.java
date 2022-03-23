package databaseweb.saka.dataAccess.abstracts;

import databaseweb.saka.entities.concretes.Character;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacterDao extends JpaRepository<Character, Integer> {

    Character getByCharacterName(String characterName);

    //@Query(value = "select account_name as account_name, cast(count(*) as INTEGER) from _characters where character_level < 29  group by account_name", nativeQuery = true)

}
