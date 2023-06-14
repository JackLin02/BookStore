<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<c:if test="${not empty sessionScope.user}">
	<div>
		<span>欢迎<span class="um_span">${sessionScope.user.username}</span>ようこそ、Free Company オンラインブックストア</span>
		<a href="pages/order/order.jsp">マイオーダー</a>
		<a href="pages/cart/cart.jsp">ショッピングカート</a>
		<a href="UserServlet?method=logout">ログアウト</a>&nbsp;&nbsp;
		<a href="index.jsp">戻る</a>
	</div>
</c:if>
<c:if test="${empty sessionScope.user}">
	<div>
		<a href="pages/user/login.jsp">ログイン</a>
		<a href="pages/user/regist.jsp">登録</a>&nbsp;&nbsp;
		<a href="pages/cart/cart.jsp">ショッピングカート</a>
		<a href="index.jsp">ログアウト</a>
		<a href="index.jsp">戻る</a>
	</div>
</c:if>