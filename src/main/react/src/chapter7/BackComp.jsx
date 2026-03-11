const BackComp = ({setMode}) => {
    return(<>
        <li><a href="/" onClick={() => {event.preventDefault();setMode('back')}}>백엔드</a></li>
        <ul>
            <li>java</li>
            <li>Oracle</li>
            <li>JSP</li>
            <li>Spring</li>
        </ul>
    </>)
}
export default BackComp;