package databaseweb.saka.business.concretes;

import databaseweb.saka.business.abstracts.AccountService;
import databaseweb.saka.core.utilities.results.DataResult;
import databaseweb.saka.core.utilities.results.Result;
import databaseweb.saka.core.utilities.results.SuccessDataResult;
import databaseweb.saka.dataAccess.abstracts.AccountDao;
import databaseweb.saka.entities.concretes.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountManager implements AccountService {

    private AccountDao accountDao;
    private List<Account> accountList;

    @Autowired
    public AccountManager(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public DataResult<List<Account>> getAll() {
        return new SuccessDataResult<List<Account>>(this.accountDao.findAll(), "find all account");
    }

    @Override
    public DataResult<Account> getByAccountName(String accountName) {
        return new SuccessDataResult<Account>(this.accountDao.getByAccountName(accountName));
    }

    @Override
    public Result updateAccountCharacterCounter() {
        List<Account> accountList = this.accountDao.findAll();
        accountList.stream().forEach(account -> {
            long countL = account.getCharacters().stream().filter(character -> character.getCharacterLevel() < 29).count();
            account.setCount((int) countL);
            this.accountDao.save(account);
        });
        return new Result(true, "Character Counter updated");
    }
}
