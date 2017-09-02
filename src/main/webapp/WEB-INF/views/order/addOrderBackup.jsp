<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>



<html>
<head>
    <title>Add Or Edit Order</title>
</head>
<body>
    Add New Order:
<br>
<sf:form method="POST" modelAttribute="productOrderList">
<table border="0">
	<c:forEach varStatus="productOrder" items="${productOrderList}">
		<sf:hidden path="productOrderList[${productOrder.index}].order.orderId"></sf:hidden>
		<sf:hidden path="productOrderList[${productOrder.index}].product.productId"></sf:hidden>
	<tr>
		<th><label for="product_quantity">${productOrder.product.productName}</label></th>
    	<td><sf:input path="productOrderList[${productOrder.index}].orderAmount" size="50" id="productOrderList[${productOrder.index}].orderAmount" /><br/>
    	        	<sf:errors path="productOrderList[${productOrder.index}].orderAmount" cssClass="error" />

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

