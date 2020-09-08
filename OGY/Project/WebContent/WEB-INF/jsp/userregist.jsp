<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>大喜利SNS - OGY | 新規登録</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <style type="text/css">
        .header{
            font-size: 40px;
            text-align: center
        }
        .container {
            max-width: 500px;
            border: solid 1px #e6e6fa;
            border-radius: 10px 10px 10px 10px;
        }
        fieldset{
            padding: 15px;
        }
        .padding {
            padding : 100px ;
        }
        .input{
            text-align: end;
        }
        .red-text{

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
            <c:if test="${validationMessage != null}">
			<P><font color="#FF0000">${validationMessage}</font></P>
			</c:if>
        </div>
        <form action="userregistconServlet" method="POST">
            <fieldset>
                <div class="form-group row">
                    <label class="col-sm-5 col-form-label">ログインID</label>
                        <div class="col-sm-12">
                            <input value="${udb.loginId}" type="text" class="form-control" name="login_id" required>
                        </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-5 col-form-label">パスワード</label>
                        <div class="col-sm-12">
                            <input type="password" class="form-control" name="password" required>
                        </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-5 col-form-label">パスワード確認用</label>
                        <div class="col-sm-12">
                            <input type="password" class="form-control" name="confirm_password" required>
                        </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-5 col-form-label">ハンドルネーム</label>
                        <div class="col-sm-12">
                            <input value="${udb.name}" type="text" class="form-control" name="user_name" required>
                        </div>
                </div>
                <div class="input">
                    <input class="btn btn-primary" type="submit" value="登録">
                </div>
            </fieldset>
        </form>
    </div>
</div>

</body>

</html>

