package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.PaibanxinxiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.PaibanxinxiView;


/**
 * 排班信息
 *
 * @author 
 * @email 
 * @date 2024-02-02 14:06:50
 */
public interface PaibanxinxiService extends IService<PaibanxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<PaibanxinxiView> selectListView(Wrapper<PaibanxinxiEntity> wrapper);
   	
   	PaibanxinxiView selectView(@Param("ew") Wrapper<PaibanxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<PaibanxinxiEntity> wrapper);
   	

}

