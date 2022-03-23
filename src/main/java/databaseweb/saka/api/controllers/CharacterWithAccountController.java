package databaseweb.saka.api.controllers;

import databaseweb.saka.business.abstracts.CharacterWithAccountService;
import databaseweb.saka.core.utilities.results.DataResult;
import databaseweb.saka.entities.concretes.Character;
import databaseweb.saka.entities.concretes.CharacterWithAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/char")
@CrossOrigin
public class CharacterWithAccountController {

    private CharacterWithAccountService characterWithAccountService;

    @Autowired
    public CharacterWithAccountController(CharacterWithAccountService characterWithAccountService) {
        this.characterWithAccountService = characterWithAccountService;
    }

    @GetMapping("/getAll")
    public DataResult<List<CharacterWithAccount>> getAll(){
        return this.characterWithAccountService.getAll();
    }

}
