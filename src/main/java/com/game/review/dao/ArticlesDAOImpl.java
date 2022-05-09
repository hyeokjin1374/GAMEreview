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
	 
	 @Override
	 public void insert(ArticlesDTO articlesdto) {
		 sqlsessiontemplate.insert("insertArt", articlesdto) ;
	 }
	
	 @Override
	 public List<GamesDTO> selectAll() {
		 return sqlsessiontemplate.selectList("selectList") ;
	 }
	 @Override
	 public List<ArticlesDTO> selectArt() {
		 return sqlsessiontemplate.selectList("selectArt") ;
	 }
	 @Override
	 public List<ArticlesDTO> selectArtAll() {
		 return sqlsessiontemplate.selectList("selectArtAll") ;
	 }
	 
	 // Like 컨트롤러
	 @Override
	 public void insertLike(Long aNum, Long mNum)  {  
		Map<String,Long> map = new HashMap<String, Long>();
		map.put("aNum", aNum) ;
		map.put("mNum", mNum) ;
	    sqlsessiontemplate.insert("insertLike", map) ;
	    
			}
	 
	 // Like 컨트롤러
	 @Override
	 public void deleteLike(Long aNum, Long mNum)  {
		Map<String,Long> map = new HashMap<String, Long>();
		map.put("aNum", aNum) ;
		map.put("mNum", mNum) ;
	    sqlsessiontemplate.delete("deleteLike", map) ;
	    
			}
	 // Like 컨트롤러
	 @Override
	 public int likeCheck(Long aNum, Long mNum)  {
		Map<String,Long> map = new HashMap<String, Long>();
		map.put("aNum", aNum) ;
		map.put("mNum", mNum) ;
	    return sqlsessiontemplate.selectOne("likeCheck", map) ;
	    
			}
	 
	 // Like 컨트롤러
	 @Override
	 public void updateLikeCheck(Long gNum, Long mNum, Long aNum)  {
		Map<String,Long> map = new HashMap<String, Long>();
		map.put("gNum", gNum) ;
		map.put("mNum", mNum) ;
		map.put("aNum", aNum) ;
	    sqlsessiontemplate.update("updateLikeCheck", map) ;
	    
			}
	 
	 // Like 컨트롤러
	 @Override
	 public void updateLikeCheckCancel(Long gNum, Long mNum, Long aNum)  {
		Map<String,Long> map = new HashMap<String,Long>();
		map.put("gNum", gNum) ;
		map.put("mNum", mNum) ;
		map.put("aNum", aNum) ;
	    sqlsessiontemplate.update("updateLikeCheckCancel", map) ;
	    
			}
	
	 @Override
	 public void ArtUpdate(ArticlesDTO articlesdto) {
		 sqlsessiontemplate.update("artupdate", articlesdto) ;
	 }
	 @Override
	 public void ArtDelete(ArticlesDTO articlesdto) {
		 sqlsessiontemplate.delete("artdelete", articlesdto) ;
	 }
	 @Override
	 public List<ArticlesDTO> selectDel(Long gNum, Long mNum, Long aNum) {
		 Map<String,Long> map = new HashMap<String,Long>();
			map.put("gNum", gNum) ;
			map.put("mNum", mNum) ;
			map.put("aNum", aNum) ;
		 return sqlsessiontemplate.selectList("selectDel", map) ;
	 }
	 @Override
	 public List<ArticlesDTO> selectContent(Long gNum, Long mNum, Long aNum) {
		 Map<String,Long> map = new HashMap<String,Long>();
		 map.put("gNum", gNum) ;
			map.put("mNum", mNum) ;
			map.put("aNum", aNum) ;
		 return sqlsessiontemplate.selectList("selectContent", map) ;
	 }
	 
	 
	 
}
