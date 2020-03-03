package pers.li.common.slf4j;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
public class Slf4jTest {

    public static void main(String[] args) {
        log.info(Arrays.toString(args));
        log.debug(Arrays.toString(args));
        log.error(Arrays.toString(args));
    }

}
