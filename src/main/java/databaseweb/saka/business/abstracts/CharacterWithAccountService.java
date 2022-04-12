package databaseweb.saka.business.abstracts;

import databaseweb.saka.core.utilities.results.DataResult;
import databaseweb.saka.entities.concretes.CharacterWithAccount;

import java.util.List;

public interface CharacterWithAccountService {

    DataResult<List<CharacterWithAccount>> getAll();

    DataResult<List<Integer>> getLevelInfo();

}
