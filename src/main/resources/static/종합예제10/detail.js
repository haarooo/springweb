console.log("detail.js")

// 1. 쿼리스트링이란? URL(주소) 뒤에 ?로 매개변수 포함하는 경우
// 2. js에서 쿼리스트링의 값 가져오는 방법
// new URLSearchParams(location.search).get("변수명")

const bno = new URLSearchParams(location.search).get("bno");
//확인
console.log(bno);


const detailFind = async () => {
    const boardBox = document.querySelector("#boardBox")
    // 쿼리스트링에 존재하는(클릭된 게시말)bno에 게시물 정보
    const response = await axios.get(`/board/detail?bno=${bno}`)
    const data = response.data;
    let html =    `제목 : <div>${data.btitle}</div>
                   작성자/작성일 : <div> ${data.bwriter} / ${data.createDate}</div>
                   내용 : <div> ${data.bcontent}</div>
                   <button onclick="update(${data.bno});">수정</button>
                   <button onclick="delete1(${data.bno});">삭제</button>`
    boardBox.innerHTML = html;
}
detailFind();


const delete1 = async(bno) => {
    const response = await axios.delete(`/board?bno=${bno}`)
    const data = response.data
    if(data == true){alert("삭제성공"); location.href="/종합예제10/index.html"}
    else{alert("삭제실패")}
}

const update = async(bno) => {
    const btitle = prompt("수정할 제목 : ");
    const bcontent = prompt("수정할 내용 : ")
    const bwriter = prompt("수정할 작성자 : ")
    const obj = {bno , btitle , bcontent , bwriter}
    const response = await axios.put("/board" , obj)
    const data = response.data
    if(data == true){alert("수정 성공"); location.reload(); //현재 페이지 새로고침}
    }else{alert("수정 실패")}
}


const cfindAll = async() => {
    const commentBox = document.querySelector("#commentBox")
    let html = ""
    const response = await axios.get(`/comment?bno=${bno}`)
    const data = response.data
    for(let index = 0 ; index<=data.length-1 ; index++){
        const comment = data[index]
        html += `        번호 : <span>${comment.cno}</span>
                         작성자/작성일 : <div> ${comment.cwriter} / ${comment.createDate} </div>
                         내용 : <div> ${comment.comment} </div>
                         <button onclick="cupdate(${comment.cno});">수정</button>
                         <button onclick="cdelete(${comment.cno});">삭제</button>`
    }
    commentBox.innerHTML = html;
}
cfindAll();


const cpost = async() => {
    const cwriter = document.querySelector(".cwriter").value
    const comment = document.querySelector(".commentInput").value
    const obj = {bno ,cwriter , comment}
    const response = await axios.post("/comment", obj)
    const data= response.data
    if(data == true){alert("등록성공"); location.reload();}
    else{alert("등록실패")}
}


const cupdate = async(cno) => {
    const comment = prompt("수정할 내용 : ")
    const cwriter = prompt("수정할 이름 : ")
    const obj = {cno ,cwriter , comment}
    const response = await axios.put("/comment" , obj)
    const data = response.data
    if(data == true){alert("수정성공"); location.reload();}
    else{alert("수정실패")}
}

const cdelete = async(cno) => {

    const response = await axios.delete(`/comment?cno=${cno}`)
    const data = response.data
    if(data == true){alert("삭제성공"); location.reload();}
    else{alert("삭제실패")}
}
