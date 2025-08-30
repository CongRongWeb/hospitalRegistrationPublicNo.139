package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.ZhenliaoxiangmuEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ZhenliaoxiangmuView;


/**
 * 诊疗项目
 *
 * @author 
 * @email 
 * @date 2024-02-02 14:06:51
 */
public interface ZhenliaoxiangmuService extends IService<ZhenliaoxiangmuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ZhenliaoxiangmuView> selectListView(Wrapper<ZhenliaoxiangmuEntity> wrapper);
   	
   	ZhenliaoxiangmuView selectView(@Param("ew") Wrapper<ZhenliaoxiangmuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ZhenliaoxiangmuEntity> wrapper);
   	

}

