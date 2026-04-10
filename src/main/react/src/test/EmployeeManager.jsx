import React, {useEffect, useState} from "react";
import axios from "axios";
import {preinitModule} from "react-dom";

export default function EmployeeManager() {


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

  // 사원 등록
  const employee = async (e) => {
    e.preventDefault();
    let name = e.target.name.value;
    let position = e.target.position.value;
    let department = e.target.department.value;
    let uploadFile = e.target.uploadFile.files[0]
    const formData = new FormData();
    formData.append("employeeName" , name)
    formData.append("position" , position)
    formData.append("departmentId" , department)
    if(uploadFile){ formData.append("multipartFile", uploadFile) }

    const response = await axios.post("http://localhost:8080/api/employee", formData)
    const data = response.data
    if(data!=null){alert("사원 등록 성공"); location.href="/"}
    else{"사원 등록 실패"}

  }


  const[employeeList , setEmployeeList] = useState([])

  // 사원 조회
  const findAll = async () =>{
    try{
      const response = await axios.get("http://localhost:8080/api/employee")
      const data = response.data;
      setEmployeeList(data)
    }catch (e){console.log(e)}
  }
  useEffect(() => {
    findAll();
  }, []);


  // 사원 수정
  const update = async (id) =>{
    let employeeName = prompt("수정할 사원명 : ");
    let position = prompt("수정할 직급명 : ");
    const obj = {"employeeId" :id , "employeeName" : employeeName , "position" :position};
    const response = await axios.put("http://localhost:8080/api/employee" , obj)
    const data = response.data
    if(data != null){alert("수정 성공"); location.href="/"}
    else{alert("수정 실패");}
  }

  // 사원 삭제
  const employDelete = async (id)=>{
    const response = await axios.delete("http://localhost:8080/api/employee?employeeId="+id);
    const data = response.data
    if(data == true){alert("삭제 성공"); location.href="/"}
    else{alert("삭제 실패");}
  }




  return (
    <div className="main">
      {/* 사원 등록 */}
      <form onSubmit={employee} className="form-box">
        <h3>사원 등록</h3>

        <div className="form-row">
          <input name="name" type="text" placeholder="이름" />
          <input name="position" type="text" placeholder="직급" />
        </div>

        <div className="form-row">
          <select name="department" >
            <option >부서를 선택하세요</option>
            {
              department.map( (d)=>{
                return (
                    <option key={d.departmentId} value={d.departmentId}> {d.departmentName}</option>
                )
              })
            }
          </select>
          <input name="uploadFile" type="file" />
        </div>

        <div className="form-action">
          <button type="submit" className="primary">등록</button>
        </div>
      </form>

      {/* 사원 목록 */}
      <div className="table-box">
        <h3>사원 전체 목록</h3>

        <table>
          <thead>
            <tr>
              <th>사진</th>
              <th>이름</th>
              <th>부서</th>
              <th>직급</th>
              <th>관리</th>
            </tr>
          </thead>
          <tbody>
          {
            employeeList.map( (b) => {
              return(
                  <tr>
                    <td><img className="img-box" src={`http://localhost:8080/upload/${b.employeeImg}`}/></td>
                    <td>{b.employeeName}</td>
                    <td>{b.departmentName}</td>
                    <td>{b.position}</td>
                    <td>
                      <button onClick={()=>{update(b.employeeId)}} className="edit">수정</button>
                      <button onClick={()=>{employDelete(b.employeeId)}} className="delete">삭제</button>
                    </td>
                  </tr>
              )
            })
          }
          </tbody>
        </table>
      </div>
    </div>
  );
}