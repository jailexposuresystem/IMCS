<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ page import="com.shoppingcart.model.Item,java.util.*" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">



<html>
    <head>
       
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="pragma" content="nocache">
    <title>Cart</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">

    </head>
    <body>
        <div style="color:red">
        	${invalid}
        	<html:errors/>
        </div>
        
        
        <html:form action="/cartaction"  method="post">
		<%-- <input type="hidden" name="page" value="<%= request.getAttribute("page")%>"> --%>
		<span class="col-md-10">
		<div >
			<table class="table table-bordered">
				<thead>
					<tr class="danger">
						<th>
						</th>
						<th>
							Id
						</th>
						<th>
							Name
						</th>
						<th>
							Price
						</th>
						<th>
							Quantity
						</th>
					</tr>
				</thead>
				<tbody>

					
			
					<% List<Item> items = (List<Item>) session.getAttribute("items");
					 System.out.println("cart"+request.getAttribute("page"));  
					for(Item item: items) { %>
					<tr class="warning">
							<td>
					<input type="checkbox" class="form-check-input" name="<%= item.getId() %>">
					</td>
						<td>
							<%= item.getId() %>
						</td>
						<td>
							<%= item.getName() %>
						</td>
						<td>
							$ <%= item.getPrice() %>
						</td>
						<td>
							<input type="text" name="q<%= item.getId() %>" > 
						</td>
						</tr>
						<% } %>
					

				</tbody>
			</table>
			<div class="btn-group">
				 <html:submit property="myMethod" value="addToCart"/>&nbsp;&nbsp;&nbsp;
				 <html:submit property="myMethod">checkout</html:submit>
				<!-- <button class="btn btn-default" type="submit" name="page" value="Add">
					 Add to Cart
				</button>
				<button class="btn btn-default" type="submit" name="page" value="Summary">
					 Checkout
				</button> -->
			</div>
		</div>
		</span>
		</html:form>

    
    </body>
</html>
