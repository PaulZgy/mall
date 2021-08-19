package cn.highsheep.mall.product.service;

import cn.highsheep.common.utils.PageUtils;
import cn.highsheep.mall.product.entity.CommentReplayEntity;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * 商品评价回复关系
 *
 * @author highsheep
 * @email 514199242@qq.com
 * @date 2021-08-06 20:13:14
 */
public interface CommentReplayService extends IService<CommentReplayEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

