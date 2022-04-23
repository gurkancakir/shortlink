package com.gurkan.shortlink.graphql;

import com.gurkan.shortlink.service.LinkService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class LinkQueryResolver implements GraphQLQueryResolver {

    private final LinkService linkService;

    public String findByCodeEquals(String code) {
        return linkService.findLinkByCode(code);
    }

}
