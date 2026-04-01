import {useEffect, useState} from "react";
import axios from "axios";

const GlobalTop = (props) => {
    console.log("1.컴포넌트 실행")
    const[myList , setMyList] = useState([]);
        // 1. axios사용하기
        const axios1 = async()=>{
            try{
                const response = await axios.get('./json/myData.json');
                const result = response.data
                setMyList(result)
            }catch(e){console.log(e)}
        }
    useEffect(()=>{
        console.log("3.useEffect 실행")
        axios1();
    },[]);


    // 현재 상태(myList=>json=>axios) 정보를 반복하여 html 구성
    // 리스트/배열.map((반복변수)=>{return(<> 결과물 </>)})
    //     {"num":1, "id":"yu", "name":"유비", "cell":"(02) 235-1111"},
    //     {"num":2, "id":"kwan", "name":"관우", "cell":"(051) 235-2222"},
    //     {"num":3, "id":"jang", "name":"장비", "cell":"(031) 235-3333"
    let listTag = myList.map((data)=>{
        return(<>
            <li key={data.id}>
                <a href={data.id}data-id={data.num}onClick={(e)=>{
                    e.preventDefault();
                    props.myLinkClick(e.target.dataset.id);}}>
                   {data.id}
                </a>
            </li>
        </>)
    })
    console.log("2. return실행")
    return(<>
        <nav>
            <ul>
                {listTag}
            </ul>
        </nav>
    </>)
}

const ContentBody = (props) =>{
    return(<>
        <div>
            <h2>{props.myResult.name}</h2>
            <ul>
                <li>num:{props.myResult.num}</li>
                <li>id:{props.myResult.id}</li>
                <li>cell:{props.myResult.cell}</li>
                <li>description:{props.myResult.description}</li>
            </ul>
        </div>
    </>)
}





export default function LocalJsonFetcher(props){
    const[ myResult, setMyResult] = useState({})
    console.log(myResult)
    return(<>
        <h2>내부 서버 통신</h2>
        <GlobalTop myLinkClick={async(num)=>{
            console.log("클릭",num);
            const response = await axios.get(`./json/dto${num}.json`)
            const result = response.data
            setMyResult(result)
        }}></GlobalTop>
        <ContentBody myResult={myResult}></ContentBody>
    </>)
}