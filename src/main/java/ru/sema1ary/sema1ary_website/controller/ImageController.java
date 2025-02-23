package ru.sema1ary.sema1ary_website.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;
import ru.sema1ary.sema1ary_website.service.ImageService;

@RestController
@RequestMapping("/api/v1/image")
public class ImageController {
    @Autowired
    private ImageService imageService;

    @PostMapping("/upload")
    public RedirectView upload(@RequestBody MultipartFile image) {
        return imageService.upload(image);
    }
}
