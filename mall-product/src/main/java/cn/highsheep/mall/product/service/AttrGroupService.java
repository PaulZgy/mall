package cn.highsheep.mall.product.service;

import cn.highsheep.common.utils.PageUtils;
import cn.highsheep.mall.product.entity.AttrGroupEntity;
import cn.highsheep.mall.product.vo.AttrGroupWithAttrsVo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * 属性分组
 *
 * @author highsheep
 * @email 514199242@qq.com
 * @date 2021-08-06 20:13:14
 */
public interface AttrGroupService extends IService<AttrGroupEntity> {

    PageUtils queryPage(Map<String, Object> params);

    PageUtils queryPage(Map<String, Object> params, Long catelogId);

    List<AttrGroupWithAttrsVo> getAttrGroupWithAttrsByCatelogId(Long catelogId);
}

