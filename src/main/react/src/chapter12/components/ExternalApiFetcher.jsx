import {useEffect, useState} from "react";
import axios from "axios";

function RandomUser(props){
    const[myJson , setMyJson] = useState({results:[]});

        const axios1 = async ()=>{
            try{
                const response = await axios.get("https://api.randomuser.me?results=10")
                const result = response.data
                setMyJson(result)
            }catch (e){console.log(e)}
        }
    useEffect(function (){
        axios1();
    }, []);

    let trTag = myJson.results.map((data)=>{
        return(<>
            <tr key={data.login.md5}>
                <td>
                    <img src={data.picture.thumbnail} alt={data.login.username}/>
                </td>
                <td>
                    <a href='/' onClick={(e)=>{
                        e.preventDefault()
                        props.onProfile(data)
                    }}>{data.login.username}</a>
                </td>
                <td>{data.name.title} {data.name.first} {data.name.last}</td>
                <td>{data.nat}</td>
                <td>{data.email}</td>
            </tr>
        </>)
    })
    return(<>
        <div>
            <table border='1'>
                <thead>
                    <tr>
                        <th>사진</th> <th>로그인</th> <th>이름</th> <th>국가</th> <th>Email</th>
                    </tr>
                </thead>
                <tbody>{trTag}</tbody>
            </table>
        </div>
    </>)

}



export default function ExternalApiFetcher(props){
    return(<>
        <h2>외부 서버 통신</h2>
        <RandomUser onProfile={(sData)=>{
            console.log(sData)
            let info = `전화번호:${sData.cell} 성별:${sData.gender} username:${sData.login.username} password:${sData.login.password}`
            alert(info)
        }}></RandomUser>
    </>)
}