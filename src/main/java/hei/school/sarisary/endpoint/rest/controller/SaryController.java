package hei.school.sarisary.endpoint.rest.controller;

import hei.school.sarisary.service.SaryService;
import java.io.IOException;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/black-and-white")
public class SaryController {
  private final SaryService saryService;

  public SaryController(SaryService saryService) {
    this.saryService = saryService;
  }

  @PutMapping(name = "/{id}", produces = MediaType.IMAGE_PNG_VALUE)
  public byte[] convertToBlackAndWhite(@PathVariable String id, @RequestBody byte[] sary) {
    try {
      if (sary == null) {
        throw new RuntimeException("Select a image");
      }

      return saryService.ConvertSary(sary, id);
    } catch (IOException e) {
      e.printStackTrace();
      throw new RuntimeException("Error 500");
    }
  }
}
