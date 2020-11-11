package com.juliamakeup1.demo.Service.implementation;

import com.juliamakeup1.demo.Model.ClientForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;

@Service
public class SmtpMailSenderImplementation {

    @Autowired
    private JavaMailSender javaMailSender;

    public void send(ClientForm clientForm) throws MessagingException, UnsupportedEncodingException {


        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);


        String mailSubject = clientForm.getNameClient() + " quiere una cita para la fecha "+ clientForm.getDateMakeUpClient();
        String mailContent = "<h2>Tienes una nueva reserva</h2>" +
                "<br><br><p>nombre: </p>"+ clientForm.getNameClient() +
                "<br><p>numero telefono: </p>"+ clientForm.getPhoneNumberClient() +
                "<br><p>fecha de reserva: </p>"+ clientForm.getDateMakeUpClient();

        helper.setFrom("ceo@protobot.dev", "Julia Makeup");
        helper.setSubject(mailSubject);
        helper.setTo("javiermoyag81@gmail.com");
        helper.setText(mailContent,true);

        javaMailSender.send(message);
    }
}
