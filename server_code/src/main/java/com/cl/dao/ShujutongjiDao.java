package com.cl.dao;

import com.cl.entity.ShujutongjiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ShujutongjiView;


/**
 * 数据统计
 * 
 * @author 
 * @email 
 * @date 2024-02-02 14:06:51
 */
public interface ShujutongjiDao extends BaseMapper<ShujutongjiEntity> {
	
	List<ShujutongjiView> selectListView(@Param("ew") Wrapper<ShujutongjiEntity> wrapper);

	List<ShujutongjiView> selectListView(Pagination page,@Param("ew") Wrapper<ShujutongjiEntity> wrapper);
	
	ShujutongjiView selectView(@Param("ew") Wrapper<ShujutongjiEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<ShujutongjiEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<ShujutongjiEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<ShujutongjiEntity> wrapper);



}
