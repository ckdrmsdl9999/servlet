package hello.servlet.basic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name="helloServlet", urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {
    //ctrl + b 단축키 --httpservlet선언된곳이동
    //정리:서블릿 http요청이오면 was(서블릿 컨테이너)가 리퀘스트 리스판스 객체를 만들어서 이 서블릿에 던져줌
    //localhost:8080/hello 입력시 웹브라우저가 http요청메세지만들어서 서버에 던짐 521
    //ctrl+o
//서블릿이 호출되면 이 서비스 메소드가 호출이됨


    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            System.out.println("HelloServlet.service");
            System.out.println("req = " + request);
            System.out.println("res = " + response);

       String username=request.getParameter("username");
        System.out.println("username = " + username);

        response.setContentType("text/plain");        //단순문자로보내고 문자셋트인코딩정보알려주기-헤더정보
      response.setCharacterEncoding("utf-8");
        response.getWriter().write("hello "+username);//http messagebody 에들어감-
//        System.out.println("res2 = " + response);
        //f12에서 보면됨
        //!!!!!!!!!!!!!!!!!!      kim 이 인코딩안되서보이는듯?
        }
    }
