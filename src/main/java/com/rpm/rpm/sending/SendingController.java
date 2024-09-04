package com.rpm.rpm.sending;

import com.rpm.rpm.Location;
import com.rpm.rpm.sending.dto.SendingRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/sending")
public class SendingController {

    private final SendingService sendingService;

    @PostMapping
    private Long postSending(@RequestPart(value = "sendingRequestDto") SendingRequestDto sendingRequestDto, @RequestPart(value = "image") MultipartFile image){

        Location location = Location.of(sendingRequestDto.getLatitude(), sendingRequestDto.getLongitude());
        return sendingService.postSending(sendingRequestDto.getUserId(), location, image);
    }
}
