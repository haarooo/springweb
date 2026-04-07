import axios from "axios";
import {useEffect, useState} from "react";
import {useSearchParams} from "react-router-dom";

export function View(props) {
    // 현재 url상의 쿼리스트링 값 가져오기
    const [params] = useSearchParams()
    const bno = params.get("bno");

    const [board, setBoard] = useState(null)

    const detail = async () => {
        try {
            const response = await axios.get(`http://localhost:8080/api/board/detail?bno=${bno}`);
            const data = response.data
            setBoard(data)
        } catch (e) {
            console.log(e)
        }
    }
    useEffect(() => {
        detail();
    }, []);

// 만약에 아직 axios의 결과가 없으면
    if (!board) return <div> 불러오는 중 </div>


    return (<>
        <div>
            <h3> 게시물 상세 </h3>
            <div> 작성자 : {board.mname} | 작성일 : {board.createDate}</div>
            <div> 제목 : {board.btitle}</div>
            {/* 리액트는 가상 dom이라서 직접적인 html대입 차단한다*/}
            <div dangerouslySetInnerHTML={{__html: board.bcontent}}/>
            <div>
                {
                    board.bfile == true && (
                        <>
                            <a href={`http"//localhost:8080/upload/${board.bfile}`} download>
                                {board.bfile.split("_")[1]}다운로드 </a>
                        </>
                    )
                }

            </div>
        </div>
    </>)
}