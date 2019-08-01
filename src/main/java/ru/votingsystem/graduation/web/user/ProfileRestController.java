package ru.votingsystem.graduation.web.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.votingsystem.graduation.model.User;
import ru.votingsystem.graduation.service.UserService;
import ru.votingsystem.graduation.util.SecurityUtil;
import ru.votingsystem.graduation.util.ValidationUtil;


@RestController
@RequestMapping(ProfileRestController.REST_URL)
public class ProfileRestController {
    static final String REST_URL = "/rest/profile";

    protected final Logger log = LoggerFactory.getLogger(getClass());

    private UserService userService;

    public ProfileRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public User get() {
        log.info("get {}", SecurityUtil.authUserId());
        return userService.get(SecurityUtil.authUserId());
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete() {
        log.info("delete {}", SecurityUtil.authUserId());
        userService.delete(SecurityUtil.authUserId());
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@RequestBody User user) {
        log.info("update {} with id={}", user, SecurityUtil.authUserId());
        ValidationUtil.assureIdConsistent(user, SecurityUtil.authUserId());
        userService.update(user);
    }
}
