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
    <style type="text/css">
    	  @media screen
          {
              #canvas
              {
                 display: block;
             }
             #image
            {
                 display: none;
             }
         }
         @media print
         {
             #canvas
             {
                 display: none;
             }
             #image
             {
                 display: block;
             }
         }
         .classTable{
         	width:80%;
         	border: 1px solid #151515
         }
         tr{
         	height: 30px;
         }
    </style>
    <script type="text/javascript">
    		function printById(id) {
			html2canvas(document.getElementById(id), {
			allowTaint : true,
			taintTest : false,
			onrendered : function(canvas) {
				canvas.id = "mycanvas";
				//document.body.appendChild(canvas);
				//生成base64图片数据
				var dataUrl = canvas.toDataURL();
				var newImg = document.createElement("img");
				newImg.src = dataUrl;
				/* document.body.appendChild(newImg);  */
				/* window.open(newImg.src); */
			  	var printWindow = window.open(newImg.src);
	      	 		// printWindow.document.write(); 
	      			 printWindow.document.write('<img src="'+newImg.src+'" />')
	         		 printWindow.print();
			}
		});
	}
    </script>
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
				
		function print(){
         var img = document.getElementById("image"); /// get image element
         var canvas  = document.getElementsByTagName("canvas")[0];  /// get canvas element
         img.src = canvas.toDataURL();                     /// update image
        
         $("#image").jqprint({
            debug:false,
           importCSS:true,
             printContainer:true,
            operaSupport:false
        });
     }
		function encode(){
         $("#code").html('');
         //var str=$('#txt').val();
         var str="阿凡提拉放空管"
         str=toUtf8(str);
         //$('#code').qrcode(str);
         $("#code").qrcode({ 
             render: "canvas", //table方式
             width: 100, //宽度
             height:100, //高度
             text: str //任意内容
         });
     }
     
     function toUtf8(str) {
         var out, i, len, c;
         out = "";
         len = str.length;
         for(i = 0; i < len; i++) {
             c = str.charCodeAt(i);
            if ((c >= 0x0001) && (c <= 0x007F)) {
                 out += str.charAt(i);
             } else if (c > 0x07FF) {
                 out += String.fromCharCode(0xE0 | ((c >> 12) & 0x0F));
                out += String.fromCharCode(0x80 | ((c >>  6) & 0x3F));
                 out += String.fromCharCode(0x80 | ((c >>  0) & 0x3F));
             } else {
                 out += String.fromCharCode(0xC0 | ((c >>  6) & 0x1F));
                 out += String.fromCharCode(0x80 | ((c >>  0) & 0x3F));
             }
         }
         return out;
     }
	jQuery(function(){
			
		//jQuery('#output').qrcode("http://www.jq22.com");
		$("#output").html('');
         //var str=$('#txt').val();
         var str = $("#studentId").val();
         //var str="afgfdagf";
         str=toUtf8(str);
         //$('#code').qrcode(str);
         $("#output").qrcode({ 
             render: "canvas", //table方式
             width: 100, //宽度
             height:100, //高度
             text: str //任意内容
         });
        

				})
	function a(){ 
	var img = document.getElementById("image"); /// get image element
         var canvas  = document.getElementsByTagName("canvas")[0];  /// get canvas element
         img.src = canvas.toDataURL();                     /// update image
	$("#code").jqprint();
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
                        <div><a href="student.html">学生管理</a></div>
                        <!--  <div><a href="stuCourse.html">学生课程</a></div>-->
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
        
        <table class="classTable">
        <tr align="center">
        <td><img src="Images/Student/logo.gif"></td>
        <td></td>
        <td rowspan="3">
        		<input type="hidden" value="${student.id}" id="studentId"/>
        		<div id="output"></div><img id="image" src="" />
        </td>
        </tr>
        <tr align="center">
        	<td></td>
        	<td><span style="font-size: 30px;font-family:楷体;color: red;">听课证</span></td>
        	<td></td>
        </tr>
         <tr align="center" ><td colspan="3"></td></tr>
        <tr align="center"><td colspan="3"><hr width="90%"></td></tr>
        <tr align="center" style="height: 20px;">
        		<td> 姓名：<span id="studentName">${student.name}</span></td>
        		<td> 性别：<span id="studentSex">${student.sex}</span></td>
        		<td> 报名时间：<span id="createDate"><fmt:formatDate value="${student.createDate}"  pattern="yyyy-MM-dd" /></span></td>
        	</tr>
        	<tr align="center" style="height: 20px;">
        		<td> 学校：<span id="studentSchoolName">${student.schoolName}</span></td>
        		<td> 校区：<span id="studenCampustName">${student.campusName}</span></td>
        		 <td> 学籍：<span id="studentCode">${student.studentCode}</span></td>
        	</tr>   
        <tr align="center"><td colspan="3"><hr width="90%"></td></tr>
        <c:forEach items="${showStuCourse}" var ="li" varStatus="status">
        		<tr align="center" style="height: 20px;">
        		<td>${li.course.gradeName}${li.course.subjectName}</td>
        		<td><fmt:formatDate value="${li.course.startTime}"  pattern="yyyy年MM月dd日" />起</td>
        		<td>${li.course.times}次课</td>     		
        	</tr>
        </c:forEach>
        <tr align="center"><td colspan="3"><hr width="90%"></td></tr>
        <tr><td colspan="3"><span>注：如有临时停课、倒课等情况，将以电话、微信等形式提前通知家长学员。</span></td></tr>
        </table>       		     
        </div>
        </div>
	<!--打印内容结束-->
		
	<!--endprint1-->       
    </div>

    
	<div align="center" style="width: 80%;"><input type=button name='button_export' title='打印1' onclick="a();" value=打印听课证></div>
            </div>
        </div>
        <div class="footer">
            <p>
                &copy;copyright 2018 智仁学堂      版权所有 </p>
        </div>
    </div>
  </body>
</html>
