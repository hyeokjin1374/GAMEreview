package com.game.review.dao;

import java.util.List;
import java.util.Map;

import com.game.review.dto.ArticlesDTO;
import com.game.review.dto.GamesDTO;

public interface ArticlesDAO {

	public void insert(ArticlesDTO articlesdto) ;
	
	public List<GamesDTO> selectAll() ;
	
	public List<ArticlesDTO> selectArt() ;
	
	public List<ArticlesDTO> selectArtAll() ;
	
	public void insertLike(Long aNum, Long mNum) ;  // Like 컨트롤러
	
	public void deleteLike(Long aNum, Long mNum) ;   // Like 컨트롤러
	
	public int likeCheck(Long aNum, Long mNum) ;   // Like 컨트롤러
	
	public void updateLikeCheck(Long gNum, Long mNum, Long aNum) ;   // Like 컨트롤러
	
	public void updateLikeCheckCancel(Long gNum, Long mNum, Long aNum) ;   // Like 컨트롤러
	
  
	public void ArtUpdate(ArticlesDTO articlesdto) ;
	
	public void ArtDelete(ArticlesDTO articlesdto) ;

	public List<ArticlesDTO> selectDel(Long gNum, Long mNum, Long aNum);
	
	public List<ArticlesDTO> selectContent(Long gNum, Long mNum, Long aNum);
	
}
