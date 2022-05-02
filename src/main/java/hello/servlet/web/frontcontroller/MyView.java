package hello.servlet.web.frontcontroller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class MyView {
private String viewPath;

    public MyView(String viewPath) {
        this.viewPath = viewPath;
    }

//        String viewPath = "/WEB-INF/views/save-result.jsp";
//        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
//        dispatcher.forward(request, response);
    public void render(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//내일하자
       // String viewPath = "/WEB-INF/views/save-result.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
        dispatcher.forward(request, response);
    }

    public void render(Map<String, Object> model, HttpServletRequest request,
                       HttpServletResponse response) throws ServletException, IOException {
        modelToRequestAttribute(model, request);
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
        dispatcher.forward(request, response);
    }

//    public void render(Map<String, Object> model, HttpServletRequest request,/////////테스트용생성
//                       HttpServletResponse response, int t) throws ServletException, IOException {
//        System.out.print("테스트코드 : "+t);
//        modelToRequestAttribute(model, request);
//        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
//        dispatcher.forward(request, response);
//    }

    private void modelToRequestAttribute(Map<String, Object> model,
                                         HttpServletRequest request) {
        model.forEach((key, value) -> request.setAttribute(key, value));
    }

}
