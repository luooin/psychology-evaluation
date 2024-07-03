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


import com.dao.XinlilaoshiDao;
import com.entity.XinlilaoshiEntity;
import com.service.XinlilaoshiService;
import com.entity.vo.XinlilaoshiVO;
import com.entity.view.XinlilaoshiView;

@Service("xinlilaoshiService")
public class XinlilaoshiServiceImpl extends ServiceImpl<XinlilaoshiDao, XinlilaoshiEntity> implements XinlilaoshiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<XinlilaoshiEntity> page = this.selectPage(
                new Query<XinlilaoshiEntity>(params).getPage(),
                new EntityWrapper<XinlilaoshiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<XinlilaoshiEntity> wrapper) {
		  Page<XinlilaoshiView> page =new Query<XinlilaoshiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<XinlilaoshiVO> selectListVO(Wrapper<XinlilaoshiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public XinlilaoshiVO selectVO(Wrapper<XinlilaoshiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<XinlilaoshiView> selectListView(Wrapper<XinlilaoshiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public XinlilaoshiView selectView(Wrapper<XinlilaoshiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
