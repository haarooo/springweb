// 컴포넌트 내보내기 , 다른 jsx에서 해당하는 컴포넌트 사용하기 위해
export default function FrontComp(props){
    return(<>
        <li><a href="/" onClick={()=>{event.preventDefault(); props.onSetMode('front')}}>프론트엔드</a></li>
        <ul>
            <li>html5</li>
            <li>css3</li>
            <li>javascript</li>
            <li>jqeury</li>
        </ul>
    </>)
}