import {Routes ,Route} from "react-router-dom";
import Home from './components/Home.jsx'
import TopNavi from "./components/TopNavi.jsx";
import NotFound from "./components/NotFound.jsx";
import CommonLayout from "./components/CommonLayout.jsx";
import LayoutIndex from "./components/LayoutIndex.jsx";
import RouterHooks from "./components/RouterHooks.jsx";

export default function Exam1(porps){
    return(<>
        <TopNavi></TopNavi>
        <Routes>
            <Route path='/' element={<Home/>}/>
            <Route path="/intro" element={<CommonLayout/>}>
                <Route index element={<LayoutIndex/>}/>
                <Route path="router" element={<RouterHooks/>}/>
            </Route>
            <Route path='*' element={<NotFound/>}/>
        </Routes>
    </>)
}