package com.sinais.app.domain;

import jakarta.persistence.*;
import java.util.Set;
import java.util.HashSet;

@Entity
@Table(name = "users")
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique=true, nullable=false)
    private String email;

    @Column(nullable=false)
    private String passwordHash;

    private String fullName;

    private boolean enabled = true;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "role")
    private Set<String> roles = new HashSet<>();

    public User(){}

    public User(String email, String passwordHash, String fullName){
        this.email = email;
        this.passwordHash = passwordHash;
        this.fullName = fullName;
        this.roles.add("USER");
    }

    // getters and setters
    public Long getId(){ return id; }
    public String getEmail(){ return email; }
    public void setEmail(String e){ this.email = e; }
    public String getPasswordHash(){ return passwordHash; }
    public void setPasswordHash(String p){ this.passwordHash = p; }
    public String getFullName(){ return fullName; }
    public void setFullName(String n){ this.fullName = n; }
    public boolean isEnabled(){ return enabled; }
    public void setEnabled(boolean e){ this.enabled = e; }
    public Set<String> getRoles(){ return roles; }
    public void setRoles(Set<String> r){ this.roles = r; }
}
