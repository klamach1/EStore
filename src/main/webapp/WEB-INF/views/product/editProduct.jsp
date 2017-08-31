<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>


<html>
<head>
    <title>Edit Product</title>
</head>
<body>
    Edit Product Details:
<br>
<sf:form method="POST" modelAttribute="product">
<table border="0">
	<tr> 
		<th align="left">Product Id:</th>
    	<td align="left">${product.productId}</td>
	</tr> 
	<tr> 
		<th align="left"><label for="product_name">Product Name:</label></th>
    	<td align="left">
    	    <sf:input path="productName" id="product_name" /><br/>
        	<sf:errors path="productName" cssClass="error" />
    	</td> 
	</tr>
	<tr>
		<th align="left"><label for="product_name">Product Sku:</label></th>
		<td align="left">
			<sf:input path="sku" id="sku" /><br/>
			<sf:errors path="sku" cssClass="error" />
		</td>
	</tr>
	<tr>
		<th align="left"><label for="uom">Unit Of Measure:</label></th>
		<td align="left">
			<sf:input path="unitOfMeasure" id="uom" /><br/>
			<sf:errors path="unitOfMeasure" cssClass="error" />
		</td>
	</tr>
	<tr>
		<th align="left"><label for="availableQuantity">Product Available Quantity:</label></th>
		<td align="left">
			<sf:input path="availableQuantity" id="availableQuantity" /><br/>
			<sf:errors path="availableQuantity" cssClass="error" />
		</td>
	</tr>
	<tr>
		<th></th>
		<td><input type="submit" value="Save" /></td>
	</tr>
</table>
</sf:form>

<br>
<a href="../list.html">Cancel</a>
<br><br>

</body>
</html>