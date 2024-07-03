package com.entity.view;

import com.entity.XinlizixunEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 心理咨询
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-01-15 10:56:21
 */
@TableName("xinlizixun")
public class XinlizixunView  extends XinlizixunEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public XinlizixunView(){
	}
 
 	public XinlizixunView(XinlizixunEntity xinlizixunEntity){
 	try {
			BeanUtils.copyProperties(this, xinlizixunEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
