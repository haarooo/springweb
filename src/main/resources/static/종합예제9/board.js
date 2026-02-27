//전체조회 , 실행조건 : js가 열렸을때, 수정/동록/삭제 성공했을때
const onFindAll = async() => {
    try{
        const tbody = document.querySelector("#boardTable tbody");
        let html = "";
        const response = await axios.get("/board")
        console.log(response.data)
        const data = response.data
        for(let index = 0 ; index <= data.length-1 ; index++){
            const board = data[index]; console.log(board)
            html+= `<tr>
                        <td>${board.bno}</td>
                        <td>${board.bcontent}</td>
                        <td>${board.bwriter}</td>
                        <td>${board.bdate}</td>
                        <td><button onclick="ondelete(${board.bno})">삭제</button></td>
                        <td><button onclick="onupdate(${board.bno})">수정</button></td>
                    </tr>`
        }
        tbody.innerHTML = html;
    }catch(e){console.log(e)}
}
onFindAll();

//등록하기
const onwrite = async() => {
    try{
        const content = document.querySelector("#bcontent").value
        const writer = document.querySelector("#bwriter").value
        const obj = {"bcontent" : content , "bwriter" : writer}
        const response = await axios.post("/board" , obj)
        const data = response.data;
            if( data == true ){
                alert("등록성공");
                content.value = ''; writer.value = ''; // 입력상자 초기화
                onFindAll();
            }
            else{ alert("등록실패 : 관리자에게 문의 "); }
    }catch(e){console.log(e)}
}

const ondelete = async(bno)=>{
    try{

        const response = await axios.delete(`/board?bno=${bno}`)
        const data = response.data;
        if(data ==true){
        alert("삭제성공")
        onFindAll();
        }else{
            alert("삭제실패")
        }
    }catch(e){console.log(e)}
}

const onupdate = async(bno)=>{
    try{
        const bcontent = prompt("수정할 내용 : ")
        const obj = {bno , bcontent}
        const response = await axios.put("/board",obj)
        const data = response.data;
        if(data == true){
            alert("수정성공")
            onFindAll();
        }else{alert("수정실패")}
    }catch(e){console.log(e)}
}

