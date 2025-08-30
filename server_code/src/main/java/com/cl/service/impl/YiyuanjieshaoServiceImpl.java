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


import com.cl.dao.YiyuanjieshaoDao;
import com.cl.entity.YiyuanjieshaoEntity;
import com.cl.service.YiyuanjieshaoService;
import com.cl.entity.view.YiyuanjieshaoView;

@Service("yiyuanjieshaoService")
public class YiyuanjieshaoServiceImpl extends ServiceImpl<YiyuanjieshaoDao, YiyuanjieshaoEntity> implements YiyuanjieshaoService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YiyuanjieshaoEntity> page = this.selectPage(
                new Query<YiyuanjieshaoEntity>(params).getPage(),
                new EntityWrapper<YiyuanjieshaoEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YiyuanjieshaoEntity> wrapper) {
		  Page<YiyuanjieshaoView> page =new Query<YiyuanjieshaoView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<YiyuanjieshaoView> selectListView(Wrapper<YiyuanjieshaoEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YiyuanjieshaoView selectView(Wrapper<YiyuanjieshaoEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
