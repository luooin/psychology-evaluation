package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.XinlipingguEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.XinlipingguVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.XinlipingguView;


/**
 * 心理评估
 *
 * @author 
 * @email 
 * @date 2023-01-15 10:56:21
 */
public interface XinlipingguService extends IService<XinlipingguEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<XinlipingguVO> selectListVO(Wrapper<XinlipingguEntity> wrapper);
   	
   	XinlipingguVO selectVO(@Param("ew") Wrapper<XinlipingguEntity> wrapper);
   	
   	List<XinlipingguView> selectListView(Wrapper<XinlipingguEntity> wrapper);
   	
   	XinlipingguView selectView(@Param("ew") Wrapper<XinlipingguEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<XinlipingguEntity> wrapper);
   	

}

