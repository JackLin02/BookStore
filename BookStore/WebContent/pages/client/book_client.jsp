<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ブックストアホームページ</title>
<%@ include file="/WEB-INF/include/base.jsp" %>
<style>
	h1 {
		text-align: center;
		margin-top: 200px;
	}

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
		$("#sub_page").click(function(){
			var pageNo = $("#pn_input").val();
			var min = $("input[name='min']").val();
			var max = $("input[name='max']").val();
			location = "BookClientServlet?method=getBooksByPageAndPrice&pageNo="+pageNo
					+"&min="+min+"&max="+max;
		});

		$(".book_cond :button").click(function(){
			var pageNo = $("#pn_input").val();
			var min = $("input[name='min']").val();
			var max = $("input[name='max']").val();
			location = "BookClientServlet?method=getBooksByPageAndPrice&pageNo="+pageNo
					+"&min="+min+"&max="+max;
		});

		$(".book_add button").click(function(){
			var bookId = $(this).attr("id");
			location = "CartServlet?method=addBookToCart&bookId="+bookId;
		});
	});
</script>
</head>
<body>
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.jpg" >
			<span class="wel_word">オンラインブックストア</span>
			<div>
				<a href="pages/user/login.jsp">ログイン</a> |
				<a href="pages/user/regist.jsp">登録</a> &nbsp;&nbsp;
				<a href="pages/cart/cart.jsp">ショッピングカート</a>
				<a href="pages/manager/manager.jsp">データベースを管理する</a>
			</div>
	</div>

	<div id="main">
		<div id="book">
			<div class="book_cond">
				価格：<input id="min" type="text" name="min" value="${param.min}"> 円 -
					<input id="max" type="text" name="max" value="${param.max}"> 円
					<button>検索</button>
			</div>
			<div style="text-align: center">
				<c:if test="${not empty sessionScope.cart.totalCount && sessionScope.cart.totalCount != 0}">
					<span>あなたのショッピングカートに${sessionScope.cart.totalCount}件商品があります</span>
				</c:if>
				<div>
					<c:if test="${not empty sessionScope.title}">
						あなかは<span style="color: red">${sessionScope.title}</span>がショッピングカートに入れました
					</c:if>
					<c:remove var="title" scope="session"/>
					<c:if test="${not empty sessionScope.msg}">
						<span style="color: red">${sessionScope.msg}</span>
					</c:if>
					<c:remove var="msg" scope="session"/>
				</div>
			</div>
			<c:forEach items="${requestScope.page.list}" var="book">
				<div class="b_list">
				<div class="img_div">
					<img class="book_img" alt="" src="static/img/test1.jpg" />
				</div>
				<div class="book_info">
					<div class="book_name">
						<span class="sp1">名前：</span>
						<span class="sp2">${book.title}</span>
					</div>
					<div class="book_author">
						<span class="sp1">作者：</span>
						<span class="sp2">${book.author}</span>
					</div>
					<div class="book_price">
						<span class="sp1">価格：</span>
						<span class="sp2">${book.price}</span>
					</div>
					<div class="book_sales">
						<span class="sp1">販売量：</span>
						<span class="sp2">${book.sales}</span>
					</div>
					<div class="book_amount">
						<span class="sp1">在庫：</span>
						<span class="sp2">${book.stock}</span>
					</div>
					<div class="book_add">
						<button id="${book.id}">ショッピングカートに入れる</button>
					</div>
				</div>
			</div>
			</c:forEach>

		</div>

		<div id="page_nav">
		<c:choose>
			<c:when test="${page.totalPageNo<5}">
				<c:set var="begin" value="1"></c:set>
				<c:set var="end" value="${page.totalPageNo}"></c:set>
			</c:when>
			<c:when test="${page.pageNo<=3}">
				<c:set var="begin" value="1"></c:set>
				<c:set var="end" value="5"></c:set>
			</c:when>
			<c:when test="${page.pageNo>3 and page.pageNo <= page.totalPageNo-2}">
				<c:set var="begin" value="${page.pageNo-2}"></c:set>
				<c:set var="end" value="${page.pageNo+2}"></c:set>
			</c:when>
			<c:otherwise>
				<c:set var="begin" value="${page.totalPageNo-4}"></c:set>
				<c:set var="end" value="${page.totalPageNo}"></c:set>
			</c:otherwise>
		</c:choose>
		<c:forEach var="i" begin="${begin}" end="${end}" step="1">
			<c:if test="${page.pageNo == i}">
				【${i}】
			</c:if>
			<c:if test="${page.pageNo != i}">
				<a href="BookClientServlet?method=getBooksByPageAndPrice&pageNo=${i}&min=${param.min}&max=${param.max}">${i}</a>
			</c:if>
		</c:forEach>
		全部${requestScope.page.pageNo}/${requestScope.page.totalPageNo}ページ，${requestScope.page.totalRecord}条記録 から第<input value="${requestScope.page.pageNo}" name="pn" id="pn_input"/>ページ
			<input id="sub_page" type="button" value="確定">
		</div>

	</div>

	<div id="bottom">
		<span>
			Free Company.Copyright &copy;2023
		</span>
	</div>
</body>
</html>