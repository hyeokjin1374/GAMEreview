package com.game.review.dao;

import java.util.List;

import com.game.review.dto.RepliesDTO;

public interface RepliesDAO {

	public void insertRe(RepliesDTO rdto) ; //댓글 등록
	
	public List<RepliesDTO> selectRe(RepliesDTO rdto) ; 	//최신 순서로 댓글 보여주기
	
	
	public int selectcount(Long rdto) ; // Articles 컨트롤러에 사용 댓글이 몇개 달려있는지 보여주기 ex) 댓글 달기(3)
	
	public void deleteRe(RepliesDTO rdto); 	//댓글 삭제하기
	
	public List<RepliesDTO> selectdel(RepliesDTO rdto) ; //댓글 삭제 전에 내가 쓴 댓글들 보여주기
	
	public void updateRe(RepliesDTO rdto) ; //댓글 수정하기
	
	
	
}
