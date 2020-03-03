package pers.li.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@SpringBootApplication
@RestController
@RequestMapping("/test")
@Slf4j
public class CommonApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommonApplication.class, args);
    }


    /**
     * 测试注解日志
     * @return
     */
    @GetMapping("/q")
    public String get(){
        log.info("12");
        log.debug("12");
        log.error("12");
        return "1";
    }
}
