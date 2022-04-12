package databaseweb.saka.business.abstracts;

import databaseweb.saka.core.utilities.results.DataResult;
import databaseweb.saka.entities.concretes.SystemSetting;

public interface SystemSettingService {
    DataResult<String> getByKey(String key);
}
