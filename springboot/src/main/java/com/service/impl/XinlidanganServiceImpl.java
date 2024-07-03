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


import com.dao.XinlidanganDao;
import com.entity.XinlidanganEntity;
import com.service.XinlidanganService;
import com.entity.vo.XinlidanganVO;
import com.entity.view.XinlidanganView;

@Service("xinlidanganService")
public class XinlidanganServiceImpl extends ServiceImpl<XinlidanganDao, XinlidanganEntity> implements XinlidanganService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<XinlidanganEntity> page = this.selectPage(
                new Query<XinlidanganEntity>(params).getPage(),
                new EntityWrapper<XinlidanganEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<XinlidanganEntity> wrapper) {
		  Page<XinlidanganView> page =new Query<XinlidanganView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<XinlidanganVO> selectListVO(Wrapper<XinlidanganEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public XinlidanganVO selectVO(Wrapper<XinlidanganEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<XinlidanganView> selectListView(Wrapper<XinlidanganEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public XinlidanganView selectView(Wrapper<XinlidanganEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
