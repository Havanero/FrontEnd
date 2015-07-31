package com.eurexchange.clear.frontend;

import com.eurexchange.clear.common.service.CommonSenderService;
import com.eurexchange.clear.common.value.ClearConstants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainGui extends javax.swing.JFrame {

    private static final long serialVersionUID = 1L;
    private String queue;
    private String reply_address;
    private String response_address;
    private Map<String, String> trade_import;
    private Map<String, String> trade_confirmation;
    QpidClient messageClient;
    QpidClient tradeConfirmation;
    static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(MainGui.class);

    public MainGui() {

        LOGGER.info("Loading GUI Controls and Connection Details.. Hang on!");
        trade_import = new BrokerConnection(CommonSenderService.Broker.TRADE_IMPORT_FROM_T7,
                ClearConstants.TRADE_IMPORT_FROM_T7_QUEUE).getConnectionURL();

        trade_confirmation = new BrokerConnection(CommonSenderService.Broker.FIXML_BROADCAST,
                String.format("%s%s", ClearConstants.TRADE_CONFIRMATION_OWNER_QUEUE_PREFIX, "CBKFR")).getConnectionURL();

        messageClient = new QpidClient(trade_import.get("url"));
        tradeConfirmation = new QpidClient(trade_confirmation.get("url"));
        initComponents();
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jProgressBar1 = new javax.swing.JProgressBar();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<String>();
        lTrade_type = new JLabel();
        jLabel5 = new JLabel("AMQP:");
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jToolBar1.setRollover(true);

        jButton1.setText("SEND PAYLOAD");
        jButton1.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });


        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jProgressBar1.addPropertyChangeListener(new java.beans.PropertyChangeListener()

                                                {

                                                    public void propertyChange(java.beans.PropertyChangeEvent evt) {
                                                        jProgressBar1PropertyChange(evt);
                                                    }
                                                }

        );

        jRadioButton1.setText("Clearing");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener()

                                        {

                                            public void actionPerformed(java.awt.event.ActionEvent evt) {
                                                jRadioButton1ActionPerformed(evt);
                                            }
                                        }

        );

        jRadioButton2.setText("Trade Confirmation");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener()

                                        {

                                            public void actionPerformed(java.awt.event.ActionEvent evt) {
                                                jRadioButton2ActionPerformed(evt);
                                            }
                                        }

        );


        jRadioButton3.setText("Trade");
        jRadioButton3.addActionListener(new java.awt.event.ActionListener()

                                        {

                                            public void actionPerformed(java.awt.event.ActionEvent evt) {
                                                jRadioButton3ActionPerformed(evt);
                                            }
                                        }

        );

        jSeparator1.setBackground(java.awt.SystemColor.info);
        jSeparator1.setForeground(new java.awt.Color(136, 45, 143));

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        jTextArea2.addMouseListener(new PopClickListener());
        jTextArea1.addMouseListener(new PopClickListener());

        jTextField1.setText("CBKFR_TESTCALMMACC1");

        jLabel2.setFont(new java.awt.Font("Cantarell", 1, 48)); // NOI18N
        jLabel2.setText("EUREX ");

        jLabel1.setText("Member Account");

        jLabel3.setText("Iteration #");

        jTextField3.setText(trade_import.get("url"));
        jTextField3.setForeground(Color.blue);
        jTextField3.setBackground(Color.lightGray);
        jTextField3.setEditable(false);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"ACCOUNT TRANSFER",
                "TRADE SPLIT", "AVERAGE PRICE", "DE-MERGE", "OC ADJUSTMENT", "TEXT ADJUSTMENT"}));

        jComboBox1.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    lTrade_type.setText(String.format("Sending Trade Type %s", e.getItem().toString()));
                    lTrade_type.setForeground(Color.BLUE);
                }

            }
        });
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setPreferredSize(new Dimension(1292, 700));

        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 666, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                .addComponent(lTrade_type)
                                                                .addGap(62, 62, 62)))
                                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 561, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                .addComponent(jRadioButton3)
                                                                .addGap(41, 41, 41)
                                                                .addComponent(jRadioButton2)
                                                                .addGap(38, 38, 38)
                                                                .addComponent(jRadioButton1)
                                                                .addGap(274, 274, 274))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(454, 454, 454))))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(152, 152, 152)
                                                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(4, 4, 4)
                                                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(jTextField3))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jButton1)
                                                .addGap(65, 65, 65))))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(47, 47, 47))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(142, 142, 142)
                                                .addComponent(jButton1)
                                                .addGap(2, 2, 2))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel5))
                                                .addGap(18, 18, 18)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel3))
                                .addGap(23, 23, 23)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jRadioButton1)
                                        .addComponent(jRadioButton2)
                                        .addComponent(jRadioButton3)
                                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(33, 33, 33)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(lTrade_type)
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addGap(18, 18, 18)
                                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(17, 17, 17))
        );
        pack();
    }// </editor-fold>

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        final String txt = evt.getActionCommand();

        if (!verifyRadioIsSelected()) {
            jTextArea1.append("PLEASE MAKE SELECTION ON RADIO BUTTON \n");
            jTextArea1.setForeground(Color.red);
            return;
        }

        jProgressBar1.setValue(0);
        jProgressBar1.setStringPainted(true);

        if (jTextField2.getText().isEmpty())
            jTextField2.setText("1");
        final int iteration = Integer.parseInt(jTextField2.getText());
        jButton1.setEnabled(false);

        SwingWorker<Object, float[]> worker;
        worker = new SwingWorker<Object, float[]>() {
            @Override
            protected void process(java.util.List<float[]> chunks) {
                float[] progress = chunks.get(chunks.size() - 1); // only want the last one
                jProgressBar1.setValue(Math.round(progress[0] * 100f));

            }

            @Override
            protected Object doInBackground() throws Exception {

                if (txt.contains("SEND") && (txt.contains("PAYLOAD"))) {
                    for (int i = 1; i <= iteration; i++) {

                        messageClient.SendMessage(String.format("%s.%s", "broadcast/broadcast", trade_import.get("queue")),
                                jTextArea1.getText(),
                                Integer.toString(i));
                        jTextArea2.setText("Loading... [ " + i + " ] MESSAGES");
                        jTextArea2.append("\n");
                        jTextArea2.setBackground(Color.LIGHT_GRAY);
                        jTextArea2.setForeground(Color.BLUE);
                        publish(new float[]{
                                getProgress1(i, iteration),
                        });
                        Thread.sleep(5);

                    }
                }
                if (txt.contains("GET")) {
                    java.util.List<String> total =
                            tradeConfirmation.getTradeConfirmation(getQueue(), jTextArea2, jProgressBar1);
                    if (total.isEmpty()) {
                        jTextArea2.setText("NO MORE MESSAGES FOUND");
                        jTextArea2.setBackground(Color.black);
                        jTextArea2.setForeground(Color.WHITE);
                    } else {
                        jTextArea1.setText("[ " + total.size() + " ] MESSAGE(S) FOUND");
                    }
                    jButton1.setEnabled(true);
                }

                if (txt.contains("SEND") && (txt.contains("CLEARING"))) {
                    for (int i = 1; i <= iteration; i++) {
                        setRequestData();
                        String key = String.format("request.%s.Request", jTextField1.getText());
                        tradeConfirmation.SendAndReceive(queue, jTextArea1.getText(), key, reply_address,
                                response_address, jTextArea2);
                        publish(new float[]{
                                getProgress1(i, iteration),
                        });

                    }
                }
                jButton1.setEnabled(true);
                return null;
            }
        };
        worker.execute();

    }

    public JProgressBar getProgressBar() {

        return jProgressBar1;
    }

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        try {

            jRadioButton2.setSelected(false);
            jRadioButton3.setSelected(false);
            jTextField3.setForeground(Color.blue);
            jTextField3.setText(trade_confirmation.get("url"));
            String filePath = System.getProperty("user.dir");
            ReadTemplate readTemplate;
            readTemplate = new ReadTemplate(filePath + "/templates/ClearingRequest.xml");
            jTextArea1.setForeground(Color.black);
            jTextArea2.setBackground(Color.white);
            jTextArea1.setText(readTemplate.getTemplate());
            jTextArea2.setText("");
            jButton1.setText("SEND CLEARING");


        } catch (IOException ex) {
            Logger.getLogger(MainGui.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {

        try {

            jTextField3.setText(trade_import.get("url"));
            jTextField3.setForeground(Color.blue);
            jRadioButton1.setSelected(false);
            jRadioButton2.setSelected(false);
            jTextArea2.setText("");
            String filePath = System.getProperty("user.dir");
            ReadTemplate readTemplate;
            readTemplate = new ReadTemplate(filePath + "/templates/TradeMatchReport.xml");
            jTextArea1.setForeground(Color.black);
            jTextArea2.setBackground(Color.white);
            jTextArea1.setText(readTemplate.getTemplate());
            jButton1.setText("SEND PAYLOAD");
        } catch (IOException ex) {
            Logger.getLogger(MainGui.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        jTextField3.setText(trade_confirmation.get("url"));
        jRadioButton1.setSelected(false);
        jRadioButton3.setSelected(false);
        jTextArea1.setText("");
        jTextArea2.setText("");
        jButton1.setText("GET PAYLOAD");
        jTextArea2.setBackground(Color.white);
        queue = String.format("broadcast.%s.%s ;{mode: consume}", jTextField1.getText(), "TradeConfirmation");
    }

    private void jProgressBar1PropertyChange(java.beans.PropertyChangeEvent evt) {
        // TODO add your handling code here:
    }

    private String getQueue() {

        return String.format("broadcast.%s.%s ;{mode: consume}", jTextField1.getText(), "TradeConfirmation");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
                    .getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainGui.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        }
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            MainGui mainGui = new MainGui();

            public void run() {
                mainGui.setTitle("Trade And Clearing Tool");
                mainGui.setVisible(true);
            }
        });
    }

    public float getProgress1(int value, int max) {
        return (float) value / (float) max;
    }

    public void setRequestData() {
        queue =
                String.format("request.%s/request; { node: { type: topic }, create: never }",
                        jTextField1.getText());
        reply_address =
                String.format("response/response.%s.queue_1; { create: receiver, node: { type: topic } }",
                        jTextField1.getText());
        response_address =
                String.format(
                        "response.%s.queue_1; {create: receiver, assert: never,node: { type: queue, x-declare:"
                                +
                                "{ auto-delete: true, exclusive: false,"
                                +
                                "arguments: { 'qpid.policy_type':"
                                +
                                "ring,'qpid.max_count': 1000,"
                                +
                                "'qpid.max_size': 1000000 } }, x-bindings: [ { exchange: 'response', queue:'response.%s.queue_1',key:"
                                +
                                "'response.%s.queue_1', } ] } }", jTextField1.getText(),
                        jTextField1.getText(), jTextField1.getText());

    }

    private boolean verifyRadioIsSelected() {

        return jRadioButton1.isSelected() || jRadioButton2.isSelected() || jRadioButton3.isSelected();
    }

    // Variables declaration - do not modify
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<?> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JToolBar jToolBar1;
    private JLabel lTrade_type;
    private JLabel jLabel5;

//    @Override
//    public void mouseClicked(MouseEvent e) {
//        System.out.println("mouse clicked");
//
//    }
//
//    @Override
//    public void mousePressed(MouseEvent e) {
//        System.out.println("mouse pressed");
//
//    }
//
//    @Override
//    public void mouseReleased(MouseEvent e) {
//        System.out.println("mouse release");
//        if (jTextArea2.getSelectedText() != null){
//            String s = jTextArea2.getSelectedText();
//            System.out.println("selected txt " + s);
//        }
//    }
//
//    @Override
//    public void mouseEntered(MouseEvent e) {
//        System.out.println("mouse entered");
//
//    }

//    @Override
//    public void mouseExited(MouseEvent e) {
//        System.out.println("mouse exited");
//    }
//    // End of variables declaration

}