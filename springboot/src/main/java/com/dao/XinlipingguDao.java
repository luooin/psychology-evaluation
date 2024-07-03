package com.dao;

import com.entity.XinlipingguEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.XinlipingguVO;
import com.entity.view.XinlipingguView;


/**
 * 心理评估
 * 
 * @author 
 * @email 
 * @date 2023-01-15 10:56:21
 */
public interface XinlipingguDao extends BaseMapper<XinlipingguEntity> {
	
	List<XinlipingguVO> selectListVO(@Param("ew") Wrapper<XinlipingguEntity> wrapper);
	
	XinlipingguVO selectVO(@Param("ew") Wrapper<XinlipingguEntity> wrapper);
	
	List<XinlipingguView> selectListView(@Param("ew") Wrapper<XinlipingguEntity> wrapper);

	List<XinlipingguView> selectListView(Pagination page,@Param("ew") Wrapper<XinlipingguEntity> wrapper);
	
	XinlipingguView selectView(@Param("ew") Wrapper<XinlipingguEntity> wrapper);
	

}
