/**
 * Created by zhangqin on 2017/10/25.
 */


import org.apache.http.Header;
import org.apache.http.HttpHost;
import org.apache.http.RequestLine;
import org.apache.http.util.EntityUtils;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.Response;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.Strings;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.search.fetch.subphase.FetchSourceContext;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author
 * @create 2017-10-25 10:07
 **/
public class Test {

    public static void main(String[] args) throws IOException {
        RestClient restClient = RestClient.builder(
                new HttpHost("localhost", 9200, "http") ).build();
        RestHighLevelClient client =
                new RestHighLevelClient(restClient);
        IndexRequest request = new IndexRequest(
                "posts",
                "doc",
                "1");
        String jsonString = "{" +
                "\"user\":\"kimchy\"," +
                "\"postDate\":\"2013-01-30\"," +
                "\"message\":\"trying out Elasticsearch\"" +
                "}";
        request.source(jsonString, XContentType.JSON);

        GetRequest getRequest = new GetRequest(
                "posts",
                "doc",
                "1");
        String[] includes = new String[]{"message", "*Date"};
        String[] excludes = Strings.EMPTY_ARRAY;
        FetchSourceContext fetchSourceContext = new FetchSourceContext(true, includes, excludes);
        getRequest.fetchSourceContext(fetchSourceContext);
        GetResponse getResponse = client.get(getRequest);
        String index = getResponse.getIndex();
        String type = getResponse.getType();
        String id = getResponse.getId();
        if(getResponse.isExists()){
            long version = getResponse.getVersion();
            String sourceAsString = getResponse.getSourceAsString();
            Map<String,Object> sourceAsMap = getResponse.getSourceAsMap();
            byte [] sourceAsBytes = getResponse.getSourceAsBytes();
        } else {

        }
       /* Map<String, Object> jsonMap = new HashMap<>();
        jsonMap.put("user", "kimchy");
        jsonMap.put("postDate", new Date());
        jsonMap.put("message", "trying out Elasticsearch");
        IndexRequest indexRequest = new IndexRequest("posts", "doc", "1")
                .source(jsonMap);
        XContentBuilder builder = XContentFactory.jsonBuilder();
        builder.startObject();
        {
            builder.field("user", "kimchy");
            builder.field("postDate", new Date());
            builder.field("message", "trying out Elasticsearch");
        }
        builder.endObject();
        IndexRequest indexRequest2 = new IndexRequest("posts", "doc", "1")
                .source(builder);*/
    }
}
