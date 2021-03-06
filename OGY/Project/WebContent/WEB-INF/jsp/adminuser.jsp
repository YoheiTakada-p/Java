<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>大喜利SNS - OGY | 管理者:ユーザ一覧</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <style type="text/css">
        .pa{
            padding-bottom: 15px;
            margin: auto;
        }
        .title{
            font-size: 20px;
            padding: 15px;
            background-color: #e6e6fa;
        }
        .post{
            font-size: 20px;
            padding: 20px
        }
        .detail{
            font-size: 15px;
            padding: 3px;
            text-align: end;
        }
        .form{
            text-align: center;
        }
    </style>

</head>

<body>

<header>

    <div class="fixed-top">
        <div class="p-2 bg-light text-white">
   <ul class="nav justify-content-center">
        <div>
            <a class="navbar-brand mr-0 mr-md-2" href="mainServlet"><font color=#696969>大喜利SNS 「OGY」</font></a>
        </div>
            <li class="nav-item">
                <a class="nav-link" href="postServlet">投稿する！</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="userprofServlet"><font color=#696969>${userName}のページ</font></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="logoutServlet"><font color=#696969>ログアウト</font></a>
            </li>
            <c:choose>
            <c:when test="${userId == 1}">
            <li class="nav-item">
                <a class="nav-link" href="adminuserServlet"><font color=#696969>管理者:ユーザ一覧</font></a>
            </li>
                <li class="nav-item">
                <a class="nav-link" href="adminpostServlet"><font color=#696969>管理者:投稿一覧</font></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="admintitleServlet"><font color=#696969>管理者:タイトル一覧</font></a>
            </li>
            </c:when>
            </c:choose>
    </ul>
        </div>
    </div>

</header>

	<div class="container">
        <div class="row">
            <div class="col-md-6 offset-md-3">
                <form action="adminuserServlet" method="post">
                    <div class="form" style="padding-top: 80px">
                        <p class="form_title">ユーザ覧</p>
                        <p>
                            <label for="login_id">ログインID</label><br>
                            <input type="text" name="loginId" id="login_id" >
                        </p>
                        <p>
                            <label for="user_name">ユーザ名</label><br>
                            <input type="text" name="name" id="user_name">
                        </p>
                        <p>
                            <input type="submit" value="検索"/>
                        </p>
                    </div>

                </form>
            </div>
        </div>
    </div>
<!-- 管理者 -->
<div class="col-md-6 offset-md-3">
<table class="table">
  <thead>
    <tr>
      <th scope="col">ログインID</th>
      <th scope="col">ユーザ名</th>
      <th scope="col">作成日時</th>
      <th scope="col"></th>
    </tr>
  </thead>
  <tbody>
      <c:forEach var="user" items="${userList}" >
                  <tr>
                     <td>${user.loginId}</td>
                     <td>${user.name}</td>
                     <td>${user.create_date}</td>
                     <td>
                       <a class="btn btn-primary" href="adminprofsessionServlet?id=${user.id}">詳細</a>
                     </td>
                   </tr>
      </c:forEach>
  </tbody>
</table>
</div>



</body>

</html>
