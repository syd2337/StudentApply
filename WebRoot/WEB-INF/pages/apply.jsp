<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!doctype html>
<html lang="zh">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>学生报名</title>
<link rel="stylesheet" type="text/css" href="Style/styles.css">
</head>
<body>
	<div class="htmleaf-container">
		<div class="wrapper">
			<div class="container">
				<h1>学生报名</h1>
				<form class="form" action="studentApplyNameAndPhone.html"
					method="get" onSubmit="return beforeSubmit(this);">
					<input name="name" type="text" placeholder="姓名" value=""> <input
						name="phoneNum" type="text" maxlength="11" placeholder="报名电话" value="">
					<div>
						<button type="submit" id="login-button">登录</button>
					</div>
				</form>
				<div>
					<a href="toAddStudent.html?student=student"><button>报名</button>
					</a>
				</div>
			</div>

			<!--  <ul class="bg-bubbles">
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
		</ul>-->
		</div>
	</div>

	<script src="Script/jquery-1.4.1.js" type="text/javascript"></script>
	<script>
		function apply() {
			var name = $("#name").val();
			var password = $("#password").val();

			alert(name);
			window.location.href = 'studentApplyNameAndPhone.html?name=' + name
					+ '&phoneNum=' + password;
		}
		function beforeSubmit(form) {
			if (form.name.value == '') {
				alert('姓名不能为空！');
				form.name.focus();
				return false;
			}
			var reg = /^[\u4e00-\u9fa5 ]{2,10}$/;
			if (!reg.test(form.name.value)) {
				alert("请输入正确的学生姓名");
				form.name.focus();
				return false;
			}
			if (form.phoneNum.value == '') {
				alert('报名电话不能为空！');
				form.phoneNum.focus();
				return false;
			}
			var reg = /^(13[0-9]|14[0-9]|15[0-9]|16[0-9]|18[0-9]|17[0-9]|19[0-9])\d{8}$/;
			if (!reg.test(form.phoneNum.value)) {
					alert("请输入正确的报名电话");
					form.phoneNum.focus();
					//$('#ID_msg').empty().append("请输入正确的手机号");
					return false;
				}
			return true;
		}
	</script>

</body>
</html>
