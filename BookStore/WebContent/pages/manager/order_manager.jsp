<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>オーダー管理</title>
<%@ include file="/WEB-INF/include/base.jsp" %>
<style>
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
		background-color: #39987c;
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
</head>
<body>

	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">オーダー管理システム</span>
			<%@ include file="/WEB-INF/include/header.jsp" %>
	</div>

	<div id="main">
		<table>
			<tr>
				<td>日付</td>
				<td>金額</td>
				<td>詳細</td>
				<td>出荷</td>

			</tr>
			<tr>
				<td>2015.04.23</td>
				<td>90.00</td>
				<td><a href="#">詳細を見る</a></td>
				<td><a href="#">出荷する</a></td>
			</tr>

			<tr>
				<td>2015.04.20</td>
				<td>20.00</td>
				<td><a href="#">詳細を見る</a></td>
				<td>出荷済み</td>
			</tr>

			<tr>
				<td>2014.01.23</td>
				<td>190.00</td>
				<td><a href="#">詳細を見る</a></td>
				<td>商品届きを確認する</td>
			</tr>
		</table>
	</div>

	<div id="bottom">
		<span> Free Company.Copyright &copy;2023 </span>
	</div>
</body>
</html>