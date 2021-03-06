package credit.credit.controller;

import credit.credit.model.CreditType;
import credit.credit.model.Creditor;
import credit.credit.model.User;
import credit.credit.repository.CreditRepository;
import credit.credit.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;
import java.util.LinkedList;
import java.util.List;

@Controller

public class CreditorController {
    @Autowired
    private CreditRepository creditRepository;
    @Autowired
    private UserRepository userRepository;


    @RequestMapping(value = "/credit")
    public String add(ModelMap map,@RequestParam(value = "message",required = false)String message, @RequestParam(name = "id",required = false) int id){
        User one = userRepository.findOne(id);
        List<Creditor> byUserId = creditRepository.findAllByUser(one);
        map.addAttribute("message", message != null ? message : "");
        map.addAttribute("creditor",new Creditor());
        map.addAttribute("user",userRepository.findOne(id));
        map.addAttribute("credit",byUserId);
        map.addAttribute("userSum",creditRepository.userSum(id));
//        int sum=0;
//        for (Creditor creditor : byUserId) {
//            if (creditor.getType().equals(CreditType.NEW)) {
//                sum += creditor.getPrice();
//            }
//        }
//        map.addAttribute("sum",sum);
        return "details";
    }
    @RequestMapping(value = "/addCredit")
    public String cred(@ModelAttribute(name = "creditor") Creditor creditor){
           creditor.setType(CreditType.NEW);
           creditRepository.save(creditor);
        return "redirect:/credit"+"?id="+creditor.getUser().getId();
    }
    @RequestMapping(value = "/changeType")
    public String type(@RequestParam("id") int id){
        Creditor one = creditRepository.findOne(id);
        one.setType(CreditType.END);
        creditRepository.save(one);
        return "redirect:/credit"+"?id="+one.getUser().getId();
    }
    @RequestMapping(value = "/deletePrice")
    public String delete(@RequestParam("id") int id){
        Creditor one = creditRepository.findOne(id);
        creditRepository.delete(id);
        return "redirect:/credit"+"?id="+one.getUser().getId();

    }
    @RequestMapping(value = "/searchByDate")
    public String date(ModelMap map,@RequestParam("date") String date){
        List<Creditor> allByDate = creditRepository.findAllByDate(date);
        if (allByDate.isEmpty()){
            map.addAttribute("mes",date.substring(5,10)+" amsatvin partq chi exel");
        }else {
            map.addAttribute("allByDate",allByDate);
        }
//        List<User> l=new LinkedList<>();
//        for (Creditor creditor : allByDate) {
//            l.add(userRepository.findOne(creditor.getUser().getId()));
//        }
//        if (!l.isEmpty()) {
//            map.addAttribute("usersByDate", l);
//        }else {
//            map.addAttribute("mes",date.substring(5,10)+" amsatvin partq chi exel");
//        }
return "result";
    }
}
