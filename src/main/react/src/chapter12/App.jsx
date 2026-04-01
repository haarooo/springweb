import TopNavi from "./components/TopNavi.jsx";
import {Route, Routes} from "react-router-dom";
import LifeCycle from "./components/LifeCycle.jsx";
import LocalJsonFetcher from "./components/LocalJsonFetcher.jsx";
import ExternalApiFetcher from "./components/ExternalApiFetcher.jsx";

export default function App(props){
    return(<>
        <TopNavi></TopNavi>
        <Routes>
            <Route path='/' element={<LifeCycle/>}/>
            <Route path="/local" element={<LocalJsonFetcher/>}/>
            <Route path="/external" element={<ExternalApiFetcher/>}/>
        </Routes>
    </>)
}