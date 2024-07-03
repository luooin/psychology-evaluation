package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 心理评估
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2023-01-15 10:56:21
 */
@TableName("xinlipinggu")
public class XinlipingguEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public XinlipingguEntity() {
		
	}
	
	public XinlipingguEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 学号
	 */
					
	private String xuehao;
	
	/**
	 * 学生姓名
	 */
					
	private String xueshengxingming;
	
	/**
	 * 测试名称
	 */
					
	private String ceshimingcheng;
	
	/**
	 * 测试成绩
	 */
					
	private String ceshichengji;
	
	/**
	 * 心理评估
	 */
					
	private String xinlipinggu;
	
	/**
	 * 评估结果
	 */
					
	private String pinggujieguo;
	
	/**
	 * 评估时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date pinggushijian;
	
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
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：学号
	 */
	public void setXuehao(String xuehao) {
		this.xuehao = xuehao;
	}
	/**
	 * 获取：学号
	 */
	public String getXuehao() {
		return xuehao;
	}
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
	 * 设置：测试名称
	 */
	public void setCeshimingcheng(String ceshimingcheng) {
		this.ceshimingcheng = ceshimingcheng;
	}
	/**
	 * 获取：测试名称
	 */
	public String getCeshimingcheng() {
		return ceshimingcheng;
	}
	/**
	 * 设置：测试成绩
	 */
	public void setCeshichengji(String ceshichengji) {
		this.ceshichengji = ceshichengji;
	}
	/**
	 * 获取：测试成绩
	 */
	public String getCeshichengji() {
		return ceshichengji;
	}
	/**
	 * 设置：心理评估
	 */
	public void setXinlipinggu(String xinlipinggu) {
		this.xinlipinggu = xinlipinggu;
	}
	/**
	 * 获取：心理评估
	 */
	public String getXinlipinggu() {
		return xinlipinggu;
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
	 * 设置：评估时间
	 */
	public void setPinggushijian(Date pinggushijian) {
		this.pinggushijian = pinggushijian;
	}
	/**
	 * 获取：评估时间
	 */
	public Date getPinggushijian() {
		return pinggushijian;
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
