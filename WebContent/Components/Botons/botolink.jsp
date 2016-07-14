<%@ page import="java.util.Map" %>
<script>
	$(document).ready(function() {
	$.getScript("Components/Util/getpost.js");
	$('#<%=request.getAttribute("id").toString() %>').click( function(){
		<% 
		String submit = request.getAttribute("submit").toString();
		String method = request.getAttribute("method").toString();
		Map<String,String> params = (Map<String,String>) (Map<?,?>) request.getAttribute("parameters");
		if (method == null || method != "post" || method != "get") method = "get";
		%><%=method%>('<%=submit%>',{<%
				int i = 0;
				for (String s: params.keySet()){
					String v = params.get(s);
				%>
				<% if (i > 0) {%>,<%}%><%=
				s%>:'<%=v%>'<%
				i++;
				}
				%>});
    });
   
	  
    
} );
</script>