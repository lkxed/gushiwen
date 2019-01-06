<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
  <title>tag</title>
</head>
<body>
<ul>
  <s:iterator value="tags">
    <li><s:property value="name" /></li>
  </s:iterator>
</ul>
</body>
</html>
