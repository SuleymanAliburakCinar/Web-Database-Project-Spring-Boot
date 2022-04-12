package databaseweb.saka.business.concretes;

import databaseweb.saka.business.abstracts.SystemSettingService;
import databaseweb.saka.core.utilities.results.DataResult;
import databaseweb.saka.core.utilities.results.SuccessDataResult;
import databaseweb.saka.dataAccess.abstracts.SystemSettingDao;
import databaseweb.saka.entities.concretes.SystemSetting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SystemSettingManager implements SystemSettingService {

    private SystemSettingDao systemSettingDao;

    @Autowired
    public SystemSettingManager(SystemSettingDao systemSettingDao) {
        this.systemSettingDao = systemSettingDao;
    }

    @Override
    public DataResult<String> getByKey(String key) {
        SystemSetting systemSetting = this.systemSettingDao.getByKey(key);
        return new SuccessDataResult<String>(systemSetting.getValue(), "System Setting value");
    }
}
