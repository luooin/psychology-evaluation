package com.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.XinlizhishiEntity;
import com.entity.view.XinlizhishiView;

import com.service.XinlizhishiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;
import com.service.StoreupService;
import com.entity.StoreupEntity;

/**
 * 心理知识
 * 后端接口
 * @author 
 * @email 
 * @date 2023-01-15 10:56:21
 */
@RestController
@RequestMapping("/xinlizhishi")
public class XinlizhishiController {
    @Autowired
    private XinlizhishiService xinlizhishiService;

    @Autowired
    private StoreupService storeupService;

    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,XinlizhishiEntity xinlizhishi,
		HttpServletRequest request){
    	if(!request.getSession().getAttribute("role").toString().equals("管理员")) {
    		xinlizhishi.setUserid((Long)request.getSession().getAttribute("userId"));
    	}
        EntityWrapper<XinlizhishiEntity> ew = new EntityWrapper<XinlizhishiEntity>();

		PageUtils page = xinlizhishiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xinlizhishi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,XinlizhishiEntity xinlizhishi, 
		HttpServletRequest request){
        EntityWrapper<XinlizhishiEntity> ew = new EntityWrapper<XinlizhishiEntity>();

		PageUtils page = xinlizhishiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xinlizhishi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( XinlizhishiEntity xinlizhishi){
       	EntityWrapper<XinlizhishiEntity> ew = new EntityWrapper<XinlizhishiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( xinlizhishi, "xinlizhishi")); 
        return R.ok().put("data", xinlizhishiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(XinlizhishiEntity xinlizhishi){
        EntityWrapper< XinlizhishiEntity> ew = new EntityWrapper< XinlizhishiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( xinlizhishi, "xinlizhishi")); 
		XinlizhishiView xinlizhishiView =  xinlizhishiService.selectView(ew);
		return R.ok("查询心理知识成功").put("data", xinlizhishiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        XinlizhishiEntity xinlizhishi = xinlizhishiService.selectById(id);
        return R.ok().put("data", xinlizhishi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        XinlizhishiEntity xinlizhishi = xinlizhishiService.selectById(id);
        return R.ok().put("data", xinlizhishi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody XinlizhishiEntity xinlizhishi, HttpServletRequest request){
    	xinlizhishi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(xinlizhishi);
    	xinlizhishi.setUserid((Long)request.getSession().getAttribute("userId"));
        xinlizhishiService.insert(xinlizhishi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody XinlizhishiEntity xinlizhishi, HttpServletRequest request){
    	xinlizhishi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(xinlizhishi);
        xinlizhishiService.insert(xinlizhishi);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody XinlizhishiEntity xinlizhishi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(xinlizhishi);
        xinlizhishiService.updateById(xinlizhishi);//全部更新
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        xinlizhishiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<XinlizhishiEntity> wrapper = new EntityWrapper<XinlizhishiEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}
		if(!request.getSession().getAttribute("role").toString().equals("管理员")) {
    		wrapper.eq("userid", (Long)request.getSession().getAttribute("userId"));
    	}


		int count = xinlizhishiService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	








}
