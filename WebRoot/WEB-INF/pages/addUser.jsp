<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
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
    
    function updateUser(userId){	
    	var id = userId;
    	var newSchoolName =$("#newSchoolName").val();
    	//alert(newSchoolName+schoolId);
    	
    	$.ajax({
		url:'updateSchool.html',
		type:'POST',
		data:{
			'newSchoolName':newSchoolName,
			'id':id,
		},
		dataType:'json',
		success:function(data){
		//alert(data);
			//window.location.href='toEdit.html';
			if(data!="success"){
				alert("修改学校失败!");
			}else{
				window.location.href='school.html';
			};//console.log(data);
		}
	});
    }
    function  addUser(access){
    var name = $("#name").val();
    var userName = $("#userName").val();
    var password = $("#password").val();
    var phone =$("#phone").val();
    var role=$("#role option:selected").val();
    var campusName=$("#campusName option:selected").val(); //获取选中的项
			if (name == '') {
				alert("姓名不能为空");
				//$('#name_msg').empty().append("不能空");
				return;
			}
			if (userName == '') {
				alert("账号不能为空");
				//$('#name_msg').empty().append("不能空");
				return;
			}
			if (password == '') {
				alert("密码不能为空");
				//$('#name_msg').empty().append("不能空");
				return;
			}
			var reg = /^[\u4e00-\u9fa5 ]{2,10}$/;
			if (!reg.test(name)) {
				alert("请输入正确的姓名");
				return;
			}
			if (phone == '') {
				alert("电话不为空");
					//$('#ID_msg').empty().append("不能空");
					return;
				}
				var reg = /^(13[0-9]|14[0-9]|15[0-9]|16[0-9]|18[0-9]|17[0-9]|19[0-9])\d{8}$/;
				if (!reg.test(phone)) {
					alert("请输入正确的电话");
					//$('#ID_msg').empty().append("请输入正确的手机号");
					return;
				}
    if(role!="超级管理员"&&campusName==""){
    	alert("请选择校区");
    	return;
    }
    	$.ajax({
		url:'addUser.html',
		type:'POST',
		data:{
			'name':name,
			'phone':phone,
			'userName':userName,
			'role':role,
			'campusName':campusName,
			'password':password
		},
		dataType:'json',
		traditional: true,//属性在这里设置
		success:function(data){
			//window.location.href='toEdit.html';
			if(data=="success"){
				alert("添加用户成功!");
			}else {
				alert("该加用户失败");
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
                
<h2 class="mbx">个人中心 &gt;添加用户 </h2>
<div class="cztable">
<table border="0" cellspacing="0" cellpadding="0" width="500px" style="margin:30px auto 0px auto;">
    <tr align="center">
        <th style="width:20%; text-align:left;">姓名：</th>
        <td style="width:70%; text-align:left;"><input id="name" value="" type="text" class="input_2 txtinput1" maxlength="11"/></td>
    </tr>
    <tr align="center">
        <th style="width:20%; text-align:left;">电话：</th>
        <td style="width:70%; text-align:left;"><input id="phone" value="" type="text" class="input_2 txtinput1" maxlength="11"/></td>
    </tr>
    <tr align="center">
        <th style="width:20%; text-align:left;">账号：</th>
        <td style="width:70%; text-align:left;"><input id="userName" value="" type="text" class="input_2 txtinput1" maxlength="11"/></td>
    </tr>
    <tr align="center">
        <th style="width:20%; text-align:left;">密码：</th>
        <td style="width:70%; text-align:left;"><input id="password" value="" type="text" class="input_2 txtinput1" maxlength="11"/></td>
    </tr>
    <tr align="center">
        <th style="width:20%; text-align:left;">权限：</th>
        <td style="width:70%; text-align:left;">
        <select id="role" name="role">
                    <option value="超级管理员">超级管理员</option>
                    <option value="校区管理员">校区管理员</option>
                    <option value="校区报名员">校区报名员</option>                               
             </select>
        </td>
    </tr>
    <tr align="center">
        <th style="width:20%; text-align:left;">校区：</th>
        <td style="width:70%; text-align:left;">
        <select id="campusName" name="campusName">
                    <option value="">请选择</option>
                    <c:forEach items="${listCampus}" var ="li" varStatus="status">
                    	<option value="${li.campusName}">${li.campusName}</option>
                    </c:forEach>                              
             </select>
        </td>
    </tr>
    <tr>
     <td colspan="2" style="text-align:center;">
    	<input type="submit" id="btnSubmit" value="添加用户" onclick="addUser()" class="input2" />
    </td>
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

