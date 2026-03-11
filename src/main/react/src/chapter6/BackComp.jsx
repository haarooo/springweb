const BackComp = ({onMyEvent2}) => {
    return(<>
        <li><a href="/" onClick={() => {onMyEvent2('백엔드 클림됨');}}>백엔드</a></li>
        <ul>
            <li>java</li>
            <li>Oracle</li>
            <li>JSP</li>
            <li>Spring</li>
        </ul>
    </>)
}
export default BackComp;