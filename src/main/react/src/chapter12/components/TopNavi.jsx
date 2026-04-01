import {NavLink} from "react-router-dom";

export default function TopNavi(props){
    // jsx에서 html에 없는 마크업들은 모두 컴포넌트이며 외부 호출시 import한다
    return(<>
        <nav>
            <NavLink to="/">생명주기</NavLink>
            <NavLink to="/local">내부통신</NavLink>
            <NavLink to="/external">외부통신</NavLink>
        </nav>
    </>);
}