package hei.school.sarisary.endpoint.rest.controller.health;

import hei.school.sarisary.service.SaryService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/black-and-white")
public class SaryController {
  private final SaryService saryService;

  public SaryController(SaryService saryService) {
    this.saryService = saryService;
  }

  @PutMapping(value = "/{id}", produces = MediaType.IMAGE_PNG_VALUE)
  public void convertToBlackAndWhite(@PathVariable String id, @RequestBody byte[] sary) {
    saryService.ConvertSary(sary, id);
  }
}
