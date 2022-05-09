package com.game.review.dto;

import java.sql.Timestamp;

import org.apache.ibatis.type.Alias;

@Alias("RepliesDTO")
public class RepliesDTO {
	
	 private Long reNum ;
	 private String reContent;
	 private Long aNum;
	 private Long mNum;
	 private Timestamp reregDate;
	 private Long reCount;
	 
	 private int repcount ; 
	 
	 
	
	public int getRepcount() {
		return repcount;
	}
	public void setRepcount(int repcount) {
		this.repcount = repcount;
	}
	public Timestamp getReregDate() {
		return reregDate;
	}
	public void setReregDate(Timestamp reregDate) {
		this.reregDate = reregDate;
	}
	public Long getReCount() {
		return reCount;
	}
	public void setReCount(Long reCount) {
		this.reCount = reCount;
	}
	public Long getReNum() {
		return reNum;
	}
	public void setReNum(Long reNum) {
		this.reNum = reNum;
	}
	public String getReContent() {
		return reContent;
	}
	public void setReContent(String reContent) {
		this.reContent = reContent;
	}
	public Long getaNum() {
		return aNum;
	}
	public void setaNum(Long aNum) {
		this.aNum = aNum;
	}
	public Long getmNum() {
		return mNum;
	}
	public void setmNum(Long mNum) {
		this.mNum = mNum;
	}
	 
	 

}
