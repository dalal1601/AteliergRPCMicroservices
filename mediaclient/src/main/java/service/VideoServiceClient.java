package service;

import dto.VideoDto;
import mapper.VideoMapper;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xproce.lab.UploadVideoRequest;
import org.xproce.lab.Video;
import org.xproce.lab.VideoIdRequest;
import org.xproce.lab.VideoServiceGrpc;

@Service
public class VideoServiceClient {

    @GrpcClient("mediaserver")
    private VideoServiceGrpc.VideoServiceBlockingStub videoStub;

    @Autowired
    private VideoMapper videoMapper;

    public VideoDto uploadVideo(UploadVideoRequest videoRequest) {
        Video videoResponse = videoStub.uploadVideo(videoRequest);
        return videoMapper.fromVideoProtoToVideoDto(videoResponse);
    }
    public VideoDto getVideo(String videoId) {
        VideoIdRequest request = VideoIdRequest.newBuilder().setId(videoId).build();
        Video videoResponse = videoStub.getVideo(request);
        return videoMapper.fromVideoProtoToVideoDto(videoResponse);
    }
}

