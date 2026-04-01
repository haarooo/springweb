import {useEffect, useState} from "react";

function MoveBox(props){
    // props란 상위 컴포넌트에서 해당 컴포넌트 호출시 전달해주는 속성명과 속성값들 객체로 받는 매개변수
    console.log('LifeCycle==>1.컴포넌트 실행(함수호출)');

    // useState란 컴포넌트내 데이터(값) 상태 관리하는 함수
    const[position , setPosition] = useState(props.initPosition);
    const[leftCount , setLeftCount] = useState(1);
    const boxStyle = {
        backgroundColor:"red", position:'relative' , textAlign: 'center' , width:'100px', height:'100px',
        margin:'10px',lineHeight:'100px',left:`${position}px`
    }


const moveLeft = ()=> {
    setPosition(()=>position-20);
    setLeftCount(()=>leftCount +1);
}
const moveRight= () => {
    setPosition(()=>position+20);
}

useEffect(function () {
    console.log('useEffect 실행==>3.컴포넌트 마운트');
    return () => {
        console.log('useEffect 실행==>4.컴포넌트 언마운드');
    }
},[leftCount]);


console.log("return 실행==>2.렌더링(return문)");
return(<>
    <div>
        <h4> 함수형 컴포넌트 생명주기 </h4>
        <div style={boxStyle}> {leftCount}</div>
        <input type='button' value="좌측이동" onClick={moveLeft}/>
        <input type='button' value="우측이동" onClick={moveRight}/>
    </div>
</>);

}


export default function LifeCycle(props){
    return(<>
        <h2> React Hook - useEffect</h2>
        <MoveBox initPosition={50}></MoveBox>
    </>)
}