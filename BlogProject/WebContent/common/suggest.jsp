<%@page import="blog.model.dto.PostBean"%>
<%@page import="blog.model.dto.BlogBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page contentType = "text/plain; charset=UTF-8" %>
<%@ page import = "java.util.List" %>
<%!
	/* 검색어 목록 */
	String[] keywords = {
		"Ajax", "Ajax실전 프로그래밍", "Ajax 비동기 통신",
		"자라", "자바 프로그래밍", "자바 서버 페이지", "자바스터디",	
		"TEST"
	};
	/* keyword를 사용해서 제시어 목록을 추출해 주는 메소드 */
	public List search(String keyword) {
		if (keyword == null || keyword.equals("")){
			return java.util.Collections.EMPTY_LIST;
		}
	
		List result = new java.util.ArrayList(8);
		
		for ( int i = 0 ; i < keywords.length ; i++ ) {
			if (keywords[i].startsWith(keyword)) {
				result.add(keywords[i]);
			}
		}
		return result; 
	}
%>
<%
	request.setCharacterEncoding("utf-8");
	
	List keywords = (List)request.getAttribute("postList");
	System.out.println(request.getAttribute("postList"));
	String keyword = request.getParameter("keyword");
	System.out.println(keyword);
	//List keywordList = search(keyword);
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