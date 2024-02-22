package hei.school.sarisary.service;

import hei.school.sarisary.file.BucketComponent;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SaryService {
  private final BucketComponent bucketComponent;

  private File uploadImage(String file, BufferedImage image) throws IOException {
    String allName = file + " .png";
    File tempFile = File.createTempFile(file, " .png");
    ImageIO.write(image, "png", tempFile);
    bucketComponent.upload(tempFile, "images/");
    return tempFile;
  }

  public void ConvertSary(byte[] sary, String id) {

    try {
      if (sary == null) {
        throw new RuntimeException("Select a image");
      }
      BufferedImage image = ImageIO.read(new ByteArrayInputStream(sary));

      uploadImage(sary + ".orginal", image);
      BufferedImage result =
          new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_BYTE_GRAY);
      result.getGraphics().drawImage(image, 0, 0, null);

      uploadImage(sary + "blackwhite", image);

    } catch (IOException e) {
      e.printStackTrace();
      throw new RuntimeException("Error 500");
    }
  }
}
