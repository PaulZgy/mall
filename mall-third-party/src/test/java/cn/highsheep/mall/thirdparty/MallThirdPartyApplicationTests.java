package cn.highsheep.mall.thirdparty;

import com.aliyun.oss.OSSClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {MallThirdPartyApplication.class})
public class MallThirdPartyApplicationTests {

    @Resource
    OSSClient ossClient;

    @Test
    public void contextLoads() throws FileNotFoundException {

        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\51419\\Pictures\\Saved Pictures\\33367765.png");
        ossClient.putObject("mall-0949", "33367765.png", fileInputStream);

    }

}
