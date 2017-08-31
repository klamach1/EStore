<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>



<html>
<head>
    <title>Add Product</title>
</head>
<body>
    Add New Product:
<br>
<sf:form method="POST" modelAttribute="product">
<table border="0">
	<tr>
		<th align="left">Catalog Id:</th>
		<td align="left">${catalog.catalogId}</td>
	</tr>
	<tr> 
		<th><label for="product_name">Product Name:</label></th>
    	<td><sf:input path="productName" size="50" id="product_name" /><br/>
    	        	<sf:errors path="productName" cssClass="error" />

    	</td> 
	</tr> 
	<tr> 
		<th><label for="sku">Sku:</label></th>
    	<td><sf:input path="sku" size="20" id="sku" /><br/>
    	        	<sf:errors path="sku" cssClass="error" />

    	</td> 
	</tr> 
			<tr> 
		<th><label for="uom">Product UOM:</label></th>
    	<td><sf:input path="unitOfMeasure" size="50" id="uom" /><br/>

    	</td> 
	</tr> 
		<tr> 
		<th><label for="quantity">Product Available Quantity:</label></th>
    	<td><sf:input path="availableQuantity" size="10" id="quantity" /><br/>

    	</td> 
	</tr>
	<tr>
		<th></th>
		<td><input type="submit" value="Save" /></td>
	</tr>
</table>
</sf:form>
    
</body>
</html>

