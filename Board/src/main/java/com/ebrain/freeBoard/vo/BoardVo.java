package com.ebrain.freeBoard.vo;

import lombok.*;

import java.sql.Timestamp;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BoardVo {
    private int boardNo;
    private int categoryNo;
    private String categoryName;
    private String writer;
    private String password;
    private String title;
    private String content;
    private int viewCount;
    private String registerDate;
    private String modifyDate;
    private int totalCnt;
}
