package com.cl.dao;

import com.cl.entity.ZhenliaoxiangmuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ZhenliaoxiangmuView;


/**
 * 诊疗项目
 * 
 * @author 
 * @email 
 * @date 2024-02-02 14:06:51
 */
public interface ZhenliaoxiangmuDao extends BaseMapper<ZhenliaoxiangmuEntity> {
	
	List<ZhenliaoxiangmuView> selectListView(@Param("ew") Wrapper<ZhenliaoxiangmuEntity> wrapper);

	List<ZhenliaoxiangmuView> selectListView(Pagination page,@Param("ew") Wrapper<ZhenliaoxiangmuEntity> wrapper);
	
	ZhenliaoxiangmuView selectView(@Param("ew") Wrapper<ZhenliaoxiangmuEntity> wrapper);
	

}
