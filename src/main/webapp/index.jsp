(선택) src/main/webapp/index.jsp 는 단순 리다이렉트:
<%@ page contentType="text/html; charset=UTF-8" %>
<%
    response.sendRedirect(request.getContextPath() + "/home");
%>

