import {Link} from "react-router-dom";
import {useEffect, useState} from "react";
import axios from "axios";

export default function Header(props){

    // 로그인 상태 저장하는 상태변수
    const[login , setLogin] = useState(false);
    // 로그인중인 회원 정보 담는 상태변수
    const[user , setUser] = useState(null)

    // 로그인 상태에 따라 메뉴 분기
    const getMyInfo = async ()=>{
        // 로그인시 localStorage에 저장한 토큰 가져오기 , .setItem , getItem
        const token = localStorage.getItem('token');
        // 만약에 토큰이 없으면 함수 종료
        if(!token){ setLogin(false); return;}
        // 헤더에 표시할 로그인된 유저 아이디 가져오기
        const response = await axios.get("http://localhost:8080/api/member2/myinfo",
            {headers:{Authorization : `Bearer ${token}`}}
        );
        //통신 결과
        const data = response.data;
        if(data == null|| data != false){
            setLogin(true);
            setUser(data); // 응답 받은 자료(회원정보) 저장
        }else{
            setLogin(false); // 비로그인
        }
    }
    // 헤더가 열리면 최초 1번 실행 , 로그인상태(백엔드 검증해야한다)
    useEffect(()=>{
        getMyInfo();
    }, []);
    //Js삼항연산자 , 조건 ? 참 : 거짓
    // js 단축평가 , 조건 && 실행문 , 조건이 참이면 실행문 , 거짓이면 생략



    // 로그아웃
    const logout = async ()=>{
        localStorage.removeItem('token')
        setLogin(false);
        alert('로그아웃');
        location.href="/"
    }






    return(<>
        <div>
            <Link to="/">홈</Link> |
            { login == false && (<>
                <Link to="/member/login">로그인</Link> |
                <Link to="/member/signup">회원가입</Link> |
            </>)}

            { login == true && (<>
                <span> {user.mid}님 </span> |
                <Link to="/member/page">내정보</Link> |
                <Link to="/board/write">글쓰기</Link> |
                <button onClick={logout}>로그아웃</button>
            </>)}
            <hr/>
        </div>
    </>)
}