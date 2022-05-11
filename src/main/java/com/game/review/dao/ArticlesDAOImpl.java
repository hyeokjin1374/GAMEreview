package com.game.review.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.game.review.dto.ArticlesDTO;
import com.game.review.dto.GamesDTO;

@Repository
public class ArticlesDAOImpl implements ArticlesDAO{
	
	 @Autowired
	 private SqlSessionTemplate sqlsessiontemplate ;
	 
	 //리뷰 글 등록 
	 @Override
	 public void insert(ArticlesDTO articlesdto) {
		 sqlsessiontemplate.insert("insertArt", articlesdto) ;
	 }
	
		/*
		 * @Override public List<GamesDTO> selectAll() { //지워도 상관없는 list 컨트롤러 확인용 return
		 * sqlsessiontemplate.selectList("selectList") ; }
		 */
	 
	//리뷰 글 번호 순서대로 정렬해서 최신글 보여주기
	 @Override
	 public List<ArticlesDTO> selectArt() {
		 return sqlsessiontemplate.selectList("selectArt") ;
	 }
	 
		/*
		 * @Override public List<ArticlesDTO> selectArtAll() { return
		 * sqlsessiontemplate.selectList("selectArtAll") ; }
		 */
	 
	  // Like 컨트롤러
	   // Like 테이블에 aNum과 mNum 정보가 없으면 0에서 1로 인서트
	 @Override
	 public void insertLike(Long aNum, Long mNum)  {  
		Map<String,Long> map = new HashMap<String, Long>();
		map.put("aNum", aNum) ;
		map.put("mNum", mNum) ;
	    sqlsessiontemplate.insert("insertLike", map) ;
	    
			}
	 
	 // Like 컨트롤러
	   // Like 테이블에 aNum과 mNum 정보가 있으면 행 딜리트
	 @Override
	 public void deleteLike(Long aNum, Long mNum)  {
		Map<String,Long> map = new HashMap<String, Long>();
		map.put("aNum", aNum) ;
		map.put("mNum", mNum) ;
	    sqlsessiontemplate.delete("deleteLike", map) ;
	    
			}
	 
	   // Like 컨트롤러
	   // Like 테이블에 aNum과 mNum 정보가  있는지 없는지 확인
	 @Override
	 public int likeCheck(Long aNum, Long mNum)  {
		Map<String,Long> map = new HashMap<String, Long>();
		map.put("aNum", aNum) ;
		map.put("mNum", mNum) ;
	    return sqlsessiontemplate.selectOne("likeCheck", map) ;
	    
			}
	 
	// Like 컨트롤러
	   // Articles 테이블에 좋아요 컬럼 1추가인
	 @Override
	 public void updateLikeCheck(Long gNum, Long mNum, Long aNum)  {
		Map<String,Long> map = new HashMap<String, Long>();
		map.put("gNum", gNum) ;
		map.put("mNum", mNum) ;
		map.put("aNum", aNum) ;
	    sqlsessiontemplate.update("updateLikeCheck", map) ;
	    
			}
	 
	   // Like 컨트롤러 
		// Articles 테이블에 좋아요 컬럼 1 감소
	 @Override
	 public void updateLikeCheckCancel(Long gNum, Long mNum, Long aNum)  {
		Map<String,Long> map = new HashMap<String,Long>();
		map.put("gNum", gNum) ;
		map.put("mNum", mNum) ;
		map.put("aNum", aNum) ;
	    sqlsessiontemplate.update("updateLikeCheckCancel", map) ;
	    
			}
	
	//리뷰글 수정하기
	 @Override
	 public void ArtUpdate(ArticlesDTO articlesdto) {
		 sqlsessiontemplate.update("artupdate", articlesdto) ;
	 }
	   //리뷰글 삭제하기
	 @Override
	 public void ArtDelete(ArticlesDTO articlesdto) {
		 sqlsessiontemplate.delete("artdelete", articlesdto) ;
	 }
	 
	// 리뷰글 삭제하기전에 내가쓴 리뷰 글 보여주기
	 @Override
	 public List<ArticlesDTO> selectDel(Long gNum, Long mNum, Long aNum) {
		 Map<String,Long> map = new HashMap<String,Long>();
			map.put("gNum", gNum) ;
			map.put("mNum", mNum) ;
			map.put("aNum", aNum) ;
		 return sqlsessiontemplate.selectList("selectDel", map) ;
	 }
	 
	// 리뷰글 수정할때 내가 썻던 글 보여주기
	 @Override
	 public List<ArticlesDTO> selectContent(Long gNum, Long mNum, Long aNum) {
		 Map<String,Long> map = new HashMap<String,Long>();
		 map.put("gNum", gNum) ;
			map.put("mNum", mNum) ;
			map.put("aNum", aNum) ;
		 return sqlsessiontemplate.selectList("selectContent", map) ;
	 }
	 
	 
	 
}
