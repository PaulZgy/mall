package cn.highsheep.mall.ware.service.impl;

import cn.highsheep.common.utils.PageUtils;
import cn.highsheep.common.utils.Query;
import cn.highsheep.mall.ware.dao.WareOrderTaskDetailDao;
import cn.highsheep.mall.ware.entity.WareOrderTaskDetailEntity;
import cn.highsheep.mall.ware.service.WareOrderTaskDetailService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("wareOrderTaskDetailService")
public class WareOrderTaskDetailServiceImpl extends ServiceImpl<WareOrderTaskDetailDao, WareOrderTaskDetailEntity> implements WareOrderTaskDetailService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<WareOrderTaskDetailEntity> page = this.page(
                new Query<WareOrderTaskDetailEntity>().getPage(params),
                new QueryWrapper<WareOrderTaskDetailEntity>()
        );

        return new PageUtils(page);
    }

}