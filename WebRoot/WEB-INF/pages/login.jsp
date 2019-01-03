<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
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
<title>用户登录</title>
<script type="text/javascript" src="Script/jquery-1.4.1.js"></script>

<!--  <script type="text/javascript" src="js/cookie_util.js"></script>
<script type="text/javascript" src="js/const.js"></script>-->
<script type="text/javascript" src="Script/log_in.js"></script>
<link rel="stylesheet" href="Style/login.css" />
<style type="text/css">
span{
width: 4em;
}
	.w2{
letter-spacing:2em; /*如果需要y个字两端对齐，则为(x-y)/(y-1),这里是（4-2）/(2-1)=2em */
 margin-right:-2em;/*同上*/
}
.w3{
letter-spacing:0.5em; /*如果需要y个字两端对齐，则为(x-y)/(y-1),这里是（4-3）/(3-1)=0.5em */
 margin-right:-0.5em;/*同上*/
}
body{
	background:  url(Images/Student/index/bg.gif) no-repeat fixed top;
}
</style>
</head>
<body>
<div><img src="Images/logoBig.jpg"/></div>
	<div class="global">
		<div class="log log_in" tabindex='-1' id='dl' style="text-align:justify;">
			<dl>
				<dt>
					<div class='header'>
						<h3>登&nbsp;录</h3>
					</div>
				</dt>
				<dt></dt>
				<dt>
					<div class='letter'>
						<span class="w3">用户名</span>：<input type="text" name="" id="count" tabindex='1' /> <span
							class="error" id="count_msg"></span>
					</div>
				</dt>
				<dt>
					<div class='letter'>
						<span class="w2">密码</span>：<input type="password" name="" id="password"
							tabindex='2' /> <span class="error" id="password_msg"></span>
					</div>
				</dt>
				<dt>
					<div>
						<input type="button" name="" id="login" value='&nbsp登&nbsp录&nbsp'
							tabindex='3' /> <input type="button" name="" id="clear"
							value='&nbsp重&nbsp置&nbsp' tabindex='4' />
						<!-- <input type="button" name="" id="sig_in" value='&nbsp注&nbsp册&nbsp'
							tabindex='4' />  -->
					</div>
				</dt>
			</dl>
		</div>
		<div class="sig sig_out" tabindex='-1' id='zc'
			style='visibility:visible;'>
			<dl>
				<dt>
					<div class='header'>
						<h3>注&nbsp;册</h3>
					</div>
				</dt>
				<dt></dt>
				<dt>
					<div class='letter'>
						用户名&nbsp;:&nbsp;<input type="text" name="" id="regist_username"
							tabindex='5' />
						<div class='warning' id='warning_1'>
							<span>该用户名不可用</span>
						</div>
					</div>
				</dt>
				<dt>
					<div class='letter'>
						密&nbsp;&nbsp;&nbsp;码:&nbsp;<input type="password" name=""
							id="regist_password" tabindex='7' />
						<div class='warning' id='warning_2'>
							<span>密码长度过短</span>
						</div>
					</div>
				</dt>
				<dt>
					<div class='password'>
						&nbsp;&nbsp;&nbsp;确认密码:&nbsp;<input type="password" name=""
							id="final_password" tabindex='8' />
						<div class='warning' id='warning_3'>
							<span>密码输入不一致</span>
						</div>
					</div>
				</dt>
				<dt>
					<div>
						<input type="button" name="" id="regist_button"
							value='&nbsp注&nbsp册&nbsp' tabindex='9' /> <input type="button"
							name="" id="back" value='&nbsp返&nbsp回&nbsp' tabindex='10' />
						<script type="text/javascript">
							function get(e) {
								return document.getElementById(e);
							}
							/*get('login').onclick = function() {
								var name = $("#count").val();
								var password =$("#password").val();
										$.ajax({								
											url : 'login.html',
											type : 'POST',
											data : {
												'name' : name,
												'password' : password
												
											},
											dataType : 'json',																						
											error : function() {
												alert("系统正在维护，请稍后访问。");
											}
										});

							}*/
							get('clear').onclick = function() {
								document.getElementById("password").value = "";
								document.getElementById("count").value = "";
							};
							//注册页面
							//get('sig_in').onclick = function() {
								//get('dl').className = 'log log_out';
								//get('zc').className = 'sig sig_in';
							//};
							//返回登录页面
							get('back').onclick = function() {
								get('zc').className = 'sig sig_out';
								get('dl').className = 'log log_in';
							};
							window.onload = function() {
								var t = setTimeout(
										"get('zc').style.visibility='visible'",
										800);
								get('final_password').onblur = function() {
									var npassword = get('regist_password').value;
									var fpassword = get('final_password').value;
									if (npassword != fpassword) {
										get('warning_3').style.display = 'block';
									}
								};
								get('regist_password').onblur = function() {
									var npassword = get('regist_password').value.length;
									if (npassword<6&&npassword>0) {
										get('warning_2').style.display = 'block';
									}
								};
								get('regist_password').onfocus = function() {
									get('warning_2').style.display = 'none';
								};
								get('final_password').onfocus = function() {
									get('warning_3').style.display = 'none';
								};
							};
						</script>
					</div>
				</dt>
			</dl>
		</div>
	</div>
</body>
</html>