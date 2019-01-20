<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
  <title>古诗文分享网</title>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!-- 自定义 CSS 样式表 -->
  <link rel="stylesheet" type="text/css" href="css/index.css"/>
  <!-- Bootstrap -->
  <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" charset="utf-8" />
</head>
<body>

<div class="poem-masthead">
  <div class="container">
    <nav class="poem-nav">
      <a class="poem-nav-item active" href="./poems">推荐</a>
      <a class="poem-nav-item" href="./poemjump">诗文</a>
      <a class="poem-nav-item" href="./jump">作者</a>
      <a class="poem-nav-item" href="./bookmark">收藏</a>
      <a class="poem-nav-item" href="./jumpuser">发表</a>

      <button id="registerBtn" data-toggle="modal" data-target="#registerModal">注册</button>
      <!-- 注册弹框 -->
      <div class="modal fade" id="registerModal" tabindex="-1" role="dialog" aria-labelledby="registerModalTitle" aria-hidden="true">
        <div class="modal-dialog" role="document">
          <div class="modal-content">
            <div class="modal-header">
              <h3 class="modal-title" id="registerModalTitle">用户注册</h3>
              <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                <span aria-hidden="true">&times;</span>
              </button>
            </div>
            <div class="modal-body">
              <form role="form" id="registerForm" action="register" method="post">
                <div class="form-group">
                  <label for="registerUsername" class="col-form-label">用户名</label>
                  <input type="text" class="form-control" id="registerUsername" required maxlength="12" minlength="5">
                </div>
                <div class="form-group">
                  <label for="registerPassword" class="col-form-label">密码</label>
                  <input type="password" class="form-control" id="registerPassword" required maxlength="12" minlength="8">
                </div>
                <div class="form-group">
                  <label for="registerRepeat" class="col-form-label">确认密码</label>
                  <input type="password" class="form-control" id="registerRepeat" required maxlength="12" minlength="8">
                </div>
              </form>
            </div>
            <div class="modal-footer">
              <button type="button" class="btn btn-secondary" data-dismiss="modal">取消</button>
              <button type="button" class="btn btn-primary" id="registerConfirmBtn">注册</button>
            </div>
          </div>
        </div>
      </div><!-- 注册弹框 -->

    </nav>
  </div>
</div>



<div class="container">

  <div class="row">
    <div class="col-sm-8 poem-title"></div>
    <div class="col-sm-8 poem-main">

      <s:if test="#request.markwarning != null">
        <div class="alert alert-warning" role="alert">
          <s:property value="#request.markwarning" />
        </div>
      </s:if>
      <s:iterator value="poems">
        <div class="poem-post">
          <h2 class="poem-post-title"><s:property value="title" /></h2>
          <br />
          <p class="poem-post-meta"><s:property value="author.name" />
            <br />
          <p><s:property value="content" /></p>
          <br />
        <s:if test="#session.tip!=null">
          <s:form action="mark" method="post">
            <s:hidden name="poem.id" value="%{id}"></s:hidden>
            <s:submit name="submit" value="收藏"></s:submit>
          </s:form>
        </s:if>


        </div><!-- /.poem-post -->
      </s:iterator>

      <nav>
        <ul class="pager">
          <s:if test="pageNum>1">
            <a href="recommend?pageNum=<s:property value="pageNum-1"/>">上一页</a>
          </s:if>

          ---------------------- 第 <s:property value="pageNum" /> 页 ----------------------
          <a href="recommend?pageNum=<s:property value="pageNum+1"/>">下一页</a>
        </ul>
      </nav>

    </div><!-- /.poem-main -->

    <div class="col-sm-3 col-sm-offset-1 poem-sidebar">
      <div class="sidebar-module sidebar-module-inset">
        <s:if test="#session.tip==null">
          <s:form method="post" action="login">
            <s:textfield name="user.username" label="账号" maxlength="12" minlength="5"/>
            <s:textfield name="user.password" label="密码" maxlength="12" minlength="8" type="password"/>
            <s:submit name="submit" value="登录"/>
          </s:form>
        </s:if>
        <s:else>
          <s:property value="#session.tip"/>,您已登录！
          <s:a action="logout">注销</s:a>
        </s:else>
      </div>
      <s:form method="post" action="admin">
        <s:submit name="submit" value="管理员登录"/>
      </s:form>
      <div class="sidebar-module">
        <h4>朝代</h4>
        <ol class="list-unstyled">
          <li><a href="dynastyAuthor?dynasty=先秦">先秦</a></li>
          <li><a href="dynastyAuthor?dynasty=两汉">两汉</a></li>
          <li><a href="dynastyAuthor?dynasty=五代">五代</a></li>
          <li><a href="dynastyAuthor?dynasty=魏晋">魏晋</a></li>
          <li><a href="dynastyAuthor?dynasty=南北朝">南北朝</a></li>
          <li><a href="dynastyAuthor?dynasty=隋代">隋代</a></li>
          <li><a href="dynastyAuthor?dynasty=唐代">唐代</a></li>
          <li><a href="dynastyAuthor?dynasty=宋代">宋代</a></li>
          <li><a href="dynastyAuthor?dynasty=金朝">金朝</a></li>
          <li><a href="dynastyAuthor?dynasty=元代">元代</a></li>
          <li><a href="dynastyAuthor?dynasty=明代">明代</a></li>
          <li><a href="dynastyAuthor?dynasty=清代">清代</a></li>
        </ol>
      </div>
    </div><!-- /.poem-sidebar -->

  </div><!-- /.row -->

</div><!-- /.container -->

<footer class="poem-footer">
  <p>poem template built for <a href="http://getbootstrap.com">Bootstrap</a> by <a
          href="https://twitter.com/mdo">@mdo</a>.</p>
  <p>
    <a href="#">Back to top</a>
  </p>
</footer>

<!-- JQuery -->
<script type="text/javascript" src="js/jquery.min.js"></script>
<!-- JQuery 表单验证插件 -->
<script type="text/javascript" src="js/jquery.validate.min.js"></script>
<!-- JQuery 表单验证插件中文本地化 -->
<script type="text/javascript" src="js/messages_zh.min.js"></script>
<script type="text/javascript" src="js/popper.min.js"></script>
<!-- Bootstrap 脚本 -->
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<!-- 自定义脚本 -->
<script type="text/javascript" src="js/index.js"></script>
</body>
</html>
