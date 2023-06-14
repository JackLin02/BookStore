<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Free Company会員登録ページ</title>
		<%@ include file="/WEB-INF/include/base.jsp" %>
		<style type="text/css">
			body {
			overflow: hidden;
			}

			* {
				margin: 0;
				font-family:"Microsoft Yahei";
				color: #666;
			}

			div{
				margin: auto;
				margin-bottom: 10px;
				margin-top: 10px;

			}

			#header {
				height: 82px;
				width: 1200px;
			}

			#main {
				height: 460px;
				width: 1200px;
				border: 1px black solid;
				overflow: auto;
			}

			#bottom {
				height: 30px;
				width: 1200px;
				text-align: center;
			}

			#book{
				width: 100%;
				height: 90%;
				margin: auto;

			}

			.b_list{
				height:300px;
				width:250px;
				margin: 20px;
				float: left;
				margin-top:0px;
				margin-bottom:0px;
				border: 1px #e3e3e3 solid;
			}

			#page_nav{
				width: 100%;
				height: 10px;
				margin: auto;

				text-align: center;
			}

			#pn_input {
				width: 30px;
				text-align: center;
			}

			.img_div{
				height: 150px;
				text-align: center;
			}

			.book_img {
				height:150px;
				width:150px;
			}

			.book_info {

				text-align: center;
			}

			.book_info div{
				height: 10px;
				width: 300px;
				text-align: left;
			}

			.wel_word{
				font-size: 60px;
				float: left;
			}

			.logo_img{
				float: left;
				width: 258px;
				height: 82px;
			}

			#header div a {
				text-decoration: none;
				font-size: 20px;
			}

			#header div{
				float: right;
				margin-top: 55px;
			}

			.book_cond{
				margin-left: 500px;
			}

			.book_cond input{
				width: 50px;
				text-align: center;
			}

			#login_header{
				height: 82px;
				width: 1200px;
			}

			.login_banner{
				height:475px;
				background-color: #2196F3;
			}

			.login_form{
				height:310px;
				width:406px;
				float: right;
				margin-right:50px;
				margin-top: 50px;
				background-color: #fff;
			}

			#content {
				height: 475px;
				width: 1200px;
			}

			.login_box{
				margin: 20px;
				height: 260px;
				width: 366px;
			}

			h1 {
				font-size: 20px;
			}
			.msg_cont{
				background: none repeat scroll 0 0 #fff6d2;
			    border: 1px solid #ffe57d;
			    color: #666;
			    height: 18px;
			    line-height: 18px;
			    padding: 3px 10px 3px 40px;
			    position: relative;
			    border: none;
			}

			.msg_cont b {
				background: url("../img/pwd-icons-new.png") no-repeat scroll -104px -22px rgba(0, 0, 0, 0);
			    display: block;
			    height: 17px;
			    left: 10px;
			    margin-top: -8px;
			    overflow: hidden;
			    position: absolute;
			    top: 50%;
			    width: 16px;
			}

			.form .itxt {
			    border: 0 none;
			    float: none;
			    font-family: "宋体";
			    font-size: 14px;
			    height: 18px;
			    line-height: 18px;
			    overflow: hidden;
			    padding: 10px 0 10px 10px;
			    width: 220px;
			    border: 1px #e3e3e3 solid;
			}

			#sub_btn{
				background-color: #39987c;
				border: none;
				color: #fff;
				width: 360px;
				height: 40px;
			}

			#l_content {
				float: left;
				margin-top: 150px;
				margin-left: 300px;
			}

			#l_content span {
				font-size: 60px;
				color: white;
			}

			.tit h1 {
				float: left;
				margin-top: 5px;
			}

			.tit a {
				float: right;
				margin-left: 10px;
				margin-top: 10px;
				color: red;
				text-decoration: none;
			}

			.tit .errorMsg {
				float: right;
				margin-left: 10px;
				margin-top: 10px;
				color: red;
			}

			.tit {
				height: 30px;
			}

			#main table{
				margin: auto;
				margin-top: 80px;
				border-collapse: collapse;
			}

			#main table td{
				width: 120px;
				text-align:center;
				border-bottom: 1px #e3e3e3 solid;
				padding: 10px;
			}

			.cart_info{
				width: 700px;
				text-align: right;
			}

			.cart_span {
				margin-left: 20px;
			}

			.cart_span span{
				color: red;
				font-size: 20px;
				margin: 10px;
			}

			.cart_span a , td a{
				font-size: 20px;
				color: blue;
			}

			#header div span {
				margin: 10px;
			}

			#header div .um_span{
				color: red;
				font-size: 25px;
				margin: 10px;
			}

			#header div a {
				color: blue;
			}
		</style>

		<script type="text/javascript">
		$(function(){
			$("#sub_btn").click(function(){

				var uname = $("#username").val();
				var regUName = /^\w{6,12}$/;

				if(regUName.test(uname) == false){
					$(".errorMsg").text("ユーザー名はポリシーに満たさない！").css("color","red");
					return false;
				}

				var pwd = $("#password").val();
				var regPWd = /^[a-zA-Z0-9_-]{6,12}$/;
				if(regPWd.test(pwd) == false){
					$(".errorMsg").text("パスワードはポリシーに満たさない！").css("color","red");
					return false;
				}

				var repwd = $("#repwd").val();
				if(repwd != pwd){
					$(".errorMsg").text("二回入力したパスワードは不一致です！").css("color","red");
					return false;
				}

				var email = $("#email").val();
				var regEmail = /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
				if(!regEmail.test(email)){
					$(".errorMsg").text("メールアドレスはポリシーに満たさない！").css("color","red");
					return false;
				}

				var code = $("#code").val();
				if(code == null || "" == code){
					$(".errorMsg").text("検証コードが入力されていない！").css("color","red");
					return false;
				}
			});

			$("#codeImg").click(function(){
				$(this).attr("src","code.jpg?random="+Math.random());
			});

			$("#username").change(function(){

				var uname = $(this).val();

				$.get("UserServlet?method=checkUserName",{"uname":uname},function(msg){
					if($.trim(msg) == "true"){
						$(".errorMsg").html("ユーザー名がすでに存在しています、別のユーザー名を入力してください！").css("color","red");
					}else {
						$(".errorMsg").html("入力されたユーザー名は有効です！").css("color","green");
					}
				});
			});
		});
		</script>
		<style type="text/css">
			.login_form{
				height:420px;
				margin-top: 25px;
			}
		</style>
	</head>
	<body>
		<div id="login_header">
			<img class="logo_img" alt="" src="static/img/logo.jpg" >
		</div>

			<div class="login_banner">

				<div id="l_content">
					<span class="login_word">登録にようこそ</span>
				</div>

				<div id="content">
					<div class="login_form">
						<div class="login_box">
							<div class="tit">
								<h1>Free Company会員に登録する</h1>
								<span class="errorMsg">${requestScope.msg}</span>
							</div>
							<div class="form">
								<form action="UserServlet?method=regist" method="post">
									<label>username：</label>
									<input value="${param.username}" class="itxt" type="text" placeholder="ユーザー名を入力してください" autocomplete="off" tabindex="1" name="username" id="username" />
									<br />
									<br />
									<label>password：</label>
									<input class="itxt" type="password" placeholder="パスワードを入力してください" autocomplete="off" tabindex="1" name="password" id="password" />
									<br />
									<br />
									<label>repassword：</label>
									<input class="itxt" type="password" placeholder="パスワードを再入力" autocomplete="off" tabindex="1" name="repwd" id="repwd" />
									<br />
									<br />
									<label>email：</label>
									<input value="${param.email}" class="itxt" type="text" placeholder="メールアドレスを入力する" autocomplete="off" tabindex="1" name="email" id="email" />
									<br />
									<br />
									<label>validate：</label>
									<input class="itxt inp" type="text" style="width: 140px;" name="code" id="code"/>
									<img id="codeImg" alt="" src="code.jpg" style="float: right; margin-right: 40px; width: 80px; height: 40px;">
									<br />
									<br />
									<input type="submit" value="登録" id="sub_btn" />

								</form>
							</div>

						</div>
					</div>
				</div>
			</div>
		<div id="bottom">
			<span>
				Free Company.Copyright &copy;2023
			</span>
		</div>
</body>
</html>