package ru.votingsystem.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users", uniqueConstraints = {@UniqueConstraint(columnNames = "email", name = "users_unique_email_idx")})
public class User extends AbstractBaseEntity {

    @NotBlank
    @Column(name = "email", nullable = false, unique = true)
    @Email
    @Size(max = 120)
    private String email;

    @Column(name = "password", nullable = false)
    @NotBlank
    @Size(min = 6, max = 120)
    private String password;

    @Column(name = "enabled", nullable = false, columnDefinition = "bool default true")
    private boolean enabled = true;

    @OneToMany
    @OrderBy("dateVote desc")
    private List<Vote> votes;

    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "role")
    @ElementCollection(fetch = FetchType.EAGER)
    private Set<Role> roles;

    public User() {
    }

    public User(@NotBlank @Email @Size(max = 120) String email, @NotBlank @Size(min = 6, max = 120) String password, boolean enabled) {
        this.email = email;
        this.password = password;
        this.enabled = enabled;
    }

    public User(@NotBlank @Email @Size(max = 120) String email, @NotBlank @Size(min = 6, max = 120) String password) {
        this.email = email;
        this.password = password;
    }

    public User(@NotBlank @Email @Size(max = 120) String email, @NotBlank @Size(min = 6, max = 120) String password, boolean enabled, List<Vote> votes, Set<Role> roles) {
        this.email = email;
        this.password = password;
        this.enabled = enabled;
        this.votes = votes;
        this.roles = roles;
    }

    public User(@NotBlank @Email @Size(max = 120) String email, @NotBlank @Size(min = 6, max = 120) String password, List<Vote> votes, Set<Role> roles) {
        this.email = email;
        this.password = password;
        this.votes = votes;
        this.roles = roles;
    }

    public User(Integer id, @NotBlank @Email @Size(max = 120) String email, @NotBlank @Size(min = 6, max = 120) String password, boolean enabled, List<Vote> votes, Set<Role> roles) {
        super(id);
        this.email = email;
        this.password = password;
        this.enabled = enabled;
        this.votes = votes;
        this.roles = roles;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Vote> getVotes() {
        return votes;
    }

    public void setVotes(List<Vote> votes) {
        this.votes = votes;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
