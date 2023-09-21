package com.kh.mybatis.common.template;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Template {
	/*
	 *  기존 JDBC
	 * 
	 * public static connection getConnection(){
	 * 		// drivdr.porperties 파일 읽어들여서 
	 *		// 해당 DB와 접속된 Connection 객체 생성해서 반환
	 * }
	 * 
	 * public static void close(JDBC용 객체){
	 * 		// 전달받은 JDBC용 객체를 반납시키는 구문
	 * }
	 * 
	 * public static void commit|rollback(connection conn){
	 * 		// 트렌젝션 처리
	 * }
	 */

		// 마이바티스
	
	public static SqlSession getSqlSession() {
		// mybatis-config.xml 파일 읽어들여서 
		// 해당 DB와 점속된 SqlSession 객체 생성해서 반환
		SqlSession sqlSession = null;
		
		// SqlSession 생성하기 위해서 => SqlSessionFactory 필요
		// SqlSessionFactory 생성하기 위해서 => SqlSessionFactoryBilder 필요
		
		String resource = "/mybatis-config.xml";
		
		try {
			
			InputStream stream = Resources.getResourceAsStream(resource); // Resources는 io로 임폴트 해라
			
			sqlSession = new SqlSessionFactoryBuilder().build(stream).openSession(false);
											// openSession() : 기본값은 false , 안하면 에러남 해줘야함
											// openSession(boolean flag) : 자동커밋 여부 (true: 하것다, false: 안하것다)
											//     ㄴ> 개발자가  autoCommit 여부를 직접 설정함 
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		return sqlSession;
	}






}
