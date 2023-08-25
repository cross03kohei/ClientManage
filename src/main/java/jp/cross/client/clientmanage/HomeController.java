package jp.cross.client.clientmanage;

import jp.cross.client.clientmanage.entity.Client;
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
    String proceedsList(Model model) {
        List<Proceeds> proceedsList = service.getProceedsList();
        model.addAttribute("list",proceedsList);
        return "index";
    }
    @GetMapping("/client")
    String clientAdd(Model model){
        model.addAttribute("clientRequest",new ClientRequest());
        return "client_add";
    }
    @GetMapping("/client/list")
    String clientList(Model model){
        List<Client> clients = service.getClientList();
        model.addAttribute("list",clients);
        return "client";
    }

    @RequestMapping(value = "client/add")
    String clientCreate(@ModelAttribute ClientRequest client){
        service.saveClient(client);
        return "redirect:/index";
    }

    @GetMapping("/search")
    String searchProceeds(Model model, @RequestParam("date") String date){
        List<Proceeds> proceedsList = service.searchProceeds(date);
        model.addAttribute("list",proceedsList);
        model.addAttribute("date",date);
        return "index";
    }

    @GetMapping("/search/client")
    String searchClient(Model model, @RequestParam("client_name") String clientName){
        List<Client> clients = service.searchClients(clientName);
        model.addAttribute("list",clients);
        return "client";
    }

}
