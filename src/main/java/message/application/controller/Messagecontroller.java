package message.application.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

//import ch.qos.logback.core.model.Model;
import message.application.model.Message;

@Controller
public class Messagecontroller {
  private List <Message> messageList = new ArrayList<>();
  
  @PostMapping("/msg")
  public String postMessage(@ModelAttribute Message newMessae)
  {
    messageList.add(newMessae);

    return "redirect:msg";
  }

  @GetMapping("/msg")
  public String showMessage(Model model){
   // Message msg1 = new Message("Marien", "Bonjour la famille!");
   // Message msg2= new Message("Marien", "hello");

    //messageList.add(msg1);
    //messageList.add(msg2);

    model.addAttribute("msglist", messageList);
    model.addAttribute("newMessage", new Message());

    return "MesgPage";
  }
}
