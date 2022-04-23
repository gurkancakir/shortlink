package com.gurkan.shortlink.graphql;

import com.graphql.spring.boot.test.GraphQLResponse;
import com.graphql.spring.boot.test.GraphQLTestTemplate;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class LinkQueryResolverTest {

    @Autowired
    private GraphQLTestTemplate graphQLTestTemplate;

    private String requestPath = "shortlink/graphql/request/link.graphql";

    private String responsePath = "shortlink/graphql/response/link.json";

    @Test
    public void findByCodeEquals() throws IOException, URISyntaxException, JSONException {
        GraphQLResponse graphQLResponse = graphQLTestTemplate.postForResource(requestPath);

        var expected = Files.readString(Paths.get(getClass().getClassLoader()
                .getResource(responsePath).toURI()));
        assertThat(graphQLResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
        JSONAssert.assertEquals(expected, graphQLResponse.getRawResponse().getBody(), true);
    }

}