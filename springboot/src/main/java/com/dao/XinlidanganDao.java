package com.dao;

import com.entity.XinlidanganEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.XinlidanganVO;
import com.entity.view.XinlidanganView;


/**
 * 心理档案
 * 
 * @author 
 * @email 
 * @date 2023-01-15 10:56:21
 */
public interface XinlidanganDao extends BaseMapper<XinlidanganEntity> {
	
	List<XinlidanganVO> selectListVO(@Param("ew") Wrapper<XinlidanganEntity> wrapper);
	
	XinlidanganVO selectVO(@Param("ew") Wrapper<XinlidanganEntity> wrapper);
	
	List<XinlidanganView> selectListView(@Param("ew") Wrapper<XinlidanganEntity> wrapper);

	List<XinlidanganView> selectListView(Pagination page,@Param("ew") Wrapper<XinlidanganEntity> wrapper);
	
	XinlidanganView selectView(@Param("ew") Wrapper<XinlidanganEntity> wrapper);
	

}
