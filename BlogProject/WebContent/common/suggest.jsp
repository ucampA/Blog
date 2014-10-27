<%@page import="blog.model.dto.PostBean"%>
<%@page import="blog.model.dto.BlogBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page contentType = "text/plain; charset=UTF-8" %>
<%@ page import = "java.util.List" %>
<%
	request.setCharacterEncoding("utf-8");
	
	List keywords = (List)request.getAttribute("postList");
	String keyword = request.getParameter("keyword");
	List keywordList;
	
	if (keyword == null || keyword.equals("")){
		keywordList = java.util.Collections.EMPTY_LIST;
	}else{
		keywordList = new ArrayList();
	}
	
	for(int i=0; i < keywords.size(); i++){
		if(	((PostBean)keywords.get(i)).getTitle().toLowerCase().startsWith(keyword.toLowerCase()) || ((PostBean)keywords.get(i)).getTitle().toLowerCase().contains(keyword.toLowerCase())){
			keywordList.add(keywords.get(i));
		}
	}
	
	out.print(keywordList.size());//제시어 개수 출력
	out.print("|");
	out.print("{");
	/* 제시어 목록을 CSV 양식으로 출력 	*/
	for (int i = 0 ; i < keywordList.size() ; i++) {
		int key = ((PostBean)keywordList.get(i)).getNo();
		String title = ((PostBean)keywordList.get(i)).getTitle();
		out.print("'"+key+"':'");
		out.print(title+"'");
		if (i < keywordList.size() - 1) {
			out.print(",");
		}
	}
	out.print("}");
%>