const func1 = async() => {
    try{
        const obj = {"studentName" : "홍길동" , "date" : "2026-02-26" , "status" : "출석"}
        const response1=
        await axios.post("/day03/attendance" , obj)
        console.log(response1.data);
    }catch(e){console.log(e)}
}
const func2 = async()=>{
    try{
        const response2=
        await axios.get("/day03/attendance")
        console.log(response2.data)
    }catch(e){console.log(e)}
}
const func3 = async()=>{
    try{
        const response3=
        await axios.get("/day03/attendance/detail?ano=1")
        console.log(response3.data)
    }catch(e){console.log(e)}
}
const func4 = async()=>{
    try{
        const response4=
        await axios.delete("/day03/attendance?ano=1")
        console.log(response4.data)
    }catch(e){console.log(e)}
}
const func5 = async()=>{
    try{
        const obj2 = {"ano" : 1 , "status" : "지각"}
        const response5=
        await axios.put("/day03/attendance" , obj2)
        console.log(response5.data)
    }catch(e){console.log(e)}
}