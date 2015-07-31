package com.eurexchange.clear.frontend;

import org.apache.qpid.AMQException;
import org.apache.qpid.client.AMQConnection;
import org.apache.qpid.url.URLSyntaxException;

import javax.jms.*;
import javax.swing.*;
import javax.xml.bind.JAXBException;
import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class QpidClient {

    private String connectionURL;
    private AMQConnection amqConnection;
    private Session session;
    static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(QpidClient.class);

    public QpidClient(String connectionUrl) {
        this.connectionURL = connectionUrl;
    }

    private AMQConnection getConnection() throws URLSyntaxException, AMQException {

        LOGGER.info(String.format("Getting Connection for %s", this.connectionURL));
        amqConnection = new AMQConnection(connectionURL);
        LOGGER.info(amqConnection.getBrokerUUID() + "Successfully connected");
        LOGGER.info("Successfully connected");

        return amqConnection;
    }

    public void SendMessage(String requestQueue, String message, String msg_count) throws JMSException,
            URISyntaxException {
        try {
            getConnection().start();
        } catch (AMQException e) {
            e.printStackTrace();
        }

        try {

            String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss.SS").format(new Date());
            StringBuilder routingKey = new StringBuilder();
            routingKey.append(String.format("broadcast.%s.%s.%s.%s.1.%s.%s.%2s", requestQueue, "KAR",
                    "GTS.777", 2, msg_count, "2", timeStamp));
            LOGGER.info("RoutingKey" + routingKey);

            session = amqConnection.createSession(false, Session.AUTO_ACKNOWLEDGE);

            Destination destination;
            destination = session.createQueue(requestQueue);
            MessageProducer messageProducer = session.createProducer(destination);
            TextMessage textMessage;
            textMessage = session.createTextMessage();
            textMessage.setStringProperty("qpid.subject", routingKey.toString());
            textMessage.setStringProperty("qpid.id", routingKey.toString());
            textMessage.setText(message);
            messageProducer.send(textMessage);
        } catch (Exception err) {
            err.printStackTrace();
        }

        session.close();
        amqConnection.close();
    }

    public List<String>
    getTradeConfirmation(String queueName, JTextArea component_writer, JProgressBar update)
            throws JMSException,
            InterruptedException, IOException, AMQException, JAXBException {
        List<String> messages = new ArrayList<>();

        try {
            getConnection().start();
        } catch (URLSyntaxException e) {
            e.printStackTrace();
        }

        Session session = amqConnection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Queue queue = session.createQueue(queueName);
        MessageConsumer messageConsumer = session.createConsumer(queue);
        Message message;
        boolean end = false;
        while (!end) {
            message = messageConsumer.receive(5);
            if (message != null) {
                LOGGER.info(((TextMessage) message).getText());
                String text = ((TextMessage) message).getText();
                component_writer.append(new XmlFormatter().format(text) + "\n");
                component_writer.setCaretPosition(component_writer.getDocument().getLength());
                new HighLightText(component_writer, "RptID=", Color.yellow);
                messages.add(text);
                update.setValue(Math.round(messages.size() * 100f));
                component_writer.append("===END OF ===========[" + messages.size()
                        + "] MESSAGE ================================\n");
                message.acknowledge();
            } else {
                end = true;
            }

        }
        amqConnection.close();
        LOGGER.info("Closed Connection");
        return messages;
    }

    public String SendAndReceive(String queue, String message, String key, String replyAddress,
                                 String responseAddress, JTextArea component_writer)
            throws JMSException, URLSyntaxException, AMQException {


        getConnection().start();

        try {
            session = amqConnection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Queue requestQueue = session.createQueue(queue);
            Destination tempResponseQueue = session.createQueue(replyAddress);
            Queue responseQueue = session.createQueue(responseAddress);
            MessageProducer messageProducer = session.createProducer(requestQueue);
            MessageConsumer messageConsumer = session.createConsumer(responseQueue);
            TextMessage textMessage = session.createTextMessage();
            textMessage.setStringProperty("qpid.subject", key);
            textMessage.setStringProperty("qpid.reply_to", replyAddress);
            textMessage.setJMSReplyTo(tempResponseQueue);
            LOGGER.info(String.format("Message Sent= %s", message));

            textMessage.setText(message);
            messageProducer.send(textMessage);
            Message incomingMsg;
            incomingMsg = messageConsumer.receive(0);
            if (incomingMsg != null) {
                String text = ((TextMessage) incomingMsg).getText();
                LOGGER.info("Message Received=" + text);
                component_writer.append(new XmlFormatter().format(text) + "\n");
                component_writer.setCaretPosition(component_writer.getDocument().getLength());
                component_writer.setForeground(Color.blue);
                incomingMsg.acknowledge();

            }
        } catch (Exception s) {
            s.printStackTrace();
            component_writer.append("\nError ==>>" + s.getCause() + "\n");
        }
        amqConnection.close();

        return null;
    }

}
