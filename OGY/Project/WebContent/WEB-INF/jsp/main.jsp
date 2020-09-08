<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>大喜利SNS - OGY | メイン</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

<style type="text/css">
.pa {
	padding-bottom: 15px;
	margin: auto;
}

.title {
	font-size: 20px;
	padding: 15px;
	background-color: #e6e6fa;
}

.post {
	font-size: 20px;
	padding: 20px
}

.detail {
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

.my-red {
	color: #dc143c
}

.morelink {
	display: block;
	max-width: 240px;
	margin: 20px auto;
	padding: 10px 20px;
	background: #ff9900;
	border: 2px solid #fff;
	color: #fff;
	text-align: center;
	border-radius: 5px;
}

.morelink:hover {
	cursor: pointer;
	border: 2px solid #ff9900;
	background: #fff;
	color: #ff9900;
}
</style>
<script src="https://kit.fontawesome.com/d6177021b6.js"
	crossorigin="anonymous"></script>


</head>

<body>

	<header>
		<div class="fixed-top">
			<div class="p-2 bg-light text-white">
				<ul class="nav justify-content-center">
					<div>
						<a class="navbar-brand mr-0 mr-md-2" href="mainServlet"><font
							color=#696969>大喜利SNS 「OGY」</font></a>
					</div>
					<li class="nav-item"><a class="nav-link" href="postServlet">投稿する！</a>
					</li>
					<li class="nav-item"><a class="nav-link"
						href="userprofServlet"><font color=#696969>${userName}のページ</font></a>
					</li>
					<li class="nav-item"><a class="nav-link" href="logoutServlet"><font
							color=#696969>ログアウト</font></a></li>
					<c:choose>
						<c:when test="${userId == 1}">
							<li class="nav-item"><a class="nav-link"
								href="adminuserServlet"><font color=#696969>管理者:ユーザ一覧</font></a>
							</li>
							<li class="nav-item"><a class="nav-link"
								href="adminpostServlet"><font color=#696969>管理者:投稿一覧</font></a>
							</li>
							<li class="nav-item"><a class="nav-link"
								href="admintitleServlet"><font color=#696969>管理者:タイトル一覧</font></a>
							</li>
						</c:when>
					</c:choose>
				</ul>
			</div>
		</div>

	</header>
	<div class="container" style="padding-top: 80px">
		<div class="row">
			<div class="col-md-6 offset-md-3">
				<form action="mainServlet" method="post">
					<ul class="nav justify-content-center">
						<div class="pa">
							<li class="nav-item">
								<button type="submit" value="1" name="serch"
									class="btn btn-outline-info">新しい！</button>
							</li>
						</div>
						<div class="pa">
							<li class="nav-item">
								<button type="submit" value="2" name="serch"
									class="btn btn-outline-danger">おすすめ</button>
							</li>
						</div>
						<div class="pa">
							<li class="nav-item">
								<button type="submit" value="3" name="serch"
									class="btn btn-outline-warning">いいね！</button>
							</li>
						</div>
					</ul>
				</form>
			</div>
		</div>
		<div id="list">
			<!-- ここにforeach -->
			<c:forEach var="user" items="${userList}">
				<div class="li">
					<div class="col-md-6 offset-md-3" style="margin-bottom: 30px">
						<div class="border">
							<div class="title">${user.title}</div>
							<div class="post">${user.sentence}</div>
							<div class="border-top">
								<div class="detail">
									<div class="detail" style="display: inline-flex">
										<c:choose>
											<c:when test="${user.id == user.post_id}">
												<form action="likedeleteServlet" method="post">
													<div title="いいねをやめる">
														<button type="submit" value="${user.id}" name="like_dl"
															class="btn btn-sm">
															<i class="fas fa-star fa-lg my-orange"></i>
														</button>
													</div>
												</form>
											</c:when>
											<c:when test="${user.user_id == userId}">
												<div class="detail">
													<font color=#696969>自分の投稿 </font>
												</div>
												<form action="deletepostServlet" method="post">
													<div style="padding-left: 10px">
														<div title="投稿を削除する">
															<button type="submit" value="${user.id}" name="post_id"
																class="btn btn-sm">
																<i class="fas fa-trash-alt fa-lg my-red"></i>
															</button>
														</div>
													</div>
												</form>
											</c:when>
											<c:otherwise>
												<form action="likeServlet" method="post"
													action="<?php echo htmlspecialchars($_SERVER['PHP_SELF'], ENT_QUOTES, 'UTF-8'); ?>">
													<div style="padding-left: 10px">
														<div title="いいねをする">
															<input type="hidden" name="scroll_top" value=""
																class="st">
															<button type="submit" value="${user.id}" name="like"
																class="btn btn-sm">
																<i class="far fa-star fa-lg my-orange at"></i>
															</button>
														</div>
													</div>
												</form>
											</c:otherwise>
										</c:choose>
										<form action="post2Servlet" method="post">
											<div style="padding-left: 10px">
												<div title="このお題を使う">
													<button type="submit" value="${user.title_id}"
														name="title_id" class="btn btn-sm">
														<i class="fas fa-share fa-lg my-blue"></i>
													</button>
												</div>
											</div>
										</form>
									</div>
								</div>
							</div>
							<div class="border-top">
								<div class="detail">
									<font color=#696969>作成者</font><a class="mr-md-2"
										href="userprof2sessionServlet?id=${user.user_id}"><font
										color=#696969>「${user.name}」</font></a> <font color=#696969>${user.like_cnt}いいね！
									</font> <font color=#696969>作成日 ${user.create_date} </font>
								</div>
							</div>
						</div>
					</div>
				</div>
			</c:forEach>
			<!-- ここまでforeach -->
		</div>
	</div>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

	<!-- スクロール位置を固定する Jquary,js,php-->
	<script>
		$('form').submit(function() {
			var scroll_top = $(window).scrollTop(); //送信時の位置情報を取得
			$('input.st', this).prop('value', scroll_top); //隠しフィールドに位置情報を設定
		});

		window.onload = function() {
			//ロード時に隠しフィールドから取得した値で位置をスクロール
			$(window).scrollTop(<?php echo @$_REQUEST['scroll_top']; ?>);
		}
	</script>
	<!-- ここまで -->

	<!-- リストを10件ずつ表示させる Jquary,js -->
	<script>
		$(function() {

			//分割したい個数を入力
			var division = 5;

			//要素の数を数える
			var divlength = $('#list .li').length;
			//分割数で割る
			dlsizePerResult = divlength / division;
			//分割数 刻みで後ろにmorelinkを追加する
			for (i = 1; i <= dlsizePerResult; i++) {
				$('#list .li').eq(division * i - 1).after(
						'<span class="morelink link'+i+'">続きを読む</span>');
			}
			//最初のli（分割数）と、morelinkを残して他を非表示
			$('#list .li,.morelink').hide();
			for (j = 0; j < division; j++) {
				$('#list .li').eq(j).show();
			}
			$('.morelink.link1').show();

			//morelinkにクリック時の動作
			$('.morelink').click(function() {
				//何個目のmorelinkがクリックされたかをカウント
				index = $(this).index('.morelink');
				//(クリックされたindex +2) * 分割数 = 表示数
				for (k = 0; k < (index + 2) * division; k++) {
					$('#list .li').eq(k).fadeIn();
				}

				//一旦全てのmorelink削除
				$('.morelink').hide();
				//次のmorelink(index+1)を表示
				$('.morelink').eq(index + 1).show();

			});

		});
	</script>
	<!-- ここまで -->
aaaaaaa
</body>

</html>

