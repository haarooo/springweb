import { useState } from "react"
import FrontComp from "../chapter7/FrontComp";
import BackComp from "../chapter7/BackComp";

export default function Exam1(props){
    // 1) useState 선언 : const[변수명 , set변수명] = useState*(초기값)
    const[mode , setMode] = useState('both'); 
    const handleSetMode = (mode)=>{setMode(mode)}; // 상태 변경을 위한 함수
    
    let contents = ''; //컴포넌트 저장용 변수
    if(mode == 'front'){
        contents = <>
                    <FrontComp onSetMode = {(mode)=> {setMode(mode)}}></FrontComp>
                    
        </>
    }else if(mode == 'back'){
        contents = <>
            <BackComp setMode = {setMode}/>
        </>
    }else{contents = <>
        <FrontComp onSetMode={(mode)=>{handleSetMode(mode)}}></FrontComp>
        <BackComp setMode={handleSetMode}/>
        </>
    }
    return(<>
        <h2><a href="/" onClick={()=>{setMode('both')}}> chapter7 p.118 </a></h2>
        <ol>
            {contents}
        </ol>

    </>)
}