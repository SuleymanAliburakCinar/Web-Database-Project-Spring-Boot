package databaseweb.saka.business.concretes;

import databaseweb.saka.business.abstracts.CharacterService;
import databaseweb.saka.core.utilities.results.DataResult;
import databaseweb.saka.core.utilities.results.Result;
import databaseweb.saka.core.utilities.results.SuccessDataResult;
import databaseweb.saka.core.utilities.results.SuccessResult;
import databaseweb.saka.dataAccess.abstracts.CharacterDao;
import databaseweb.saka.entities.concretes.Character;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CharacterManager implements CharacterService {

    private CharacterDao characterDao;

    @Autowired
    public CharacterManager(CharacterDao characterDao) {
        this.characterDao = characterDao;
    }


    @Override
    public DataResult<List<Character>> getAll() {
        return new SuccessDataResult<List<Character>>(this.characterDao.findAll(), "findAll");
    }

    @Override
    public DataResult<List<Character>> getAllSortedLevelASC() {
        Sort sort = Sort.by(Sort.Direction.ASC, "characterLevel");
        return new SuccessDataResult<List<Character>>(this.characterDao.findAll(sort), "Levele göre artan sıra ile");
    }

    @Override
    public DataResult<List<Character>> getAllSortedLevelDESC() {
        Sort sort = Sort.by(Sort.Direction.DESC, "characterLevel");
        return new SuccessDataResult<List<Character>>(this.characterDao.findAll(sort), "Levele göre azalan sıra ile");
    }

    @Override
    public DataResult<List<Character>> getAllSortedLastLoginDESC() {
        Sort sort = Sort.by(Sort.Direction.ASC, "deleteDate");
        return new SuccessDataResult<List<Character>>(this.characterDao.findAll(sort), "Delete Date artan");
    }

    @Override
    public DataResult<List<Character>> getAllSortedDeleteDateDESC() {
        Sort sort = Sort.by(Sort.Direction.ASC, "lastLoginDate");
        return new SuccessDataResult<List<Character>>(this.characterDao.findAll(sort), "Last Login artan");
    }

    @Override
    public DataResult<List<Character>> getAll(Sort sort) {
        return new SuccessDataResult<List<Character>>(this.characterDao.findAll(sort), "findAll");
    }

    @Override
    public DataResult<Character> getByCharacterName(String characterName) {
        return new SuccessDataResult<Character>(this.characterDao.getByCharacterName(characterName), "get by character name");
    }

    @Override
    public Result add(Character character) {
        this.characterDao.save(character);
        return new SuccessResult("Character eklendi");
    }
}
