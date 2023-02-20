package com.ebrain.freeBoard.Controller;

import com.ebrain.freeBoard.service.BoardService;
import com.ebrain.freeBoard.service.IService;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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
        serviceMap.put("/boards/free/writeForm", null); // 게시판 등록폼 이동
        serviceMap.put("/boards/free/write", new BoardService()); // 게시판 등록
        serviceMap.put("/boards/free/view", new BoardService()); // 게시판 상세 보기
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
        // request가 들어오면 Servlet에서 service 메서드가 가장 먼저 실행됨

        // 요청 URI 추출
        String requestURI = request.getRequestURI();
        log.debug("requestURI :: {}", requestURI);

        // 요청 url에 해당하는 서비스 조회
        IService service = serviceMap.get(requestURI);
        log.debug("선택된 서비스 :: {}", service);

        // 단순 page 이동
        switch (requestURI) {
            case "/boards/free/write":
                break;
            case "/boards/free/writeForm":
                request.getRequestDispatcher("/WEB-INF/boards/free/writeForm.jsp").forward(request, response);
                break;
            default: // 예외처리 - 매핑에 없는 URL이 요청됐을 때
                response.setStatus(HttpServletResponse.SC_NOT_FOUND); // 404 에러코드
                break;
        }
    }
}
