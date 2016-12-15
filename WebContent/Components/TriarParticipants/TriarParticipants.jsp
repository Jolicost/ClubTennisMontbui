<%@ page import="Communicacio.Dades.InfoSoci" %>
<%@ page import="Communicacio.Dades.Reserves.Participants.*" %>
<%@ page import="Presentacio.Components.Gestors.Taules.*" %>
<%@ page import="Presentacio.Controladors.*" %>
<%@ page import="java.util.*" %>
<%
InfoTriarParticipants i = (InfoTriarParticipants) request.getAttribute("info");
%>
<script src="/Components/TriarParticipants/TriarParticipants.js"></script>
<script src="https://cdn.datatables.net/1.10.11/js/jquery.dataTables.min.js"></script>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.11/css/jquery.dataTables.min.css">
<script>
	var min = <%= i.getMinim() %>;
	var max = <%= i.getMaxim() %>;
</script>
<div class="container">
	<div class="row">
		<div class="col col-md-12">
		<h2 class="text">Tria els participants:
		<span class="text text-muted small">Mínim: <%=i.getMinim() - 1 %> ;</span>
		<span class="text text-muted small">Màxim: <%= i.getMaxim() - 1 %></span>
		</h3>
		<button class="btn btn-default center-block" id="seleccionar">Seleccionar</button>
		<%
			if (i.getSocis().size() > 0){
				InfoSoci is = i.getSocis().iterator().next();
				Set<List<String>> values = i.getPublicAttributesSocis();
				%>
				<table id="socis">
					<thead>
					<tr>
						<%
						for (String s:is.getPublicAttributesNames()){
						%>
							<th><%=s %></th>
						<%
						}
						%>
					</tr>	
					</thead>
					<tbody>		
					<%
						for (List<String> l:values){
						%>
							<tr>
							<% 
							for (String s: l){
								%>
									<td><%=s %></td>							
								<%
							}
							%>
							</tr>
						<%
						}
					%>
					</tbody>	
				</table>
				<%
			}
		%>
		</div>
	</div>
</div>
