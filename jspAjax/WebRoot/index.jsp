<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  <script type="text/javascript" src ="js/jquery-1.11.3.min.js"></script>
  <script type="text/javascript" src = "js/jquery.json-2.3.min.js"></script>
  <script type="text/javascript">
  $(function(){
  	 $("img").hide();
  	$("#ss").click(function(){
  		var userName = $("#userName").val();
  		$.ajax({
  		url:"ajax",
  		data:{"userName":userName},
  		beforeSend:function(){
  			 $("img").show();
  		},
  		success:function(r){
  			$("span").html(r);
  			if(r=="已存在！"){
  			alert("r");
  			}else{
  			location.href="show.jsp";
  			}
  		},
  		complete:function(){
  			$("img").hide();
  		}
  	}) 
  	})
  		
  })
  </script>
  <body>
  <form action="">
  	<input type="text" name="userName" id="userName"/>
  	<input type="password" name="userPwd" id="userPwd"/>
  	<input type="button" name ="ss" id="ss"/>
  	<br><br>
  		<span><img alt="" src="img/飞机05.gif"> </span>
  </form>
  </body>
</html>
