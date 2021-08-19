package cn.highsheep.mall.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import cn.highsheep.common.utils.PageUtils;
import cn.highsheep.mall.order.entity.OrderOperateHistoryEntity;

import java.util.Map;

/**
 * 订单操作历史记录
 *
 * @author highsheep
 * @email 514199242@qq.com
 * @date 2021-08-06 23:43:37
 */
public interface OrderOperateHistoryService extends IService<OrderOperateHistoryEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

