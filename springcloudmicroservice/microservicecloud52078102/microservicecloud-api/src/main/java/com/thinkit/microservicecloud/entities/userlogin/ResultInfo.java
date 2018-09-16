package com.thinkit.microservicecloud.entities.userlogin;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data

public class ResultInfo {
    private  String code;
    private  String login;
    private  String msg;
    private  String result;


    public  ResultInfo(){
        this.code="";
        this.login="";
        this.msg="";
        this.result="";
    }
    @Override
    public String toString() {
        return "ResultInfo{" +
                "code='" + code + '\'' +
                ", login='" + login + '\'' +
                ", msg='" + msg + '\'' +
                ", result='" + result + '\'' +
                '}';
    }
}
