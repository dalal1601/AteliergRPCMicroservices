package com.example.mediaclient.mapper;

import com.example.mediaclient.dto.CreatorDto;
import org.springframework.stereotype.Component;
import org.xproce.lab.Creator;

@Component
public class CreatorMapper {

    public CreatorDto fromCreatorProtoToCreatorDto(Creator creator) {
        CreatorDto creatorDto = new CreatorDto();
        creatorDto.setId(creator.getId());
        creatorDto.setName(creator.getName());
        creatorDto.setEmail(creator.getEmail());
        return creatorDto;
    }

    public Creator fromCreatorDtoToCreatorProto(CreatorDto creatorDto) {
        return Creator.newBuilder()
                .setId(creatorDto.getId())
                .setName(creatorDto.getName())
                .setEmail(creatorDto.getEmail())
                .build();
    }
}

