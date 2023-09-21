package com.kh.mybatis.common.template;

import com.kh.mybatis.common.model.vo.PageInfo;

public class Pagenation {
	
	public static PageInfo getPageInfo(int listCount,int currentPage,int pageLimit,int boardLimit) {
		
		// 위의 4개를 가지고 아래 3개의 값을 구해낼 꺼임
		int maxPage = (int)Math.ceil((double)listCount / boardLimit);	
		// 가장 마지막페이지(총 페이지 수)
		int startPage = (currentPage - 1) / pageLimit * pageLimit + 1;	
		// 페이징바의 시작수
		int endPage = startPage + pageLimit - 1;
		// 페이징바의 끝수
		
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		
		PageInfo pi = new PageInfo(listCount, currentPage, pageLimit, boardLimit, maxPage, startPage, endPage);
	
		return pi;
			
	}

}
