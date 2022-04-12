package databaseweb.saka.business.concretes;

import databaseweb.saka.business.abstracts.ProxyService;
import databaseweb.saka.core.utilities.results.Result;
import databaseweb.saka.core.utilities.results.SuccessResult;
import databaseweb.saka.dataAccess.abstracts.ProxyDao;
import databaseweb.saka.entities.concretes.Proxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.stream.Stream;

@Service
public class ProxyManager implements ProxyService {

    private ProxyDao proxyDao;

    @Autowired
    public ProxyManager(ProxyDao proxyDao) {
        this.proxyDao = proxyDao;
    }

    @Override
    public Result updateProxyList() {
        try {
            FileReader fileReader = new FileReader("src/main/resources/proxies.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            Stream<String> lines = bufferedReader.lines();
            lines.forEach(line -> {
                String[] data = line.split(":");
                this.proxyDao.save(Proxy.builder()
                        .proxyIp(data[0]).proxyPort(data[1]).proxyUser(data[2]).proxyPass(data[3]).isUsing(false).build());
            });
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return new SuccessResult("database güncellendi");
    }

    @Override
    public Proxy getFreeProxy(List<String> proxyList) {
        return this.proxyDao.findByProxyIpNotIn(proxyList).
                stream().findFirst().orElse(null);
    }
}
