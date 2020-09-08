<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>大喜利SNS - OGY | ログイン</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <style type="text/css">
        .header{
            font-size: 40px;
            text-align: center
        }
        .container {
            max-width: 400px;
            border: solid 1px #e6e6fa;
            border-radius: 10px 10px 10px 10px;
        }
        fieldset{
            padding: 15px;
        }
        .padding {
            padding : 100px ;
        }
    </style>

</head>

<body>

<div class="padding">
    <div class="header">
        <p><font color=#696969>大喜利SNS「OGY」</font></p>
    </div>
    <div class="container">
    	<div style="text-align: center">
    		<c:if test="${loginErrorMessage != null}">
			<p class="red-text center-align">${loginErrorMessage}</p>
			<br>
			</c:if>
		</div>
        <form action="loginreServlet" method="post">
            <fieldset>
                <div class="form-group">
                    <label>ログインID</label>
                    <input type="text" class="form-control" value="${inputLoginId}" name="login_id" required>
                </div>
                <div class="form-group">
                    <label>パスワード</label>
                    <input type="password" class="form-control" name="password" required>
                </div>
                <div class="text-center">
                    <button type="submit" class="btn btn-primary">ログイン</button>
                </div>
            </fieldset>
        </form>
            <div align="right">
                <a href="userregistServlet">新規登録</a>
            </div>
    </div>
</div>

</body>

</html>