package com.cl.dao;

import com.cl.entity.YiyuanjieshaoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.YiyuanjieshaoView;


/**
 * 医院介绍
 * 
 * @author 
 * @email 
 * @date 2024-02-02 14:06:50
 */
public interface YiyuanjieshaoDao extends BaseMapper<YiyuanjieshaoEntity> {
	
	List<YiyuanjieshaoView> selectListView(@Param("ew") Wrapper<YiyuanjieshaoEntity> wrapper);

	List<YiyuanjieshaoView> selectListView(Pagination page,@Param("ew") Wrapper<YiyuanjieshaoEntity> wrapper);
	
	YiyuanjieshaoView selectView(@Param("ew") Wrapper<YiyuanjieshaoEntity> wrapper);
	

}
