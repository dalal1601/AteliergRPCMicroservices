package com.example.mediaserver;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.xproce.lab.*;

import java.util.UUID;

@GrpcService
public class VideoService extends VideoServiceGrpc.VideoServiceImplBase  {

    @Override
    public void uploadVideo(UploadVideoRequest request, StreamObserver<Video>
            responseObserver) {
        String title = request.getTitle();
        String description = request.getDescription();
        String url = request.getUrl();

        Video video = Video.newBuilder()
                .setId(UUID.randomUUID().toString())
                .setTitle(title)
                .setDescription(description)
                .setUrl(url)
                //apreees
                .build();

        responseObserver.onNext(video);
        responseObserver.onCompleted();
    }
    @Override
    public void getVideo(VideoIdRequest request, StreamObserver<Video> responseObserver) {
        // Exemple : Récupérer une vidéo par son ID
        Video video = Video.newBuilder()
                .setId(request.getId())
                .setTitle("Sample Title")
                .setDescription("Sample Description")
                .setUrl("http://example.com/video.mp4")
                .setDurationSeconds(120)
                .setCreator(Creator.newBuilder()
                        .setId("1")
                        .setName("John Doe")
                        .setEmail("john.doe@example.com")
                        .build())
                .build();

        responseObserver.onNext(video);
        responseObserver.onCompleted();
    }


}
/*
*

    public void convert(Bank.ConvertCurrencyRequest request, StreamObserver<Bank.ConvertCurrencyResponse> responseObserver) {
        String currencyFrom = request.getCurrencyFrom();
        String currencyTo = request.getCurrencyTo();
        double amount = request.getAmount();
        Bank.ConvertCurrencyResponse response = Bank.ConvertCurrencyResponse.newBuilder()
                .setCurrencyFrom(currencyFrom)
                .setCurrencyTo(currencyTo)
                .setAmount(amount)
                .setResult(amount * 12.14)

                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
* @Override
public void uploadVideo(UploadVideoRequest request, StreamObserver<Video> responseObserver) {
    // Extract data from the request
    String title = request.getTitle();
    String description = request.getDescription();
    String url = request.getUrl();
    int durationSeconds = request.getDurationSeconds();
    Creator creator = request.getCreator();  // The Creator object within the request

    // Create a new Video (Protobuf) message for the response
    Video responseVideo = Video.newBuilder()
            .setId(UUID.randomUUID().toString()) // Generate a new unique ID for the video
            .setTitle(title)  // Set title from the request
            .setDescription(description)  // Set description from the request
            .setUrl(url)  // Set URL from the request
            .setDurationSeconds(durationSeconds)  // Set duration from the request
            .setCreator(creator)  // Set creator from the request
            .build();

    // Logic to save the video to the database (DAO operation)
    VideoEntity videoEntity = new VideoEntity();
    videoEntity.setId(responseVideo.getId());
    videoEntity.setTitle(responseVideo.getTitle());
    videoEntity.setDescription(responseVideo.getDescription());
    videoEntity.setUrl(responseVideo.getUrl());
    videoEntity.setDurationSeconds(responseVideo.getDurationSeconds());
    videoEntity.setCreatorId(responseVideo.getCreator().getId()); // Store creator ID in the entity

    // Save the video entity to the database using DAO
    videoDao.save(videoEntity);

    // Send the response back to the client
    responseObserver.onNext(responseVideo);  // Send the response video to the client
    responseObserver.onCompleted();  // Mark the gRPC call as completed
}

* */
