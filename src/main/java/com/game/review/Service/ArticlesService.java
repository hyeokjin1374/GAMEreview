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
	   
	   public List<GamesDTO> selectAll(){
		   List<GamesDTO> games = articlesdao.selectAll() ;
		   
		   return games ;
	   }
	   public List<ArticlesDTO> selectArt() {
		   List<ArticlesDTO> art = articlesdao.selectArt() ;
		   
		   return art ;
	   }
	   public List<ArticlesDTO> selectArtAll() {
		   List<ArticlesDTO> art = articlesdao.selectArtAll() ;
		   
		   return art ;
	   }
	   
	   public void insertLike(Long aNum, Long mNum) {
		   articlesdao.insertLike(aNum, mNum);
	   }
	   public void deleteLike(Long aNum, Long mNum) {
		   articlesdao.deleteLike(aNum, mNum);
	   }
	   public int likeCheck(Long aNum, Long mNum) {
		   return articlesdao.likeCheck(aNum, mNum);
	   }
	   public void updateLikeCheck(Long gNum, Long mNum, Long aNum) {
		   articlesdao.updateLikeCheck(gNum, mNum, aNum);
	   }
	   public void updateLikeCheckCancel(Long gNum, Long mNum, Long aNum) {
		   articlesdao.updateLikeCheckCancel(gNum, mNum, aNum);
	   }
	   
	   public void ArtUpdate(ArticlesDTO articlesdto) {
		    articlesdao.ArtUpdate(articlesdto);
		   
	   }
	   public void ArtDelete(ArticlesDTO articlesdto) {
		    articlesdao.ArtDelete(articlesdto); 
	   }
	   public List<ArticlesDTO> selectDel(Long gNum, Long mNum, Long aNum) {
		  return articlesdao.selectDel(gNum,  mNum, aNum);
			
	   }
	   public List<ArticlesDTO> selectContent(Long gNum, Long mNum, Long aNum) {
			  return articlesdao.selectContent(gNum,  mNum, aNum);
				
		   }

}
