<%@ page import="java.util.List" %>
<%
List<String> errors = (List<String>) (List<?>)request.getAttribute("errors");
List<String> success = (List<String>) (List<?>)request.getAttribute("success");
%>

<% if (errors.size() > 0 || success.size() > 0){%>
	<div class="container">
		<div class="row">
		<div id="llistaerrors">
		<ul class="col-md-4 col-md-offset-4">
		<%
			for (String s: errors){
			%>
					<li class="text-danger"><%=s%></li>
			<%
			}
			for (String s: success){
			%>
					<li class="text-success"><%=s%></li>
			<%
			}
		%>
		</ul>
		</div>
		</div>	
	</div>
<%}%>