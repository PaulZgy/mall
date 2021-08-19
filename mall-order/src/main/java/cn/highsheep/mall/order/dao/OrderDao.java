package cn.highsheep.mall.order.dao;

import cn.highsheep.mall.order.entity.OrderEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单
 * 
 * @author highsheep
 * @email 514199242@qq.com
 * @date 2021-08-06 23:43:37
 */
@Mapper
public interface OrderDao extends BaseMapper<OrderEntity> {
	
}
