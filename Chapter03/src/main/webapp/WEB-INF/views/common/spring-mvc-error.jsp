<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isErrorPage="true"%>
<h1>Error Page</h1>
URL: ${url}
<BR />
Exception: ${exception.message}
<c:forEach items="${exception.stackTrace}" var="exceptionStackTrace">    
		${exceptionStackTrace} 
    </c:forEach>
