package com.gurkan.shortlink.graphql;

import com.gurkan.shortlink.entity.Link;
import com.gurkan.shortlink.service.LinkService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.relay.*;
import graphql.schema.DataFetchingEnvironment;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class LinkQueryResolver implements GraphQLQueryResolver {

    private final LinkService linkService;

    public String findByCodeEquals(String code) {
        return linkService.findLinkByCode(code);
    }

    public Connection<Link> links(int first, String after, DataFetchingEnvironment env) {
        return new SimpleListConnection<>(linkService.findAll()).get(env);
    }

}
