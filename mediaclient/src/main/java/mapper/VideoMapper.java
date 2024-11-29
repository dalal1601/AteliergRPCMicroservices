package mapper;

import dto.VideoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.xproce.lab.Video;

@Component
public class VideoMapper {

    @Autowired
    private CreatorMapper creatorMapper;

    public VideoDto fromVideoProtoToVideoDto(Video video) {
        VideoDto videoDto = new VideoDto();
        videoDto.setId(video.getId());
        videoDto.setTitle(video.getTitle());
        videoDto.setDescription(video.getDescription());
        videoDto.setUrl(video.getUrl());
        videoDto.setDurationSeconds(video.getDurationSeconds());
        videoDto.setCreator(creatorMapper.fromCreatorProtoToCreatorDto(video.getCreator()));
        return videoDto;
    }

    public Video fromVideoDtoToVideoProto(VideoDto videoDto) {
        return Video.newBuilder()
                .setId(videoDto.getId())
                .setTitle(videoDto.getTitle())
                .setDescription(videoDto.getDescription())
                .setUrl(videoDto.getUrl())
                .setDurationSeconds(videoDto.getDurationSeconds())
                .setCreator(creatorMapper.fromCreatorDtoToCreatorProto(videoDto.getCreator()))
                .build();
    }
}

