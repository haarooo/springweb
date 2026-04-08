import {Route, Routes} from "react-router-dom";
import Login from "./pages/member/Login.jsx";
import Header from "./components/Header.jsx";
import {useState} from "react";
import axios from "axios";
import Write from "./pages/board/Write.jsx";
import Signup from "./pages/member/Signup.jsx";
import Board from "./pages/board/Board.jsx";
import {View} from "./pages/board/View.jsx";
import Chat from "./pages/chat/Chat.jsx";

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
                <Route path="/board/board" element={<Board/>}/>
                <Route path="/board/view" element={<View/>}/>
                <Route path="/chat" element={<Chat/>}/>
            </Routes>
            {/* 푸터 */}
        </div>

    </>)
}