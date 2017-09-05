<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>



<html>
<head>
    <title>View Order</title>
</head>
<body>
<h2><c:out value="View Order Id - ${customerOrder.order.orderId}"/></h2>
<br>
    <table border="0">
        <c:forEach var="productOrder" varStatus="po" items="${customerOrder.productOrderList}">
            <tr>
                <td><c:out value="Product: ${productOrder.product.productName}"/></td>
                <td><c:out value="Quantity: ${productOrder.orderAmount}"/></td>
            </tr>
        </c:forEach>
        <tr>
            <th><c:out value="Confirmation Number ${customerOrder.order.confirmNumber}"/></th>
        </tr>
    </table>


</body>
</html>

