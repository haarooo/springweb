
/* 1. 프론트 관련 컴포넌트 */ 
function FrontComp(){ // 생성방법 1 : function 캄포넌트명(){}
  // 생성방법 2 : 컴포넌트내 return (<>HTML코드</>)
  return (<> 
    <li>프론트엔드</li>
        <ul>
            <li>HTML5</li>
            <li>CSS#</li>
            <li>Javascript</li>
            <li>jQuery</li>
        </ul>
  </>) 
}

// 2. 백엔드 관련 컴포넌트
const BackComp = () => {
  return(<>
      <li>백엔드</li>
        <ul>
            <li>Java</li>
            <li>Oracle</li>
            <li>JSP</li>
            <li>Spring Boot</li>
        </ul>
    </>)
}

let FormComp = function(){
  return(<>
    <form>
        <select name="gubun">
            <option value="front">프론트엔드</option>
            <option value="back">백엔드</option>
        </select>
        <input type="text" name="title"/>
        <input type="submit" value="추가" />
    </form>
  </>)
}

function App() {
  
  return (
    <>
      <div>
        <h2>React-Component</h2>
        <ol>
          <FrontComp></FrontComp>
          <BackComp/>
        </ol>
        <FormComp/>
      </div>
    </>
  )
}

export default App
