package ru.votingsystem.util;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ru.votingsystem.model.AbstractBaseEntity;

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
