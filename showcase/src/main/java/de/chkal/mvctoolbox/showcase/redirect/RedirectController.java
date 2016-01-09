package de.chkal.mvctoolbox.showcase.redirect;

import de.chkal.mvctoolbox.core.redirect.Redirect;

import javax.inject.Inject;
import javax.mvc.Models;
import javax.mvc.annotation.Controller;
import javax.ws.rs.*;

@Controller
@Path("/redirect/{param1}")
public class RedirectController {

  @Inject
  private Models models;

  @PathParam("param1")
  private String param1;

  @QueryParam("param2")
  private String param2;

  @GET
  public String get() {
    models.put("param1", param1);
    models.put("param2", param2);
    return "redirect.jsp";
  }

  @POST
  public String post(@BeanParam RedirectForm form) {

    return Redirect.to("/redirect/{param1}")
        .set("param1", form.getParam1())
        .set("param2", form.getParam2())
        .build();

  }

}
