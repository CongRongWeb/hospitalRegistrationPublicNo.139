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


import com.cl.dao.ZhenliaoxiangmuDao;
import com.cl.entity.ZhenliaoxiangmuEntity;
import com.cl.service.ZhenliaoxiangmuService;
import com.cl.entity.view.ZhenliaoxiangmuView;

@Service("zhenliaoxiangmuService")
public class ZhenliaoxiangmuServiceImpl extends ServiceImpl<ZhenliaoxiangmuDao, ZhenliaoxiangmuEntity> implements ZhenliaoxiangmuService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZhenliaoxiangmuEntity> page = this.selectPage(
                new Query<ZhenliaoxiangmuEntity>(params).getPage(),
                new EntityWrapper<ZhenliaoxiangmuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ZhenliaoxiangmuEntity> wrapper) {
		  Page<ZhenliaoxiangmuView> page =new Query<ZhenliaoxiangmuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<ZhenliaoxiangmuView> selectListView(Wrapper<ZhenliaoxiangmuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ZhenliaoxiangmuView selectView(Wrapper<ZhenliaoxiangmuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
