package databaseweb.saka.business.concretes;

import databaseweb.saka.business.abstracts.CharacterWithAccountService;
import databaseweb.saka.core.utilities.results.DataResult;
import databaseweb.saka.core.utilities.results.SuccessDataResult;
import databaseweb.saka.dataAccess.abstracts.CharacterWithAccountDao;
import databaseweb.saka.entities.concretes.CharacterWithAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
