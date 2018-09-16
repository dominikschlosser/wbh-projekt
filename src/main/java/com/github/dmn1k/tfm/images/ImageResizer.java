package com.github.dmn1k.tfm.images;

import lombok.Cleanup;
import org.imgscalr.Scalr;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Service
public class ImageResizer {
    public byte[] createThumbnail(MultipartFile multipartFile) throws IOException {
        @Cleanup ByteArrayInputStream inputStream = new ByteArrayInputStream(multipartFile.getBytes());
        @Cleanup ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        BufferedImage img = ImageIO.read(inputStream);
        BufferedImage scaledImg = Scalr.resize(img, 60);

        ImageIO.setUseCache(false);
        ImageIO.write(scaledImg, MediaType.parseMediaType(multipartFile.getContentType()).getSubtype(), outputStream);

        return outputStream.toByteArray();
    }
}
