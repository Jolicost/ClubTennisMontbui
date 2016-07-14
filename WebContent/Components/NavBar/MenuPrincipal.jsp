<%@ page import="Communicacio.Dades.Accions.*" %>
<%@ page import="java.util.List" %>
<%
InfoAccions ia = (InfoAccions) request.getAttribute("MenuPrincipal");
InfoAccions mu = (InfoAccions) request.getAttribute("MenuUsuari");
%> 
<nav class="navbar navbar-default">
<div class="container-fluid"> 
	<div class="navbar-header">
		<a class="navbar-brand" href="index">Club Tennis Montbui</a>
	</div> 
	<ul class="nav navbar-nav">
		<%
		for (InfoAccio a: ia.getAccions()){
			if (a.EsGrup()){
				%>
				<li class="dropdown">
	    			<a class="dropdown-toggle" data-toggle="dropdown" href="#"><%= a.getTitol() %>
	    			<span class="caret"></span></a>
	    				<ul class="dropdown-menu">
	      				<%
	      					List<InfoAccio> l = a.getAccions();
	      					for (InfoAccio b: l){
	      					%>
	      						<li><a href='<%= b.getDispacher() %>'><%= b.getTitol() %></a></li>
	      					<%		
	      					}
	      				%>
	    				</ul>
	  			</li>
				
				
				<%				
			}
			else{
				%>
					<li><a href='<%= a.getDispacher() %>'><%= a.getTitol() %></a></li>
				<%		
			}
		}
		%>
	</ul>
	<ul class="nav navbar-nav navbar-right">
		<%
		for (InfoAccio a: mu.getAccions()){
				%>
				<li>
	    			<a href="<%= a.getDispacher() %>">
	    				<span class="glyphicon glyphicon-<%= a.getGlyph() %>">
	    				</span> <%= a.getTitol() %>
	    			</a>
	  			</li>
				
				
				<%				
		}
		%>
	</ul>
</div>
</nav>