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
public class ArticlesController {

	      @Autowired
	      private ArticlesService articlesservice ;
	      
	      @Autowired
	      private RepliesService rservice ;
	      
	     
	      
	      @RequestMapping(value="/art/{gNum}" ,method = RequestMethod.GET)
	      public String art(@ModelAttribute("artData") ArtCommand acmd ,
	    		  Errors errors, Model model, HttpServletRequest request,
	    		  HttpServletResponse response,
	    		  @PathVariable("gNum") Long gNum
	    		  ) throws ServletException, IOException {
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
	   
	      @RequestMapping(value="/art/{gNum}" ,method = RequestMethod.POST)
	      public String art2(@ModelAttribute("artData") ArtCommand acmd,
	    		  Errors errors,MultipartFile upload,
	    		  @PathVariable("gNum") int gNum) throws Exception {
	    	  System.out.println("리뷰댓글 컨트롤러");
	    	  
	    //	new ArticlesValidator().validate(acmd, errors ) ;
	    	      if(errors.hasErrors()) {
	    	    	  return "/art" ;
	    	      }
	    	    articlesservice.artregist(acmd);  
	    	    
	    	
	    	      return "redirect:/art/{gNum}" ;
	    	  
	      }
	      
	      @RequestMapping(value="/artupdate/{gNum}/{aNum}" ,method = RequestMethod.GET)
	      public String ArtUpdate(@ModelAttribute("ArtUpdateData") ArtCommand acmd,
	    		  Errors errors, @PathVariable("gNum") Long gNum,
	    		  @PathVariable("aNum") Long aNum,Model model) {
	    	  System.out.println("리뷰 업데이트 겟");
	   	     Long mNum = (long) 2 ;
	    	  
	    	  List<ArticlesDTO> art = articlesservice.selectContent(gNum, mNum, aNum);
	    	  System.out.println("art :" + art);
	    	  model.addAttribute("art" ,art);  
	    	  
	    	    return "/artupdate" ; 
	    	  
	      }
	      
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
	    	  
	    	  
	    	  articlesservice.ArtUpdate(adto);
	    	    
	    	    return "redirect:/art/{gNum}" ; 
	    	  
	      }
	      
	      @RequestMapping(value="/artdelete/{gNum}/{aNum}" ,method = RequestMethod.GET)
	      public String ArtDelete(@PathVariable("gNum") Long gNum,
	    		  @PathVariable("aNum") Long aNum,Model model) {
	    	  
	    	  System.out.println("댓글삭제 확인" );
  
	    	Long mNum = (long) 2 ;
	         
	    	  List<ArticlesDTO> delete = articlesservice.selectDel( gNum,  mNum,  aNum);
	    	model.addAttribute("delete" ,delete); 
	    	  System.out.println("리뷰삭제 페이지");
	    	 
	    	  return "/artdelete" ;
	      }
	      
	      @RequestMapping(value="/artdelete/{gNum}/{aNum}" ,method = RequestMethod.POST)
	      public String ArtDelete2( @PathVariable("gNum") Long gNum,
	    		  @PathVariable("aNum") Long aNum) {
	    	  
	    	  System.out.println("리뷰삭제 포스트");
	    
	    	  
	    	  ArticlesDTO adto = new ArticlesDTO() ;
	    	  adto.setaNum(aNum);
	    	  adto.setgNum(gNum);
	    	  adto.setmNum((long) 2);
	    	  
	    	  articlesservice.ArtDelete(adto);
	    	  
	    	  return "redirect:/art/{gNum}" ;
	      }



 
   }  
