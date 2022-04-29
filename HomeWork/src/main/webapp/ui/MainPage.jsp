<%@ page language="java"
		contentType="text/html; charset=UTF-8"
		pageEncoding="UTF-8"%>

<html>
<head>
        <title>Главная страница</title>
</head>

<body>
 <p align="center"><font size="5" color="green">${param.success}</font></p>
       <h2 align="center"> Добро пожаловать на главную страницу <h2>

      <div align="center"> <form action="${pageContext.request.contextPath}/ui/SignUp" target="_self">
                <button>Регистрация</button> </form> </div>

      <div align="center"> <form action="${pageContext.request.contextPath}/ui/SignIn" target="_self">
          <button>Авторизация</button> </form> </div>

      <div align="center"> <form action="${pageContext.request.contextPath}/ui/user/message" target="_self">
      <button>Отправить новое сообщение</button> </form> </div>

      <div align="center"> <form action="${pageContext.request.contextPath}/ui/user/chats" target="_self">
      <button>Входящие сообщения</button> </form> </div>

      <div align="center"> <form action="${pageContext.request.contextPath}/ui/admin/statistics" target="_self">
      <button>Статистика (для админа)</button> </form> </div>


</body>
</html>