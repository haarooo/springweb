package example.day02.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tools.jackson.core.io.UTF8Writer;

import java.io.IOException;

//서블릿 : 자바 회사에서 HTTP웹 동적처리 하기 위한 라이브러리(클래스)
//사용법
// 1. 현재 클래스 -> HttpServlet 클래스로 부터 상속 받는다
// 2. 현재 클래스 위에 @WebServlet("/URL")
// 3. (스프링화경에만 해당) AppStart 클래스 위에 순수 서블릿 사용 @ServletComponentScan 주입하여 스프링이 서블릿 찾을 수 있도록 한다.
@WebServlet("/day02/servlet") //localhost:8080/day02/servlet 요청시 통신 가능한 클래스 정의 //
                              // 주소 만들기 , 중복없이 영문으로 설정
public class ServletController extends HttpServlet {

    // 순수 자바의 메소드
    boolean method(int param){return true;}

    //1. 서블릿 클래스로부터 HTTP 요청시 init함수 최초 1번 실행된다
    @Override
    public void init() throws ServletException {
        System.out.println("init 함수 실행");
        super.init();
    }

    //2. 서블릿 클래스로부터 HTTP 요청마다 service함수 실행된다
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("service 함수 실행");
        super.service(req, res);
    }

    //3. HTTP 메소드란? GET,POST,PUT,DELETE으로 통신방법
    // 서블릿 객체는 요청이 끝나도 사라지지 않고 다음 요청에 재사용
    // HttpServletRequest(요청정보) HttpServletResponse(응답정보) 객체는 요청이 끝나면 사라진다
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ServletController.doGet"); //현재 메소드 출력
        //HTTP요청시 포함된 매개변수 확인
        String data = req.getParameter("data");
        System.out.println("data = " + data);
        //HTTP요청시 클라이언트 응답
        resp.getWriter().println("Client Response : HELLO!");
    }

    //POST , 브라우저의 주소입력창에 요청은 무조건 GET방식이므로 POST,PUT,DELETE 방식은 talend로 확인
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ServletController.doPost");
        String data = req.getParameter("data");
        System.out.println("data = " + data);
        resp.getWriter().println("Client Response : POST");
    }

    //PUT
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ServletController.doPut");
        String data = req.getParameter("data");
        System.out.println("data = " + data);
        resp.getWriter().println("Client Response : PUT");
    }
    //DELETE

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ServletController.doDelete");
        String data = req.getParameter("data");
        System.out.println("data = " + data);
        resp.getWriter().println("Client Response : DELETE");
    }
    //HTTP란? 클라이언트와 서버간의 통신하는 규칙
    //클라이언트가 1번 요청의 1번 응답 즉 요청이 없으면 응답 불가
    //서블릿 클래스내 동일한 시그니처(선언부) 갖는 메소드는 존재할 수 없다.
    //하나의 서블릿에 doGet()메소드는 1개만 존재할 수 있다. --> 스프링 환경에서 보완 제공
}//class e
