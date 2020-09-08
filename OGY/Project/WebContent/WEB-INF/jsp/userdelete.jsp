<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>大喜利SNS - OGY | ユーザ退会</title>
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
    <div class="container" style="padding-top: 80px">
        <!-- プロフィール -->
        <div style="text-align: center">
            <h5>ユーザ退会</h5>
        </div>
               <div class="row">
            <div class="col-md-6 offset-md-3" style="margin-top: 30px">
                <div class="border-bottom">
                    <p>　　　名　前　　：　　${udb.name}　さん</p>
                    <p>　　いいねの数　：　　${ulb.like}　いいね！</p>
                    <p>　　　ひと言　　：　　${udb.comment}</p>
                </div>
            </div>
        </div>
                <div class="row">
            <div class="col-md-4 offset-md-4" style="text-align: center">
                <div class="border-bottom">
                    <p></p>
                    <a>本当に退会しますか？</a>
                    <p></p>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-4 offset-md-4" style="text-align: center">
            	<div class="border-bottom">
                    <form action="userdeleteServlet" method="post">
                        <button class="btn" type='submit'><font color="red">退会する</font></button>
                    </form>
                </div>
            </div>
        </div>
    </div>

</body>

</html>
