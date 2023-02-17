package com.ebrain.freeBoard.vo;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class CategoryVo {
    private int categoryNo; // 카테고리번호
    private String name;    // 카테고리이름
}
