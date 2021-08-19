package cn.hishsheep.mall.product;

import cn.highsheep.mall.product.MallProductApplication;
import cn.highsheep.mall.product.service.BrandService;
import cn.highsheep.mall.product.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {MallProductApplication.class})
public class MallProductApplicationTests {

    @Autowired
    BrandService brandService;

    @Autowired
    CategoryService categoryService;
    @Test
    public void test() {
        Long[] catelogPath = categoryService.findCatelogPath((long) 225);
        log.error("xxxx {}", Arrays.asList(catelogPath));
    }


}
