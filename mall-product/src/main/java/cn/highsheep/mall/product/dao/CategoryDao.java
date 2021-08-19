package cn.highsheep.mall.product.dao;

import cn.highsheep.mall.product.entity.CategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品三级分类
 * 
 * @author highsheep
 * @email 514199242@qq.com
 * @date 2021-08-06 20:13:14
 */
@Mapper
public interface CategoryDao extends BaseMapper<CategoryEntity> {
	
}
