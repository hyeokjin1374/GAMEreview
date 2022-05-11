package com.game.review.dao;

import java.util.List;
import java.util.Map;

import com.game.review.dto.ArticlesDTO;
import com.game.review.dto.GamesDTO;

public interface ArticlesDAO {

	public void insert(ArticlesDTO articlesdto) ;
	
	/* public List<GamesDTO> selectAll() ; */   //list 컨트롤러 확인용 지워도 상관없음
	
	//리뷰 글 번호 순서대로 정렬해서 최신글 보여주기
	public List<ArticlesDTO> selectArt() ;
	
	/* public List<ArticlesDTO> selectArtAll() ; */
	
	  // Like 컨트롤러
	   // Like 테이블에 aNum과 mNum 정보가 없으면 0에서 1로 인서트
	public void insertLike(Long aNum, Long mNum) ;  // Like 컨트롤러
	
	 // Like 컨트롤러
	   // Like 테이블에 aNum과 mNum 정보가 있으면 행 딜리트
	public void deleteLike(Long aNum, Long mNum) ;   // Like 컨트롤러
	
	  // Like 컨트롤러
	   // Like 테이블에 aNum과 mNum 정보가  있는지 없는지 확인
	public int likeCheck(Long aNum, Long mNum) ;   // Like 컨트롤러
	
	   // Like 컨트롤러
	   // Articles 테이블에 좋아요 컬럼 1추가
	public void updateLikeCheck(Long gNum, Long mNum, Long aNum) ;   // Like 컨트롤러
	
	   // Like 컨트롤러 
		// Articles 테이블에 좋아요 컬럼 1 감소
	public void updateLikeCheckCancel(Long gNum, Long mNum, Long aNum) ;   // Like 컨트롤러
	
	  //리뷰글 수정하기
	public void ArtUpdate(ArticlesDTO articlesdto) ;
	
	  //리뷰글 삭제하기
	public void ArtDelete(ArticlesDTO articlesdto) ;

	   // 리뷰글 삭제하기전에 내가쓴 리뷰 글 보여주기
	public List<ArticlesDTO> selectDel(Long gNum, Long mNum, Long aNum);
	
	// 리뷰글 수정할때 내가 썻던 글 보여주기
	public List<ArticlesDTO> selectContent(Long gNum, Long mNum, Long aNum);
	
}
