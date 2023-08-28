package jp.cross.client.clientmanage;

import jp.cross.client.clientmanage.entity.Client;
import jp.cross.client.clientmanage.entity.Manager;
import jp.cross.client.clientmanage.entity.Proceeds;
import jp.cross.client.clientmanage.request.ClientRequest;
import jp.cross.client.clientmanage.request.ProceedsRequest;
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

    /**
     *顧客追加の画面表示
     */
    @GetMapping("/client")
    String clientAdd(Model model){
        model.addAttribute("clientRequest",new ClientRequest());
        return "client_add";
    }

    /**
     * 顧客の詳細を表示すると同時にそれに紐づく売上一覧の表示をおこなう
     */
    @GetMapping("/client/{id}")
    String ClientDetail(Model model,@PathVariable("id")Integer id){
        List<Proceeds> proceedsList = service.getProceedsClient(id);
        Client client = service.getClient(id);
        model.addAttribute("list",proceedsList);
        model.addAttribute("client",client);
        return "client_detail";
    }

    /**
     *顧客の一覧を表示する
     */
    @GetMapping("/client/list")
    String clientList(Model model){
        List<Client> clients = service.getClientList();
        model.addAttribute("list",clients);
        return "client";
    }

    /**
     *顧客を追加、編集を行う
     */
    @RequestMapping(value = "client/add")
    String clientCreate(@ModelAttribute ClientRequest client){
        service.saveClient(client);
        return "redirect:/index";
    }

    /**
     *売上登録の画面表示
     */
    @GetMapping("/client/proceeds/add/{id}")
    String proceedsAdd(Model model,@PathVariable("id")Integer id){
        List<Manager> managers = service.getManagerList();
        model.addAttribute("id",id); //登録の際に使用する顧客のID
        model.addAttribute("proceedsRequest",new ProceedsRequest());
        model.addAttribute("managerList",managers);
        model.addAttribute("selectedValue", "01");
        return "proceeds_add";
    }

    /**
     *売上の登録、編集を行う
     */
    @GetMapping("/client/proceeds/create")
    String proceedsCreate(@ModelAttribute ProceedsRequest proceedsRequest,
                          @RequestParam("clientId")Integer clientId,
                          @RequestParam("managerId")Integer managerId){

        return "redirect:/client/{clientId}";
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
