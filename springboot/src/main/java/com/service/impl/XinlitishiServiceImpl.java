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


import com.dao.XinlitishiDao;
import com.entity.XinlitishiEntity;
import com.service.XinlitishiService;
import com.entity.vo.XinlitishiVO;
import com.entity.view.XinlitishiView;

@Service("xinlitishiService")
public class XinlitishiServiceImpl extends ServiceImpl<XinlitishiDao, XinlitishiEntity> implements XinlitishiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<XinlitishiEntity> page = this.selectPage(
                new Query<XinlitishiEntity>(params).getPage(),
                new EntityWrapper<XinlitishiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<XinlitishiEntity> wrapper) {
		  Page<XinlitishiView> page =new Query<XinlitishiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<XinlitishiVO> selectListVO(Wrapper<XinlitishiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public XinlitishiVO selectVO(Wrapper<XinlitishiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<XinlitishiView> selectListView(Wrapper<XinlitishiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public XinlitishiView selectView(Wrapper<XinlitishiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
