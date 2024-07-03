package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.XinlitishiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.XinlitishiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.XinlitishiView;


/**
 * 心理提示
 *
 * @author 
 * @email 
 * @date 2023-01-15 10:56:21
 */
public interface XinlitishiService extends IService<XinlitishiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<XinlitishiVO> selectListVO(Wrapper<XinlitishiEntity> wrapper);
   	
   	XinlitishiVO selectVO(@Param("ew") Wrapper<XinlitishiEntity> wrapper);
   	
   	List<XinlitishiView> selectListView(Wrapper<XinlitishiEntity> wrapper);
   	
   	XinlitishiView selectView(@Param("ew") Wrapper<XinlitishiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<XinlitishiEntity> wrapper);
   	

}

