package com.game.review.dto;

import java.sql.Timestamp;

import org.apache.ibatis.type.Alias;

@Alias("GamesDTO")
public class GamesDTO {
	
	private Long gNum;     //게임 넘버
	private String gCode;  //코드
	private String gName;  // 이름
	private String gDev;  //개발사
	private Timestamp gDate;  // 출시일
	private Long gPrice;  //가격
	private String gAvg;  // 평점
	private String gContent;  //내용
	private String adNum ;  //관리자 넘버
	
	
	public Long getgNum() {
		return gNum;
	}
	public void setgNum(Long gNum) {
		this.gNum = gNum;
	}
	public String getgCode() {
		return gCode;
	}
	public void setgCode(String gCode) {
		this.gCode = gCode;
	}
	public String getgName() {
		return gName;
	}
	public void setgName(String gName) {
		this.gName = gName;
	}
	public String getgDev() {
		return gDev;
	}
	public void setgDev(String gDev) {
		this.gDev = gDev;
	}
	
	public Timestamp getgDate() {
		return gDate;
	}
	public void setgDate(Timestamp gDate) {
		this.gDate = gDate;
	}
	public Long getgPrice() {
		return gPrice;
	}
	public void setgPrice(Long gPrice) {
		this.gPrice = gPrice;
	}
	public String getgAvg() {
		return gAvg;
	}
	public void setgAvg(String gAvg) {
		this.gAvg = gAvg;
	}
	public String getgContent() {
		return gContent;
	}
	public void setgContent(String gContent) {
		this.gContent = gContent;
	}
	public String getAdNum() {
		return adNum;
	}
	public void setAdNum(String adNum) {
		this.adNum = adNum;
	}
	

	
	
	
}
