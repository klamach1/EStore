<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>



<html>
<head>
    <title>Add Or Edit Order</title>
</head>
<body>
    Add New Order:
<br>
<sf:form method="POST" modelAttribute="productOrders">
<table border="0">
	<%--<c:out value="Products for Sale = ${productOrders.productOrderList.size}"/>--%>
	<c:forEach var="productOrder" varStatus="po" items="${productOrders.productOrderList}">
		<sf:hidden path="productOrderList[${po.index}].order.orderId"></sf:hidden>
		<sf:hidden path="productOrderList[${po.index}].product.productId"></sf:hidden>
	<tr>
		<th><label for="product_quantity">${productOrder.product.productName}</label></th>
    	<td><sf:input path="productOrderList[${po.index}].orderAmount" size="50" id="productOrderList[${po.index}].orderAmount" /><br/>
    	        	<sf:errors path="productOrderList[${po.index}].orderAmount" cssClass="error" />

    	</td>
	</tr>
	</c:forEach>
	<tr>
		<th></th>
		<td><input type="submit" value="Save" /></td>
	</tr>
</table>
</sf:form>
    
</body>
</html>

