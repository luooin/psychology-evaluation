package com.entity.view;

import com.entity.XinlipingguEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 心理评估
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-01-15 10:56:21
 */
@TableName("xinlipinggu")
public class XinlipingguView  extends XinlipingguEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public XinlipingguView(){
	}
 
 	public XinlipingguView(XinlipingguEntity xinlipingguEntity){
 	try {
			BeanUtils.copyProperties(this, xinlipingguEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
