console.log("task.js exe")

// [1] 타입 : js는 동적타입이므로
    //1. 기본자료
console.log(3);console.log(true); console.log(3.14); console.log("안녕")
    //2. 배열
console.log([3,true,3.14,"안녕"])
    //3. 객체 json
console.log({"name" : "유재석" , "age": 40})
    //4. 함수
function func1(){}
// 다양한 함수 형식
function func2(){} //선언적 함수
//function (){} // 익명 함수
//() => {} //화살표(람다표현식)함수 , 리액트 표현
//[3] 화살표 함수는 익명이므로 변수에 저장한다
const func3 = ( ) => { }
//================================================//
/* 1.
    Axios
        1. 정의 : 대표적으로 비동기/동기 통신 함수
            Axios(React) vs JS(Fetch) vs JQuery(AJAX)
        2. 목적 : js환경에서 서버와의 통신
        3. 설치 :
            1. HTML에 CDN 코드 추가한다.
            2. <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
        4. 사용법
*/
//axios.http메소드명("통신할주소)
axios.get("http://localhost:8080/day03/task")

// axios.http메소드명("통신할주소").then((response)=>{console.log(response.data)}); 도메인 생략 가능
axios.delete("/day03/task?name=유재석").then((response) => {console.log(response.data);})

//3. axios.http
axios.post("/day03/task?age=10").then((response) => {console.log(response.data);}).catch((error)=>{console.log(error);});

//4. axios.http메소드명("통신할주소" , body)
const obj = {"name" : "유재석" , "age" : 40}
axios.put("/day03/task" , obj ).then((response) => {console.log(response.data);}).catch((error)=>{console.log(error);});
// 비동기통신이란? 요청이 여러개 있을때 먼저 처리된 응답부터 실행

// 동기통신이란? 요청이 여러개 있을때 요청순으로 응답
//5. async 동기화
const func5 = async()=>{
    try{ //1. 예외처리
         //2. await axios 동기화
         //3. axios 결과를 변수/상수에 대입
        const response =
           await axios.get("/day03/task/axios?name=강호동")
        //4. 결과확인
        console.log(response.data);
    }catch(e){console.log(e);}
}
func5();