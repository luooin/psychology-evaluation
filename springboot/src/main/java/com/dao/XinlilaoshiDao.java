package com.dao;

import com.entity.XinlilaoshiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.XinlilaoshiVO;
import com.entity.view.XinlilaoshiView;


/**
 * 心理老师
 * 
 * @author 
 * @email 
 * @date 2023-01-15 10:56:21
 */
public interface XinlilaoshiDao extends BaseMapper<XinlilaoshiEntity> {
	
	List<XinlilaoshiVO> selectListVO(@Param("ew") Wrapper<XinlilaoshiEntity> wrapper);
	
	XinlilaoshiVO selectVO(@Param("ew") Wrapper<XinlilaoshiEntity> wrapper);
	
	List<XinlilaoshiView> selectListView(@Param("ew") Wrapper<XinlilaoshiEntity> wrapper);

	List<XinlilaoshiView> selectListView(Pagination page,@Param("ew") Wrapper<XinlilaoshiEntity> wrapper);
	
	XinlilaoshiView selectView(@Param("ew") Wrapper<XinlilaoshiEntity> wrapper);
	

}
