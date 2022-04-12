package databaseweb.saka.dataAccess.abstracts;

import databaseweb.saka.core.utilities.results.DataResult;
import databaseweb.saka.entities.concretes.SystemSetting;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.xml.crypto.Data;

public interface SystemSettingDao extends JpaRepository<SystemSetting, Integer> {
    SystemSetting getByKey(String key);
}
