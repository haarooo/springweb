import axios from "axios";
import {useEffect, useState} from "react";
import {Link} from "react-router-dom";

export default function Board(props){

    // 2. axios로 부터 받은 게시물들을 저장하는 상태변수
    const[list , setList] = useState([])


    // 1. axios
    const findAll = async () =>{
        try{
            const response = await axios.get("http://localhost:8080/api/board/findall")
            const data = response.data;
            setList(data);
        }catch (e){console.log(e)}
    }

    // 3. axios 실행 시험
    useEffect(() => {
        findAll();
    }, []);


    return(<>
        <div>
            <h3> 게시판 목록</h3>
            <table border="1">
                <thead>
                    <tr>
                        <th> 번호</th>
                        <th> 제목 </th>
                        <th> 작성자 </th>
                        <th> 등록일 </th>
                    </tr>
                </thead>
                <tbody>
                    {
                    list.map( board =>{
                        return(
                            <tr key={board.bno}>
                                <td>{board.bno}</td>
                                <td><Link to={`/board/view?bno=${board.bno}`}>{board.btitle}</Link></td>
                                <td>{board.mname}</td>
                                <td>{board.createDate}</td>
                            </tr>
                            )
                         })
                    }

                </tbody>
            </table>
        </div>
    </>)
}