package cn.highsheep.mall.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import cn.highsheep.common.utils.PageUtils;
import cn.highsheep.mall.coupon.entity.SeckillSkuNoticeEntity;

import java.util.Map;

/**
 * 秒杀商品通知订阅
 *
 * @author highsheep
 * @email 514199242@qq.com
 * @date 2021-08-06 23:08:13
 */
public interface SeckillSkuNoticeService extends IService<SeckillSkuNoticeEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

