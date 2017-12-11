<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ page import="com.shoppingcart.model.CartItem,java.util.*" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
       
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="pragma" content="nocache">
    <title>Checkout</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">

    </head>
    <body>
        <div style="color:red">
        	${invalid}
        	<html:errors/>
        </div>

	<div class="row">
		<html:form action="/cartaction"  method="post">
		
		<%-- <input type="hidden" name="page" value="<%= request.getAttribute("page")%>"> --%>
		<div class="col-md-10">
		<h1>Cart Summary</h1>
			<table class="table table-bordered">
				<thead>
					<tr class="danger">
						<th>
							Item
						</th>
						<th>
							Quantity
						</th>
						<th>
							Price
						</th>
						
					</tr>
				</thead>
				<tbody>

					<% List<CartItem> cartItems = (List<CartItem>) request.getAttribute("cartlist");
					 System.out.println("summary" + cartItems.size());  
					for(CartItem item: cartItems) { %>
					<tr class="warning">
		
						<td>
							<%= item.getName() %>
						</td>
						<td>
							<%= item.getQuantity() %>
						</td>
						<td>
							<%= item.getAmount() %>
						</td>
			
						</tr>
						<% } %>
								
					<tr class="warning">
		
						<td colspan="2">
							Total
						</td>
						
						<td>
							 $ <%= request.getAttribute("total")%>
						</td>
			
						</tr>
					
				</tbody>
			</table>
			<div class="btn-group">
			<html:submit property="myMethod" value="BackToCart"/>&nbsp;&nbsp;&nbsp;
				 <html:submit property="myMethod" value="Checkout"/>
			</div>
				 
			<!-- <button class="btn btn-default" type="submit" name="page" value="Add">
					 Back to Cart
				</button>
				<button class="btn btn-default" type="submit" name="page" value="Checkout">
					 Checkout
				</button> -->
			</div>
		
		</html:form>	
		</div>

	    
    </body>
</html>