package com.ll.medium.global.rsData.RsData;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@Getter
public class RsData<T> {
    String resultCode;
    String msg;
    int statusCode;
    T data;

    public static <T> RsData<T> of(String resultCode, String msg) {
        return of(resultCode, msg, null);
    }

    public static <T> RsData<T> of(String resultCode, String msg, T data) {
        int statusCode = Integer.parseInt(resultCode.split("-", 1)[0]);
        return new RsData<>(resultCode, msg,statusCode, data);
    }

    public boolean isFail() {
        return !isSuccess();
    }

    private boolean isSuccess() {
        return getStatusCode() >=200 && getStatusCode() < 400;
    }


}
