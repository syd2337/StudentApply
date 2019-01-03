<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
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
    <script type="text/javascript" src="Script/jquery.qrcode.min.js"></script>
    <script type="text/javascript" src="Script/jquery.jqprint-0.3.js"></script>
    <script type="text/javascript" src="Script/html2canvas.js"></script>
<script language="javascript">
function preview(oper)
{
if (oper < 10){
bdhtml=window.document.body.innerHTML;//获取当前页的html代码
sprnstr="<!--startprint"+oper+"-->";//设置打印开始区域
eprnstr="<!--endprint"+oper+"-->";//设置打印结束区域
prnhtml=bdhtml.substring(bdhtml.indexOf(sprnstr)+18); //从开始代码向后取html
prnhtml=prnhtml.substring(0,prnhtml.indexOf(eprnstr));//从结束代码向前取html
window.document.body.innerHTML=prnhtml;
window.print();
window.document.body.innerHTML=bdhtml;
} else {
window.print();
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
        	<li><a class="tab1" href="student.html">学生管理</a></li>
             <!--<li><a class="tab2" href="stuCourse.html">学生课程</a></li>
             <li><a class="tab2" href="grade.html">年级管理</a></li>
            <li><a class="tab2" href="subject.html">科目管理</a></li>-->
            
        </ul>
    </div>
    
    <div id="code">
    <!--startprint1-->

		<!--打印内容开始-->
		<div id=sty>
        <div class="tis">
        
        <table width="100%" border="1" cellspacing="0" cellpadding="0">
        <tr align="center" style="height: 50px;"><td colspan="4"><span style="font-size: 30px">智仁教育(天津)收款凭证</span></td></tr>
        	<tr align="center" style="height: 20px;">
        		<td> 姓名：<span id="studentName">${student.name}</span></td>
        		<td> 性别：<span id="studentSex">${student.sex}</span></td>
        		<td> 报名时间：<span id="createDate"><fmt:formatDate value="${student.createDate}"  pattern="yyyy-MM-dd" /></span></td>
        		<td></td>
        	</tr>
        	<tr align="center" style="height: 20px;">
        		<td> 学校：<span id="studentSchoolName">${student.schoolName}</span></td>
        		<td> 校区：<span id="studenCampustName">${student.campusName}</span></td>
        		 <td> 学籍：<span id="studentCode">${student.studentCode}</span></td>
        		 <td></td>
        	</tr>     	
        	<tr align="center" style="height: 20px;">
        		<td>培训课程</td>
        		<td>课程次数</td>
        		<td>课时</td>
        		<td>金额</td>     		
        	</tr>
        	<c:forEach items="${showStuCourse}" var ="li" varStatus="status">
        		<tr align="center" style="height: 20px;">
        		<td>${li.course.subjectName}</td>
        		<td>${li.course.times}次</td>
        		<td>${li.course.theClass}</td>
        		<td>${li.course.rates}X${li.course.theClass}</td>     		
        	</tr>
        	</c:forEach>
        	<tr align="center" style="height: 20px;">
        		<td colspan="4">总计金额：${student.prices}元</td>
        	</tr>
        	<tr align="center" style="height: 20px;">
        		<td></td><td></td><td colspan="2">家长签字：</td>
        	</tr>
        </table>       		     
        </div>
        </div>
	<!--打印内容结束-->
		
	<!--endprint1-->       
    </div>

    
	<div align="center"><input type=button name='button_export' title='打印1' onclick="preview(1)" value=打印凭证><a href="selectStuCourseByStudentId.html?id=${student.id}"><button >返回</button></a></div>
            </div>
        </div>
        <div class="footer">
            <p>
                &copy;copyright 2018 智仁学堂      版权所有 </p>
        </div>
    </div>
  </body>
</html>
