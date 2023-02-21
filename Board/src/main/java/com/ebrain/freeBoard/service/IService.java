package com.ebrain.freeBoard.service;

import com.ebrain.freeBoard.vo.BoardVo;
import com.ebrain.freeBoard.vo.ReturnVo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * 서비스 공통 인터페이스
 * <p>
 * 서로 다른 서비스를 하나의 서비스로 생성하기위해 생성
 */
public interface IService {
    /**
     * 비즈니스 로직 처리
     *
     * @param request  HttpServletRequest
     * @param response HttpServletResponse
     *
     * @return 화면에 필요한 정보
     */
    ReturnVo<?> process(HttpServletRequest request, HttpServletResponse response);
}
