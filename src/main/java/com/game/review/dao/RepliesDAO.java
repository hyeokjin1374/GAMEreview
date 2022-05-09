package com.game.review.dao;

import java.util.List;

import com.game.review.dto.RepliesDTO;

public interface RepliesDAO {

	public void insertRe(RepliesDTO rdto) ;
	
	public List<RepliesDTO> selectRe(RepliesDTO rdto) ;
	
	public List<RepliesDTO> selectdel(RepliesDTO rdto) ;
	
	public int selectcount(Long rdto) ;
	
	public void deleteRe(RepliesDTO rdto);
	
	public void updateRe(RepliesDTO rdto) ;
	
	
	
}
