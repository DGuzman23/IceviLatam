package com.uca.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(generator = "users_users_id_seq",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "users_users_id_seq", sequenceName = "public.users_users_id_seq", allocationSize = 1)
    @Column(name = "users_id")
    int id;

    @Column(name = "users_username")
    String username;

    @Column(name = "users_password")
    String password;

    @Column(name = "users_name")
    String name;

    @Column(name = "users_last_name")
    String last_name;

    @Column(name = "users_status")
    String status;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "users_id"), inverseJoinColumns = @JoinColumn(name = "roles_id"))
    private Set<Role> roles;

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}