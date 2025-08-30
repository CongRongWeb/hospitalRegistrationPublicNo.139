package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.YishengyuyueDao;
import com.cl.entity.YishengyuyueEntity;
import com.cl.service.YishengyuyueService;
import com.cl.entity.view.YishengyuyueView;

@Service("yishengyuyueService")
public class YishengyuyueServiceImpl extends ServiceImpl<YishengyuyueDao, YishengyuyueEntity> implements YishengyuyueService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YishengyuyueEntity> page = this.selectPage(
                new Query<YishengyuyueEntity>(params).getPage(),
                new EntityWrapper<YishengyuyueEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YishengyuyueEntity> wrapper) {
		  Page<YishengyuyueView> page =new Query<YishengyuyueView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<YishengyuyueView> selectListView(Wrapper<YishengyuyueEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YishengyuyueView selectView(Wrapper<YishengyuyueEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, Wrapper<YishengyuyueEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, Wrapper<YishengyuyueEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, Wrapper<YishengyuyueEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }




}
