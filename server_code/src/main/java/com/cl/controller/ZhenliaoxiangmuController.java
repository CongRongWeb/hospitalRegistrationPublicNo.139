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

import com.cl.entity.ZhenliaoxiangmuEntity;
import com.cl.entity.view.ZhenliaoxiangmuView;

import com.cl.service.ZhenliaoxiangmuService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;
import com.cl.service.StoreupService;
import com.cl.entity.StoreupEntity;

/**
 * 诊疗项目
 * 后端接口
 * @author 
 * @email 
 * @date 2024-02-02 14:06:51
 */
@RestController
@RequestMapping("/zhenliaoxiangmu")
public class ZhenliaoxiangmuController {
    @Autowired
    private ZhenliaoxiangmuService zhenliaoxiangmuService;

    @Autowired
    private StoreupService storeupService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ZhenliaoxiangmuEntity zhenliaoxiangmu,
		HttpServletRequest request){
        EntityWrapper<ZhenliaoxiangmuEntity> ew = new EntityWrapper<ZhenliaoxiangmuEntity>();

		PageUtils page = zhenliaoxiangmuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhenliaoxiangmu), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ZhenliaoxiangmuEntity zhenliaoxiangmu, 
		HttpServletRequest request){
        EntityWrapper<ZhenliaoxiangmuEntity> ew = new EntityWrapper<ZhenliaoxiangmuEntity>();

		PageUtils page = zhenliaoxiangmuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhenliaoxiangmu), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ZhenliaoxiangmuEntity zhenliaoxiangmu){
       	EntityWrapper<ZhenliaoxiangmuEntity> ew = new EntityWrapper<ZhenliaoxiangmuEntity>();
      	ew.allEq(MPUtil.allEQMapPre( zhenliaoxiangmu, "zhenliaoxiangmu")); 
        return R.ok().put("data", zhenliaoxiangmuService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ZhenliaoxiangmuEntity zhenliaoxiangmu){
        EntityWrapper< ZhenliaoxiangmuEntity> ew = new EntityWrapper< ZhenliaoxiangmuEntity>();
 		ew.allEq(MPUtil.allEQMapPre( zhenliaoxiangmu, "zhenliaoxiangmu")); 
		ZhenliaoxiangmuView zhenliaoxiangmuView =  zhenliaoxiangmuService.selectView(ew);
		return R.ok("查询诊疗项目成功").put("data", zhenliaoxiangmuView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ZhenliaoxiangmuEntity zhenliaoxiangmu = zhenliaoxiangmuService.selectById(id);
		zhenliaoxiangmu = zhenliaoxiangmuService.selectView(new EntityWrapper<ZhenliaoxiangmuEntity>().eq("id", id));
        return R.ok().put("data", zhenliaoxiangmu);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ZhenliaoxiangmuEntity zhenliaoxiangmu = zhenliaoxiangmuService.selectById(id);
		zhenliaoxiangmu = zhenliaoxiangmuService.selectView(new EntityWrapper<ZhenliaoxiangmuEntity>().eq("id", id));
        return R.ok().put("data", zhenliaoxiangmu);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ZhenliaoxiangmuEntity zhenliaoxiangmu, HttpServletRequest request){
    	zhenliaoxiangmu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(zhenliaoxiangmu);
        zhenliaoxiangmuService.insert(zhenliaoxiangmu);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ZhenliaoxiangmuEntity zhenliaoxiangmu, HttpServletRequest request){
    	zhenliaoxiangmu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(zhenliaoxiangmu);
        zhenliaoxiangmuService.insert(zhenliaoxiangmu);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ZhenliaoxiangmuEntity zhenliaoxiangmu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(zhenliaoxiangmu);
        zhenliaoxiangmuService.updateById(zhenliaoxiangmu);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        zhenliaoxiangmuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
