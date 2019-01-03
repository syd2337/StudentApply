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
    function showMsg(msg, obj) {
        jBox.tip(msg);
        $("#" + obj).focus();
    }        
   	function saveClick(includeId) {
        var Ctitle = $("#Ctitle").val();   //消息标题
        if (Ctitle == "" || Ctitle.length>20) {
            showMsg("请您输入消息标题,且不超过20个字！", "Ctitle");
            return false;
        }
        var Ctype = $("#Ctype").val();
        //消息类型
        if (Ctype == ("Unselected")) {
            showMsg("请您选择类型！", "Ctype");
            return false;
        }
        var Ccontent = $("#Ccontent").val(); //消息内容
        
        if (Ccontent == "" || Ccontent.length>300) {
            showMsg("请您输入消息内容，且不超过300个字！", "Ccontent");
            return false;
        }
        $.ajax({
		url:'updateInclude.html',
		type:'POST',
		data:{
			'title':Ctitle,
			'titleType':Ctype,
			'content':Ccontent,
			'includeId':includeId
		},
		dataType:'json',
		success:function(data){
		
			//window.location.href='toEdit.html';
			if(data==null){
				alert("添加信息失败!");
			}else{
				window.location.href='include.html';
			}
			
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
                   
                    ${sessionScope.user.name}，欢迎您！s
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
                
   <h2 class="mbx">新闻管理 &gt; 添加新闻</h2>
    <div class="morebt">
        <ul>
            <li><a class="tab1" href="grade.html">新闻管理</a></li>                    
        </ul>
    </div>
    <div class="cztable">
       

    <table width="100%" cellpadding="0" cellspacing="0">
        <tr>
            <td width="15%" align="right"><div align="right">信息主题： </div></td>
            <td><input id="Ctitle" size="20" name="Ctitle" class="input_2" value="${include.title}"/></td>
        </tr>
        <tr>
            <td width="15%" align="right"><div align="right">信息类型： </div></td>
            <td>
                <select id="Ctype" name="Ctype">
                    <option value="${include.titleType}">${include.titleType}</option>
                    <option value="公司动态">公司动态</option>
                    <option value="行业资讯">行业资讯</option>                            
                </select>
            </td>
        </tr>
        <tr>
            <td width="15%" align="right"><div align="right">信息内容： </div></td>
            <td><textarea name="Ccontent" cols="80" rows="5" id="Ccontent" class="input_2" >${include.content}</textarea></td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <div align="center" >
                    <input type="submit" value="提交" onclick="saveClick('${include.id}')" class="input2" />
                    <a href="include.html"><input type="submit" value="返回"  class="input2" /></a>
                </div>
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
