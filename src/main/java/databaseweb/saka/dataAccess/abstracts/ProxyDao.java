package databaseweb.saka.dataAccess.abstracts;

import databaseweb.saka.entities.concretes.Proxy;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProxyDao extends JpaRepository<Proxy, Integer> {

   List<Proxy> findByProxyIpNotIn(List<String> activeProxyList);

}
