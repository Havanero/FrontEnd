/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eurex;

import java.awt.Color;
import java.awt.Graphics;
import java.io.IOException;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jms.BytesMessage;
import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.Queue;
import javax.jms.TextMessage;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.SwingWorker;
import static org.apache.log4j.Level.DEBUG;
import org.apache.qpid.AMQException;
import org.apache.qpid.client.AMQAnyDestination;
import org.apache.qpid.client.AMQConnection;
import org.apache.qpid.transport.DeliveryProperties;
import org.apache.qpid.transport.Header;
import org.apache.qpid.transport.MessageProperties;
import org.apache.qpid.transport.MessageTransfer;
import org.apache.qpid.url.URLSyntaxException;
import org.slf4j.LoggerFactory;

/**
 *
 * @author carvcal
 */
public class MessageClient {
    private final static org.slf4j.Logger LOGGER = LoggerFactory
            .getLogger(MessageClient.class);
    
    private final String connectionURL;
    private AMQConnection amqConnetion;
    public MessageClient(String connectionURL){
        this.connectionURL = connectionURL;
//         org.apache.log4j.BasicConfigurator.configure();
    }
 
    private AMQConnection getConnection() throws URLSyntaxException, AMQException{
        try {
             LOGGER.info("Getting Connection" + connectionURL);
             amqConnetion  = new AMQConnection(connectionURL);
             LOGGER.info(amqConnetion.getBrokerUUID() + "Successfully connected");
             LOGGER.info("Successfully connected");
            
        } catch (AMQException ex) {
        }     
          return amqConnetion;
    }    
    public void SendMessage(String requestQueue, String message,String msg_count) throws JMSException, URISyntaxException{
         try {
               getConnection().start();
               } catch (URLSyntaxException | AMQException ex) {
            }
            String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss.SS").format(new Date());
            StringBuilder routingKey = new StringBuilder();
            routingKey.append(String.format("broadcast.%s.%s.%s.%s.1.%s.%s.%2s", requestQueue,"KAR","GTS.777",2,msg_count,"2",timeStamp));
            LOGGER.info("RoutinhKey" +routingKey);
         try (Session session = amqConnetion.createSession(false, Session.AUTO_ACKNOWLEDGE)) {
             Queue queue =  session.createQueue(requestQueue);
             Destination destination = (Destination)queue;
             MessageProducer messageProducer = session.createProducer(destination);
             TextMessage textMessage;
             textMessage = session.createTextMessage();
             textMessage.setStringProperty("qpid.subject", routingKey.toString());
             textMessage.setStringProperty("qpid.id", routingKey.toString());
             textMessage.setText(message);
             messageProducer.send(textMessage);
         }
            amqConnetion.close();
        
    }
    
    public List<String> getTradeConfirmation(String queueName, JTextArea componentWritter, JProgressBar update) throws JMSException,
            InterruptedException, IOException{
        int msgCount=0;
        List<String>messages = new ArrayList();
        try {
               getConnection().start();
               } catch (URLSyntaxException | AMQException ex) {
            }
         try (Session session = amqConnetion.createSession(false, Session.AUTO_ACKNOWLEDGE)) {
             Queue queue =  session.createQueue(queueName);
//             String selector = "MtchID='CALEB002' and Txt3='VS 1.04'";
             MessageConsumer messageConsumer = session.createConsumer(queue);
             Message message;
             boolean end= false;
             while(!end){
                 message = (TextMessage)messageConsumer.receive(1);
                 if (message instanceof TextMessage){
//                     MessageProperties pros = message.MessageProperties();
//                     System.out.println(pros.getMessageId());
                     LOGGER.info(((TextMessage) message).getText());
                     String text = ((TextMessage) message).getText();
                     //componentWritter.append(text+"\n");
                     componentWritter.append(new XmlFormatter().format(text)+"\n");
                     componentWritter.setCaretPosition(componentWritter.getDocument().getLength());
                     new HighLightText(componentWritter,"RptID=", Color.yellow);
                     messages.add(text);
                     update.setValue(Math.round(messages.size() * 100f));
                     componentWritter.append("===END OF ===========[" + messages.size()+"] MESSAGE ================================\n");
                     message.acknowledge();
                 }
                 else{
                     end=true;
                 }
                 
             }
             LOGGER.info("Closed Connection");
         }
         catch(Exception s){
             s.printStackTrace();
         }
        amqConnetion.close();
        return messages;
    }
    
 public String SendAndRecieve(String queue, String message, String key, String replyAddress, String responseAddress, JTextArea componentWritter) 
         throws JMSException{
      try {
               getConnection().start();
               } catch (URLSyntaxException | AMQException ex) {
            }
     
     try (Session session = amqConnetion.createSession(false, Session.AUTO_ACKNOWLEDGE)){
         
         Queue requestQueue = session.createQueue(queue);
         Destination tempResponseQueue = session.createQueue(replyAddress);
         Queue responseQueue = session.createQueue(responseAddress);
         MessageProducer messageProducer = session.createProducer(requestQueue);     
         MessageConsumer messageConsumer = session.createConsumer(responseQueue);
         TextMessage textMessage = session.createTextMessage();
         textMessage.setStringProperty("qpid.subject", key);
         textMessage.setStringProperty("qpid.reply_to", replyAddress);
         textMessage.setJMSReplyTo(tempResponseQueue);
         System.out.println("Message Sent=" + message);
         
         textMessage.setText(message);
         messageProducer.send(textMessage);
         Message incomingMsg ;
         incomingMsg = (TextMessage)messageConsumer.receive(0);
         if (incomingMsg instanceof TextMessage){
             String text = ((TextMessage) incomingMsg).getText();
             System.out.println("Message Recieved=" + text);
             componentWritter.append(new XmlFormatter().format(text)+"\n");
             componentWritter.setCaretPosition(componentWritter.getDocument().getLength());
             componentWritter.setForeground(Color.blue);
             incomingMsg.acknowledge();
             
         }
     }catch(Exception s){
         s.printStackTrace();
         componentWritter.append("\nError ==>>"+s.getCause()+"\n");
     }
     amqConnetion.close();
     
     return null;
 }
//TODO: still testing ...
 private void processThread(final List msg){
    Runnable r = new Runnable() {
         
         public void run() {
             System.out.println("Running Threads.." +msg.size());
             for (int i=0;i<=msg.size();i++){
                System.out.println("setting front end messages Threads.." + msg.size());
//                frontEnd.getProgressBar().setValue(Math.round(i * 100f));
                
             }
             
         }
     };
    new Thread(r).start();
   }
}
