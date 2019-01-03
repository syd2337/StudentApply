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
</title>
    <script src="Script/jBox/jquery-1.4.2.min.js" type="text/javascript"></script>	
    <style type="text/css">
         .classTable{
         	margin-top:110px;
         	width:100%;
         	
         	font-family: '楷体';
         	
         }
         .classTable1{
         	margin-top:10px;
         	width:100%;
         	
         	font-family: '楷体';
         	
         }
         tr{
         	height: 30px;
         }
         .right{
         	margin-left: 50%;
         }
         
    </style>
    <style type="text/css" media="all">
            
             @media print {
                .no-print { display: none; }
                .page-break { page-break-after: always; }
            }
        </style>
    		
<script language="javascript">
	function preview(oper){
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
	<!--startprint1-->
	<div id="code1">
	<!--打印内容开始-->
		<div id=sty>
        <div class="tis" style="font-family: 楷体;">
        <table class="classTable" style="font-family: 楷体; font-size: 15px;">
        <tr align="left" style="height: 40px;">
        	<td></td>
        	<td><!--  <span style="font-size: 30px;font-family:楷体;color: red;">听课证</span>--></td>
        	<td></td>
        </tr>
         <tr align="left" ><td colspan="3"></td></tr>
        <!--  <tr align="center"><td colspan="3"><hr width="90%"></td></tr>-->
        <tr align="left" style="height: 20px;">
        		<td style="width: 28%;"> 姓名：<span id="studentName">${student.name}</span></td>
        		<td style="width: 31%;"> 性别：<span id="studentSex">${student.sex}</span></td>
        		<td style="width: 41%;"> 报名时间：<span id="createDate"><fmt:formatDate value="${student.createDate}"  pattern="yyyy-MM-dd" /></span></td>
        	</tr>
        	<tr align="left" style="height: 20px;">
        		<td> 学校：<span id="studentSchoolName">${student.schoolName}</span></td>
        		<td> 校区：<span id="studenCampustName">${student.campusName}</span></td>
        		 <td>学籍：<span id="studentCode">${student.studentCode}</span></td>
        	</tr>   
        <!--  <tr align="center"><td colspan="3"><hr width="90%"></td></tr>-->
        <tr align="left" style="height: 20px;">
        	<td></td>
        	<td><!--  <span style="font-size: 30px;font-family:楷体;color: red;">听课证</span>--></td>
        	<td></td>
        </tr>
        </table>
        <table class="classTable1">
        <c:forEach items="${showStuCourse}" var ="li" varStatus="status">
        		<tr align="left" style="height: 20px;font-size: 18px;">
        		<td style="width: 30%;">${li.course.gradeName}${li.course.subjectName}</td>
        		<td style="width: 38%;"><fmt:formatDate value="${li.course.startTime}"  pattern="yyyy-MM-dd" />起</td>
        		<td style="width: 20%;">${li.course.times}次课</td>     		
        	</tr>
        </c:forEach>
        <!--  <tr align="center"><td colspan="3"><hr width="90%"></td></tr>-->
        <!--  <tr><td colspan="3"><span>注：如有临时停课、倒课等情况，将以电话、微信等形式提前通知家长学员。</span></td></tr>-->
        </table>       		     
        </div>
        </div>
	<!--打印内容结束-->
		
	<!--endprint1-->       
    </div>

    
	<div align="center" style="width: 60%;" class="no-print">
	<input type=button name='button_export' title='打印1' onClick="window.print()" value=打印听课证>
	<a href="selectStuCourseByStudentId.html?id=${student.id}"><button >返回</button></a></div>      
  </body>
</html>
