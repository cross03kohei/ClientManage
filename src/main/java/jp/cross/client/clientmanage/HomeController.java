package jp.cross.client.clientmanage;

import jp.cross.client.clientmanage.entity.Proceeds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    ClientService clientService;

    @GetMapping("/index")
    String clientList(Model model) {


        return "index";
    }

    @GetMapping("/search")
    String searchList(Model model){

        return "index";
    }

}
