package databaseweb.saka.business.abstracts;

import databaseweb.saka.core.utilities.results.DataResult;
import databaseweb.saka.core.utilities.results.Result;
import databaseweb.saka.entities.concretes.Character;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface CharacterService {

    DataResult<List<Character>> getAll();

    DataResult<List<Character>> getAllSortedLevelASC();

    DataResult<List<Character>> getAllSortedLevelDESC();

    DataResult<List<Character>> getAllSortedLastLoginDESC();

    DataResult<List<Character>> getAllSortedDeleteDateDESC();

    DataResult<List<Character>> getAll(Sort sort);

    DataResult<Character> getByCharacterName(String characterName);



    Result add(Character character);

}
