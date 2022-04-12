package databaseweb.saka.business.abstracts;

import databaseweb.saka.core.utilities.results.DataResult;
import databaseweb.saka.core.utilities.results.Result;
import databaseweb.saka.entities.concretes.Account;

import java.util.List;

public interface AccountService {

    DataResult<List<Account>> getAll();

    DataResult<Account> getByAccountName(String accountName);

    DataResult<List<Account>> getAllSorted();

    Result updateAccountCharacterCounter();


}
