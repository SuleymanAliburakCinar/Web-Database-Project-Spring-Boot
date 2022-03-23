package databaseweb.saka.api.controllers;


import databaseweb.saka.business.abstracts.CharacterService;
import databaseweb.saka.core.utilities.results.DataResult;
import databaseweb.saka.core.utilities.results.Result;
import databaseweb.saka.entities.concretes.Character;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/characters")
@CrossOrigin
public class CharactersController {

    private CharacterService characterService;

    @Autowired
    public CharactersController(CharacterService characterService) {
        this.characterService = characterService;
    }

    @GetMapping("/getAll")
    public DataResult<List<Character>> getAll(){
        return this.characterService.getAll();
    }

    @GetMapping("/getByCharacterName")
    public DataResult<Character> getByCharacterName(@RequestParam String characterName){
        return this.characterService.getByCharacterName(characterName);
    }

    @GetMapping("/getAllSortedLevelAsc")
    public DataResult<List<Character>> getAllSortedLevelAsc(){
        return this.characterService.getAllSortedLevelASC();
    }

    @GetMapping("/getAllSortedLevelDesc")
    public DataResult<List<Character>> getAllSortedLevelDesc(){
        return this.characterService.getAllSortedLevelDESC();
    }

    @GetMapping("/getAllSorted")
    public DataResult<List<Character>> getAllSorted(Sort sort){
        return this.characterService.getAll(sort);
    }

    @PostMapping("/add")
    public Result add(@RequestBody Character character){
        return this.characterService.add(character);
    }


}
