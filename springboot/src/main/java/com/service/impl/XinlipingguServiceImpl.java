package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.XinlipingguDao;
import com.entity.XinlipingguEntity;
import com.service.XinlipingguService;
import com.entity.vo.XinlipingguVO;
import com.entity.view.XinlipingguView;

@Service("xinlipingguService")
public class XinlipingguServiceImpl extends ServiceImpl<XinlipingguDao, XinlipingguEntity> implements XinlipingguService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<XinlipingguEntity> page = this.selectPage(
                new Query<XinlipingguEntity>(params).getPage(),
                new EntityWrapper<XinlipingguEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<XinlipingguEntity> wrapper) {
		  Page<XinlipingguView> page =new Query<XinlipingguView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<XinlipingguVO> selectListVO(Wrapper<XinlipingguEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public XinlipingguVO selectVO(Wrapper<XinlipingguEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<XinlipingguView> selectListView(Wrapper<XinlipingguEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public XinlipingguView selectView(Wrapper<XinlipingguEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
