<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <title>Title</title>
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
            <a class="poem-nav-item" href="./poemjump.action">诗文</a>
            <a class="poem-nav-item" href="./jump.action">作者</a>
            <a class="poem-nav-item" href="#">收藏</a>
            <a class="poem-nav-item" href="./jumpuser.action">发表</a>

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

    <div class="poem-header">
        <h1 class="poem-title">The Bootstrap poem</h1>
        <p class="lead poem-description">The official example template of creating a poem with Bootstrap.</p>
    </div>

    <div class="row">

        <div class="col-sm-8 poem-main">

            <table border=1>
                <tr>
                    <th>用户名</th>
                    <th>密码</th>
                </tr>
                <s:iterator value="users">
                    <%int i=0; %>
                    <tr>
                        <td><s:property value="username" /></td>
                        <td><s:property value="password" /></td>
                        <td><s:form action="deleteuser" method="post">
                            <s:hidden name="user.username" value="%{username}"></s:hidden>
                            <s:submit value="封禁" />
                        </s:form>
                        </td>

                    </tr>
                </s:iterator>
            </table>

        </div><!-- /.poem-main -->

        <div class="col-sm-3 col-sm-offset-1 poem-sidebar">
            <div class="sidebar-module sidebar-module-inset">
                <s:if test="#session.tip==null">
                    <s:form method="post" action="login">
                        <s:textfield name="user.username" label="账号" maxlength="12" minlength="5"/>
                        <s:textfield name="user.password" label="密码" maxlength="12" minlength="8"/>
                        <s:submit name="submit" value="登录"/>
                    </s:form>
                </s:if>
                <s:else>
                    <s:property value="#session.tip"/>,您已登录！
                </s:else>
            </div>
            <div class="sidebar-module">
                <h4>Archives</h4>
                <ol class="list-unstyled">
                    <li><a href="#">March 2014</a></li>
                    <li><a href="#">February 2014</a></li>
                    <li><a href="#">January 2014</a></li>
                    <li><a href="#">December 2013</a></li>
                    <li><a href="#">November 2013</a></li>
                    <li><a href="#">October 2013</a></li>
                    <li><a href="#">September 2013</a></li>
                    <li><a href="#">August 2013</a></li>
                    <li><a href="#">July 2013</a></li>
                    <li><a href="#">June 2013</a></li>
                    <li><a href="#">May 2013</a></li>
                    <li><a href="#">April 2013</a></li>
                </ol>
            </div>
            <div class="sidebar-module">
                <h4>Elsewhere</h4>
                <ol class="list-unstyled">
                    <li><a href="#">GitHub</a></li>
                    <li><a href="#">Twitter</a></li>
                    <li><a href="#">Facebook</a></li>
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
