package com.j2htmx.inline.controllers;

import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DataBufferFactory;
import org.springframework.core.io.buffer.DefaultDataBufferFactory;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/api/media")
public class MediaController {

    @GetMapping("/mp3/{fileName}")
    public Mono<ResponseEntity<RepresentationModel<?>>> getMp3Link(@PathVariable String fileName) {
        String fileLocation = "file:///songs/" + fileName;

        // Build the HATEOAS link
        Link mp3Link = Link.of(UriComponentsBuilder.fromPath("/api/media/mp3/download/{fileName}")
                        .build(fileName).toString())

                .withRel("mp3-resource")
                .withType("audio/mpeg");

        // Create a RepresentationModel and add the link
        RepresentationModel<?> response = new RepresentationModel<>();
        response.add(mp3Link);

        return Mono.just(ResponseEntity.ok(response));
    }


    @GetMapping("/mp3/download/{fileName}")
    public ResponseEntity<byte[]> downloadMp3(@PathVariable String fileName) {
        try {
            // Adjust path to where your MP3 files are stored
            Path path = Paths.get(fileName);  // Example path to MP3 file
            byte[] mp3Data = Files.readAllBytes(path);  // Read the MP3 file as bytes

            return ResponseEntity.ok()
                    .header("Content-Disposition", "inline; filename=\"songs\\" + fileName + "\"")  // Inline to display in player
                    .contentType(MediaType.valueOf("audio/mpeg"))  // Set correct content type
                    .body(mp3Data);
        } catch (IOException e) {
            // Handle file not found or error
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(("Error reading MP3 file: " + e.getMessage()).getBytes());
        }
    }


}
