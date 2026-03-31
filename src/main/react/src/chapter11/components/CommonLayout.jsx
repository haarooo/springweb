import {Outlet} from "react-router-dom";

export default function CommonLayout(props){
    return(<>
        <div>
            <div>
                Outlet 컴포넌트 알아보기
            </div>
            <article>
                <Outlet />
            </article>
            <div style={{background:'lightgray' , padding:'10px'}}>
                공통 레이아웃
            </div>
        </div>
    </>)};