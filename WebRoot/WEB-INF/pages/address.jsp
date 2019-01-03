<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>智仁学堂</title>
</head>
<link href="Style/css.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="css/parts.css" type="text/css">
<body>
	<div class="main">
		<div class="top"></div>
		<div class="menu">
			<li><a href="selectIncludeByType.html">首&nbsp;&nbsp;页</a></li>
			<li ><a href="aboutUs.html">关于智仁</a>
			</li>
			<li id=active><a href="address.html">联系我们</a>
			</li>
		</div>
		<div class="banner"></div>
		<div class="comm_m">
			<ul class="comm_left">
				<div id="leftmenu">
					<ul>
					</ul>
					<dt>
						<a href="#"><img src="Images/left_b.jpg"> </a>
					</dt>
				</div>

			</ul>
			<ul class="comm_right">
				<p>
					您当前所在位置:<a href="selectIncludeByType.html">首页</a>&gt;&gt;<a
						href="#">联系我们</a>
				</p>
				<div id="mainbr">

					<div id="stuffbox">

						<p align="center">
							<span style="font-size:20px;color:#666666;">欢迎来电咨询</span>
						</p>
						<p align="left">
							<span style="font-size:16px;color:#666666;">咨询电话：${sessionScope.address.phone}</span>
						</p>
						<p align="left">
							<span style="font-size:16px;color:#666666;">公司邮箱：${sessionScope.address.email}</span>
						</p>
						<p align="left">
							<span style="font-size:16px;color:#666666;">公司地址：${sessionScope.address.address}</span>
						</p>

					</div>
				</div>
		</div>
		</ul>

		<div class="clear"></div>

		<div class="footer">
			版权所有：天津智信培训有限公司 地址：${sessionScope.address.address}<br>
			咨询电话:${sessionScope.address.phone}
			E-mail：${sessionScope.address.email} <br> Copyright © 2018 All
			Rights Reserved
		</div>
	</div>

</body>
</html>
