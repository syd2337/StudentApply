$(function() {
	
	$('#login').click(loginAction);
	/*$('#count').on('blur', checkName).on('focus', function() {
		$('#count_msg').empty();
	}).focus();
	$('#password').on('blur', checkPassword).on('focus', function() {
		$('#password_msg').empty();
	});*/
});

//检查姓名是否符合要求
function checkName() {
	var name = $("#count").val();
	if (name == '') {
		$('#count_msg').empty().append("不能空");
		return false;
	}
	var reg = /^\w{3,10}$/;
	if (reg.test(name)) {
		$('#count_msg').empty();
		return true;
	}
	$('#count_msg').empty().append("3-10位");
	return false;
}


//检查密码是否符要求
function checkPassword() {
	var password = $("#password").val();
	if (password == '') {
		$("#password_msg").empty().append("不能空");
		return false;
	}
	var reg = /^\w{3,10}$/;
	if (reg.test(password)) {
		$('#password_msg').empty();
		return true;
	}
	$('#password_msg').empty().append("3-10位");
	return false;

}

function loginAction() {

	var name = $('#count').val();
	var password = $('#password').val();

	var namePass = checkName();
	var pwdPass = checkPassword();
	if (!namePass || !pwdPass) {
		return false;
	}
	$.ajax({
		url:'login.html',
		type:'POST',
		data:{
			'name':name,
			'password':password
		},
		dataType:'json',
		success:function(data){
			//window.location.href='toEdit.html';
			if(data==null){
				alert("用户名或密码错误!");
			}else{
				window.location.href='home.html';
			};
			
			//console.log(data);
		}
	});
	//window.location.href = 'login.html?name='+ name+'&password='+password;
};

function login(userName){
	if(userName=="" || userName==null){
		//alert("您没有登录，请登录")
		//window.location.href='http://127.0.0.1:8080/StudentApply'
		window.location.href='toLogin.html'
	}
}