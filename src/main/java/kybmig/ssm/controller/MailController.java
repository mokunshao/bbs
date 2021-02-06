package kybmig.ssm.controller;


import kybmig.ssm.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


@Component
class MailTask {
    private MailSender sender;
    private MailProperties mailProperties;

    public MailTask(MailSender sender, MailProperties mailProperties) {
        this.sender = sender;
        this.mailProperties = mailProperties;
    }

    public void sendMailSync(String address, String title, String content) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(mailProperties.getUsername());
        mailMessage.setSubject(title);
        mailMessage.setTo(address);
        mailMessage.setText(content);
        try {
            sender.send(mailMessage);
        } catch (MailException ex) {
            System.err.println(ex.getMessage());
        }
        Utility.log("sendMailSync end");
    }

    @Async
    public void sendMailAsync(String address, String title, String content) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(mailProperties.getUsername());
        mailMessage.setSubject(title);
        mailMessage.setTo(address);
        mailMessage.setText(content);
        try {
            sender.send(mailMessage);
        } catch (MailException ex) {
            System.err.println(ex.getMessage());
        }
        Utility.log("sendMailAsync end");
    }
}

@Controller
public class MailController {
    private MailTask mailTask;

    public MailController(MailTask mailTask) {
        this.mailTask = mailTask;
    }

    @GetMapping("/mail/index")
    public ModelAndView index() {
        return new ModelAndView("mail/index");
    }

    @PostMapping("/mail/send")
    @ResponseBody
    public String send(String address, String title, String content) {
        Utility.log("同步发送邮件");
        if (address != null && title != null && content != null) {
            this.mailTask.sendMailSync(address, title, content);
            Utility.log("发送邮件完毕");
        }
        return "发送成功";
    }

    @PostMapping("/mail/send/async")
    @ResponseBody
    public String sendAsync(String address, String title, String content) {
        Utility.log("异步发送邮件开始");

        if (address != null && title != null && content != null) {
            this.mailTask.sendMailAsync(address, title, content);
            Utility.log("异步发送邮件完毕");
        }
        return "发送成功";
    }
}
