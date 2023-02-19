package com.ebrain.freeBoard.Controller;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@WebServlet("*.do")
public class BoardController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.debug("doGet Start!!");

        selectService(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.debug("doPost Start!!");

        selectService(request, response);
    }

    /**
     * RequestURI에서 command 판단하여, 해당 서비스 호출
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void selectService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.debug("selectService Start!!");

        String requestURI = request.getRequestURI(); // 프로젝트 + 파일 Path
        String contextPath = request.getContextPath(); // 프로젝트 Path
        String command = requestURI.substring(contextPath.length()); // 파일 Path

        log.debug("command :: {}", command);

        switch (command) {
            case "/insert.do":
                //TODO insert 서비스 호출
                break;
            case "/select.do":
                //TODO select 서비스 호출
                break;
            case "/update.do":
                //TODO update 서비스 호출
                break;
            case "/delete.do":
                //TODO delete 서비스 호출
                break;
        }
    }
}
