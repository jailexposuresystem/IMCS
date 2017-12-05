<%@ page import="com.shoppingcart.model.*,java.util.*" %>


<%@ include file = "header.jsp" %>
	<div class="row">
		<%@ include file = "menu.jsp" %>
		
		<form action="CartServlet" name="addtocartform" method="post">
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
				 
			<button class="btn btn-default" type="submit" name="page" value="Add">
					 Back to Cart
				</button>
				<button class="btn btn-default" type="submit" name="page" value="Checkout">
					 Checkout
				</button>
			</div>
		</div>
		</form>
	</div>
	<%@ include file = "footer.jsp" %>