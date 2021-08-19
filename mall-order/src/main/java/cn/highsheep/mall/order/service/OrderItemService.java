package cn.highsheep.mall.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import cn.highsheep.common.utils.PageUtils;
import cn.highsheep.mall.order.entity.OrderItemEntity;

import java.util.Map;

/**
 * 订单项信息
 *
 * @author highsheep
 * @email 514199242@qq.com
 * @date 2021-08-06 23:43:37
 */
public interface OrderItemService extends IService<OrderItemEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

