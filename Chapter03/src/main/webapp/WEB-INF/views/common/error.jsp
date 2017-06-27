<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isErrorPage="true"%>
<H3>Exception for ${pageContext.errorData.requestURI}</H3>
${pageContext.exception}
<H3>Complete Stack Trace is</H3>
<c:forEach var="trace" items="${pageContext.exception.stackTrace}">
${trace}
</c:forEach>
