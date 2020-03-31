package com.example.demo.test.util;

import org.slf4j.LoggerFactory;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class RegisterRequest {
    @SuppressWarnings("unused")
    private static final org.slf4j.Logger log = LoggerFactory.getLogger(RegisterRequest.class);

    @NotNull(message = "手机号不能为空")
    @Pattern(regexp = "^1(3|4|5|6|7|8|9)\\d{9}$")
    private String mobile;

    @NotNull(message = "昵称不能为空")
    @Size(min = 1, max = 20, message = "昵称为1~20位")
    private String nikeName;

    @NotNull(message = "密码不能为空")
    @Size(min = 1, max = 6, message = "密码为1~6位")
    private String password;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getNikeName() {
        return nikeName;
    }

    public void setNikeName(String nikeName) {
        this.nikeName = nikeName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
