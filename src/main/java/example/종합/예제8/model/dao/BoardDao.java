package example.종합.예제8.model.dao;

import example.종합.예제8.model.dto.BoardDto;

import java.sql.*;
import java.util.ArrayList;

public class BoardDao {
    private BoardDao(){connect();};
    private static final BoardDao instance = new BoardDao();
    public  static BoardDao getInstance(){return instance;}


    //데이터베이스 연동
    private String url = "jdbc:mysql://localhost:3306/boardservice7";
    private String user = "root"; private String password = "1234";
    // 연동 인터페이스 선언
    private Connection conn;
    // 연동 함수 선언
    private void connect(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver"); // mysql라이브러리 객체 메모리 할당
            conn = DriverManager.getConnection(url , user , password); // 구현체
        }catch (Exception e){
            System.out.println("DB연동 실패");
        }
    }
    //게시물 등록
    public boolean write(String bcontent , String bwriter){
        try{
            // 1) SQL 작성한다. 저장-> C-> INSERT , ? 와일드카드 기호로 변수값이 들어갈 자리 뜻한다
            String sql = "insert into board(bcontent , bwriter) values(? , ?)";
            // 2) 연동된 인터페이스에 SQL기재한다 반환 preparedStatement
            PreparedStatement ps = conn.prepareStatement(sql);
            // 3) SQL이 기재된(ps) 인터페이스에 매개변수 대입
            ps.setString(1 , bcontent); // ps.set타입명(?순서번호 ,값)
            ps.setString(2, bwriter);//2번 ?에 bwriter대입한다
            //4) 매개변수까지 대입하여 준비가 끝났으면 SQL 실행
            int count = ps.executeUpdate();
            //5) 결과 제어
            if(count == 1){return true;}
            else{return false;}
        }catch (SQLException e){System.out.println("시스팀오류 SQL" + e);}
        return false;
    }
    //게시물 삭제
    public boolean delete(int bno){
        try{
            // 1) SQL을 작성한다 , ?는 매개변수
            String sql = "delete from board where bno = ?";
            // sql에 기재한다
            PreparedStatement ps = conn.prepareStatement(sql);
            // 인터페이스에 매개변수 대입
            ps.setInt(1 , bno);
            // SQL 실행
            int count = ps.executeUpdate();
            // 결과 제어
            if(count ==1){return true;}
            else{return false;}
        }catch (SQLException e){System.out.println("sql 문제 발생");}
        return false;
    }

    //게시물 수정
    public boolean update(int bno , String bcontent){
        try{
            //sql 작성
            String sql = "update board set bcontent = ? where bno = ?";
            // sql 기재
            PreparedStatement ps = conn.prepareStatement(sql);
            // 인터페이스에 매개변수 대입
            ps.setString(1 , bcontent);
            ps.setInt(2, bno);
            //SQL 실행
            int count = ps.executeUpdate();
            //결과제어
            if(count ==1){return true;}
            else{return false;}
        }catch (SQLException e){System.out.println("sql 문제 발생");}
        return false;
    }

    //게시물 출력
    public ArrayList<BoardDto> findAll() {
        ArrayList<BoardDto> boards = new ArrayList<>(); // 조회 결과 레코드를 저장할 리스트 선언
        try {
            //sql 작성
            String sql = "select * from board";
            //sql 기재
            PreparedStatement ps = conn.prepareStatement(sql);
            // 매개변수 대입 생략
            //sql실행
            ResultSet rs = ps.executeQuery(); //조회 결과 테이블 제어
            while (rs.next()) {
                //rs.get타입명(속성명) // 현재 레코드의 속성값 호출
                int bno = rs.getInt("bno");
                String bcontent = rs.getString("bcontent");
                String bwriter = rs.getString("bwriter");
                String bdate = rs.getString("bdate");
                //객체 만들기
                BoardDto boardDto = new BoardDto(bno, bcontent, bwriter, bdate);
                //리스트 저장
                boards.add(boardDto);
                //asdasd
            }


        } catch (SQLException e) {
            System.out.println("sql 문제 발생");
        }
        return boards;
    }
}
