package ru.sema1ary.sema1ary_website.service;

import lombok.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.servlet.view.RedirectView;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class ImageService {
    private final Path imagesPath = Paths.get("images/");

    public RedirectView upload(@NonNull MultipartFile image) {
        try {
            String uuid = UUID.randomUUID().toString();
            image.transferTo(imagesPath.resolve(uuid + ".png"));

            return new RedirectView(ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path("/images/")
                    .path(uuid + ".png")
                    .toUriString());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
