<%@ page contentType="text/html;charset=UTF-8" language="java" import="com.thoughtworks.entity.Item" %>
<%@ page import="java.util.List" %>
<html>
<head>
    <title></title>
</head>
<body>
<h1>ITEM LIST</h1>
<hr/>
<% List<Item> items = (List<Item>) (request.getAttribute("items"));
    for (Item item : items) {
        request.setAttribute("item", item);
%>
${item.itemId}|${item.barcode}|${item.itemname}|${item.unitname}|${item.price}|<a
        href="http://localhost:8080/item/delete.do?id=${item.itemId}">删除</a><br/>
<%
        request.removeAttribute("item");
    }
%>
</body>
</html>
