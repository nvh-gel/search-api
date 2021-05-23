package com.eden.shop.search.utils;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * ResponseModel
 *
 * @author nvhien
 */
@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ResponseModel {

    private String code;
    private String responseCode;
    private String message;
    private Object data;

    /**
     * Format response data.
     *
     * @param code code str
     * @param responseCode response code str
     * @param message response message str
     * @return response model
     */
    private static ResponseModel formatResponse(String code, String responseCode, String message) {

        return new ResponseModel(code, responseCode, message, null);
    }

    /**
     * Format response data from preset enum.
     *
     * @param responseCode response code enum
     * @return response model
     */
    public static ResponseModel formatResponse(ResponseCode responseCode) {

        return formatResponse(responseCode.getCode(), responseCode.name(), responseCode.getMessage());
    }
}
