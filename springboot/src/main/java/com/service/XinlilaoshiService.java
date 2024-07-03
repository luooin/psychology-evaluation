package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.XinlilaoshiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.XinlilaoshiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.XinlilaoshiView;


/**
 * 心理老师
 *
 * @author 
 * @email 
 * @date 2023-01-15 10:56:21
 */
public interface XinlilaoshiService extends IService<XinlilaoshiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<XinlilaoshiVO> selectListVO(Wrapper<XinlilaoshiEntity> wrapper);
   	
   	XinlilaoshiVO selectVO(@Param("ew") Wrapper<XinlilaoshiEntity> wrapper);
   	
   	List<XinlilaoshiView> selectListView(Wrapper<XinlilaoshiEntity> wrapper);
   	
   	XinlilaoshiView selectView(@Param("ew") Wrapper<XinlilaoshiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<XinlilaoshiEntity> wrapper);
   	

}

