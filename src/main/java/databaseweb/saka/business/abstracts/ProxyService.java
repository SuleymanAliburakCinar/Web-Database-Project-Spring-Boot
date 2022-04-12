package databaseweb.saka.business.abstracts;

import databaseweb.saka.core.utilities.results.Result;
import databaseweb.saka.entities.concretes.Proxy;

import java.util.List;

public interface ProxyService {

    Result updateProxyList();

    Proxy getFreeProxy(List<String> proxyList);

}
