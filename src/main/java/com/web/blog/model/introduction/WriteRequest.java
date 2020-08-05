package com.web.blog.model.introduction;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.ToString;

@Valid
@ToString
public class WriteRequest {

    @ApiModelProperty(required = true)
    @NotNull
    Introduction introduction;

    @ApiModelProperty(required = true)
    HashTag hashTag;

    public Introduction getIntroduction() {
        return introduction;
    }

    public void setIntroduction(Introduction introduction) {
        this.introduction = introduction;
    }

    public HashTag getHashTag() {
        return hashTag;
    }

    public void setHashTag(HashTag hashTag) {
        this.hashTag = hashTag;
    }

    @Builder
    public WriteRequest(@NotNull Introduction introduction, HashTag hashTag) {
        this.introduction = introduction;
        this.hashTag = hashTag;
    }

    public WriteRequest() {
    }

    

}