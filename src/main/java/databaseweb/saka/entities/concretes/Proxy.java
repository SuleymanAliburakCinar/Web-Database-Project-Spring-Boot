package databaseweb.saka.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "proxies")
public class Proxy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "proxy_ip")
    private String proxyIp;

    @Column(name = "proxy_port")
    private String proxyPort;

    @Column(name = "proxy_user")
    private String proxyUser;

    @Column(name = "proxy_pass")
    private String proxyPass;

    @Column(name = "is_using")
    private Boolean isUsing;


}
