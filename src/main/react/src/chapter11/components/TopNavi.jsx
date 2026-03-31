import {Link , NavLink}from 'react-router-dom'

export default function TopNavi(props){
    // <a> : 클릭하면 브라우저 전체 새로고침
    // <Link> : 클릭하면 새로고침 없이 URL 변경
    return(<>
        <nav>
            <a href="/">Home</a>&nbsp;
            <NavLink to="/intro">인트로</NavLink>&nbsp;
            <NavLink to="/intro/router">Router Hook</NavLink>&nbsp;
            <Link to="/xyz">잘못된URL</Link>&nbsp;
        </nav>
    </>)
}