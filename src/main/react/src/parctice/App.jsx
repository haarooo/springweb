import {Route, Routes} from "react-router-dom";
import Detail from "./components/Detail.jsx";
import Edit from "./components/Edit.jsx";
import Index from "./components/Index.jsx";
import Create from "./components/Create.jsx";

export default function App(props){
    return(<>

        <Routes>
            <Route path="/" element={<Index/>}/>
            <Route path="/task/create" element={<Create/>}/>
            <Route path="/task/detail" element={<Detail/>}/>
            <Route path="/task/edit" element={<Edit/>}/>
        </Routes>
    </>)
}