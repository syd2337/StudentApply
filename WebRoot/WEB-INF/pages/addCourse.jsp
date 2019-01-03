<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>



<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
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
    <script  type="text/javascript" src="My97DatePicker/WdatePicker.js"></script>
    <script type="text/javascript" src="Script/log_in.js"></script>   
<script type="text/javascript">
    function addCourse(){
    var gradeName=$("#gradeName option:selected").val();
    var subjectName=$("#subjectName option:selected").val(); //获取选中的项
    var startTime=$("#startTime").val();
    var endTime=$("#endTime").val();
    var period=$("#period").val();
    var rates=$("#rates").val();
    var times =$("#times").val();
    var theClass = $("#theClass").val();
    var campusName = $("#campusName option:selected").val();
    //alert(startTime+endTime+campusName);
    if(campusName=="Unselected"){
    	alert("请选择校区");
    	return;
    }
    if(gradeName=="Unselected"){
    	alert("请选择年级");
    	return;
    }
    if(subjectName=="Unselected"){
    	alert("请选择科目");
    	return;
    }
    if(startTime==""){
    	alert("请填写开始时间");
    	return;
    }
    if(endTime==""){
    	alert("请填写结束时间");
    	return;
    }
    if(period==""){
    	alert("请填写课程时长");
    	return;
    }
    var reg = /^([0-9]|1[0-9]|2[0-3]):[0-5][0-9]-([0-9]|1[0-9]|2[0-3]):[0-5][0-9]$/;
	if (!reg.test(period)) {
		alert("请填写正确的课程时长");
		return;
	}
    if(rates==""){
    	alert("请填写课程资费");
    	return;
    }
    if(times==""){
    	alert("请填写课程次数");
    	return;
    }
    if(theClass==""){
    	alert("请填写课时");
    	return;
    }
    	$.ajax({
		url:'addCourse.html',
		type:'POST',
		data:{
			'gradeName':gradeName,
			'subjectName':subjectName,
			'startTime':startTime,
			'endTime':endTime,
			'period':period,
			'rates':rates,
			'times':times,
			'theClass':theClass,
			'campusName':campusName
		},
		dataType:'json',
		success:function(data){
			//window.location.href='toEdit.html';
			if(data==null){
				alert("添加课程失败!");
			}else{
				window.location.href='course.html';
			};
			
			//console.log(data);
		}
	});
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
                
<h2 class="mbx">课程管理 &gt;添加课程 </h2>
<div class="cztable">
<table border="0" cellspacing="0" cellpadding="0" width="500px" style="margin:30px auto 0px auto;">
     <tr align="center">
        <th style="width:20%; text-align:left;">校区名称：</th>
        <td style="width:70%; text-align:left;">
        	<select id="campusName" name="campusName">
                    <option value="Unselected">请选择</option>
                    <c:forEach items="${campusList}" var ="li" varStatus="status">
                    	<option value="${li.campusName}">${li.campusName}</option>
                    </c:forEach>                              
             </select>
        </td>
    </tr>
    <tr align="center">
        <th style="width:20%; text-align:left;">年级名称：</th>
        <td style="width:70%; text-align:left;">
        	<select id="gradeName" name="gradeName">
                    <option value="Unselected">请选择</option>
                    <c:forEach items="${gradeList}" var ="li" varStatus="status">
                    	<option value="${li.name}">${li.name}</option>
                    </c:forEach>                              
             </select>
        </td>
    </tr>
     <tr align="center">
        <th style="width:20%; text-align:left;">科目名称：</th>
        <td style="width:70%; text-align:left;">
        	<select id="subjectName" name="subjectName">
                    <option value="Unselected">请选择</option>
                    <c:forEach items="${subjectList}" var ="li" varStatus="status">
                    	<option value="${li.name}">${li.name}</option>
                    </c:forEach>                              
             </select>
        </td>
    </tr>    
    <tr align="center">
        <th style="width:20%; text-align:left;">开始时间：</th>
        <td style="width:70%; text-align:left;"><input id="startTime"  value="" class="Wdate" type="text" onclick="WdatePicker({el:this,dateFmt:'yyyy-MM-dd'})"/></td>
    </tr>
    <tr align="center">
        <th style="width:20%; text-align:left;">结束时间：</th>
        <td style="width:70%; text-align:left;"><input id="endTime"  value="" class="Wdate" type="text" onclick="WdatePicker({el:this,dateFmt:'yyyy-MM-dd'})"/></td>
    </tr>
    <tr align="center">
        <th style="width:20%; text-align:left;">课程时长：</th>
        <td style="width:70%; text-align:left;"><input id="period" value="" type="text" class="input_2 txtinput1"  placeholder="例如08:00-18:00"/></td>
    </tr>
    <tr align="center">
        <th style="width:20%; text-align:left;">课程资费：</th>
        <td style="width:70%; text-align:left;"><input id="rates" value="" type="text" class="input_2 txtinput1" />/小时</td>
    </tr>
    <tr align="center">
        <th style="width:20%; text-align:left;">课程次数：</th>
        <td style="width:70%; text-align:left;"><input id="times" value="" type="text" class="input_2 txtinput1" />次</td>
    </tr>
    <tr align="center">
        <th style="width:20%; text-align:left;">课时：</th>
        <td style="width:70%; text-align:left;"><input id="theClass" value="" type="text" class="input_2 txtinput1" /></td>
    </tr>
    <!--  <tr align="center">
        <th style="width:20%; text-align:left;">确认新密码：</th>
        <td style="width:70%; text-align:left;"><input id="txtConfirmNewPwd" value="" type="password" class="input_2 txtinput1" /></td>
    </tr>-->
    <tr>
    <td colspan="2" style="text-align:center;"><input type="submit" id="btnSubmit" value="确认添加" onclick="addCourse()" class="input2" /></td>
    </tr>
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

