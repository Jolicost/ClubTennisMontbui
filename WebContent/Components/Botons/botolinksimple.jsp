<%@ page import="java.util.Map" %>
<script>
<% 
	String submit = request.getParameter("submit");
	String id = request.getParameter("id");
	String param = request.getParameter("param");
	String value = request.getParameter("value");
%>
$(document).ready(function() {
	$.getScript("Components/Util/getpost.js");
	$("[id='<%=id %>']").click( function(){
		get('<%=submit%>',{<%=param%>:'<%=value%>'});
    });
   
	  
    
});
</script>