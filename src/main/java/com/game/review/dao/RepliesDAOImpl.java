package com.game.review.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.game.review.dto.RepliesDTO;

@Repository
public class RepliesDAOImpl implements RepliesDAO{

	
	   @Autowired
	   private SqlSessionTemplate sst ;
	   
	   @Override
	   public void insertRe(RepliesDTO rdto) {
		   sst.insert("insertRe", rdto) ;
	   }
	   @Override
	   public List<RepliesDTO> selectRe(RepliesDTO rdto){
		   Map<String,Long> map = new HashMap<String,Long>();
		   map.put("kk", rdto.getaNum());
		   
		   
		   return sst.selectList("selectRe" , map);
	   }
	   @Override
	   public List<RepliesDTO> selectdel(RepliesDTO rdto){
		   Map<String,Long> map2 = new HashMap<String,Long>();
		   map2.put("kk", rdto.getaNum());
		   map2.put("kk2", rdto.getmNum());
		   
		   return sst.selectList("selectdel" , map2);
	   }
	   @Override
	   public int selectcount(Long rdto) {
		   return sst.selectOne("selectcount", rdto) ;
	   }
	   @Override
	   public void updateRe(RepliesDTO rdto) {
		   sst.update("updateRe", rdto) ;
	   }
	   @Override
	   public void deleteRe(RepliesDTO rdto) {
		   sst.delete("deleteRe", rdto) ;
	   }
	
	  
}
