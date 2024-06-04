package com.example.demo.beans;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@Component
@ConfigurationProperties(prefix = "datasource")
@Setter
@Getter
public class ConfigProp {

    @Value("${random.long}")
    long url;
    @Value("${random.int}")
    int ddd;
    @Value("${random.uuid}")
    String password;

    public void ConfigPropLog(){
        System.out.println( "url  : " + url + "\n" +
                            "ddd  : " + ddd + "\n" +
                            "password : " + password);
    }
}
