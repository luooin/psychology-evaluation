package com.dao;

import com.entity.XinlitishiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.XinlitishiVO;
import com.entity.view.XinlitishiView;


/**
 * 心理提示
 * 
 * @author 
 * @email 
 * @date 2023-01-15 10:56:21
 */
public interface XinlitishiDao extends BaseMapper<XinlitishiEntity> {
	
	List<XinlitishiVO> selectListVO(@Param("ew") Wrapper<XinlitishiEntity> wrapper);
	
	XinlitishiVO selectVO(@Param("ew") Wrapper<XinlitishiEntity> wrapper);
	
	List<XinlitishiView> selectListView(@Param("ew") Wrapper<XinlitishiEntity> wrapper);

	List<XinlitishiView> selectListView(Pagination page,@Param("ew") Wrapper<XinlitishiEntity> wrapper);
	
	XinlitishiView selectView(@Param("ew") Wrapper<XinlitishiEntity> wrapper);
	

}
