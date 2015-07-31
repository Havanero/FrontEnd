package com.eurexchange.clear.frontend;

import com.eurexchange.clear.common.service.CommonSenderService;
import com.eurexchange.clear.dao.AmqpQueueDao;
import com.eurexchange.clear.dao.AmqpQueueDaoImpl;
import com.eurexchange.clear.dao.ConfigurationDao;
import com.eurexchange.clear.dao.ConfigurationDaoImpl;
import com.eurexchange.clear.domain.AmqpQueue;
import com.eurexchange.clear.systemconfig.service.SystemConfigService;
import com.eurexchange.clear.systemconfig.service.SystemConfigServiceImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.HashMap;
import java.util.Map;


public class BrokerConnection {
    private HashMap<String, String> queue_configuration;
    private CommonSenderService.Broker _broker;
    private String queueName;
    AmqpQueueDao amqpDao;
    SystemConfigService systemConfigService;
    ConfigurationDao configDao;
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("clearingLivePU");
    EntityManager em = emf.createEntityManager();

    public BrokerConnection(CommonSenderService.Broker broker, String queue) {
        this._broker = broker;
        this.queueName = queue;
    }


    public Map<String, String> getConnectionURL() {
        return getConnectionURL(_broker, queueName);
    }

    private Map<String, String> getConnectionURL(CommonSenderService.Broker broker, String queueName) {
        amqpDao = new AmqpQueueDaoImpl(em);
        configDao = new ConfigurationDaoImpl(em);
        systemConfigService = new SystemConfigServiceImpl(configDao);

        AmqpQueue queue = amqpDao.findByBrokerAndQueueName(
                broker, queueName);
        queue.setUser("admin");
        queue.setPassword("admin");
        String brokerAddress =
                systemConfigService.getCachedStringConfigValue(queue.getBrokerId());
        queue_configuration = new HashMap<>();
        queue_configuration.put("url", CommonSenderService.Broker.createUrl(queue, brokerAddress));
        queue_configuration.put("queue", queue.getQueueName());
        queue_configuration.put("destination_queue", queue.getDestination());
        return queue_configuration;
    }
}