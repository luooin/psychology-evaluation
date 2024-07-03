package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.XinlidanganEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.XinlidanganVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.XinlidanganView;


/**
 * 心理档案
 *
 * @author 
 * @email 
 * @date 2023-01-15 10:56:21
 */
public interface XinlidanganService extends IService<XinlidanganEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<XinlidanganVO> selectListVO(Wrapper<XinlidanganEntity> wrapper);
   	
   	XinlidanganVO selectVO(@Param("ew") Wrapper<XinlidanganEntity> wrapper);
   	
   	List<XinlidanganView> selectListView(Wrapper<XinlidanganEntity> wrapper);
   	
   	XinlidanganView selectView(@Param("ew") Wrapper<XinlidanganEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<XinlidanganEntity> wrapper);
   	

}

