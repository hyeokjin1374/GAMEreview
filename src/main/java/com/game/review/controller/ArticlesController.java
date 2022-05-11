package com.game.review.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.game.review.Service.ArticlesService;
import com.game.review.Service.RepliesService;
import com.game.review.command.ArtCommand;
import com.game.review.dto.ArticlesDTO;

@Controller
//리뷰 등록 컨트롤러
public class ArticlesController {

	      @Autowired
	      private ArticlesService articlesservice ;
	      
	      @Autowired
	      private RepliesService rservice ;
	      
	     
	      //리뷰등록 할때
	      @RequestMapping(value="/art/{gNum}" ,method = RequestMethod.GET)
	      public String art(@ModelAttribute("artData") ArtCommand acmd ,
	    		  Errors errors, Model model, HttpServletRequest request,
	    		  HttpServletResponse response,
	    		  @PathVariable("gNum") Long gNum
	    		  ) throws ServletException, IOException {
	    	  
	    	  // art 는  등록한 리뷰를 selectArt 쿼리문으로  A_NUM 순서대로 리뷰등록한 글 보이게 
	    	  // selectcount 리뷰글에 댓글이 몇개 달려있는지 확인 ex) 댓글달기(3) 댓글 3개가 있다.
	    	  List<ArticlesDTO> art = articlesservice.selectArt() ;
	    	  
	    	  for(int i = 0 ; i < art.size() ; i++) {
		    		int result = rservice.selectcount(art.get(i).getaNum());
		    		art.get(i).setRepcount(result);
		    	 }
	    	  model.addAttribute("art" , art) ;
	    	  
	    	  System.out.println(acmd.getgNum() + "게임넘버");
	    	  System.out.println("게임 넘버는: " + gNum);   	 
	    	
	    	  return "/art" ;
	      }
	       
	      //리뷰등록 할때
	      @RequestMapping(value="/art/{gNum}" ,method = RequestMethod.POST)
	      public String art2(@ModelAttribute("artData") ArtCommand acmd,
	    		  Errors errors,MultipartFile upload,
	    		  @PathVariable("gNum") int gNum) throws Exception {
	    	  System.out.println("리뷰댓글 컨트롤러");
	    	  
	    //	new ArticlesValidator().validate(acmd, errors ) ;
	    	      if(errors.hasErrors()) {
	    	    	  return "/art" ;
	    	      }
	    	      //artregist >> 리뷰등록 인서트
	    	    articlesservice.artregist(acmd);  
	    	    
	    	
	    	      return "redirect:/art/{gNum}" ;
	    	  
	      }
	      
	      // 리뷰 수정하기
	      @RequestMapping(value="/artupdate/{gNum}/{aNum}" ,method = RequestMethod.GET)
	      public String ArtUpdate(@ModelAttribute("ArtUpdateData") ArtCommand acmd,
	    		  Errors errors, @PathVariable("gNum") Long gNum,
	    		  @PathVariable("aNum") Long aNum,Model model) {
	    	  System.out.println("리뷰 업데이트 겟");
	   	     Long mNum = (long) 2 ;
	    	  
	   	      //내가 작성했던 리뷰글 보여주기
	    	  List<ArticlesDTO> art = articlesservice.selectContent(gNum, mNum, aNum);
	    	  System.out.println("art :" + art);
	    	  model.addAttribute("art" ,art);  
	    	  
	    	    return "/artupdate" ; 
	    	  
	      }
	      
	      //리뷰 수정하기 
	      @RequestMapping(value="/artupdate/{gNum}/{aNum}" ,method = RequestMethod.POST)
	      public String ArtUpdate2(@ModelAttribute("ArtUpdateData") ArtCommand acmd,
	    		  Errors errors, @PathVariable("gNum") Long gNum,
	    		  @PathVariable("aNum") Long aNum) {
	    	  
	    	  System.out.println("리뷰 업데이트 포스트");
	    	  ArticlesDTO adto = new ArticlesDTO();
	    	  adto.setaContent(acmd.getaContent());
	    	  adto.setgNum(gNum);
	    	  adto.setaNum(aNum);
	    	  adto.setmNum((long) 2);
	    	  adto.setaScore(acmd.getaScore());
	    	  
	    	  //리뷰 수정 업데이트문
	    	  articlesservice.ArtUpdate(adto);
	    	    
	    	    return "redirect:/art/{gNum}" ; 
	    	  
	      }
	      
	      //리뷰글 삭제하기
	      @RequestMapping(value="/artdelete/{gNum}/{aNum}" ,method = RequestMethod.GET)
	      public String ArtDelete(@PathVariable("gNum") Long gNum,
	    		  @PathVariable("aNum") Long aNum,Model model) {
	    	  
	    	  System.out.println("댓글삭제 확인" );
  
	    	Long mNum = (long) 2 ;
	         
	    	    //리뷰글 삭제하기 전에 내가 쓴 리뷰글 확인하기
	    	  List<ArticlesDTO> delete = articlesservice.selectDel( gNum,  mNum,  aNum);
	    	model.addAttribute("delete" ,delete); 
	    	  System.out.println("리뷰삭제 페이지");
	    	 
	    	  return "/artdelete" ;
	      }
	      
	      //리뷰글 삭제
	      @RequestMapping(value="/artdelete/{gNum}/{aNum}" ,method = RequestMethod.POST)
	      public String ArtDelete2( @PathVariable("gNum") Long gNum,
	    		  @PathVariable("aNum") Long aNum) {
	    	  
	    	  System.out.println("리뷰삭제 포스트");
	    
	    	  
	    	  ArticlesDTO adto = new ArticlesDTO() ;
	    	  adto.setaNum(aNum);
	    	  adto.setgNum(gNum);
	    	  adto.setmNum((long) 2);
	    	  
	    	  //리뷰글 삭제하기
	    	  articlesservice.ArtDelete(adto);
	    	  
	    	  return "redirect:/art/{gNum}" ;
	      }



 
   }  
