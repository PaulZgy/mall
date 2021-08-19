package cn.highsheep.mall.coupon.dao;

import cn.highsheep.mall.coupon.entity.SeckillSessionEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 秒杀活动场次
 * 
 * @author highsheep
 * @email 514199242@qq.com
 * @date 2021-08-06 23:08:13
 */
@Mapper
public interface SeckillSessionDao extends BaseMapper<SeckillSessionEntity> {
	
}
