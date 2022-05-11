package com.game.review.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.game.review.command.ArtCommand;
import com.game.review.dao.ArticlesDAO;
import com.game.review.dto.ArticlesDTO;
import com.game.review.dto.GamesDTO;

@Service
public class ArticlesService {
	
	   @Autowired
	   private ArticlesDAO articlesdao ;

	    //리뷰 글 등록 
	   public void artregist(ArtCommand acmd) throws Exception {
		   ArticlesDTO adto = new ArticlesDTO() ;
			/*
			 * SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			 *  Date date = * sdf.parse(acmd.getaRegdate()) ; 
			 *  long time = date.getTime(); 
			 *  Timestamp ts = new Timestamp(time) ; adto.setaRegdate(ts);
			 */
		     Long i = (long) 2 ;
		     
		     adto.setaContent(acmd.getaContent());
             adto.setaScore(acmd.getaScore());
             adto.setgNum(acmd.getgNum());
             
             adto.setmNum(i);
             
             System.out.println("ㅎㅎㅎ");
             System.out.println(adto.getgNum() + "서비스확인");
             articlesdao.insert(adto);
		   
	   }

		/*
		 * //리뷰글 전부 보여주기 public List<GamesDTO> selectAll(){ //지워도 상관없는 list 컨트롤러 확인용
		 * List<GamesDTO> games = articlesdao.selectAll() ;
		 * 
		 * return games ; }
		 */
	   //리뷰 글 번호 순서대로 정렬해서 최신글 보여주기
	   public List<ArticlesDTO> selectArt() {
		   List<ArticlesDTO> art = articlesdao.selectArt() ;
		   
		   return art ;
	   }
		/*
		 * //리뷰글 전부 보여주기 public List<ArticlesDTO> selectArtAll() { List<ArticlesDTO> art
		 * = articlesdao.selectArtAll() ;
		 * 
		 * return art ; }
		 */
	   
	   // Like 컨트롤러
	   // Like 테이블에 aNum과 mNum 정보가 없으면 0에서 1로 인서트
	   public void insertLike(Long aNum, Long mNum) {
		   articlesdao.insertLike(aNum, mNum);
	   }
	   // Like 컨트롤러
	   // Like 테이블에 aNum과 mNum 정보가 있으면 행 딜리트
	   public void deleteLike(Long aNum, Long mNum) {
		   articlesdao.deleteLike(aNum, mNum);
	   }
	   // Like 컨트롤러
	   // Like 테이블에 aNum과 mNum 정보가  있는지 없는지 확인
	   public int likeCheck(Long aNum, Long mNum) {
		   return articlesdao.likeCheck(aNum, mNum);
	   }
	   // Like 컨트롤러
	   // Articles 테이블에 좋아요 컬럼 1추가
	   public void updateLikeCheck(Long gNum, Long mNum, Long aNum) {
		   articlesdao.updateLikeCheck(gNum, mNum, aNum);
	   }
	   // Like 컨트롤러 
	// Articles 테이블에 좋아요 컬럼 1 감소
	   public void updateLikeCheckCancel(Long gNum, Long mNum, Long aNum) {
		   articlesdao.updateLikeCheckCancel(gNum, mNum, aNum);
	   }
	   
	   //리뷰글 수정하기
	   public void ArtUpdate(ArticlesDTO articlesdto) {
		    articlesdao.ArtUpdate(articlesdto);
		   
	   }
	   //리뷰글 삭제하기
	   public void ArtDelete(ArticlesDTO articlesdto) {
		    articlesdao.ArtDelete(articlesdto); 
	   }
	   // 리뷰글 삭제하기전에 내가쓴 리뷰 글 보여주기
	   public List<ArticlesDTO> selectDel(Long gNum, Long mNum, Long aNum) {
		  return articlesdao.selectDel(gNum,  mNum, aNum);
			
	   }
	   // 리뷰글 수정할때 내가 썻던 글 보여주기
	   public List<ArticlesDTO> selectContent(Long gNum, Long mNum, Long aNum) {
			  return articlesdao.selectContent(gNum,  mNum, aNum);
				
		   }

}
