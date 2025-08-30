package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.YaopinxinxiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.YaopinxinxiView;


/**
 * 药品信息
 *
 * @author 
 * @email 
 * @date 2024-02-02 14:06:51
 */
public interface YaopinxinxiService extends IService<YaopinxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YaopinxinxiView> selectListView(Wrapper<YaopinxinxiEntity> wrapper);
   	
   	YaopinxinxiView selectView(@Param("ew") Wrapper<YaopinxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YaopinxinxiEntity> wrapper);
   	

}

