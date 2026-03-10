function FrontComp(props){
    return(<>
        <li><a href="/" onClick={()=>{props.onMyEvent1();}}>프론트엔드</a></li>
        <ul>
            <li>html5</li>
            <li>css3</li>
            <li>javascript</li>
            <li>jquery</li>
        </ul>
    </>)
}


function Exam2(){

    function 출력함수(){alert('출력된메시지')}
    // 익명함수 ? 이름이 없는 함수(재사용이 안된다.) / 일회성 또는 이벤트함수
    return(<>
        <h2> 이벤트 처리 p.100 </h2>
        <button onClick={출력함수}> 리엑트버튼 </button>
        <button onClick={function(){alert('출력된메시지2');}}>리액트버튼2</button>
        <button onClick={()=>{alert('출력된메시지3');}}>리액트버튼3</button>
        <FrontComp onMyEvent1={()=>{alert("프론트엔드 클릭됨(부모가전달)")}}></FrontComp>
    </>)
}
export default Exam2

/*
    리액트 이벤트에서 주의할점
    1. onclick-0> onClick , 합성이벤트(리엑트가 핸들러/연결 통해 이벤트 실행)
    2. onClick 에서 함수를 실행하는 구조가 아니고 *전달*하는 구조
        1) 선언방법 , function 함수명(){}
        2) 호출 , 함수명(); 
        3) 함수란 여러개 계산식/코드(데이터x) 묶음 , 
        4) 변수란 하나의 값을 저장하는 공간 
    ** HTML : <button onclick="출력함수();"/>
    ** REACT : <button onCLick={출력함수} />
*/ 