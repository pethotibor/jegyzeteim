package nye.progkor.jegyzeteim.controller;

import nye.progkor.jegyzeteim.model.Jegyzeteim;
import nye.progkor.jegyzeteim.service.JegyzeteimService;
import java.util.List;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/jegyzeteim")

public class JegyzeteimController {
	private static final String JEGYZETEIM_LIST_TEMPLATE_NAME = "jegyzeteim/list";
	  private static final String JEGYZETEIM_EDIT_TEMPLATE_NAME = "jegyzeteim/edit";
	  private static final String JEGYZETEIM_ATTRIBUTE_NAME = "jegyzeteim";

	  private final JegyzeteimService jegyzeteimService;

	  public JegyzeteimController(final JegyzeteimService jegyzeteimService) {
	    this.jegyzeteimService = jegyzeteimService;
	  }

	  @GetMapping
	  public String getAllJegyzeteim(final Model model) {
	    final List<Jegyzeteim> jegyzeteim = jegyzeteimService.getAllJegyzeteim();
	    model.addAttribute("jegyzeteim", jegyzeteim);
	    return JEGYZETEIM_LIST_TEMPLATE_NAME;
	  }

	  @GetMapping("/{id}")
	  public String getJegyzeteim(final Model model, final @PathVariable Long id) {
	    final Jegyzeteim jegyzeteim = jegyzeteimService.getJegyzeteim(id);
	    model.addAttribute(JEGYZETEIM_ATTRIBUTE_NAME, jegyzeteim);
	    return JEGYZETEIM_EDIT_TEMPLATE_NAME;
	  }


	  @PostMapping(value = "/update", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	  public String updateJegyzeteim(final Model model,
	                               final @RequestParam(value = "id", required = false) Long id,
	                               final Jegyzeteim jegyzeteimChanges) {
	    final Jegyzeteim jegyzeteim = jegyzeteimService.updateJegyzeteim(id, jegyzeteimChanges);
	    model.addAttribute(JEGYZETEIM_ATTRIBUTE_NAME, jegyzeteim);
	    return JEGYZETEIM_EDIT_TEMPLATE_NAME;
	  }

	  @GetMapping("/create")
	  public String createJegyzeteimForm(final Model model) {
	    return "jegyzeteim/create";
	  }

	  @PostMapping("/create")
	  public String createJegyzeteim(final Model model, final Jegyzeteim jegyzeteim) {
	    final Jegyzeteim savedJegyzeteim = jegyzeteimService.createJegyzeteim(jegyzeteim);
	    model.addAttribute(JEGYZETEIM_ATTRIBUTE_NAME, savedJegyzeteim);
	    return JEGYZETEIM_EDIT_TEMPLATE_NAME;
	  }

	  @GetMapping("/{id}/delete")
	  public String deleteJegyzeteim(final Model model, final @PathVariable("id") Long id) {
	    try {
	      jegyzeteimService.deleteJegyzeteim(id);
	    } catch (nye.progkor.jegyzeteim.model.exception.NotFoundException e) {
	      // Ignored
	    }
	    final List<Jegyzeteim> jegyzeteim = jegyzeteimService.getAllJegyzeteim();
	    model.addAttribute("jegyzeteim", jegyzeteim);
	    return JEGYZETEIM_LIST_TEMPLATE_NAME;
	  }
}
