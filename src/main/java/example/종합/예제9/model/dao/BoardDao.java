package example.종합.예제9.model.dao;


import example.종합.예제9.model.dto.BoardDto;
import org.springframework.stereotype.Component;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

@Component
public class BoardDao {
    public BoardDao(){connect();}
    //데이터베이스 연동
    private String url = "jdbc:mysql://localhost:3306/boardservice9";
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

    public List<BoardDto> findAll(){
        List<BoardDto> list = new ArrayList<>();
        try{
            String sql = "select*from board";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.executeQuery();
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                BoardDto boardDto = new BoardDto
                        (rs.getInt("bno") , rs.getString("bcontent"),
                         rs.getString("bwriter") , rs.getString("bdate"));
                list.add(boardDto);
            }
        }catch(Exception e){System.out.println(e);}
        return list;
    }

    public boolean write(BoardDto boardDto){
        try{
            String sql = "insert into board(bcontent,bwriter) values(?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, boardDto.getBcontent());
            ps.setString(2, boardDto.getBwriter());
            int count = ps.executeUpdate();
            if(count == 1){return true;}
        }catch (SQLException e){System.out.println(e);}
        return false;
    }

    public boolean update( BoardDto boardDto ){
        try{
            String sql = "update board set bcontent = ? where bno = ?";
            PreparedStatement ps = conn.prepareStatement( sql );
            ps.setString( 1 , boardDto.getBcontent() );
            ps.setInt( 2 , boardDto.getBno() );
            int count = ps.executeUpdate();
            if( count == 1 ) return true;
        } catch (Exception e) {System.out.println(e);}
        return false;
    }

    public boolean delete(int bno){
        try{
            String sql = "delete from board where bno=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1 , bno);
            int count = ps.executeUpdate();
            if(count ==1){return true;}
        }catch (Exception e){System.out.println(e);}
        return false;
    }



}//class e
