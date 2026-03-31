import {useState} from "react";


const TopComp = ({Mydata})=>{
  return(<>
      <ol>
          <li>프론트엔드</li>
          <ul>
              {Mydata.front.map((item ,i) => <li key={i}>{item}</li>)}
          </ul>
          <li> 백엔드 </li>
          <ul>
              {Mydata.back.map((item ,i)=><li key={i}>{item}</li>)}
          </ul>
      </ol>
  </>)
}



export default function Exam1(props){
    const [Mydata , setMyData]=useState({
        front:['HTML5','CSS3','Javascript','jQuery'],
        back: ['Java','Oracle','jsp','spring']
    });
    // useState훅(hook:갈고리-연결  상태/값/데이터 <--갈고리-->컴포넌트)
    // 즉 상태가 변경되면 (주소/참조)값 컴포넌트 렌더링 된다
    const addFront = () => {
        Mydata.front.push('React');
        setMyData(Mydata);
    }
    const addBack= () => {
        const newBack = [...Mydata.back , 'Node.js'];
        const newMydata = { ...Mydata , back : newBack};
        setMyData(newMydata);
    }
    return (<>
        <h2> React-Shallow Comparison</h2>
        <TopComp Mydata={Mydata} />
        <button type='button' onClick={addFront}></button>
        <button type='button' onClick={addBack}></button>


    </>)
}