package com.gurkan.shortlink.entity;

import com.gurkan.shortlink.enums.RecordStatus;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "links")
public class Link extends BaseEntity {

    private RecordStatus status;
    private String code;
    private String link;
}
