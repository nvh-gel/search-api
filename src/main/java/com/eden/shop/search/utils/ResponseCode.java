package com.eden.shop.search.utils;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PACKAGE)
public enum ResponseCode {

    SUCCESS("10200", "response.message.success"),
    ACCEPTED("10202", "response.message.accepted"),
    BAD_REQUEST("10400", "response.message.bad_request"),
    UNAUTHORIZED("10401", "response.message.unauthorized"),
    NOT_FOUND("10404", "response.message.not_found"),
    INTERNAL_SERVER_ERROR("10500", "response.message.internal_server_error");

    private final String code;
    private final String message;
}
