<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>大喜利SNS - OGY | マイページ</title>
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
                .my-orange {
        	color: #fecb81
        }
        .my-blue {
        	color: #1e90ff
        }
        .my-red{
        	color: #dc143c
        }
    </style>
    <script src="https://kit.fontawesome.com/d6177021b6.js" crossorigin="anonymous"></script>

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
            <h5>${udb.name}のページ</h5>
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
         <!-- 本人だけ表示させる -->
        <c:if test="${udb.id == userId or userId == 1}">
                <div class="row">
            <div class="col-md-2 offset-md-2" style="text-align: center">
                <div class="border-bottom">
                    <a href="userupdatenameServlet"><font color=#696969>名前を変更</font></a>
                </div>
            </div>
            <div class="col-md-2" style="text-align: center">
                <div class="border-bottom">
                    <a href="userupdatecomment"><font color=#696969>ひと言を変更</font></a>
                </div>
            </div>
            <div class="col-md-2" style="text-align: center">
                <div class="border-bottom">
                    <a href="userupdatepasswordServlet"><font color=#696969>パスワードを変更</font></a>
                </div>
            </div>
            <div class="col-md-2" style="text-align: center">
                <div class="border-bottom">
                    <a href="userdeleteServlet?id=${udb.id}"><font color=#696969>退　会</font></a>
                </div>
            </div>
        </div>
        </c:if>
        <!-- プロフィールここまで-->
        <div style="text-align: center">
            <br>
            <h5>${udb.name}の投稿</h5>
        </div>
        <div class="row">
            <!-- ここにforeach -->
<c:forEach var="user" items="${userList}" >
            <div class="col-md-6 offset-md-3" style="margin-bottom: 30px">
                <div class="border">
                    <div class="title">
                        ${user.title}
                    </div>
                    <div class="post">
                        ${user.sentence}
                    </div>
                    <div class="border-top">
                        <div class="detail">
                        	<div  class="detail" style="display:inline-flex">
                        <c:choose>
                        	<c:when test="${user.id == user.post_id}">
                        		<form action="likedeleteServlet" method="post">
                        		<div title="いいねをやめる">
                            		<button type="submit" value="${user.id}" name="like_dl" class="btn btn-sm"><i class="fas fa-star fa-lg my-orange"></i></button>
                            	</div>
                            	</form>
                            </c:when>
                            <c:when test="${user.user_id == userId}">
                            	<div class="detail">
                            		<font color=#696969>自分の投稿　</font>
                            	</div>
                            	<form action="deletepostprofServlet" method="post">
                            	<div style="padding-left: 10px">
                            	<div title="投稿を削除する">
                            		<button type="submit" value="${user.id}" name="post_id" class="btn btn-sm"><i class="fas fa-trash-alt fa-lg my-red"></i></button>
                            	</div>
                            	</div>
                            	</form>
                            </c:when>
                            <c:when test="${userId == 1}">
                            <form action="deletepostprofServlet" method="post">
                            	<div style="padding-left: 10px">
                            	<div title="投稿を削除する">
                            		<button type="submit" value="${user.id}" name="post_id" class="btn btn-sm"><i class="fas fa-trash-alt fa-lg my-red"></i></button>
                            	</div>
                            	</div>
                            	</form>
                            </c:when>
                            <c:otherwise>
                            	<form action="likeServlet" method="post">
                            	<div style="padding-left: 10px">
                            	<div title="いいねをする">
                            		<button type="submit" value="${user.id}" name="like" class="btn btn-sm"><i class="far fa-star fa-lg my-orange"></i></button>
                            	</div>
                            	</div>
                            	</form>
                            </c:otherwise>
                        </c:choose>
                        	<form action="post2Servlet" method="post">
                        	<div style="padding-left: 10px">
                        	<div title="このお題を使う">
                            	<button type="submit" value="${user.title_id}" name="title_id" class="btn btn-sm"><i class="fas fa-share fa-lg my-blue"></i></button>
                            </div>
                            </div>
                            </form>
                           </div>
                        </div>
                    </div>
                    <div class="border-top">
                        <div class="detail">
                            <font color=#696969>作成者</font><font color=#696969>「${user.name}」</font>
                            <font color=#696969>${user.like_cnt}いいね！　</font>
                            <font color=#696969>作成日　${user.create_date}　</font>
                        </div>
                    </div>
                </div>
            </div>
            </c:forEach>
            <!-- ここまでforeach -->
        </div>
    </div>


</body>

</html>


