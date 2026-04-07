import {Route, Routes} from "react-router-dom";
import Login from "./pages/member/Login.jsx";
import Header from "./components/Header.jsx";
import {useState} from "react";
import axios from "axios";
import Write from "./pages/board/Write.jsx";
import Signup from "./pages/member/Signup.jsx";

export default function App(props){



    return(<>
        <div id="wrap">
            {/* 헤더 */}
            <Header/>
            <Routes>
                {/* 본문 */}
                <Route path="/member/login" element={<Login/>}/>
                <Route path="/board/write" element={<Write/>}/>
                <Route path="/member/signup" element={<Signup/>}/>
            </Routes>
            {/* 푸터 */}
        </div>

    </>)
}