<%@page isELIgnored="false" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
 
<html>
<body>
<s:form action="upload" enctype="multipart/form-data" method="post">
  <s:file name="doc" label="upload" />
  <s:submit value="Submit" />
</s:form>
</body>
</html>