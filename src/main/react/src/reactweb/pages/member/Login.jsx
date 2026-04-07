import axios from "axios";

export default function Login(props){

    // 1. RestApi에게 Axios로 통신
    const login = async (e)=>{
        e.preventDefault();
        let mid = e.target.mid.value;
        let mpwd = e.target.mpwd.value;
        const obj = {mid , mpwd}

        const response = await axios.post("http://localhost:8080/api/member3/login" ,
            obj , {withCredentials : true} // 통신할 서버에게 쿠키값 통신
        );
        // let token = response.headers['authorization']

        //if(token&&token.startsWith("Bearer ")){
        //   token = token.substring(7); // 문자열내 7번째부터 자른 값 대입
        //}
        if(response.data == true){
            //localStorage.setItem("token" , token);
            alert("로그인 성공"); location.href="/";} // 네비게이트 대신 location 사용
        else{alert("로그인 실패")}
    }




    return(<>
        <div>
            <h3> 로그인 페이지</h3>
            <form onSubmit={login}>
                아이디 : <input name="mid"/><br/>
                비밀번호 : <input name="mpwd"/> <br/>
                <button type="submit"> 로그인 </button>
            </form>
        </div>
    </>)
}