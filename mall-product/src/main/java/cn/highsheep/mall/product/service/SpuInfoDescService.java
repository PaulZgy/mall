package cn.highsheep.mall.product.service;

import cn.highsheep.common.utils.PageUtils;
import com.baomidou.mybatisplus.extension.service.IService;
import cn.highsheep.mall.product.entity.SpuInfoDescEntity;

import java.util.Map;

/**
 * spu信息介绍
 *
 * @author highsheep
 * @email 514199242@qq.com
 * @date 2021-08-06 20:13:14
 */
public interface SpuInfoDescService extends IService<SpuInfoDescEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void saveSpuInfoDesc(SpuInfoDescEntity descEntity);
}

