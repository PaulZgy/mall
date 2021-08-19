package cn.highsheep.mall.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import cn.highsheep.common.utils.PageUtils;
import cn.highsheep.mall.coupon.entity.CouponSpuRelationEntity;

import java.util.Map;

/**
 * 优惠券与产品关联
 *
 * @author highsheep
 * @email 514199242@qq.com
 * @date 2021-08-06 23:08:13
 */
public interface CouponSpuRelationService extends IService<CouponSpuRelationEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

