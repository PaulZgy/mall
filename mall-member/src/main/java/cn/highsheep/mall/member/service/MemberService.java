package cn.highsheep.mall.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import cn.highsheep.common.utils.PageUtils;
import cn.highsheep.mall.member.entity.MemberEntity;

import java.util.Map;

/**
 * 会员
 *
 * @author highsheep
 * @email 514199242@qq.com
 * @date 2021-08-06 23:27:25
 */
public interface MemberService extends IService<MemberEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

