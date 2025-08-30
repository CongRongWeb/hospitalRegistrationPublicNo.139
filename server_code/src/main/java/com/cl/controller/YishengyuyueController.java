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

import com.cl.entity.YishengyuyueEntity;
import com.cl.entity.view.YishengyuyueView;

import com.cl.service.YishengyuyueService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 医生预约
 * 后端接口
 * @author 
 * @email 
 * @date 2024-02-02 14:06:50
 */
@RestController
@RequestMapping("/yishengyuyue")
public class YishengyuyueController {
    @Autowired
    private YishengyuyueService yishengyuyueService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,YishengyuyueEntity yishengyuyue,
                @RequestParam(required = false) Double renshustart,
                @RequestParam(required = false) Double renshuend,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yisheng")) {
			yishengyuyue.setYishengzhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("huanzhe")) {
			yishengyuyue.setHuanzhezhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<YishengyuyueEntity> ew = new EntityWrapper<YishengyuyueEntity>();
                if(renshustart!=null) ew.ge("renshu", renshustart);
                if(renshuend!=null) ew.le("renshu", renshuend);

		PageUtils page = yishengyuyueService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yishengyuyue), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,YishengyuyueEntity yishengyuyue, 
                @RequestParam(required = false) Double renshustart,
                @RequestParam(required = false) Double renshuend,
		HttpServletRequest request){
        EntityWrapper<YishengyuyueEntity> ew = new EntityWrapper<YishengyuyueEntity>();
                if(renshustart!=null) ew.ge("renshu", renshustart);
                if(renshuend!=null) ew.le("renshu", renshuend);

		PageUtils page = yishengyuyueService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yishengyuyue), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( YishengyuyueEntity yishengyuyue){
       	EntityWrapper<YishengyuyueEntity> ew = new EntityWrapper<YishengyuyueEntity>();
      	ew.allEq(MPUtil.allEQMapPre( yishengyuyue, "yishengyuyue")); 
        return R.ok().put("data", yishengyuyueService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(YishengyuyueEntity yishengyuyue){
        EntityWrapper< YishengyuyueEntity> ew = new EntityWrapper< YishengyuyueEntity>();
 		ew.allEq(MPUtil.allEQMapPre( yishengyuyue, "yishengyuyue")); 
		YishengyuyueView yishengyuyueView =  yishengyuyueService.selectView(ew);
		return R.ok("查询医生预约成功").put("data", yishengyuyueView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        YishengyuyueEntity yishengyuyue = yishengyuyueService.selectById(id);
		yishengyuyue = yishengyuyueService.selectView(new EntityWrapper<YishengyuyueEntity>().eq("id", id));
        return R.ok().put("data", yishengyuyue);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        YishengyuyueEntity yishengyuyue = yishengyuyueService.selectById(id);
		yishengyuyue = yishengyuyueService.selectView(new EntityWrapper<YishengyuyueEntity>().eq("id", id));
        return R.ok().put("data", yishengyuyue);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody YishengyuyueEntity yishengyuyue, HttpServletRequest request){
    	yishengyuyue.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(yishengyuyue);
        yishengyuyueService.insert(yishengyuyue);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody YishengyuyueEntity yishengyuyue, HttpServletRequest request){
    	yishengyuyue.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(yishengyuyue);
        yishengyuyueService.insert(yishengyuyue);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody YishengyuyueEntity yishengyuyue, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yishengyuyue);
        yishengyuyueService.updateById(yishengyuyue);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        yishengyuyueService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	





    /**
     * （按值统计）
     */
    @RequestMapping("/value/{xColumnName}/{yColumnName}")
    public R value(@PathVariable("yColumnName") String yColumnName, @PathVariable("xColumnName") String xColumnName,HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("yColumn", yColumnName);
        EntityWrapper<YishengyuyueEntity> ew = new EntityWrapper<YishengyuyueEntity>();
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yisheng")) {
            ew.eq("yishengzhanghao", (String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("huanzhe")) {
            ew.eq("huanzhezhanghao", (String)request.getSession().getAttribute("username"));
		}
        List<Map<String, Object>> result = yishengyuyueService.selectValue(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        return R.ok().put("data", result);
    }

    /**
     * （按值统计(多)）
     */
    @RequestMapping("/valueMul/{xColumnName}")
    public R valueMul(@PathVariable("xColumnName") String xColumnName,@RequestParam String yColumnNameMul, HttpServletRequest request) {
        String[] yColumnNames = yColumnNameMul.split(",");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        List<List<Map<String, Object>>> result2 = new ArrayList<List<Map<String,Object>>>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        EntityWrapper<YishengyuyueEntity> ew = new EntityWrapper<YishengyuyueEntity>();
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("yisheng")) {
            ew.eq("yishengzhanghao", (String)request.getSession().getAttribute("username"));
        }
        if(tableName.equals("huanzhe")) {
            ew.eq("huanzhezhanghao", (String)request.getSession().getAttribute("username"));
        }
        for(int i=0;i<yColumnNames.length;i++) {
            params.put("yColumn", yColumnNames[i]);
            List<Map<String, Object>> result = yishengyuyueService.selectValue(params, ew);
            for(Map<String, Object> m : result) {
                for(String k : m.keySet()) {
                    if(m.get(k) instanceof Date) {
                        m.put(k, sdf.format((Date)m.get(k)));
                    }
                }
            }
            result2.add(result);
        }
        return R.ok().put("data", result2);
    }

    /**
     * （按值统计）时间统计类型
     */
    @RequestMapping("/value/{xColumnName}/{yColumnName}/{timeStatType}")
    public R valueDay(@PathVariable("yColumnName") String yColumnName, @PathVariable("xColumnName") String xColumnName, @PathVariable("timeStatType") String timeStatType,HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("yColumn", yColumnName);
        params.put("timeStatType", timeStatType);
        EntityWrapper<YishengyuyueEntity> ew = new EntityWrapper<YishengyuyueEntity>();
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("yisheng")) {
            ew.eq("yishengzhanghao", (String)request.getSession().getAttribute("username"));
        }
        if(tableName.equals("huanzhe")) {
            ew.eq("huanzhezhanghao", (String)request.getSession().getAttribute("username"));
        }
        List<Map<String, Object>> result = yishengyuyueService.selectTimeStatValue(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        return R.ok().put("data", result);
    }

    /**
     * （按值统计）时间统计类型(多)
     */
    @RequestMapping("/valueMul/{xColumnName}/{timeStatType}")
    public R valueMulDay(@PathVariable("xColumnName") String xColumnName, @PathVariable("timeStatType") String timeStatType,@RequestParam String yColumnNameMul,HttpServletRequest request) {
        String[] yColumnNames = yColumnNameMul.split(",");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("timeStatType", timeStatType);
        List<List<Map<String, Object>>> result2 = new ArrayList<List<Map<String,Object>>>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        EntityWrapper<YishengyuyueEntity> ew = new EntityWrapper<YishengyuyueEntity>();
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("yisheng")) {
            ew.eq("yishengzhanghao", (String)request.getSession().getAttribute("username"));
        }
        if(tableName.equals("huanzhe")) {
            ew.eq("huanzhezhanghao", (String)request.getSession().getAttribute("username"));
        }
        for(int i=0;i<yColumnNames.length;i++) {
            params.put("yColumn", yColumnNames[i]);
            List<Map<String, Object>> result = yishengyuyueService.selectTimeStatValue(params, ew);
            for(Map<String, Object> m : result) {
                for(String k : m.keySet()) {
                    if(m.get(k) instanceof Date) {
                        m.put(k, sdf.format((Date)m.get(k)));
                    }
                }
            }
            result2.add(result);
        }
        return R.ok().put("data", result2);
    }

    /**
     * 分组统计
     */
    @RequestMapping("/group/{columnName}")
    public R group(@PathVariable("columnName") String columnName,HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("column", columnName);
        EntityWrapper<YishengyuyueEntity> ew = new EntityWrapper<YishengyuyueEntity>();
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("yisheng")) {
            ew.eq("yishengzhanghao", (String)request.getSession().getAttribute("username"));
        }
        if(tableName.equals("huanzhe")) {
            ew.eq("huanzhezhanghao", (String)request.getSession().getAttribute("username"));
        }
        List<Map<String, Object>> result = yishengyuyueService.selectGroup(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        return R.ok().put("data", result);
    }




    /**
     * 总数量
     */
    @RequestMapping("/count")
    public R count(@RequestParam Map<String, Object> params,YishengyuyueEntity yishengyuyue, HttpServletRequest request){
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("yisheng")) {
            yishengyuyue.setYishengzhanghao((String)request.getSession().getAttribute("username"));
        }
        if(tableName.equals("huanzhe")) {
            yishengyuyue.setHuanzhezhanghao((String)request.getSession().getAttribute("username"));
        }
        EntityWrapper<YishengyuyueEntity> ew = new EntityWrapper<YishengyuyueEntity>();
        int count = yishengyuyueService.selectCount(MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yishengyuyue), params), params));
        return R.ok().put("data", count);
    }


}
