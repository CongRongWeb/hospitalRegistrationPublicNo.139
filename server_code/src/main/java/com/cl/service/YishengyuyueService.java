package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.YishengyuyueEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.YishengyuyueView;


/**
 * 医生预约
 *
 * @author 
 * @email 
 * @date 2024-02-02 14:06:50
 */
public interface YishengyuyueService extends IService<YishengyuyueEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YishengyuyueView> selectListView(Wrapper<YishengyuyueEntity> wrapper);
   	
   	YishengyuyueView selectView(@Param("ew") Wrapper<YishengyuyueEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YishengyuyueEntity> wrapper);
   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<YishengyuyueEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<YishengyuyueEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<YishengyuyueEntity> wrapper);



}

