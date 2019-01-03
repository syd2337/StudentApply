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
    	select{
    		width: 137px;
    		
    		
    	}
    	#gradeName{
    	margin-left: 4px;
    	}
    	#checkCourse{
    	margin-left: 292px;
    	}
    	.Wdate{
    		width: 135px;
    	}
    </style>       
    <script src="Script/Base.js" type="text/javascript"></script>
    <script language="javascript" type="text/javascript">                
    function deleteCampus(courseId,gradeName,subjectName){
    	if(confirm("是否确认删除"+gradeName+subjectName)){
    	$.ajax({
		url:'deleteCourse.html',
		type:'POST',
		data:{
			'id':courseId
		},
		dataType:'json',
		success:function(data){
			//window.location.href='toEdit.html';
			if(data!="success"){
				alert("删除课程失败!");
				window.location.href='course.html';
			}else{
				window.location.href='course.html';
			};
			
			//console.log(data);
		}
	});
    	}
    	
    }
    function selectCourse (){
    var gradeName=$("#gradeName option:selected").val();
    var subjectName=$("#subjectName option:selected").val(); //获取选中的项
    var startTime=$("#startTime").val();
    var endTime=$("#endTime").val();
    var period=$("#period").val();
    var rates=$("#rates").val();
    //alert(stratTime+endTime)
    window.location.href='selectCourseDynamic.html?gradeName='+gradeName+'&subjectName='+subjectName+'&startTime='+startTime+'&endTime='+endTime+'&period='+period+'&rates='+rates;
    	
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
        课程中心 &gt; 课程管理</h2>
    <div class="morebt">
        <ul>
        	<li><a class="tab1" href="course.html">课程管理</a></li>
            <!--  <li><a class="tab1" href="campus.html">校区管理</a></li>
            <li><a class="tab2" href="grade.html">年级管理</a></li>
            <li><a class="tab2" href="subject.html">科目管理</a></li>-->
            
        </ul>
    </div>
    <div class="cztable">
        <div class="tis">
        
        			<span style="letter-spacing:1em;margin-right:-1em;">年级：</span><select id="gradeName" name="gradeName" >
                    <option value="${course.gradeName}">${course.gradeName}</option>
                    <c:forEach items="${gradeList}" var ="li" varStatus="status">
                    	<option value="${li.name}">${li.name}</option>
                    </c:forEach>                              
        				</select>
        	
        			<span style="letter-spacing:1em;margin-right:-1em;"> 科目：</span><select id="subjectName" name="subjectName" >
                    <option value="${course.subjectName}">${course.subjectName}</option>
                    <c:forEach items="${subjectList}" var ="li" varStatus="status">
                    	<option value="${li.name}">${li.name}</option>
                    </c:forEach>                              
        		</select>
        		
        			开始时间：<input id="startTime"  value='<fmt:formatDate value="${course.startTime}" pattern="yyyy-MM-dd"/>' class="Wdate" type="text" onclick="WdatePicker({el:this,dateFmt:'yyyy-MM-dd'})"/>
        		
        			结束时间：<input id="endTime"  value='<fmt:formatDate value="${course.endTime}" pattern="yyyy-MM-dd"/>' class="Wdate" type="text" onclick="WdatePicker({el:this,dateFmt:'yyyy-MM-dd'})"/><br />
        		<div style="margin-top: 4px;"></div>
        		课程时长：  <input id="period" value="${course.period}" type="text" class="input_2 txtinput1"  placeholder="例如08:00-18:00"/>
        		课程资费：<input id="rates" value="${course.rates}" type="text" class="input_2 txtinput1" />&nbsp;&nbsp;元
        		<button id="checkCourse" onclick="selectCourse()">查询</button>
        		<a href="toAddCourse.html"><button>添加</button></a>
        	             		        	        		        	     
        </div>
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tbody>
                <tr style="height: 25px" align="center">
                    <th scope="col">
                       	 编号
                    </th>
                    <th scope="col">
                        	校区
                    </th>
                    <th scope="col">
                        	年级
                    </th>
                    <th scope="col">
                        	科目
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
                        	课程次数
                    </th>
                    <th scope="col">
                        	课时
                    </th>
                    <th scope="col">
                       	 操作
                    </th>
                </tr>
                <tr align="center"><td colspan="8"><c:if test="${empty courseList}">无数据请添加</c:if></td></tr>
                <c:forEach items="${courseList}" var ="li" varStatus="status">
                <tr align="center">
                    <td>
                        ${status.index+1}
                    </td>
                    <td>
                        ${li.campusName}
                    </td>
                    <td>
                        ${li.gradeName}
                    </td>
                    <td>
                        <a href="getApplyStudent.html?id=${li.id}">${li.subjectName}</a>
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
                        ${li.rates}/小时
                    </td>
                    <td>
                        <a href="getTimes.html?id=${li.id}">${li.times}次</a>
                    </td>
                    <td>
                        <a>${li.theClass}</a>
                    </td>                   
                    <td>
                    <a href="toUpdateCourse.html?id=${li.id}"><button>修改</button></a><button  onclick="deleteCampus('${li.id}','${li.gradeName}','${li.subjectName}')">删除</button>                        
                    </td>
                </tr>
                </c:forEach>                               
            </tbody>
        </table>
        
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
