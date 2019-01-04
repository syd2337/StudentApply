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
    <script src="Script/tabs.js" type="text/javascript"></script>
    <script src="Script/test.js" type="text/javascript"></script>
    <script type="text/javascript" src="Script/log_in.js"></script>
    <script src="Script/chosen.jquery.js" type="text/javascript"></script>
  	<link rel="stylesheet" href="Style/chosen.css" />
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
    	.Wdate{
    		width: 135px;
    	}
    	/*#checkStudent{
    		margin-left: 185px;
    	}*/
    	.chzn-single{
    		margin-bottom: -10px;
    	}
    </style>      
    <script src="Script/Base.js" type="text/javascript"></script>
    <script language="javascript" type="text/javascript">
    $(document).keydown(function(event){ 
	if(event.keyCode == 13){ //绑定回车 
	$('#checkStudent').click(); 
		} 
	}); 

    function deleteStudent(studentId,studentName,payCondition){
    	if(payCondition=="已缴费"){
      	alert("该学生已缴费不能删除");
      	return;
      	}
    	if(confirm("是否确认删除"+studentName)){
    	$.ajax({
		url:'deleteStudent.html',
		type:'POST',
		data:{
			'id':studentId
		},
		dataType:'json',
		success:function(data){
			//window.location.href='toEdit.html';
			if(data!="success"){
				alert("删除学生失败!");
				window.location.href='student.html';
			}else{
				window.location.href='student.html';
			};
			
			//console.log(data);
		}
	});
    	}
    	
    }
    function selectStudent (){
    var gradeName=$("#gradeName option:selected").val();
    var schoolName=$(".chosen-select option:selected").val();
    var campusName=$("#campusName option:selected").val(); //获取选中的项
    var payCondition=$("#payCondition option:selected").val();
    //var parentName=$("#parentName").val();
    var phoneNumOne=$("#phoneNumOne").val();
    var name=$("#name").val();
    var sex = $("input[name='sex']:checked").val();
    var createDate=$("#createDate").val();
    var subjectName=$("#subjectName option:selected").val();
    if(sex==undefined){
    
    	sex='';
    }
    //alert(stratTime+endTime)
    window.location.href='selectStudentDynamicNew.html?gradeName='+gradeName+'&schoolName='+schoolName+'&campusName='+campusName+'&payCondition='+payCondition+'&phoneNumOne='+phoneNumOne+'&name='+name+'&sex='+sex+'&createDate='+createDate+'&subjectName='+subjectName;
    	
    }
    function toUpdateStudent(studentId,payCondition){
    var payCondition=payCondition;
    var id = studentId;
      
      	window.location.href='toUpdateStudent.html?id='+id;
      
    }
    function checkGreaterStuCourse(){
    	var theGreaterNum = $("#greaterCourse").val();
    	var reg = /^[0-9]{1,2}$/;
    	if (!reg.test(theGreaterNum)) {
				alert("请输入正确的数字");
				return;
			}
		if (theGreaterNum == '') {
			alert("数字不能为空");
				//$('#name_msg').empty().append("不能空");
			return;
			}
		window.location.href='checkGreaterStuCourse.html?theGreaterNum='+theGreaterNum;
    }
    function checkApplyNum(){
    	var applyNum = $("#applyNum").val();
    	var reg = /^[0-9]{8}$/;
    	if (!reg.test(applyNum)) {
				alert("请输入正确的数字");
				return;
			}
		if (applyNum == '') {
			alert("数字不能为空");
				//$('#name_msg').empty().append("不能空");
			return;
			}
		window.location.href='checkapplyNum.html?applyNum='+applyNum;
    }
    function checkStuCourseBySubjectName(){
    	var subjectName = $("#subjectName").val();
		if (subjectName == '') {
			alert("科目不能为空");
				//$('#name_msg').empty().append("不能空");
			return;
			}
		window.location.href='checkStuCourseBySubjectName.html?subjectName='+subjectName;
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
       学生中心 &gt; 学生管理</h2>
    <div class="morebt">
        <ul>
        	<li><a class="tab1" href="student.html">学生管理</a></li>
             <!--<li><a class="tab2" href="stuCourse.html">学生课程</a></li>
            <li><a class="tab2" href="grade.html">年级管理</a></li>
            <li><a class="tab2" href="subject.html">科目管理</a></li>-->
            
        </ul>
    </div>
    
    <div class="cztable">
       
        
        	学校：<select data-placeholder="选择一个学校" class="chosen-select"  tabindex="2" style="width: 139px;">
                    <option value=""></option>
                    <c:forEach items="${schoolList}" var ="li" varStatus="status">
                    	<option value="${li.name}">${li.name}</option>
                    </c:forEach>                              
        		</select> 
       		 校区：<select id="campusName" name="campusName" >
                    <!--  <option value=""></option>-->
                    <c:forEach items="${campusList}" var ="li" varStatus="status">
                    	<option value="${li.campusName}">${li.campusName}</option>
                    </c:forEach>                              
        		</select>     
        	年级：<select id="gradeName" name="gradeName" >
                    <option value=""></option>
                    <c:forEach items="${gradeList}" var ="li" varStatus="status">
                    	<option value="${li.name}">${li.name}</option>
                    </c:forEach>                              
        		</select>
        	姓名：<input id="name" value="" type="text" class="input_2 txtinput1" style="width: 131px;"/>
        	性别：<input id="nan" name="sex" value="男" type="radio"/>男
        		<input id="nv" name="sex" value="女" type="radio"/>女 <br />
        	
        	<div style="margin-top: 4px;"></div>
        	电话：<input id="phoneNumOne" value="" type="text" class="input_2 txtinput1" style="width: 131px;" />
        	 缴费：<select id="payCondition" name="payCondition" >
                    <option value=""></option>
                    <option value="已缴费">已缴费</option>
                    <option value="未缴费">未缴费</option>
                    <option value="已退费">已退费</option>                                                 
        		</select>
        	科目：<select id="subjectName" name="subjectName" >
                    <option value="${subjectName}"></option>
                    <c:forEach items="${subjectList}" var ="li" varStatus="status">
                    	<option value="${li.name}">${li.name}</option>
                    </c:forEach>                              
        		</select>
        	时间：<input id="createDate"  value='<fmt:formatDate value="${student.createDate}" pattern="yyyy-MM-dd"/>' class="Wdate" type="text" onclick="WdatePicker({el:this,dateFmt:'yyyy-MM-dd'})"/>                    
        	<button id="checkStudent" onclick="selectStudent()">查询</button><a href="toAddStudent.html"><button>添加</button></a>
        	<div style="margin-top: 4px;"></div>
        	<!--  学生报名课程大于：<input id="greaterCourse" value="${theGreaterNum}" maxlength="2" placeholder="只能输入数字" style="width: 100px;"/>&nbsp;&nbsp;科&nbsp;&nbsp;<button id="checkGreaterStuCourse" onclick="checkGreaterStuCourse()">查询</button>-->
        	<!--  科目查询：<select id="subjectName" name="subjectName" >
                    <option value="${subjectName}"></option>
                    <c:forEach items="${subjectList}" var ="li" varStatus="status">
                    	<option value="${li.name}">${li.name}</option>
                    </c:forEach>                              
        		</select>
        		<button id="checkStuCourseBySubjectName" onclick="checkStuCourseBySubjectName()">查询</button>-->
        	<!--  报名号查询：<input id="applyNum" value="${theApplyNum}" maxlength="8" placeholder="只能输入数字" style="width: 100px;"/><button  onclick="checkApplyNum()">查询</button>-->
        	<button id="Button1" onclick="method1('ta')" value="导出" style="margin-left: 752px;">导出</button>        	     
        
        <table id="ta" width="100%" border="0" cellspacing="0" cellpadding="0">
            <tbody>
                <tr style="height: 25px" align="center">
                    <th scope="col">
                       	 编号
                    </th>
                    <th scope="col">
                        	学籍号
                    </th>
                    <th scope="col">
                        	姓名
                    </th>
                    <th scope="col">
                        	性别
                    </th>
                    <th scope="col">
                        	报名号
                    </th>
                    <th scope="col">
                        	电话
                    </th>
                    <th scope="col">
                        	学校
                    </th>
                    <th scope="col">
                        	校区
                    </th>
                    <th scope="col">
                        	年级
                    </th>
                    <th scope="col">
                        	缴费情况
                    </th>
                    <th scope="col">
                        	报名时间
                    </th>
                    <th scope="col">
                       	 操作
                    </th>
                </tr>
                <tr align="center"><td colspan="12"><c:if test="${empty studentList}">无数据请添加</c:if></td></tr>
                <c:forEach items="${studentList}" var ="li" varStatus="status">
                <tr align="center">
                    <td>
                        ${status.index+1}
                    </td>
                    <td>
                        ${li.studentCode}
                    </td>
                    <td>
                        <a href="selectStuCourseByStudentId.html?id=${li.id}">${li.name}</a>
                    </td>
                    <td>
                        ${li.sex}
                    </td>
                    <td>
                        ${li.applyNum}
                    </td>
                    <td>
                        ${li.phoneNumOne}
                    </td>
                    <td>
                        ${li.schoolName}
                    </td>
                    <td>
                        ${li.campusName}
                    </td>
                    <td>
                        ${li.gradeName}
                    </td>
                    <td>
                        ${li.payCondition}
                    </td>
                    <td>
                        <fmt:formatDate value="${li.createDate}"  pattern="yyyy-MM-dd" />
                    </td>        
                    <td>
                    <button onclick="toUpdateStudent('${li.id}','${li.payCondition}')">修改</button><button  onclick="deleteStudent('${li.id}','${li.name}','${li.payCondition}')">删除</button>                        
                    </td>
                </tr>
                </c:forEach>                               
            </tbody>
        </table>
        <div class='MainStyle'>
        	<div class=''>
        		<a onclick="theFir()">首页</a>
        	</div>
        	<div class=''>
        		<a onclick="up()">上一页</a>
        	</div>
        	<div class=''><span id="pageNo">${pageNo}</span>/<span id="totalPage">${totalPage}</span></div>
        	<div class=''>
        		<a onclick="down()">下一页</a>
        	</div>
        	<div class=''>
        		<a onclick="theEnd()">尾页</a>
        	</div>
        </div>
    </div>
	
            </div>
        
        <div class="footer">
            <p>
                &copy;copyright 2018 智仁学堂      版权所有 </p>
        </div>
    </div>
    </div>
</body>
<script type="text/javascript">
    var config = {

      '.chosen-select'           : {},

      '.chosen-select-deselect'  : {allow_single_deselect:true},

      '.chosen-select-no-single' : {disable_search_threshold:10},

      '.chosen-select-no-results': {no_results_text:'Oops, nothing found!'},

      '.chosen-select-width'     : {width:"95%"}

    };

    for (var selector in config) {

      $(selector).chosen(config[selector]);

    }
  </script>
</html>
