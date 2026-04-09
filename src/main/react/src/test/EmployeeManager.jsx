import React, {useEffect, useState} from "react";
import axios from "axios";

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

  const employee = async (e) => {
    e.preventDefault();
    let name = e.target.name.value;
    let position = e.target.position.value;
    let department = e.target.department.value;
    let uploadFile = e.target.uploadFile.files[0]
    const formData = new FormData();
    formData.append("name" , name)
    formData.append("position" , position)
    formData.append("department" , department)
    if(formData){formData.append("uploadFile" , uploadFile)};

    const response = await axios.post("http://localhost:8080/api/employee", formData)
    const data = response.data
    if(data!=null){alert("사원 등록 성공"); location.href="/"}
    else{"사원 등록 실패"}

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
                    <option> {d.departmentName}</option>
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
            <tr>
              <td><img className="img-box" /> </td>
              <td>김민준</td>
              <td>개발팀</td>
              <td>선임 개발자</td>
              <td>
                <span className="edit">수정</span>
                <span className="delete">삭제</span>
              </td>
            </tr>

            <tr>
              <td><img className="img-box" /> </td>
              <td>이서연</td>
              <td>디자인팀</td>
              <td>수석 디자이너</td>
              <td>
                <span className="edit">수정</span>
                <span className="delete">삭제</span>
              </td>
            </tr>

            <tr>
              <td><img className="img-box" /> </td>
              <td>박도윤</td>
              <td>기획팀</td>
              <td>팀장</td>
              <td>
                <span className="edit">수정</span>
                <span className="delete">삭제</span>
              </td>
            </tr>
          </tbody>
        </table>
      </div>
    </div>
  );
}