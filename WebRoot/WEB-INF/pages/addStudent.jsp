<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
<link href="Style/radio.css" rel="stylesheet" type="text/css" />
    <script src="Script/jBox/jquery-1.4.2.min.js" type="text/javascript"></script>
    <script src="Script/jBox/jquery.jBox-2.3.min.js" type="text/javascript"></script>
    <script src="Script/jBox/i18n/jquery.jBox-zh-CN.js" type="text/javascript"></script>
    <script src="Script/Common.js" type="text/javascript"></script>
    <script src="Script/Data.js" type="text/javascript"></script>
    <script src="Script/index.js"></script>
    <script src="Script/prefixfree.min.js"></script>
    <script src="Script/modernizr.js"></script>
    <script  type="text/javascript" src="My97DatePicker/WdatePicker.js"></script>
    <script type="text/javascript" src="Script/log_in.js"></script>
    <script src="Script/chosen.jquery.js" type="text/javascript"></script>
	<!--  <script src="Script/prism.js" type="text/javascript" charset="utf-8"></script>-->
  	<link rel="stylesheet" href="Style/chosen.css"/>
  	<script type="text/javascript"></script>   
	<script type="text/javascript">
	function changeGrade(){
		$("#prices").val(0);
		var campusName=$("#campusName option:selected").val(); //获取选中的项
		var gradeName=$("#gradeName option:selected").val();
		alert(campusName+gradeName)
		if(gradeName!="Unselected"){
			$.ajax({
		url:'toApplyStuCourse.html',
		type:'POST',
		data:{
			'gradeName':gradeName,
			'campusName':campusName		
		},
		dataType:'json',
		success:function(data){
		
			$("#wrapper").empty();
				if (data == null) {
					alert("该年级无课程");
				} else {
					var content = "<tr style='height: 25px' align='center'>"
                	+"<th scope='col'></th>"
                    +"<th scope='col'>科目名称</th><th scope='col'>课程时长</th>"
                    +"<th scope='col'>课程资费</th><th scope='col'>课程次数</th>"
                    +"<th scope='col'>课时</th></tr>";				
					var list = data;
					//alert(list1);
					for ( var i = 0; i < list.length; i++) {																		
						content = content
								+ '<tr align="center">'
								+ '<td><input type="checkbox" name="text_box" class="text_box" value=\''+list[i].id+'\' onclick="selectCourse(this,\''+list[i].rates+'\',\''+list[i].theClass+'\')"/></td>'					
								+ '<td>'+list[i].subjectName+'</td>'
								+ '<td>'+list[i].period+'</td>'
								+ '<td>'+list[i].rates +'</td>'
								+ '<td>'+list[i].times +'次</td>'
								+ '<td>'+list[i].theClass +'</td>'															
								//+ '"onclick="selectScore(\'' + subject+'\')"/></td>' 
								+ '</tr>';
					}				      
					$("#wrapper").append(content);
				}
		}
	});
		}
	}
	function selectCourse(checkbox,rates,theClass){
		var val=$("#prices").val();
		if(val==""){
			val=0;
		}
		var price=parseInt(rates)*parseInt(theClass);
		if(checkbox.checked==true){
			val=parseInt(val)+price;
		}else{
			if(val>=price){
				val=parseInt(val)-price;
			}
		}
          $("#prices").val(val);
	}
    function addStudent(){
    var gradeName=$("#gradeName option:selected").val();
    var schoolName=$(".chosen-select option:selected").val();
    var campusName=$("#campusName option:selected").val(); //获取选中的项
    var parentName=$("#parentName").val();
    var phoneNumOne=$("#phoneNumOne").val();
    var payCondition=$("#payCondition option:selected").val();
    var name=$("#name").val();
    var sex = $("input[name='sex']:checked").val();
    var prices = $("#prices").val();
			if (name == '') {
				alert("学生姓名不能为空");
				//$('#name_msg').empty().append("不能空");
				return;
			}
			var reg = /^[\u4e00-\u9fa5 ]{2,10}$/;
			if (!reg.test(name)) {
				alert("请输入正确的学生姓名");
				return;
			}
			if (parentName == '') {
				alert("家长姓名不能为空");
				//$('#name_msg').empty().append("不能空");
				return;
			}
			if (!reg.test(parentName)) {
				alert("请输入正确的家长姓名");
				return;
			}
			
			if (phoneNumOne == '') {
				alert("联系电话不为空");
					//$('#ID_msg').empty().append("不能空");
					return;
				}
				var reg = /^(13[0-9]|14[0-9]|15[0-9]|16[0-9]|18[0-9]|17[0-9]|19[0-9])\d{8}$/;
				if (!reg.test(phoneNumOne)) {
					alert("请输入正确的联系电话");
					//$('#ID_msg').empty().append("请输入正确的手机号");
					return;
				}
    if(gradeName=="Unselected"){
    	alert("请选择年级");
    	return;
    }
    if(schoolName=="Unselected"){
    	alert("请选择学校");
    	return;
    }
    if(campusName=="Unselected"){
    	alert("请选择校区");
    	return;
    }
    var obj = document.getElementsByName("text_box");
    var courseList = [];
    for(k in obj){
        if(obj[k].checked)
            courseList.push(obj[k].value);
    }
    if(courseList.length==0){
    	alert("请选择至少一门课程！");
    	return;
    }
    
    	$.ajax({
		url:'addStudent.html',
		type:'POST',
		data:{
			'gradeName':gradeName,
			'schoolName':schoolName,
			'campusName':campusName,
			'parentName':parentName,
			'phoneNumOne':phoneNumOne,
			'name':name,
			'sex':sex,
			'courseList':courseList,
			'payCondition':payCondition,
			'prices':prices
		},
		dataType:'json',
		traditional: true,//属性在这里设置
		success:function(data){
			//window.location.href='toEdit.html';
			if(data==null){
				alert("添加学生失败!");
			}else if(data=="student"){
				alert("该学生已存在");
			}else{
				//window.location.href='student.html';
				window.location.href='singleStudent.html?name='+name+'&phoneNum='+phoneNumOne;
			};
			
			//console.log(data);
		}
	});
    }
    /*function changePayCondition(){
    	var payCondition=$("#payCondition option:selected").val();
    	var prices = $("#prices").val();
    	if(payCondition=="已缴费"){
    	if(prices==0||prices==""){
    		alert("该学生未缴费")
    		return;
    	}
    	var r=confirm("是否打印收款凭证")
  			if (r==true){
   				document.write("You pressed OK!")
             }
    	} 
    }*/
</script>
<style type="text/css">
    .txtinput1{width:180px;}
</style>
<style type="text/css" media="all">

    /* fix rtl for demo */

    .chosen-rtl .chosen-drop { left: -9000px; }

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
                
<h2 class="mbx">学生管理 &gt;添加学生 </h2>
<div class="cztable">
<table border="0" cellspacing="0" cellpadding="0" width="500px" style="margin:30px auto 0px auto;">
	<tr align="center">
        <th style="width:20%; text-align:left;">学生姓名：</th>
        <td style="width:70%; text-align:left;"><input id="name" value="" type="text" class="input_2 txtinput1"  /></td>
    </tr>
    <tr align="center">
        <th style="width:20%; text-align:left;">学生性别：</th>
        <td style="width:70%; text-align:left;">
        	<input id="nan" name="sex" value="男" type="radio" checked="checked" />男
        	<input id="nv" name="sex" value="女" type="radio"/>女  
        </td>
    </tr>
    <tr align="center">
        <th style="width:20%; text-align:left;">家长姓名：</th>
        <td style="width:70%; text-align:left;"><input id="parentName" value="" type="text" class="input_2 txtinput1"  /></td>
    </tr>
    <tr align="center">
        <th style="width:20%; text-align:left;">联系电话：</th>
        <td style="width:70%; text-align:left;"><input id="phoneNumOne" value="" type="text" class="input_2 txtinput1" maxlength="11" /></td>
    </tr>
    <tr align="center">
        <th style="width:20%; text-align:left;">学校名称：</th>
        <td style="width:70%; text-align:left;">
        <select data-placeholder="选择一个学校" class="chosen-select"  tabindex="2" style="width:180px;">
            <option value="Unselected"></option>
            <c:forEach items="${schoolList}" var ="li" varStatus="status">
                    	<option value="${li.name}">${li.name}</option>
            </c:forEach>
        </select>
        	<!--  <select id="schoolName" name="schoolName">
                    <option value="Unselected">请选择</option>
                    <c:forEach items="${schoolList}" var ="li" varStatus="status">
                    	<option value="${li.name}">${li.name}</option>
                    </c:forEach>                              
             </select> -->
        </td>
    </tr>
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
        	<select id="gradeName" name="gradeName" onchange="changeGrade()">
                    <option value="Unselected">请选择</option>
                    <c:forEach items="${gradeList}" var ="li" varStatus="status">
                    	<option value="${li.name}">${li.name}</option>
                    </c:forEach>                              
             </select>
        </td>
    </tr>    
    <!--  <tr align="center">
        <th style="width:20%; text-align:left;">确认新密码：</th>
        <td style="width:70%; text-align:left;"><input id="txtConfirmNewPwd" value="" type="password" class="input_2 txtinput1" /></td>
    </tr>-->
    
</table>
<table border="0" cellspacing="0" cellpadding="0" width="500px" style="margin:30px auto 0px auto;" id="wrapper"></table>
<table border="0" cellspacing="0" cellpadding="0" width="500px" style="margin:30px auto 0px auto;">
	<tr align="center">	
        <th style="width:20%; text-align:left;">费用总计：</th>
        <td style="width:70%; text-align:left;">       	
            <input type="text" value="" id="prices">元                                          
        </td>
    </tr>
	<tr align="center">	
        <th style="width:20%; text-align:left;">缴费状态：</th>
        <td style="width:70%; text-align:left;">       	
            <select id="payCondition" name="payCondition" onchange="changePayCondition()">
                    <option value="未缴费">未缴费</option>
                    <option value="已缴费">已缴费</option>                              
             </select>                                           
        </td>
    </tr>
    <tr>
    <td colspan="2" style="text-align:center;"><input type="submit" id="btnSubmit" value="确认添加" onclick="addStudent()" class="input2" /></td>
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
<script type="text/javascript">

    var config = {

      '.chosen-select'           : {},

      '.chosen-select-deselect'  : {allow_single_deselect:true},

      '.chosen-select-no-single' : {disable_search_threshold:10},

      '.chosen-select-no-results': {no_results_text:'Oops, nothing found!'},

      '.chosen-select-width'     : {width:"95%"}

    }

    for (var selector in config) {

      $(selector).chosen(config[selector]);

    }

  </script>
</html>

