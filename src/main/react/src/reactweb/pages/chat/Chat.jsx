import {useEffect, useRef, useState} from "react";
import axios from "axios";
// 6. stomp설치
import{Client} from "@stomp/stompjs";


export default function Chat(props){

    // 7. Client 객체를 저장하는 (레퍼런스)변수 , useRef vs useState
    // useRef = 특정한 상태/값 저장 , 화면 렌더링에 영향을 주지 않는 저장소
    // useRef가 변해도 렌더링은 안된다 , useState는 변하는 렌더링 된다
    // useRef = {current : null} , useRef 객체내 current 속성을 갖는다  , current = 저장된 상태/값
    // 만약에 다른 상태들이 변해서 렌더링 했을 때 채팅 클라이언트는 변화가 없게끔 하기 위해
    const client = useRef(null);

    // 13. 서버에게 받은 메시지들을 저장하는 상태변수
    const [messages , setMessages] = useState([]);

    // 4. 로그인 정보 상태변수
    const[loginUser , setLoginUser] = useState(null);

    // 3. 회원정보 불러오기
    const getMyInfo = async ()=>{
        try{
            const response = await axios.get("http://localhost:8080/api/member3/myinfo", {withCredentials:true})
            const data = response.data;
            setLoginUser(data || null); // 단축평가 : 조건&&참 , 조간||거짓
            console.log(data);
        }catch (e){console.log(e)}
    }

    // 5. 해당 컴포넌트 생명주기
    useEffect(()=>{
        getMyInfo();

        // 8. 웹소켓 연결하기
        const stomp = new Client({
            brokerURL : "ws://localhost:8080/ws", // 엔드포인트로 설정한 주소
            reconnectDelay : 5000 , //연동 실패시 5초마다 재연동
            onConnect : ()=>{ // 연결 성공시 실행할 로직
                console.log("소켓 연결 성공")
                // 12. 메시지 구독 서버->클라이언트
                stomp.subscribe("/topic/message" , (msg)=>{
                    console.log(msg);
                    // 서버에 받은 메시지를 json으로 변환
                    const data = JSON.parse(msg.body);
                    // 서버에 받은 메시지를 상태변수에 대입
                    messages.push(data)
                    setMessages([...messages]) // 얇은 비교

                })
            }
        });

        // 9. 웹소켓 실행
        stomp.activate();
        // 10. 웹소켓을 안전하게 useRef에 보관
        client.current=stomp;

        // 11. 컴포넌트 언마운트 될때 , 컴포넌트 생명주기(마운트=탄생/업데이트=인생/언마운트=죽음)
        return ()=>{
            // 언마운트 실행문
            stomp.deactivate(); // 소켓 닫기
        }

    }, [])



    // 2. 입력받은 값을 저장하는 상태변수
    const[sendMsg , setSendMsg] = useState("");

    // 1. 전송 버튼 클릭시 입력받은 값 가져오기 = 서버에게 채팅 메세지 보내기
    const sendMessage = () =>{
        console.log(sendMsg);// 1. 입력받은 값 확인
        if(sendMsg==''){
            alert('메시지 입력하세요'); return;
        }

        // 14. 서버에 보낼 메시지 구성
        const obj = {sender : loginUser.mname , message : sendMsg}

        // 13. 연동된 소켓에 메시지 보내기 , useRef의 상태값 호출 , .current
        // stomp.publish({})
        client.current.publish({
            destination : "/app/chat", // 메시지를 받을 서버의 주소 , @MessageMapping 주소
            body : JSON.stringify(obj) // 보낼 메시지를 json형식의 문자열 타입 ,
        })


        setSendMsg(''); //메시지 전송 후 입력상자 , 초기화

    }

    return(<>
        <div>
            <h3> 채팅 </h3>
            <div className="contents" style={ {width : "300px"}}>

                {/* 받은 메시지들이 저장된 messages 출력하기 */}
                {
                    messages.map( ( msg ) => {
                        return (
                            <div className="msgbox">
                                { /* 삼항연산자 이용한 html 분기 */}
                                { loginUser && loginUser.mname == msg.sender ?
                                    (<>
                                        <div className="msg" style={ { textAlign : "right" }}> { msg.message } </div>
                                    </>) :
                                    (<>
                                        <div className="sender"> { msg.sender } </div>
                                        <div className="msg"> { msg.message } </div>
                                    </>)
                                }
                            </div>
                        )
                    })
                }
            </div>

            {/* 입력상자내 value 속성에 상태변수 대입시 입력 가능(렌더링 안 된 상태) = 상태변수는 렌더링 해야한다*/}
            <input value={sendMsg} onChange={(e)=> {setSendMsg(e.target.value)}}/>
            <button onClick={sendMessage}>전송</button>
        </div>
    </>)
}