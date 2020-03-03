package pers.li.common.slf4j;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@Slf4j
public class Slf4jTest {

    /**
     * 测试注解日志,当配置文件application.properties中
     * logging.level.root=error,则只会打印error的日志
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
