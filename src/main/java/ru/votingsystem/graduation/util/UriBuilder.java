package ru.votingsystem.graduation.util;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ru.votingsystem.graduation.model.AbstractBaseEntity;

import java.net.URI;

public class UriBuilder {
    private UriBuilder() {
    }

    public static URI buildUriEntity(String restUrl, AbstractBaseEntity entity) {
        return ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(restUrl + "/{id}")
                .buildAndExpand(entity.getId()).toUri();
    }
}
