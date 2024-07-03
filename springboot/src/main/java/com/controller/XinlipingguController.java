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

import com.entity.XinlipingguEntity;
import com.entity.view.XinlipingguView;

import com.service.XinlipingguService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 心理评估
 * 后端接口
 * @author 
 * @email 
 * @date 2023-01-15 10:56:21
 */
@RestController
@RequestMapping("/xinlipinggu")
public class XinlipingguController {
    @Autowired
    private XinlipingguService xinlipingguService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,XinlipingguEntity xinlipinggu,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("xuesheng")) {
			xinlipinggu.setXuehao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("xinlilaoshi")) {
			xinlipinggu.setLaoshizhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<XinlipingguEntity> ew = new EntityWrapper<XinlipingguEntity>();

		PageUtils page = xinlipingguService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xinlipinggu), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,XinlipingguEntity xinlipinggu, 
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("xuesheng")) {
			xinlipinggu.setXuehao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("xinlilaoshi")) {
			xinlipinggu.setLaoshizhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<XinlipingguEntity> ew = new EntityWrapper<XinlipingguEntity>();

		PageUtils page = xinlipingguService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xinlipinggu), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( XinlipingguEntity xinlipinggu){
       	EntityWrapper<XinlipingguEntity> ew = new EntityWrapper<XinlipingguEntity>();
      	ew.allEq(MPUtil.allEQMapPre( xinlipinggu, "xinlipinggu")); 
        return R.ok().put("data", xinlipingguService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(XinlipingguEntity xinlipinggu){
        EntityWrapper< XinlipingguEntity> ew = new EntityWrapper< XinlipingguEntity>();
 		ew.allEq(MPUtil.allEQMapPre( xinlipinggu, "xinlipinggu")); 
		XinlipingguView xinlipingguView =  xinlipingguService.selectView(ew);
		return R.ok("查询心理评估成功").put("data", xinlipingguView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        XinlipingguEntity xinlipinggu = xinlipingguService.selectById(id);
        return R.ok().put("data", xinlipinggu);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        XinlipingguEntity xinlipinggu = xinlipingguService.selectById(id);
        return R.ok().put("data", xinlipinggu);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody XinlipingguEntity xinlipinggu, HttpServletRequest request){
    	xinlipinggu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(xinlipinggu);
        xinlipingguService.insert(xinlipinggu);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody XinlipingguEntity xinlipinggu, HttpServletRequest request){
    	xinlipinggu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(xinlipinggu);
    	xinlipinggu.setUserid((Long)request.getSession().getAttribute("userId"));
        xinlipingguService.insert(xinlipinggu);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody XinlipingguEntity xinlipinggu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(xinlipinggu);
        xinlipingguService.updateById(xinlipinggu);//全部更新
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        xinlipingguService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<XinlipingguEntity> wrapper = new EntityWrapper<XinlipingguEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("xuesheng")) {
			wrapper.eq("xuehao", (String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("xinlilaoshi")) {
			wrapper.eq("laoshizhanghao", (String)request.getSession().getAttribute("username"));
		}

		int count = xinlipingguService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	








}
