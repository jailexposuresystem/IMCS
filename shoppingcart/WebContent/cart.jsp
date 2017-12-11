<%@ page import="com.shoppingcart.model.Item,java.util.*" %>

<title>Cart</title>
<%@ include file = "header.jsp" %>
	<div class="row">
		<%@ include file = "menu.jsp" %>
		
		<form action="CartServlet" name="addtocartform" method="post">
		<%-- <input type="hidden" name="page" value="<%= request.getAttribute("page")%>"> --%>
		<div class="col-md-10">
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
					 System.out.println(request.getAttribute("page"));  
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
				 
			<button class="btn btn-default" type="submit" name="page" value="Add">
					 Add to Cart
				</button>
				<button class="btn btn-default" type="submit" name="page" value="Summary">
					 Checkout
				</button>
			</div>
		</div>
		</form>
	</div>
	<%@ include file = "footer.jsp" %>