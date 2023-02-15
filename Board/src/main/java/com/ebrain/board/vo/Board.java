package com.ebrain.board.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.mariadb.jdbc.util.log.Slf4JLogger;

@Getter
@Setter
@Slf4j
public class Board {
    private String id;
    private String name;

    public void testMsg() {
        log.debug("디버그 테스트중...!!!");
        log.info("인포 테스트중...!!!");
        log.error("에러 테스트중...!!!");
    }

}
