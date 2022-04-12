package databaseweb.saka.api.controllers;

import databaseweb.saka.business.abstracts.SystemSettingService;
import databaseweb.saka.core.utilities.results.DataResult;
import databaseweb.saka.entities.concretes.SystemSetting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/systemSetting")
@CrossOrigin
public class SystemSettingController {

    private SystemSettingService systemSettingService;

    @Autowired
    public SystemSettingController(SystemSettingService systemSettingService) {
        this.systemSettingService = systemSettingService;
    }

    @GetMapping("/getByKey")
    public DataResult<String> getByKey(@RequestParam String key){
        return this.systemSettingService.getByKey(key);
    }
}
