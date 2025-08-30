package com.cl.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.cl.utils.ValidatorUtils;
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
import com.cl.annotation.IgnoreAuth;

import com.cl.entity.YiyuanjieshaoEntity;
import com.cl.entity.view.YiyuanjieshaoView;

import com.cl.service.YiyuanjieshaoService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 医院介绍
 * 后端接口
 * @author 
 * @email 
 * @date 2024-02-02 14:06:50
 */
@RestController
@RequestMapping("/yiyuanjieshao")
public class YiyuanjieshaoController {
    @Autowired
    private YiyuanjieshaoService yiyuanjieshaoService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,YiyuanjieshaoEntity yiyuanjieshao,
		HttpServletRequest request){
        EntityWrapper<YiyuanjieshaoEntity> ew = new EntityWrapper<YiyuanjieshaoEntity>();

		PageUtils page = yiyuanjieshaoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yiyuanjieshao), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,YiyuanjieshaoEntity yiyuanjieshao, 
		HttpServletRequest request){
        EntityWrapper<YiyuanjieshaoEntity> ew = new EntityWrapper<YiyuanjieshaoEntity>();

		PageUtils page = yiyuanjieshaoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yiyuanjieshao), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( YiyuanjieshaoEntity yiyuanjieshao){
       	EntityWrapper<YiyuanjieshaoEntity> ew = new EntityWrapper<YiyuanjieshaoEntity>();
      	ew.allEq(MPUtil.allEQMapPre( yiyuanjieshao, "yiyuanjieshao")); 
        return R.ok().put("data", yiyuanjieshaoService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(YiyuanjieshaoEntity yiyuanjieshao){
        EntityWrapper< YiyuanjieshaoEntity> ew = new EntityWrapper< YiyuanjieshaoEntity>();
 		ew.allEq(MPUtil.allEQMapPre( yiyuanjieshao, "yiyuanjieshao")); 
		YiyuanjieshaoView yiyuanjieshaoView =  yiyuanjieshaoService.selectView(ew);
		return R.ok("查询医院介绍成功").put("data", yiyuanjieshaoView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        YiyuanjieshaoEntity yiyuanjieshao = yiyuanjieshaoService.selectById(id);
		yiyuanjieshao = yiyuanjieshaoService.selectView(new EntityWrapper<YiyuanjieshaoEntity>().eq("id", id));
        return R.ok().put("data", yiyuanjieshao);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        YiyuanjieshaoEntity yiyuanjieshao = yiyuanjieshaoService.selectById(id);
		yiyuanjieshao = yiyuanjieshaoService.selectView(new EntityWrapper<YiyuanjieshaoEntity>().eq("id", id));
        return R.ok().put("data", yiyuanjieshao);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody YiyuanjieshaoEntity yiyuanjieshao, HttpServletRequest request){
    	yiyuanjieshao.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(yiyuanjieshao);
        yiyuanjieshaoService.insert(yiyuanjieshao);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody YiyuanjieshaoEntity yiyuanjieshao, HttpServletRequest request){
    	yiyuanjieshao.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(yiyuanjieshao);
        yiyuanjieshaoService.insert(yiyuanjieshao);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody YiyuanjieshaoEntity yiyuanjieshao, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yiyuanjieshao);
        yiyuanjieshaoService.updateById(yiyuanjieshao);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        yiyuanjieshaoService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
