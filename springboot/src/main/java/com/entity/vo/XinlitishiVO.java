package com.entity.vo;

import com.entity.XinlitishiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 心理提示
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 * @date 2023-01-15 10:56:21
 */
public class XinlitishiVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 学生姓名
	 */
	
	private String xueshengxingming;
		
	/**
	 * 评估结果
	 */
	
	private String pinggujieguo;
		
	/**
	 * 提示内容
	 */
	
	private String tishineirong;
		
	/**
	 * 提示时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date tishishijian;
		
	/**
	 * 老师账号
	 */
	
	private String laoshizhanghao;
		
	/**
	 * 老师姓名
	 */
	
	private String laoshixingming;
		
	/**
	 * 头像
	 */
	
	private String touxiang;
		
	/**
	 * 用户id
	 */
	
	private Long userid;
				
	
	/**
	 * 设置：学生姓名
	 */
	 
	public void setXueshengxingming(String xueshengxingming) {
		this.xueshengxingming = xueshengxingming;
	}
	
	/**
	 * 获取：学生姓名
	 */
	public String getXueshengxingming() {
		return xueshengxingming;
	}
				
	
	/**
	 * 设置：评估结果
	 */
	 
	public void setPinggujieguo(String pinggujieguo) {
		this.pinggujieguo = pinggujieguo;
	}
	
	/**
	 * 获取：评估结果
	 */
	public String getPinggujieguo() {
		return pinggujieguo;
	}
				
	
	/**
	 * 设置：提示内容
	 */
	 
	public void setTishineirong(String tishineirong) {
		this.tishineirong = tishineirong;
	}
	
	/**
	 * 获取：提示内容
	 */
	public String getTishineirong() {
		return tishineirong;
	}
				
	
	/**
	 * 设置：提示时间
	 */
	 
	public void setTishishijian(Date tishishijian) {
		this.tishishijian = tishishijian;
	}
	
	/**
	 * 获取：提示时间
	 */
	public Date getTishishijian() {
		return tishishijian;
	}
				
	
	/**
	 * 设置：老师账号
	 */
	 
	public void setLaoshizhanghao(String laoshizhanghao) {
		this.laoshizhanghao = laoshizhanghao;
	}
	
	/**
	 * 获取：老师账号
	 */
	public String getLaoshizhanghao() {
		return laoshizhanghao;
	}
				
	
	/**
	 * 设置：老师姓名
	 */
	 
	public void setLaoshixingming(String laoshixingming) {
		this.laoshixingming = laoshixingming;
	}
	
	/**
	 * 获取：老师姓名
	 */
	public String getLaoshixingming() {
		return laoshixingming;
	}
				
	
	/**
	 * 设置：头像
	 */
	 
	public void setTouxiang(String touxiang) {
		this.touxiang = touxiang;
	}
	
	/**
	 * 获取：头像
	 */
	public String getTouxiang() {
		return touxiang;
	}
				
	
	/**
	 * 设置：用户id
	 */
	 
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	
	/**
	 * 获取：用户id
	 */
	public Long getUserid() {
		return userid;
	}
			
}
