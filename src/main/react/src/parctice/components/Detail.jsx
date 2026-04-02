import {useSearchParams} from "react-router-dom";
import axios from "axios";
import {useEffect, useState} from "react";

export default function Detail(props){
    const [searchParams , setSearchParams] = useSearchParams();
    const id = searchParams.get("id");


    const [task , setTask] = useState({})

    const getTaskDetail = async () =>{
        const response = await axios.get('http://localhost:8080/api/task/detail?id='+id);
        const data = response.data
        setTask(data);
    }

    useEffect(()=>{
        getTaskDetail();
    },[])

    if(task==null)return<div> 가져오는 중</div>

    return(<>
        <p> 번호 , 제목 , 요청내용 , 요청자명 , 상태 , 등록일</p>
        <p>번호 : {task.id}</p>
        <p>제목 : {task.title}</p>
        <p>내용 : {task.content}</p>
        <p>요청자명 : {task.requester}</p>
        <p>상태 : {task.status}</p>
        <p>등록일 : {task.createdDate}</p>
    </>)
}