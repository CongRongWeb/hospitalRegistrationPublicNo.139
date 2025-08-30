package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.YiyuanjieshaoEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.YiyuanjieshaoView;


/**
 * 医院介绍
 *
 * @author 
 * @email 
 * @date 2024-02-02 14:06:50
 */
public interface YiyuanjieshaoService extends IService<YiyuanjieshaoEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YiyuanjieshaoView> selectListView(Wrapper<YiyuanjieshaoEntity> wrapper);
   	
   	YiyuanjieshaoView selectView(@Param("ew") Wrapper<YiyuanjieshaoEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YiyuanjieshaoEntity> wrapper);
   	

}

