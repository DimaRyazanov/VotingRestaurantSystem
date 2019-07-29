package ru.votingsystem.graduation.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "votes", uniqueConstraints = {@UniqueConstraint(columnNames = {"user_id", "menu_id"}, name = "votes_unique_user_menu_idx")})
public class Vote extends AbstractBaseEntity {

    @Column(name = "date_time", nullable = false)
    @NotNull
    private LocalDateTime dateTime;

    @Column(name = "rate", nullable = false)
    @Range(min = 0, max = 5)
    private int rate;

    @ManyToOne
    @JoinColumn(name = "menu_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @NotNull
    private Menu menu;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @NotNull
    private User user;

    public Vote() {
    }

    public Vote(Vote v) {
        this(v.id, v.dateTime, v.rate, v.menu, v.user);
    }

    public Vote(@NotNull LocalDateTime dateTime, @Range(min = 0, max = 5) int rate, @NotNull Menu menu, @NotNull User user) {
        this(null, dateTime, rate, menu, user);
    }

    public Vote(Integer id, @NotNull LocalDateTime dateTime, @Range(min = 0, max = 5) int rate, @NotNull Menu menu, @NotNull User user) {
        super(id);
        this.dateTime = dateTime;
        this.rate = rate;
        this.menu = menu;
        this.user = user;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public int getRate() {
        return rate;
    }

    public Menu getMenu() {
        return menu;
    }

    public User getUser() {
        return user;
    }
}
