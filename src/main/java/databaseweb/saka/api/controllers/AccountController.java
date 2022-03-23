package databaseweb.saka.api.controllers;

import databaseweb.saka.business.abstracts.AccountService;
import databaseweb.saka.core.utilities.results.DataResult;
import databaseweb.saka.core.utilities.results.Result;
import databaseweb.saka.entities.concretes.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")
@CrossOrigin
public class AccountController {

    private AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/getAllAccounts")
    private DataResult<List<Account>> getAll(){
        return this.accountService.getAll();
    }

    @GetMapping("/getByAccountName")
    private DataResult<Account> getByAccountName(@RequestParam String accountName){
        return this.accountService.getByAccountName(accountName);
    }

    @GetMapping("/updateAccounts")
    private Result updateAccounts(){
        return this.accountService.updateAccountCharacterCounter();
    }

}
