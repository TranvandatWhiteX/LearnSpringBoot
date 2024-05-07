package com.dattran.learnspringboot.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum ErrorCode {
    USER_EXISTED(400, "User existed."),
    USER_NOT_FOUND(404, "User not found."),
    UNCATEGORIZED_EXCEPTION(999, "Uncategorized exception.")
    ;
    private int code;
    private String message;

}
