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
    function deleteStuCourse(stuCourseId,courseName){
    var payCondition = $("#studentPayCondition").text();    
    var studentId = $("#studentId").val();
    	if(payCondition=="已缴费"){
    		alert("该学生已缴费不能删除");
    		return;
    	}
    	if(confirm("是否确认删除"+courseName)){
    	$.ajax({
		url:'deleteStCourse.html',
		type:'POST',
		data:{
			'id':stuCourseId
		},
		dataType:'json',
		success:function(data){
			//window.location.href='toEdit.html';
			if(data!="success"){
				alert("删除课程失败!");
				window.location.href='selectStuCourseByStudentId.html?id='+studentId;
			}else{
				window.location.href='selectStuCourseByStudentId.html?id='+studentId;
			};
			
			//console.log(data);
		}
		});
    	}
    	
    }
    function showPayCard(studentId){
    	var payCondition = $("#studentPayCondition").text();
    	if(payCondition=="未缴费"){
    		alert("该学生未缴费不能打印凭证");
    		return;
    	}
    window.location.href='toShowPayCard.html?studentId='+studentId;
    }
    function showClassCard(studentId){
    var payCondition = $("#studentPayCondition").text();
    var sing = "student"; 
    //alert(payCondition)
    if(payCondition=="未缴费"){
    		alert("该学生未缴费不能查看听课证");
    		return;
    	}
    window.location.href='showClassCard.html?studentId='+studentId+'&sing='+sing;
    }
    function getPayState(courseId,stuCourseId){
    	var payState=$("#payState option:selected").val();
    	var studentId = $("#studentId").val();
    	if(payState=="已退费"){
    		if(confirm("是否确认退费")){
    			$.ajax({
		url:'changePayState.html',
		type:'POST',
		data:{
			'studentId':studentId,
			'courseId':courseId,
			'payState':payState,
			'stuCourseId':stuCourseId
		},
		dataType:'json',
		success:function(data){
			//window.location.href='toEdit.html';
			if(data!="success"){
				//alert("删除课程失败!");
				//window.location.href='selectStuCourseByStudentId.html?id='+studentId;
			}else{
				//window.location.href='selectStuCourseByStudentId.html?id='+studentId;
			};
			
			//console.log(data);
					}
				});
    		}
    	}
    	
    }
    </script>
</head>
<body>

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
                        
                        <li><a href="student.html">学生中心</a></li>
                        
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
                        <strong>学生中心</strong><div class="leftbgbt2">
                        </div>
                    </div>
                    <div class="cdlist">
                        <div><a href="#">学生管理</a></div>
                        <!--  <div><a href="stuCourse.html">学生课程</a></div>-->
                    </div>					                                                                                            
                </div>
            </div>
            <div class="rightbox">
                
    <h2 class="mbx">
        学生中心 &gt; 课程管理</h2>
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
        		<td><a href="toAddStuCourse.html?studentId=${student.id}"><button>添加课程</button></a></td>        		
        		<td><button onclick="showClassCard('${student.id}')">打印听课证</button></td>
        	</tr>
        </table>       		     
        </div>
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tbody>
                <tr style="height: 25px" align="center">
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
                    <th scope="col">
                        	缴费状态
                    </th>
                    <th scope="col">
                       	 操作
                    </th>
                </tr>
                <tr align="center"><td colspan="8"><c:if test="${empty stuCourseList}">无数据请添加</c:if></td></tr>
                <c:forEach items="${stuCourseList}" var ="li" varStatus="status">
                <tr align="center">
                    <td>
                        ${status.index+1}
                    </td>
                    <td>
                        ${li.course.gradeName}
                    </td>
                    <td>
                        ${li.course.subjectName}
                    </td>
                    <td>
                        <fmt:formatDate value="${li.course.startTime}"  pattern="yyyy-MM-dd" />
                    </td>
                    <td>
                       <fmt:formatDate value="${li.course.endTime}"  pattern="yyyy-MM-dd" /> 
                    </td>
                    <td>
                        ${li.course.period}
                    </td>
                    <td>
                        ${li.course.rates}元
                    </td>
                    <td>
                    ${li.payState}                   
                    </td>                    
                    <td>
                    <!--  <button onclick="showClassCard('${li.id}')">听课证</button>--><button  onclick="deleteStuCourse('${li.id}','${li.course.subjectName}')">删除</button>                        
                    </td>
                </tr>
                </c:forEach>                               
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
