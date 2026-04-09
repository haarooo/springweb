import React, {act, useEffect, useState} from "react";
import axios from "axios";
import {data} from "react-router-dom";






export default function DepartmentManager() {


  // 부서 등록
  const departmentWrite = async (e) =>{
    e.preventDefault();

    let department = e.target.department.value;
    const obj = {"departmentName" : department}
    const response = await axios.post("http://localhost:8080/api/department", obj)
    const data= response.data
    if(data != null){alert("부서 등록 성공") ; location.href="/"}
    else{alert("부서 등록 실패")}

  }

  // 부서 조회
  const[department , setDepartment] = useState([])
  const departmentGet = async ()=>{
    try{
      const response = await axios.get("http://localhost:8080/api/department")
      const result = response.data
      setDepartment(result);
    }catch (e){console.log(e)}
  }
  useEffect(()=>{
    departmentGet();
  },[])

  // 부서명 수정
  const update = async (id) =>{
    let department = prompt("수정할 부서명 : ");
    const obj = {"departmentId": id , "departmentName": department}
    const response = await axios.put("http://localhost:8080/api/department" , obj)
    const data = response.data
    if(data != null){alert("수정 성공"); location.href="/"}
    else{alert("수정 실패")}
  }

  // 부서명 삭제
  const deletePart = async (id)=>{
    const response = await axios.delete("http://localhost:8080/api/department?departmentId="+id);
    const data = response.data
    if(data ==true){alert("삭제 성공"); location.href="/"}
    else{alert("삭제 실패")}


  }



  return (
    <div className="sidebar">
      <h3>부서 관리</h3>

      <form className="dept-input" onSubmit={departmentWrite}>
        <input name="department" type="text" placeholder="신규 부서명 입력" />
        <button type="submit">추가</button>
      </form>

      <table className="dept-table">
        <thead>
          <tr>
            <th>부서명</th>
            <th>관리</th>
          </tr>
        </thead>
        <tbody>
        {
          department.map(department =>{
            return(
               <tr>
                  <td>{department.departmentName}</td>
                  <td>
                    <button onClick={()=>{update(department.departmentId)}} className="edit">수정</button>
                    <button onClick={()=>deletePart(department.departmentId)} className="delete">삭제</button>
                  </td>
               </tr>
            )
          })
        }
        </tbody>
      </table>
    </div>
  );
}