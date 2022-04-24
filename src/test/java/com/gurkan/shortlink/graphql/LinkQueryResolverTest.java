package com.gurkan.shortlink.graphql;

import com.graphql.spring.boot.test.GraphQLResponse;
import com.graphql.spring.boot.test.GraphQLTestTemplate;
import org.json.JSONException;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class LinkQueryResolverTest {

    @Autowired
    private GraphQLTestTemplate graphQLTestTemplate;

    @ParameterizedTest
    @MethodSource("provideInputs")
    public void findByCodeEquals(String requestPath, String responsePath) throws IOException, URISyntaxException, JSONException {
        GraphQLResponse graphQLResponse = graphQLTestTemplate.postForResource(requestPath);

        var expected = Files.readString(Paths.get(getClass().getClassLoader()
                .getResource(responsePath).toURI()));
        assertThat(graphQLResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
        JSONAssert.assertEquals(expected, graphQLResponse.getRawResponse().getBody(), true);
    }

    private static Stream<Arguments> provideInputs() {
        String folder = "shortlink/graphql/";
        return Stream.of(
                Arguments.of(folder + "request/link.graphql", folder + "response/link.json"),
                Arguments.of(folder + "request/paginate.graphql", folder + "response/paginate.json")
        );
    }

}