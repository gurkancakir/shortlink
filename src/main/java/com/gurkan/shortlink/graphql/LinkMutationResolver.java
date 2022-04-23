package com.gurkan.shortlink.graphql;

import com.gurkan.shortlink.dto.CreateLinkRequestDto;
import com.gurkan.shortlink.dto.CreateLinkResponseDto;
import com.gurkan.shortlink.entity.Link;
import com.gurkan.shortlink.service.LinkService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.AllArgsConstructor;
import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class LinkMutationResolver implements GraphQLMutationResolver {

    private final LinkService linkService;
    private final DozerBeanMapper beanMapper;

    public Link createLink(CreateLinkRequestDto createLinkRequestDto) {
        CreateLinkResponseDto createLinkResponseDto = linkService.save(createLinkRequestDto);
        return beanMapper.map(createLinkResponseDto, Link.class);
    }
}
