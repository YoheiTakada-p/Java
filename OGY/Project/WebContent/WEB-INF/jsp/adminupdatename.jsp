<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>大喜利SNS - OGY | 管理者用ユーザ情報変更</title>
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
        .container{
            max-width: 500px
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
            <h5>名前の変更</h5>
        </div>
         <div style="text-align: center">
            <c:if test="${validationMessage != null}">
			<P><font color="#FF0000">${validationMessage}</font></P>
			</c:if>
        </div>
        <form action="adminupdatenameServlet" method="post">
            <fieldset>
                <div class="form-group row">
                    <label class="col-sm-5 col-form-label">名前</label>
                        <div class="col-sm-12">
                            <input value="${udb.name}" type="text" class="form-control" name="name" required>
                        </div>
                </div>
                <div class="col-md-4 offset-md-4" style="text-align: center">
                	<div class="border-bottom">
                		<button class="btn" type='submit'><font color="#696969">変更する</font></button>
                	</div>
            	</div>
            </fieldset>
        </form>
    </div>

</body>

</html>

