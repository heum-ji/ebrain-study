package com.ebrain.freeBoard.Controller;

import com.ebrain.freeBoard.service.BoardListService;
import com.ebrain.freeBoard.service.BoardViewService;
import com.ebrain.freeBoard.service.IService;
import com.ebrain.freeBoard.vo.BoardVo;
import com.ebrain.freeBoard.vo.ReturnVo;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

/**
 * 모든 요청을 우선 처리하는 FrontController
 * 각 요청에 해당하는 서비스를 호출함
 */
@Slf4j
@WebServlet(name = "FrontController", urlPatterns = "/boards/*")
public class FrontController extends HttpServlet {
    /**
     * 각 요청에 해당하는 서비스 Map
     * (URL, 해당하는 서비스)
     */
    private Map<String, IService> serviceMap = null;

    public FrontController() {
        serviceMap = new HashMap<>();
        // 요청된 URL을 처리할 서비스 매핑
        serviceMap.put("/boards/free/list", new BoardListService()); // 게시판 목록 조회
        serviceMap.put("/boards/free/view", new BoardViewService()); // 게시판 상세 조회
    }

    /**
     * request 요청에 해당하는 서비스 호출
     * request가 들어오면 Servlet에서 service 메서드가 가장 먼저 실행됨
     *
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 요청 URI 추출
        String requestURI = request.getRequestURI();
        log.debug("requestURI :: {}", requestURI);

        // 요청 url에 해당하는 서비스 조회
        IService service = serviceMap.get(requestURI);

        // 예외 : 요청하지 않은 URL인 경우 메서드 종료
        if (service == null) {
            log.debug("404 :: {} 에 해당하는 페이지가 없습니다.", requestURI);
            return;
        }

        log.debug("선택된 서비스 :: {}", service);

        // 인코딩
        request.setCharacterEncoding("UTF-8");

        // 비즈니스 로직 처리
        ReturnVo<?> returnVo = service.process(request, response);

        // 화면에 전달할 파라미터 Set
        request.setAttribute("vo", returnVo.getVo()); // 단건
        request.setAttribute("list", returnVo.getList()); // 목록
        request.setAttribute("pagination", returnVo.getPagination()); // 하단 페이징 처리
        request.setAttribute("totalCnt", returnVo.getTotalCnt()); // 전체 게시물 수

        // 화면 이동
        if ("Y".equals(returnVo.getRedirectYn())) { // redirect 처리
            response.sendRedirect(getPath(returnVo.getPageName()));
        } else if ("N".equals(returnVo.getRedirectYn())) { // forward 처리
            request.getRequestDispatcher(getPath(returnVo.getPageName())).forward(request, response);
        }

    }

    /**
     * 이동할 화면(JSP) prefix 및 suffix 처리
     *
     * @param path 이동할 화면 경로
     *
     * @return prefix 및 suffix 처리 완료된 화면 Path
     */
    private String getPath(String path) {
        String prefix = "/WEB-INF"; // 접두어
        String suffix = ".jsp"; // 접미어

        return prefix + path + suffix;
    }
}
