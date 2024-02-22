package hei.school.sarisary.service;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.springframework.stereotype.Service;

@Service
public class SaryService {
  public byte[] ConvertSary(byte[] sary, String id) throws IOException {

    BufferedImage image = ImageIO.read(new ByteArrayInputStream(sary));

    BufferedImage result =
        new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_BYTE_GRAY);
    result.getGraphics().drawImage(image, 0, 0, null);
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    ImageIO.write(result, "png", byteArrayOutputStream);
    return byteArrayOutputStream.toByteArray();
  }
}
