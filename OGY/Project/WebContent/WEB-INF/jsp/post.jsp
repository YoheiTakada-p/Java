<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>大喜利SNS - OGY | 投稿</title>
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
        .textareasize{
            font-size: 20px;
            padding: 20px
        }
        .detail{
            font-size: 15px;
            padding: 3px;
            text-align: end;
        }
        .colo{
            border-radius: 0px 0px 0px 0px;
            background-color: #e6e6fa;
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
        <div class="row">
            <div class="col-md-6 offset-md-3" style="margin-bottom: 30px">
                <div class="border">
                    <form action="postServlet" method="post">
                    <select name="title" class="form-control form-control-lg colo">
                    <c:forEach var="titleList" items="${titleList}">
                        <option value="${titleList.id}">「${titleList.title}」</option>
                    </c:forEach>
                        <option value="0">ランダム</option>
                    </select>
                    <div class="textareasize">
                        <div class="form-group">
                            <textarea class="form-control" name="post" rows="3" required maxlength="30"></textarea>
                        </div>
                    </div>
                    <div class="textareasize">
                        <div class="border-top">
                            <p>次のお題(入力なしでも可)</p>
                            <div class="form-group">
                                <textarea class="form-control" name="user_title" rows="1"></textarea>
                            </div>
                        </div>
                    </div>
                    <div class="border-top">
                        <div class="detail" style="text-align: center">
                            <button type="submit" class="btn btn-primary btn-sm">投稿する</button>
                        </div>
                    </div>
                    </form>
                </div>
            </div>
        </div>
    </div>


</body>

</html>

