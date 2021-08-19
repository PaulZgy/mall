package cn.highsheep.mall.product.service;

import cn.highsheep.common.utils.PageUtils;
import cn.highsheep.mall.product.vo.AttrRespVo;
import com.baomidou.mybatisplus.extension.service.IService;
import cn.highsheep.mall.product.entity.AttrAttrgroupRelationEntity;

import java.util.List;
import java.util.Map;

/**
 * 属性&属性分组关联
 *
 * @author highsheep
 * @email 514199242@qq.com
 * @date 2021-08-06 20:13:14
 */
public interface AttrAttrgroupRelationService extends IService<AttrAttrgroupRelationEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void saveBatch(List<AttrRespVo> vos);
}

