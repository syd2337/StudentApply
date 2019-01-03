<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>智仁学堂</title>
<link href="Style/css.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div class=main>
   <div class=top>
  </div>
  <div class=menu>
     <li id=active><a href="#">首&nbsp; 页</a></li>
     <li ><a href="aboutUs.html" >关于智仁</a></li>
	<li ><a href="address.html" >联系我们</a></li>
  </div>
  <div class=banner>
  </div>
  <div class=index_m>
     <ul class=left>
       <div id="Language">
阅读能力培训　写作能力培训<br>
科学技术培训　逻辑思维培训<br>
文化艺术培训<br>
英语培训　礼仪培训　国学培训　<br>

	      </div>
     </ul>
     <ul class=mid>
        <div class="fllb">
			      <div class="menu1box">
			      <ul id="menu1">
				      <li class="hover" onMouseOver="setTab(1,0)"><b>公司动态</b></li>
				      <li onMouseOver="setTab(1,1)"><b>行业资讯</b></li>
				      
			      </ul>
			      </div>
           <div class="main1box">
			      <div id="main1">
				    <ul class="block"><li>
					    <div class="lsn">
						  <ol>
						  <c:forEach items="${companyList}" var ="li" varStatus="status">
						  <li><span>[<fmt:formatDate value="${li.createDate}" pattern="yyyy-MM-dd"/>]</span><a href="toNew.html?id=${li.id}">${li.title}</a></li>
						  </c:forEach>          					     
                 		</ol>
					    </div>
					  </li></ul>
				    <ul><li>
					    <div class="lsn">
						  <ol>
						  <c:forEach items="${tradeList}" var ="li" varStatus="status">
						  <li><span>[<fmt:formatDate value="${li.createDate}" pattern="yyyy-MM-dd"/>]</span><a href="toNew.html?id=${li.id}">${li.title}</a></li>
						  </c:forEach>                					    
                 		</ol>
					    </div>
				    </li></ul>
			  </div>
			</div>
		</div>
	 		<script>
			function setTab(m,n){
			var tli=document.getElementById("menu"+m).getElementsByTagName("li");
			var mli=document.getElementById("main"+m).getElementsByTagName("ul");
			for(i=0;i<tli.length;i++){
			   tli[i].className=i==n?"hover":"";
			   mli[i].style.display=i==n?"block":"none";
			}
			}
		</script>
		  
     </ul>
     <ul class=right>
       <div id="member">
       <div style="margin: 0 auto;"><a href="toLogin.html"><button style="width: 150px;height: 40px;margin-bottom: 10px;">用户登录</button></a></div>
       <div style="margin: 0 auto;"><a href="apply.html"><button style="width: 150px;height: 40px;">学生报名</button></a></div>
     </ul>
  </div>
  <div class=link style="display: none;">
     <ul>合作伙伴</ul>
     <a href="#" target="_blank"><img src="Images/s_20110720231658206.gif"  alt="中国翻译协会"></a><a href="#" target="_blank"><img src="Images/s_20110720233757787.gif"  alt="华研报告网"></a><a href="#" target="_blank"><img src="Images/s_20110720233958137.jpg"  alt="中国翻译人才网"></a><a href="#" target="_blank"><img src="Images/s_20110720234153504.gif"  alt="中国翻译家联盟"></a><a href="#" target="_blank"><img src="Images/s_20110720235305739.jpg"  alt="ciuti"></a><a href="#" target="_blank"><img src="Images/s_20110720235425941.jpg"  alt="interational"></a><a href="#" target="_blank"><img src="Images/s_20110720235535974.jpg"  alt="外文出版社"></a>  
   </div>
		<div class="footer">
			版权所有：天津智信培训有限公司 地址：${sessionScope.address.address}<br>
			咨询电话:${sessionScope.address.phone}
			E-mail：${sessionScope.address.email} <br> Copyright © 2018 All
			Rights Reserved
		</div>
	</div>
</body>
</html>