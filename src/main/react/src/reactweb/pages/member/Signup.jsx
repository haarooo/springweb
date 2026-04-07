import axios from "axios";

const memberSign = async (e) =>{
    e.preventDefault();
    const mid = e.target.mid.value;
    const mpwd = e.target.mpwd.value;
    const mname = e.target.mname.value;
    const obj = {mid , mpwd , mname}

    const response = await axios.post("http://localhost:8080/api/member/signup" , obj)
    const data = response.data;
    if(data == true){alert('회원가입 성공'); location.href="/member/login"}
    else{alert('회원가입 실패')}
}


export default function Signup(props){
    return(<>
        <h2>회원가입 페이지</h2>
        <form onSubmit={memberSign}>
            아이디 : <input name="mid"/> <br/>
            비밀번호 : <input name="mpwd"/> <br/>
            이름 : <input name="mname"/> <br/>
            <button type="submit">회원가입</button>
        </form>
    </>)
}