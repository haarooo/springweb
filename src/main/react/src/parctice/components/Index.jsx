import {useEffect, useState} from "react";
import {Link} from "react-router-dom";
import axios from "axios";

function TaskList(props){
    const[myTask , setMyTask] =useState([])
    const taskList = async ()=>{
        try{
            const response =await axios.get("http://localhost:8080/api/task")
            const result = response.data
            setMyTask(result)
        }catch (e){console.log(e)}
    }
    useEffect(()=>{
        taskList();
    },[]);


    // [4] 삭제 요청 REST API , delete update , write 존재하는 키워드 이므로 불가능하다.
    const deleteTask = async( id )=>{
        const result = confirm( '정말 취소할까요? '); // 확인true , 취소false
        if( result == true ){
            const response = await axios.delete('http://localhost:8080/api/task?id='+id);
            // 본문이 없으므로 본문으로 분기하지 않고 HTTP 응답 코드 분기
            if( response.status == 204 ){ alert('삭제성공'); taskList(); }
            else{ alert('삭제실패'); }
        }
    }


    let trTag = myTask.map((data)=>{
        return(<>
            <tr>
                <td>{data.id}</td>
                <td>{data.title}</td>
                <td>{data.content}</td>
                <td>{data.requester}</td>
                <td>{data.createdDate}</td>
                <td>{data.updateDate}</td>
                <td>{data.status}</td>
                <td>
                    <button><Link to={'/task/detail?id='+data.id}>상세보기</Link></button>
                    <button>수정</button>
                    <button onClick={ ( ) => { deleteTask( data.id );  } } > 삭제 </button>
                </td>
            </tr>
        </>)
    })

    return(<>
        <Link to="/task/create">등록</Link>
        <div>
            <table border='1'>
                <thead>
                    <tr>
                        <th>id</th> <th>제목</th> <th>내용</th> <th>요청자</th> <th>등록일</th> <th>수정일</th> <th>상태</th>
                        <th>비고</th>
                    </tr>
                </thead>
                <tbody>{trTag}</tbody>
            </table>
        </div>
    </>)



}


export default function Index(props){
    return(<>
        <TaskList></TaskList>
    </>)
}