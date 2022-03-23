package databaseweb.saka.dataAccess.abstracts;

import databaseweb.saka.entities.concretes.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountDao extends JpaRepository<Account, String> {

    Account getByAccountName(String accountName);

}
