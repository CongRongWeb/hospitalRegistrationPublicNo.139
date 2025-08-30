package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.ShujutongjiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ShujutongjiView;


/**
 * 数据统计
 *
 * @author 
 * @email 
 * @date 2024-02-02 14:06:51
 */
public interface ShujutongjiService extends IService<ShujutongjiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ShujutongjiView> selectListView(Wrapper<ShujutongjiEntity> wrapper);
   	
   	ShujutongjiView selectView(@Param("ew") Wrapper<ShujutongjiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ShujutongjiEntity> wrapper);
   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<ShujutongjiEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<ShujutongjiEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<ShujutongjiEntity> wrapper);



}

