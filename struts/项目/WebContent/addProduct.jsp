<%@ taglib prefix="s" uri="/struts-tags" %>
 
<html>
 
<s:head/>
 
<body>
 
<s:form action="addProduct">
 
  <s:textfield name="product.name" label="product name" />
  <s:submit value="Submit" />
 
</s:form>
 
</body>
</html>