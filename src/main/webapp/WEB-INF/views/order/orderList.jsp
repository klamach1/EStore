<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Order List</title>
</head>
<body>
Order List
<br>
<div>
    <c:forEach var="order" items="${orderList}">
        <li><c:out value="Order Date ${order.orderCreated} - Total Items ${order.totalAmount} - Status ${order.confirmNumber == 0 ? 'Incomplete' : 'Complete'}" />
            <c:choose>
            <c:when test="${order.confirmNumber == 0}">
                <a href="/editOrder/${order.orderId}.html">Edit</a> <a href="/deleteOrder/${order.orderId}.html">Delete</a>
            </c:when>
            <c:otherwise><a href="/viewOrder/${order.orderId}.html">View</a></c:otherwise>
            </c:choose>
        </li>
    </c:forEach>
</div>
<a href="/addOrder.html">Create New Order</a>

</body>
</html>