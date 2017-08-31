<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Product List</title>
</head>
<body>
Product List
<br>
<div> 
    <c:forEach var="product" items="${productList}">
        <li><c:out value="${product.productName} - Sku ${product.sku}" /> <a href="${catalog.catalogId}/editProduct/${product.productId}.html">Edit</a>
            <a href="${catalog.catalogId}/deleteProduct/${product.productId}.html">Delete</a></li>
    </c:forEach> 
</div>    
<a href="${catalog.catalogId}/addProduct.html">Add New Product</a>
    
</body>
</html>