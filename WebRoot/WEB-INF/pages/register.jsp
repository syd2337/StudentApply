<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>



<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head><meta http-equiv="Content-Type" content="text/html; charset=utf-8" /><title>
	学生信息管理平台
</title><link href="Style/StudentStyle.css" rel="stylesheet" type="text/css" />
<link href="Script/jBox/Skins/Blue/jbox.css" rel="stylesheet" type="text/css" />
<link href="Style/ks.css" rel="stylesheet" type="text/css" />
    <script src="Script/jBox/jquery-1.4.2.min.js" type="text/javascript"></script>
    <script src="Script/jBox/jquery.jBox-2.3.min.js" type="text/javascript"></script>
    <script src="Script/jBox/i18n/jquery.jBox-zh-CN.js" type="text/javascript"></script>
    <script src="Script/Common.js" type="text/javascript"></script>
    <script src="Script/Data.js" type="text/javascript"></script>
    <script type="text/javascript" src="Script/log_in.js"></script>
    
<script type="text/javascript" language="javascript">
	function showCourse(courseId){
	var gradeName = "初一";
	var subjectName="历史";
		//alert(courseId);
		$.ajax({
			url:'showCourse.html',
			type:'POST',
			data:{
			'courseId':courseId
			},
			dataType:'json',
			success:function(data){
			//alert("+++++++++");
			$("#wrapper").empty();
				if (data == null) {
					alert("该年级无课程");
				} else {
					var content = "<tr style='height: 25px' align='center'>"
                	
                    +"<th scope='col'>编号</th><th scope='col'>姓名</th>"
                    +"<th scope='col'>年级</th><th scope='col'>科目</th></tr>";				
					var list = data;
					//alert(list1);
					//alert(list)
					
					for ( var i = 0; i < list.length; i++) {
					if(list[i].student!=null){																		
						content = content
								+ '<tr align="center">'
								+ '<td>'+(i+1)+'</td>'					
								
								+ '<td>'+list[i].student.name+'</td>'
								+ '<td>'+gradeName +'</td>'
								+ '<td>'+subjectName +'</td>'															
								//+ '"onclick="selectScore(\'' + subject+'\')"/></td>' 
								+ '</tr>';
					}
					}				      
					$("#wrapper").append(content);
				}
		}
		
		});
	}
    function register(){
    	var studentId = $("#studentId").val();
    	var student = $("#studentId");
    	//alert(stuCourseId.length)
    	//if(stuCourseId.length!=36){
    		//alert("不是正确编码")
    		//return;
    	//}
    	if(studentId.length==36){
    	$.ajax({
		url:'toRegister.html',
		type:'POST',
		data:{
			'studentId':studentId,
			
		},
		dataType:'json',
		success:function(data){
			//window.location.href='toEdit.html';
			if(data==null){
			var msg = new SpeechSynthesisUtterance("签到失败!");
    		window.speechSynthesis.speak(msg);
				alert("签到失败!");
				document.getElementById('studentId').value='';
				document.getElementById('studentId').focus();
			}else if(data=="repeat"){
			var msg = new SpeechSynthesisUtterance("请不要重复签到!");
    		window.speechSynthesis.speak(msg);
				alert("请不要重复签到!");
				document.getElementById('studentId').value='';
				document.getElementById('studentId').focus();
				
			}else if(data=="error"){
			var msg = new SpeechSynthesisUtterance("编码不正确!");
    		window.speechSynthesis.speak(msg);
				alert("编码不正确!");
				document.getElementById('studentId').value='';
				document.getElementById('studentId').focus();
			}else{
			var msg = new SpeechSynthesisUtterance("签到成功"+data.student.name+data.course.subjectName);
    		window.speechSynthesis.speak(msg);
				alert("签到成功"+data.student.name+data.course.subjectName);
				document.getElementById('studentId').value='';
				document.getElementById('studentId').focus();
				
			};
			
			//console.log(data);
		}
	});
		}
    }
</script>
<style type="text/css">
    .txtinput1{width:180px;}
</style>
</head>
<body onload="login('${sessionScope.user.name}')">

    <div class="banner">
        <div class="bgh">
            <div class="page">
                <div id="logo">
                    <a href="../../Index.aspx.html">
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
                
<h2 class="mbx">上课扫码 &gt;扫码管理 </h2>
<div class="cztable">
<c:if test="${!empty listCourseC1}">
<table border="0" cellspacing="0" cellpadding="0">
    <tr align="center">
        <th>初一</th>
        <c:forEach items="${listCourseC1}" var ="li" varStatus="status">
        <td><a onclick="showCourse('${li.id}')">${li.subjectName}</a></td>
        </c:forEach>   
    </tr>   
</table>
</c:if>
<c:if test="${!empty listCourseC2}">
<table border="0" cellspacing="0" cellpadding="0" >
    <tr align="center">
        <th>初二</th>
        <c:forEach items="${listCourseC2}" var ="li" varStatus="status">
        <td><a onclick="showCourse('${li.id}')">${li.subjectName}</a></td>
        </c:forEach>   
    </tr>   
</table>
</c:if>
<c:if test="${!empty listCourseC3}">
<table border="0" cellspacing="0" cellpadding="0" >
    <tr align="center">
        <th>初三</th>
        <c:forEach items="${listCourseC3}" var ="li" varStatus="status">
        <td><a onclick="showCourse('${li.id}')">${li.subjectName}</a></td>
        </c:forEach>   
    </tr>   
</table>
</c:if>
<c:if test="${!empty listCourseG1}">
<table border="0" cellspacing="0" cellpadding="0" >
    <tr align="center">
        <th>高一</th>
        <c:forEach items="${listCourseG1}" var ="li" varStatus="status">
        <td><a onclick="showCourse('${li.id}')">${li.subjectName}</a></td>
        </c:forEach>   
    </tr>   
</table>
</c:if>
<c:if test="${!empty listCourseG2}">
<table border="0" cellspacing="0" cellpadding="0" >
    <tr align="center">
        <th>高二</th>
        <c:forEach items="${listCourseG2}" var ="li" varStatus="status">
        <td><a onclick="showCourse('${li.id}')">${li.subjectName}</a></td>
        </c:forEach>   
    </tr>   
</table>
</c:if>
<c:if test="${!empty listCourseG3}">
<table border="0" cellspacing="0" cellpadding="0" >
    <tr align="center">
        <th>高三</th>
        <c:forEach items="${listCourseG3}" var ="li" varStatus="status">
        <td><a onclick="showCourse('${li.id}')">${li.subjectName}</a></td>
        </c:forEach>   
    </tr>   
</table>
</c:if>
<table border="0" cellspacing="0" cellpadding="0" >
    <tr align="center">
        <th style="width:20%; text-align:left;">上课编码：</th>
        <td style="width:70%; text-align:left;"><input id="studentId" value="" type="text" class="input_2 txtinput1" oninput="register();"/></td>
    </tr>
    <!--  <tr align="center">
        <th style="width:20%; text-align:left;">新密码：</th>
        <td style="width:70%; text-align:left;"><input id="txtNewPwd" value="" type="password" class="input_2 txtinput1" />&nbsp;&nbsp;6~16个字符，区分大小写</td>
    </tr>
    <tr align="center">
        <th style="width:20%; text-align:left;">确认新密码：</th>
        <td style="width:70%; text-align:left;"><input id="txtConfirmNewPwd" value="" type="password" class="input_2 txtinput1" /></td>
    </tr>-->  
</table>
<table id="wrapper">

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

