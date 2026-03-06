console.log("write.js")

const post = async () => {
    const bwriter = document.querySelector(".writerInput").value
    const bcontent = document.querySelector(".contentInput").value
    const btitle = document.querySelector(".titleInput").value

    const obj = {"bwriter" : bwriter , "bcontent" : bcontent , "btitle" : btitle}
    const response = await axios.post("/board" , obj)
    const data = response.data;
    if(data == true){
    alert("등록성공")
    location.href = "/종합예제10/index.html"
    }else{alert("등록실패")}

}