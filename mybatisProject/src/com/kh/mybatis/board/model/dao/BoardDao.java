package com.kh.mybatis.board.model.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.kh.mybatis.board.model.vo.Board;
import com.kh.mybatis.board.model.vo.Reply;
import com.kh.mybatis.common.model.vo.PageInfo;

public class BoardDao {

	public int selectListCount(SqlSession sqlSession) {
		
		int listCount = sqlSession.selectOne("boardMapper.selectListCount");
		
		return listCount;
	}

	public ArrayList<Board> selectList(SqlSession sqlSession, PageInfo pi) {

//		sqlSession.selectList("boardMapper.selectList");
		
//		마이바티스에서는 페이징 처리를 위해 RowBounds 라는 클래스 제공
		
//		* offset : 몇 개의 게시글 건너뛰고 조회할건지에 대한 값
		
		/*
		 * ex) boardLimit : 한페이지당 몇개의 게시글을 보여줄지 / 5
		 * 								offset(건너뛸숫자)		limit(조회할숫자)
		 * currentPage : 1    1~5			0					5
		 * currentPage : 2    6~10			5					5
		 * currentPage : 3    11~15			10					5
		 * ....
		 */
		
//		int offset = (현재페이지 -1 ) * 몇개씩 보여줄껀지
		int offset = (pi.getCurrentPage() -1 ) * pi.getBoardLimit();
		int limit = pi.getBoardLimit();
		
		RowBounds rowBounds = new RowBounds(offset, limit);
		
//		sqlSession.selectList("맵퍼아이디.쿼리아이디", 퀴리가 불완전하면 채워줄 무언가, rowBounds)
		
		
		ArrayList<Board> list = (ArrayList)sqlSession.selectList("boardMapper.selectList", null, rowBounds);
		
		return list;
	}

	public int increaseCount(SqlSession sqlSession, int boardNo) {

		int result = sqlSession.update("boardMapper.increaseCount", boardNo);
		
		return result;
	}

	public Board selectBoard(SqlSession sqlSession, int boardNo) {

		
		Board b = sqlSession.selectOne("boardMapper.selectBoard", boardNo);
		
		return b;
	}

	public ArrayList<Reply> selectReplyList(SqlSession sqlSession, int boardNo) {

		ArrayList<Reply> list = (ArrayList)sqlSession.selectList("boardMapper.selectReplyList", boardNo);
		
		return list;
	}

	public int selectSearchCount(SqlSession sqlSession, HashMap<String, String> map) {
		
		int searchCount = sqlSession.selectOne("boardMapper.selectSearchCount", map);
		
		return searchCount;
	}

	public ArrayList<Board> selectSearchList(SqlSession sqlSession, HashMap<String, String> map, PageInfo pi) {

		
		int offset = (pi.getCurrentPage() -1 ) * pi.getBoardLimit();
		int limit = pi.getBoardLimit();
		
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		ArrayList<Board> list = (ArrayList)sqlSession.selectList("boardMapper.selectSearchList", map, rowBounds);
		
		return list;
	}

	public int deleteBoard(SqlSession sqlSession, int boardNo) {

		int result = sqlSession.update("boardMapper.deleteBoard", boardNo);
		
		return result;
	}

}
