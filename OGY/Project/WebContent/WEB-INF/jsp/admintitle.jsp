<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>大喜利SNS - OGY | 管理者:タイトル一覧</title>
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
       <div style="text-align: center">
            <h5>タイトル一覧</h5>
        </div>
        <div class="row">
            <!-- ここにforeach -->
            <c:forEach var="titleList" items="${titleList}">
            <div class="col-md-6 offset-md-3" style="margin-bottom: 30px">
                <div class="border">
                    <div class="title">
                    ${titleList.title}
                    </div>
                    <div class="border-top">
                        <div class="detail">
                        	<div  class="detail" style="display:inline-flex">
                            	<form action="admindeletetitleServlet" method="post">
                            	<div style="padding-left: 10px">
                            	<div title="タイトルを削除する">
                            		<button type="submit" value="${titleList.id}" name="title_id" class="btn btn-sm"><i class="fas fa-trash-alt fa-lg my-red"></i></button>
                            	</div>
                            	</div>
                            	</form>
                           </div>
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
