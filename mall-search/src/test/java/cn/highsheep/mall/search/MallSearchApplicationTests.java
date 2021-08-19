package cn.highsheep.mall.search;


import cn.highsheep.mall.search.config.MallElasticSearchConfig;
import com.alibaba.fastjson.JSON;
import lombok.Data;
import lombok.ToString;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.Aggregations;
import org.elasticsearch.search.aggregations.bucket.terms.Terms;
import org.elasticsearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
import org.elasticsearch.search.aggregations.metrics.Avg;
import org.elasticsearch.search.aggregations.metrics.AvgAggregationBuilder;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MallSearchApplicationTests {

    @Autowired
    private RestHighLevelClient client;

    @Test
    public void searchData() throws IOException {
        //1.创建检索请求
        SearchRequest request = new SearchRequest();
        request.indices("newbank");
        //2.指定DSL，检索条件
        SearchSourceBuilder searchBuilder = new SearchSourceBuilder();
        searchBuilder.query(QueryBuilders.matchQuery("address", "mill"));
        TermsAggregationBuilder ageAgg = AggregationBuilders.terms("ageAgg").field("age").size(10);
        AvgAggregationBuilder balanceAgg = AggregationBuilders.avg("balanceAgg").field("balance");
        searchBuilder.aggregation(ageAgg);
        searchBuilder.aggregation(balanceAgg);
        request.source(searchBuilder);
        //3.执行检索
        SearchResponse response = client.search(request, MallElasticSearchConfig.COMMON_OPTIONS);
        //4.分析结果 response
        //4.1 获取检索到的源数据
        SearchHits hits = response.getHits();
        SearchHit[] searchHit = hits.getHits();
        for (SearchHit hit : searchHit) {
            String sourceAsString = hit.getSourceAsString();
            Account account = JSON.parseObject(sourceAsString, Account.class);
            System.out.println(account.toString());
        }
        //4.2 获取分析数据
        Aggregations aggregations = response.getAggregations();
        Terms ageAgg1 = aggregations.get("ageAgg");
        for (Terms.Bucket bucket : ageAgg1.getBuckets()) {
            String keyAsString = bucket.getKeyAsString();
            System.out.println("年龄： " + keyAsString + " : " + bucket.getDocCount());
        }

        Avg balanceAgg1 = aggregations.get("balanceAgg");
        System.out.println("平均薪资: " + balanceAgg1.getValue());
    }

    @Test
    public void indexData() throws IOException {
        IndexRequest indexRequest = new IndexRequest("users");
        indexRequest.id("1");
        User user = new User();
        user.setAge("18");
        user.setUserName("tom");
        String jsonString = JSON.toJSONString(user);
        indexRequest.source(jsonString, XContentType.JSON);
        //执行操作
        IndexResponse index = client.index(indexRequest, MallElasticSearchConfig.COMMON_OPTIONS);
        //提取有用的响应信息
        System.out.println(index);
    }
    @Data
    class User{
        private String userName;
        private String age;
    }

    /**
     * Auto-generated: 2021-08-17 19:34:58
     *
     * @author bejson.com (i@bejson.com)
     * @website http://www.bejson.com/java2pojo/
     */
    @Data
    @ToString
    static class Account {

        private int account_number;
        private int balance;
        private String firstname;
        private String lastname;
        private int age;
        private String gender;
        private String address;
        private String employer;
        private String email;
        private String city;
        private String state;
    }

}
