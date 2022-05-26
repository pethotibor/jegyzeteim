package nye.progkor.jegyzeteim.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nye.progkor.jegyzeteim.model.Jegyzeteim;
import nye.progkor.jegyzeteim.model.exception.NotFoundException;
import nye.progkor.jegyzeteim.service.JegyzeteimService;

@RestController
@RequestMapping("/api/v1/jegyzeteim")
public class JegyzeteimRestController {
    
    private final JegyzeteimService jegyzeteimService;

  public JegyzeteimRestController(final JegyzeteimService jegyzeteimService) {
    this.jegyzeteimService = jegyzeteimService;
  }

  @GetMapping
  public List<Jegyzeteim> getAllJegyzeteim() {
    return jegyzeteimService.getAllJegyzeteim();
  }

  @GetMapping("/{id}")
  Jegyzeteim getJegyzeteim(final @PathVariable Long id) {
    return jegyzeteimService.getJegyzeteim(id);
  }

  @PostMapping
  Jegyzeteim createJegyzeteim(final @RequestBody Jegyzeteim jegyzeteim) {
    return jegyzeteimService.createJegyzeteim(jegyzeteim);
  }

  @PutMapping("/{id}")
  Jegyzeteim updateJegyzeteim(final @PathVariable Long id, final @RequestBody Jegyzeteim jegyzeteimChange) {
    return jegyzeteimService.updateJegyzeteim(id, jegyzeteimChange);
  }

  @DeleteMapping("/{id}")
  ResponseEntity<Void> deleteJegyzeteim(final @PathVariable Long id) {
    try {
      jegyzeteimService.deleteJegyzeteim(id);
    } catch (NotFoundException e) {
      // Ignored
    }
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
