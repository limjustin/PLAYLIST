package limjustin.playlist.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping("/")
    public String init() {
        return "init";
    }

    @RequestMapping("/main")
    public String main() {
        return "main";
    }
}
