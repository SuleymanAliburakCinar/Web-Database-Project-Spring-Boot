package databaseweb.saka.business.concretes;

import databaseweb.saka.business.abstracts.CharacterWithAccountService;
import databaseweb.saka.core.utilities.results.DataResult;
import databaseweb.saka.core.utilities.results.SuccessDataResult;
import databaseweb.saka.dataAccess.abstracts.CharacterWithAccountDao;
import databaseweb.saka.entities.concretes.CharacterWithAccount;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class CharacterWithAccountManager implements CharacterWithAccountService {

    private CharacterWithAccountDao characterWithAccountDao;

    @Autowired
    public CharacterWithAccountManager(CharacterWithAccountDao characterWithAccountDao) {
        this.characterWithAccountDao = characterWithAccountDao;
    }

    @Override
    public DataResult<List<CharacterWithAccount>> getAll() {
        return new SuccessDataResult<List<CharacterWithAccount>>(this.characterWithAccountDao.findAll(),"Character with account find all");
    }

    @Override
    public DataResult<List<Integer>> getLevelInfo() {
        List<CharacterWithAccount> characterList = this.characterWithAccountDao.findAll();
        int first = 0, last = 0;
        for(CharacterWithAccount character : characterList){
            if(character.getCharacterLevel() < 29) first++;
            else if(character.getCharacterLevel() == 29) last++;
        }
        List<Integer> result = new ArrayList<>();
        result.add(first);
        result.add(last);
        return  new SuccessDataResult<List<Integer>>(result, "character level data");
    }

}
