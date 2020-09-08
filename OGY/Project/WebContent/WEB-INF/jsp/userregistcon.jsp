<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>大喜利SNS - OGY | 新規登録確認</title>
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
    </style>

</head>

<body>

<div class="padding">
    <div class="header">
        <p><font color=#696969>大喜利SNS「OGY」</font></p>
    </div>
    <div class="container">
        <form action="userregistreServlet" method="post">
            <fieldset>
                <div class="form-group row">
                    <label class="col-sm-5 col-form-label">ログインID</label>
                        <div class="col-sm-12">
                            <input type="text" class="form-control" name="login_id" value="${udb.loginId}" readonly>
                        </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-5 col-form-label">パスワード</label>
                        <div class="col-sm-12">
                            <input type="password" class="form-control" name="password" value="${udb.password}" readonly>
                        </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-5 col-form-label">ハンドルネーム</label >
                        <div class="col-sm-12">
                            <input type="text" class="form-control" name="user_name" value="${udb.name}" readonly>
                        </div>
                </div>
                <div style="text-align: center">
                <p>上記の内容で登録しますか？</p>
                    </div>
                <div style="text-align: center">
                <div>
                    <input class="btn btn-primary"  type="submit" name="confirm_button" value="修　正">　　　　　<input class="btn btn-primary" type="submit" name="confirm_button" value="登　録">
                </div>
                </div>
            </fieldset>
        </form>
    </div>
</div>

</body>

</html>
