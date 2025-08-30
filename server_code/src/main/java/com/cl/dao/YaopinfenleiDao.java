package com.cl.dao;

import com.cl.entity.YaopinfenleiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.YaopinfenleiView;


/**
 * 药品分类
 * 
 * @author 
 * @email 
 * @date 2024-02-02 14:06:50
 */
public interface YaopinfenleiDao extends BaseMapper<YaopinfenleiEntity> {
	
	List<YaopinfenleiView> selectListView(@Param("ew") Wrapper<YaopinfenleiEntity> wrapper);

	List<YaopinfenleiView> selectListView(Pagination page,@Param("ew") Wrapper<YaopinfenleiEntity> wrapper);
	
	YaopinfenleiView selectView(@Param("ew") Wrapper<YaopinfenleiEntity> wrapper);
	

}
