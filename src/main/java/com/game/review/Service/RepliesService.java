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
	
	
	//댓글 등록
	public void insetRe(RepliesCommand rcmd) {
		RepliesDTO rdto = new RepliesDTO() ;
		
		Long i = (long) 1 ;
		rdto.setmNum(i);  // 맴버넘버
		
		rdto.setaNum(rcmd.getaNum());  //리뷰넘버
		rdto.setReContent(rcmd.getReContent());  //댓글내용
		
		rdao.insertRe(rdto);
		
	}
	
	//최신 순서로 댓글 보여주기
	public List<RepliesDTO> selectRe(RepliesDTO rdto){
	    	List<RepliesDTO> rep = rdao.selectRe(rdto);
	    	
	    	return rep ;
	}
	
	// Articles 컨트롤러에 사용 댓글이 몇개 달려있는지 보여주기 ex) 댓글 달기(3)
	public int selectcount(Long rdto) {
		int result =  rdao.selectcount(rdto);
	     return result ;
	} 
	
	//댓글 수정하기
	public void updateRe(RepliesDTO rdto) {
	
		rdao.updateRe(rdto);
		     
	}
	
	//댓글 삭제 전에 내가 쓴 댓글들 보여주기
	public List<RepliesDTO> selectdel(RepliesDTO rdto){
		List<RepliesDTO> rep = rdao.selectdel(rdto);
		return rep ;
	}
	
	//댓글 삭제하기
	public void deleteRe(RepliesDTO rdto) {
	
		rdao.deleteRe(rdto);
	}
	
	
	

}
