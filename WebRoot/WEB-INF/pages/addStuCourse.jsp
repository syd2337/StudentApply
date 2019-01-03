<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>



<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>
	学生报名信息管理系统
</title>
<link href="Style/StudentStyle.css" rel="stylesheet" type="text/css" />
<link href="Script/jBox/Skins/Blue/jbox.css" rel="stylesheet" type="text/css" />
<link href="Style/ks.css" rel="stylesheet" type="text/css" />
    <script src="Script/jBox/jquery-1.4.2.min.js" type="text/javascript"></script>
    <script src="Script/jBox/jquery.jBox-2.3.min.js" type="text/javascript"></script>
    <script src="Script/jBox/i18n/jquery.jBox-zh-CN.js" type="text/javascript"></script>
    <script src="Script/Common.js" type="text/javascript"></script>
    <script  type="text/javascript" src="My97DatePicker/WdatePicker.js"></script>
    <script src="Script/Data.js" type="text/javascript"></script>
    <script type="text/javascript" src="Script/log_in.js"></script>
    <style type="text/css">
    	button{
    		margin-left:3px;
    		margin-right:3px;
    		padding-left: 3px;
    		padding-right: 3px;
    	}
    </style>
    <script src="Script/Base.js" type="text/javascript"></script>
    <script language="javascript" type="text/javascript">
    var flag=0;
	function Checkall(XelementName){
    var checkboxes=document.getElementsByName(XelementName);
    for(var i=0;i<checkboxes.length;i++){
        if (flag%3==0)    
            checkboxes[i].checked=true;
        if (flag%3==1)
            checkboxes[i].checked=false;
        if (flag%3==2)
            checkboxes[i].checked=!checkboxes[i].checked;
    	}
       flag++;
   	}
    function addStuCourse(){
    var studentId = $("#studentId").val();
    var obj = document.getElementsByName("checkbox1");
    var courseList = [];
    for(k in obj){
        if(obj[k].checked)
            courseList.push(obj[k].value);
    }
    if(courseList.length==0){
    	alert("请选择至少一门课程！")
    	return;
    }
    $.ajax({
		url:'addStuCourse.html',
		type:'POST',
		data:{
			'studentId':studentId,
			'courseList':courseList
		},
		dataType:'json',
		traditional: true,//属性在这里设置
		success:function(data){
			//window.location.href='toEdit.html';
			
			if(data==""){
				alert("添加课程失败!");
			}else if(data=="error"){
				alert("请不要重复添加课程");
			}else{
				window.location.href='selectStuCourseByStudentId.html?id='+data;
			};
			
			//console.log(data);
		}
	});
    }
    </script>
</head>
<body onload="login('${sessionScope.user.name}')">

    <div class="banner">
        <div class="bgh">
            <div class="page">
                <div id="logo">
                    <a href="../Index.aspx.html">
                        <img src="Images/Student/logo.gif" alt="" width="165" height="48" />
                    </a>
                </div>
                <div class="topxx">
                    
                    ${sessionScope.user.name}，欢迎您！
                </div>
                <div class="blog_nav">
                    <ul>
                        <li><a href="school.html">学校中心</a></li>
                        <li><a href="course.html">课程中心</a></li>
                        <li><a href="student.html">学生中心</a></li>
                        <li><a href="user.html">我的信息</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
    <div class="page">
        <div class="box mtop">
            <div class="leftbox">
                <div class="l_nav2">
                    <div class="ta1">
                        <strong>学校中心</strong>
                        <div class="leftbgbt">
                        </div>
                    </div>
                    <div class="cdlist">
                        <div>
                            <a href="school.html">学校管理</a></div>
                        <div>
                            <a href="campus.html">校区管理 </a>
                        </div>
                        <div>
                            <a href="grade.html">年级管理</a></div>
                        <div>
                            <a href="subject.html">科目管理</a></div>
                       <!--  <div>
                            <a href="../MyInfo/Objection.aspx.html">我的异议</a>
                        </div>--> 
                    </div>
                    <!--  <div class="ta1">
                        <strong>教务中心</strong>
                        <div class="leftbgbt2">
                        </div>
                    </div>
                    <div class="cdlist">
                        <div>
                            <a href="Application.aspx.html">我的报考</a></div>
                        <div>
                            <a href="Score.aspx.html">我的成绩</a></div>
                        <div>
                            <a href="Book.aspx.html">我的书籍</a></div>
                    </div>-->
                    <div class="ta1">
                        <strong>课程中心</strong><div class="leftbgbt2">
                        </div>
                    </div>
                    <div class="cdlist">
                        <div><a href="course.html">课程管理</a></div>
                        <!--<div><a href="../OnlineTeaching/StudentStudyRecordList.aspx.html">学习历程</a></div>-->
                    </div>
                   
                    <div class="ta1">
                        <strong>学生中心</strong><div class="leftbgbt2">
                        </div>
                    </div>
                    <div class="cdlist">
                        <div><a href="student.html">学生管理</a></div>
                        <!--  <div><a href="stuCourse.html">学生课程</a></div>-->
                    </div>
					<div class="ta1">
                        <strong>我的信息</strong>
                        <div class="leftbgbt2">
                        </div>
                    </div>
                    <div class="cdlist">
                        <div><a href="user.html">信息管理</a></div>
                        <div><a href="changePassword.html">修改密码</a></div>
                    </div>
                    <div class="ta1">
                        <strong>新闻中心</strong>
                        <div class="leftbgbt2">
                        </div>
                    </div>
                    <div class="cdlist">
                        <div><a href="include.html">新闻管理</a></div>
                    </div>
                    <div class="ta1">
                        <strong>信息中心</strong>
                        <div class="leftbgbt2">
                        </div>
                    </div>
                    <div class="cdlist">
                        <div><a href="updateAddress.html">地址管理</a></div>
                    </div>
                    <div class="cdlist">
                        <div><a href="updateAboutUs.html">关于我们</a></div>
                    </div>
                    <div class="ta1">
                        <strong>扫码上课</strong>
                        <div class="leftbgbt2">
                        </div>
                    </div>
                    <div class="cdlist">
                        <div><a href="register.html">扫码上课</a></div>                       
                    </div>
                </div>
            </div>
            <div class="rightbox">
                
    <h2 class="mbx">
       学生中心 &gt; 添加课程</h2>
    <div class="morebt">
        <ul>
        	<li><a class="tab1" href="student.html">学生管理</a></li>
             <!--<li><a class="tab2" href="stuCourse.html">学生课程</a></li>
             <li><a class="tab2" href="grade.html">年级管理</a></li>
            <li><a class="tab2" href="subject.html">科目管理</a></li>-->
            
        </ul>
    </div>
    <div class="fllist">
    <div class="cztable">
        <div class="tis">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
        	<tr align="center">
        		<td> 姓名：<span id="studentName">${student.name}</span><input type="hidden" id="studentId" value="${student.id}"/></td>
        		<td> 性别：<span id="studentSex">${student.sex}</span></td>
        		<td> 学校：<span id="studentSchoolName">${student.schoolName}</span></td>
        		<td> 校区：<span id="studenCampustName">${student.campusName}</span></td>
        		<td> 缴费：<span id="studentPayCondition">${student.payCondition}</span></td>
        	</tr>
        </table>       		     
        </div>
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tbody>
                <tr style="height: 25px" align="center">
                	<th scope="col">
                		<input type="checkbox" id="btn" value="" onclick="Checkall('checkbox1')"/>
                	</th>
                    <th scope="col">
                       	 编号
                    </th>
                    <th scope="col">
                        	年级名称
                    </th>
                    <th scope="col">
                        	科目名称
                    </th>
                    <th scope="col">
                        	开始时间
                    </th>
                    <th scope="col">
                        	结束时间
                    </th>
                    <th scope="col">
                        	课程时长
                    </th>
                    <th scope="col">
                        	课程资费
                    </th>
                </tr>
                <tr align="center"><td colspan="8"><c:if test="${empty courseList}">无数据请添加</c:if></td></tr>
                <c:forEach items="${courseList}" var ="li" varStatus="status">
                <tr align="center">
                	<td>
                		<input type="checkbox" name="checkbox1" value="${li.id}"/>
                	</td>
                    <td>
                        ${status.index+1}
                    </td>
                    <td>
                        ${li.gradeName}
                    </td>
                    <td>
                        ${li.subjectName}
                    </td>
                    <td>
                        <fmt:formatDate value="${li.startTime}"  pattern="yyyy-MM-dd" />
                    </td>
                    <td>
                       <fmt:formatDate value="${li.endTime}"  pattern="yyyy-MM-dd" /> 
                    </td>
                    <td>
                        ${li.period}
                    </td>
                    <td>
                        ${li.rates}元
                    </td>                   
                </tr>
                </c:forEach> 
                <tr>
    				<td colspan="8" style="text-align:center;"><input type="submit" id="btnSubmit" value="确认添加" onclick="addStuCourse()" class="input2" /></td>
    			</tr>                              
            </tbody>
        </table>       
    </div>
	</div>
            </div>
        </div>
        <div class="footer">
            <p>
                &copy;copyright 2018 智仁学堂      版权所有 </p>
        </div>
    </div>
</body>
</html>
