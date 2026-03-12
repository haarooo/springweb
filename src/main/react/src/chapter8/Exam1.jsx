import React from "../assets/react.png";
import "./index.css"
export default function Exam1(props){
    const myStyle = {
        color : "white",
        backgroundColor : "DodgerBlue",
        padding : "10px",
        fontFamily : "Verdana"

    };
    const iwidth = {maxWidth : '100px'}
    return(<>
        <h2> chapter8 p.126 </h2>
        <ol>
            <li style={{color : "red"}}> 프론트엔드 </li>
            <ul>
                <li><img src="img/img1.jpg" style={iwidth}/></li>
                <li><img src={React} style={iwidth} /></li>
                <li><img src="http://placehold.co/600x400" style={iwidth} /></li>
            </ul>
            <li className='backEnd'>백엔드</li>
            <ul>
                <li id='backEndSub'>java</li>
                <li className='warnings'>oracle</li>
                <li style={myStyle}>spring</li>
                <li>jsp</li>
            </ul>
        </ol>
    </>)
}