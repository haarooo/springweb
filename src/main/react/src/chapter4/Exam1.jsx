// 컴포넌트 만드는 방법
// 1. 해당 폴더를 오른쪽 클릭 -> new file 
// 2. 첫글자가 대문자로 시작하는.jsx 파일확장자로 생성
// 예) Exam1.jsx
// 3. function 컴포넌트명(){return (<> jsx문법 </>)}
// 4. 파일내 내보내기 할 컴포넌트 1개 , export default 컴포넌트명  
function FrontComp(props){
    const liRows = [];
    for(let i = 0 ; i < props.propData1.length ; i++){
        liRows.push(
            <li key={i}>{props.propData1[i]}</li>
        );
    }
    return(<>
        <li>{props.frTitle}</li>
        <ul>{liRows}</ul>
    </>)
} 

const BackComp = ({propData2 , baTitle}) =>{
    const liRows = [];
    let keyCnt = 0;
    for(let row of propData2){
        liRows.push(
            <li key={keyCnt++}>{row}</li>
        )
    }
    return (<>
        <li>{baTitle}</li>
        <ul>{liRows}</ul>
    </>)
}

function MyComponent(props){
    return(<>
        <h2>props객체 사용</h2>
        <p>{props.p1},{props.p2},{props.p3},{props.p4}</p>
    </>)
}

function MyComponent2({p1,p2,p3,p4}){
    return(<>
        <h2> 구조분해할당 </h2>
        <p>{p1},{p2},{p3},{p4}</p>
    </>)
}

function Exam1(){
    const frontData = ['html' , 'css' , 'css3'];
    const backData = ['java' , 'Oracle' , 'JSP']
    return(<>
        <div>
            <h3> 프롭스 예제 p.87</h3>
            <ol>
                <FrontComp propData1={frontData}frTitle="프론트엔드"></FrontComp>
                <BackComp propData2={backData}baTitle="백엔드"></BackComp>
            </ol>
        </div>
        <MyComponent p1={'html5'} p2={'css3'}p3={'javascript'}p4={'jQeury'}/>
        <MyComponent2 p1={'html5'} p2={'css3'}p3={'javascript'}p4={'jQeury'}/>
    </>)
}
export default Exam1; //내보내기