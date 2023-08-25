package jp.cross.client.clientmanage;

import jp.cross.client.clientmanage.entity.Proceeds;
import jp.cross.client.clientmanage.request.ClientRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    ClientService service;

    @GetMapping("/index")
    String clientList(Model model) {
        List<Proceeds> proceedsList = service.getProceedsList();
        model.addAttribute("list",proceedsList);
        return "index";
    }
    @GetMapping("/client")
    String clientadd(Model model){
        model.addAttribute("clientRequest",new ClientRequest());
        return "client_add";
    }

    @RequestMapping(value = "client/add")
    String clientCreate(@ModelAttribute ClientRequest client){
        service.saveClient(client);
        return "redirect:/index";
    }

    @GetMapping("/search")
    String searchList(Model model, @RequestParam("date") String date){
        List<Proceeds> proceedsList = service.searchList(date);
        model.addAttribute("list",proceedsList);
        model.addAttribute("date",date);
        return "index";
    }

}
