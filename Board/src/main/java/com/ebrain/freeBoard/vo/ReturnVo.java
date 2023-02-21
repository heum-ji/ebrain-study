package com.ebrain.freeBoard.vo;

import common.Pagination;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 비즈니스 처리 후 Return Vo
 *
 * @param <T>
 */
@Getter
@Setter
public class ReturnVo<T> {
    /**
     * 조회된 단건
     */
    private T vo;

    /**
     * 조회된 목록
     */
    private List<T> list;

    /**
     * 이동할 페이지 이름
     */
    private String pageName;

    /**
     * 하단 페이징 처리용 객체
     */
    private Pagination pagination;

    /**
     * Redirect 여부
     * Y : Redirect, N : Forward
     */
    private String redirectYn;

    private int totalCnt;
}
