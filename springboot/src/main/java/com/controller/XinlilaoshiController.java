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

import com.entity.XinlilaoshiEntity;
import com.entity.view.XinlilaoshiView;

import com.service.XinlilaoshiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 心理老师
 * 后端接口
 * @author 
 * @email 
 * @date 2023-01-15 10:56:21
 */
@RestController
@RequestMapping("/xinlilaoshi")
public class XinlilaoshiController {
    @Autowired
    private XinlilaoshiService xinlilaoshiService;


    
	@Autowired
	private TokenService tokenService;
	
	/**
	 * 登录
	 */
	@IgnoreAuth
	@RequestMapping(value = "/login")
	public R login(String username, String password, String captcha, HttpServletRequest request) {
		XinlilaoshiEntity u = xinlilaoshiService.selectOne(new EntityWrapper<XinlilaoshiEntity>().eq("laoshizhanghao", username));
		if(u==null || !u.getMima().equals(password)) {
			return R.error("账号或密码不正确");
		}
		
		String token = tokenService.generateToken(u.getId(), username,"xinlilaoshi",  "管理员" );
		return R.ok().put("token", token);
	}
	
	/**
     * 注册
     */
	@IgnoreAuth
    @RequestMapping("/register")
    public R register(@RequestBody XinlilaoshiEntity xinlilaoshi){
    	//ValidatorUtils.validateEntity(xinlilaoshi);
    	XinlilaoshiEntity u = xinlilaoshiService.selectOne(new EntityWrapper<XinlilaoshiEntity>().eq("laoshizhanghao", xinlilaoshi.getLaoshizhanghao()));
		if(u!=null) {
			return R.error("注册用户已存在");
		}
		Long uId = new Date().getTime();
		xinlilaoshi.setId(uId);
        xinlilaoshiService.insert(xinlilaoshi);
        return R.ok();
    }

	
	/**
	 * 退出
	 */
	@RequestMapping("/logout")
	public R logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return R.ok("退出成功");
	}
	
	/**
     * 获取用户的session用户信息
     */
    @RequestMapping("/session")
    public R getCurrUser(HttpServletRequest request){
    	Long id = (Long)request.getSession().getAttribute("userId");
        XinlilaoshiEntity u = xinlilaoshiService.selectById(id);
        return R.ok().put("data", u);
    }
    
    /**
     * 密码重置
     */
    @IgnoreAuth
	@RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request){
    	XinlilaoshiEntity u = xinlilaoshiService.selectOne(new EntityWrapper<XinlilaoshiEntity>().eq("laoshizhanghao", username));
    	if(u==null) {
    		return R.error("账号不存在");
    	}
        u.setMima("123456");
        xinlilaoshiService.updateById(u);
        return R.ok("密码已重置为：123456");
    }


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,XinlilaoshiEntity xinlilaoshi,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("xinlilaoshi")) {
			xinlilaoshi.setLaoshizhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<XinlilaoshiEntity> ew = new EntityWrapper<XinlilaoshiEntity>();

		PageUtils page = xinlilaoshiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xinlilaoshi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,XinlilaoshiEntity xinlilaoshi, 
		HttpServletRequest request){
        EntityWrapper<XinlilaoshiEntity> ew = new EntityWrapper<XinlilaoshiEntity>();

		PageUtils page = xinlilaoshiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xinlilaoshi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( XinlilaoshiEntity xinlilaoshi){
       	EntityWrapper<XinlilaoshiEntity> ew = new EntityWrapper<XinlilaoshiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( xinlilaoshi, "xinlilaoshi")); 
        return R.ok().put("data", xinlilaoshiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(XinlilaoshiEntity xinlilaoshi){
        EntityWrapper< XinlilaoshiEntity> ew = new EntityWrapper< XinlilaoshiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( xinlilaoshi, "xinlilaoshi")); 
		XinlilaoshiView xinlilaoshiView =  xinlilaoshiService.selectView(ew);
		return R.ok("查询心理老师成功").put("data", xinlilaoshiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        XinlilaoshiEntity xinlilaoshi = xinlilaoshiService.selectById(id);
        return R.ok().put("data", xinlilaoshi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        XinlilaoshiEntity xinlilaoshi = xinlilaoshiService.selectById(id);
        return R.ok().put("data", xinlilaoshi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody XinlilaoshiEntity xinlilaoshi, HttpServletRequest request){
    	xinlilaoshi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(xinlilaoshi);
    	XinlilaoshiEntity u = xinlilaoshiService.selectOne(new EntityWrapper<XinlilaoshiEntity>().eq("laoshizhanghao", xinlilaoshi.getLaoshizhanghao()));
		if(u!=null) {
			return R.error("用户已存在");
		}
		xinlilaoshi.setId(new Date().getTime());
        xinlilaoshiService.insert(xinlilaoshi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody XinlilaoshiEntity xinlilaoshi, HttpServletRequest request){
    	xinlilaoshi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(xinlilaoshi);
    	XinlilaoshiEntity u = xinlilaoshiService.selectOne(new EntityWrapper<XinlilaoshiEntity>().eq("laoshizhanghao", xinlilaoshi.getLaoshizhanghao()));
		if(u!=null) {
			return R.error("用户已存在");
		}
		xinlilaoshi.setId(new Date().getTime());
        xinlilaoshiService.insert(xinlilaoshi);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody XinlilaoshiEntity xinlilaoshi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(xinlilaoshi);
        xinlilaoshiService.updateById(xinlilaoshi);//全部更新
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        xinlilaoshiService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<XinlilaoshiEntity> wrapper = new EntityWrapper<XinlilaoshiEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("xinlilaoshi")) {
			wrapper.eq("laoshizhanghao", (String)request.getSession().getAttribute("username"));
		}

		int count = xinlilaoshiService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	








}
