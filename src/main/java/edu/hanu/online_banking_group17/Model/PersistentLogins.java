package edu.hanu.online_banking_group17.Model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Entity
@Table(name = "Persistent_Logins")
public class PersistentLogins {

    @Id
    @Column(name = "series")
    private String series;

    @Column(name = "username")
    private String username;

    @Column(name = "token")
    private String token;

    @Column(name = "last_used")
    private Date lastUsed;
}
