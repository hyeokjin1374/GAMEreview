package com.game.review.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.game.review.command.RepliesCommand;
import com.game.review.dao.RepliesDAO;
import com.game.review.dto.RepliesDTO;

@Service
public class RepliesService {
	
	@Autowired
	private RepliesDAO rdao ;
	
	public void insetRe(RepliesCommand rcmd) {
		RepliesDTO rdto = new RepliesDTO() ;
		
		Long i = (long) 1 ;
		rdto.setmNum(i);  // 맴버넘버
		
		rdto.setaNum(rcmd.getaNum());  //리뷰넘버
		rdto.setReContent(rcmd.getReContent());  //댓글내용
		
		rdao.insertRe(rdto);
		
	}
	
	public List<RepliesDTO> selectRe(RepliesDTO rdto){
	    	List<RepliesDTO> rep = rdao.selectRe(rdto);
	    	
	    	return rep ;
	}
	
	public List<RepliesDTO> selectdel(RepliesDTO rdto){
    	List<RepliesDTO> rep = rdao.selectdel(rdto);
    	return rep ;
}
	public int selectcount(Long rdto) {
		int result =  rdao.selectcount(rdto);
	     return result ;
	} 
	
	public void updateRe(RepliesDTO rdto) {
	
		rdao.updateRe(rdto);
		     
	}
	
	public void deleteRe(RepliesDTO rdto) {
	
		rdao.deleteRe(rdto);
	}
	
	
	

}
