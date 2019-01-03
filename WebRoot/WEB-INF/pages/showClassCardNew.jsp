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
         	margin-top:-20px;
         	width:60%;
         	border: 1px solid #151515;
         	font-family: '楷体';
         	
         }
         .classTable1{
         	margin-top:-20px;
         	width:60%;
         	
         	font-family: '楷体';
         	
         }
         tr{
         	height: 30px;
         }
         .right{
         	margin-left: 50%;
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
				
		function print1(){
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
         var str="阿凡提拉放空管";
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
             width: 110, //宽度
             height:110, //高度
             text: str //任意内容
         });
        

				})
	function a(){ 
	var img = document.getElementById("image"); /// get image element
         var canvas  = document.getElementsByTagName("canvas")[0];  /// get canvas element
         img.src = canvas.toDataURL();                     /// update image
	$("#code").jqprint();
	}
	function  printTable(){
          $("#code1").jqprint({
              debug: false,            
              importCSS: true,         
              printContainer: true,    
              operaSupport: false  
          });
      }
</script>
  </head>
  
  <body> 
    <div id="code">
    

		<!--打印内容开始-->
		<div id=sty>
        <div class="tis" style="font-family: 楷体;">
        <table class="classTable" style="margin-top:-75px; font-family: 楷体; margin-left: 140px;font-size: 14px;">
        <tr align="center">
        <td><!--  <img src="Images/Student/logo.gif">--></td>
        <td></td>
        <td>
        		<input type="hidden" value="${student.id}" id="studentId"/>
        		<div id="output"></div><img id="image" src="" /><span style="font-size: 18px;margin-left: 10px;font-weight: bold;">${student.name}</span>
        		
        </td>
        </tr>
        </table>       		     
        </div>
        </div>
	<!--打印内容结束-->
	</div>  
	<div align="center" style="width: 60%;">
	<input type=button name='button_export' title='打印1' onclick="a();" value=打印二维码>
	<a href="selectStuCourseByStudentId.html?id=${student.id}"><button >返回</button></a></div>      
  </body>
</html>
