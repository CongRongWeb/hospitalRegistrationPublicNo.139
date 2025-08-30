package com.cl.dao;

import com.cl.entity.YishengyuyueEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.YishengyuyueView;


/**
 * 医生预约
 * 
 * @author 
 * @email 
 * @date 2024-02-02 14:06:50
 */
public interface YishengyuyueDao extends BaseMapper<YishengyuyueEntity> {
	
	List<YishengyuyueView> selectListView(@Param("ew") Wrapper<YishengyuyueEntity> wrapper);

	List<YishengyuyueView> selectListView(Pagination page,@Param("ew") Wrapper<YishengyuyueEntity> wrapper);
	
	YishengyuyueView selectView(@Param("ew") Wrapper<YishengyuyueEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<YishengyuyueEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<YishengyuyueEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<YishengyuyueEntity> wrapper);



}
