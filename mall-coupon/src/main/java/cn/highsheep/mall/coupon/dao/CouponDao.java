package cn.highsheep.mall.coupon.dao;

import cn.highsheep.mall.coupon.entity.CouponEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 优惠券信息
 * 
 * @author highsheep
 * @email 514199242@qq.com
 * @date 2021-08-06 23:08:14
 */
@Mapper
public interface CouponDao extends BaseMapper<CouponEntity> {
	
}
