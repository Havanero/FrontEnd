package com.eurex;


import java.awt.Color;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.SwingWorker;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author cubanguy
 */
public class FrontEnd extends javax.swing.JFrame {

    private String queue;
    private String reply_address;
    private String response_address;
    /**
     * Creates new form FrontEnd
     */
    public FrontEnd() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
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
        jComboBox1 = new javax.swing.JComboBox();

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

        jProgressBar1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jProgressBar1PropertyChange(evt);
            }
        });

        jRadioButton1.setText("Clearing");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        jRadioButton2.setText("Trade Confirmation");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        jRadioButton3.setText("Trade");
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });

        jSeparator1.setBackground(java.awt.SystemColor.info);
        jSeparator1.setForeground(new java.awt.Color(136, 45, 143));

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        jTextField1.setText("CBKFR_TESTCALMMACC2");

        jLabel2.setFont(new java.awt.Font("Cantarell", 1, 48)); // NOI18N
        jLabel2.setText("EUREX ");

        jLabel1.setText("Member Account");

        jLabel3.setText("Iteration #");

        jTextField3.setText("admin/admin@cgbch");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ACCOUNT TRANSFER", "TRADE SPLIT", "AVERAGE PRICE", "DE-MERGE", "OC ADJUSTMENT", "TEXT ADJUSTMENT" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(152, 152, 152)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 666, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
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
                                .addGap(454, 454, 454))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(65, 65, 65))))))
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
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)))
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
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 12, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

  
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        final String txt = evt.getActionCommand();  
        
        if(!verifyRadioIsSelected()){
            jTextArea1.append("PLEASE MAKE SELECTION ON RADIO BUTTON \n");
            jTextArea1.setForeground(Color.red);
            return;
        }
        
        jProgressBar1.setValue(0);
        jProgressBar1.setStringPainted(true);
        
        if (jTextField2.getText().isEmpty()) jTextField2.setText("1");
        final int iteration=Integer.parseInt(jTextField2.getText());
        jButton1.setEnabled(false);
      
        
        SwingWorker worker;
        worker = new SwingWorker<Object, float[]>() {
        MessageClient messageClient = new MessageClient("amqp://admin:admin@client_id/admin?brokerlist='tcp://cbgd01.xeop.de:21282'");
        MessageClient tradeConfirmation = new MessageClient("amqp://admin:admin@client_id/admin?brokerlist='tcp://cbgd01.xeop.de:20282'");            
        MessageClient clearingRequest = new MessageClient("amqp://admin:admin@client_id/admin?brokerlist='tcp://cbgd01.xeop.de:22282'");            
            @Override
            protected void process(List<float[]> chunks) {
                float[] progress = chunks.get(chunks.size() - 1); // only want the last one
                jProgressBar1.setValue(Math.round(progress[0] * 100f));
        
            }
            @Override
            protected Object doInBackground() throws Exception {
             
             if (txt.contains("SEND")&&(txt.contains("PAYLOAD"))){
                    for (int i=1; i<=iteration;i++){
                        messageClient.SendMessage("broadcast/broadcast.RAPPIDD_Trade", jTextArea1.getText(),Integer.toString(i));
                        jTextArea2.setText("Loading... [ " + i  + " ] MESSAGES");
                        jTextArea2.append("\n");
                        jTextArea2.setBackground(Color.LIGHT_GRAY);
                        jTextArea2.setForeground(Color.BLUE);
                        publish(new float[]{
                        getProgress1(i, iteration),
                        });
                        Thread.sleep(5);
                        
                    }
             }
             if(txt.contains("GET")){
                  List total = tradeConfirmation.getTradeConfirmation(queue, jTextArea2,jProgressBar1);
                  if (total.isEmpty()){
                      jTextArea2.setText("NO MORE MESSAGES FOUND");
                      jTextArea2.setBackground(Color.black);
                      jTextArea2.setForeground(Color.WHITE);
                  }else{
                       jTextArea1.setText("[ " + total.size() + " ] MESSAGE(S) FOUND");
                   }
                  jButton1.setEnabled(true);
             }
             
             if (txt.contains("SEND")&&(txt.contains("CLEARING"))){
                 for (int i=1; i<=iteration;i++){
                 setRequestData();
                 String key=String.format("request.%s.Request", jTextField1.getText());
                 tradeConfirmation.SendAndRecieve(queue,jTextArea1.getText(),key,reply_address,response_address,jTextArea2);
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
                   
    }//GEN-LAST:event_jButton1ActionPerformed
   
    public JProgressBar getProgressBar(){
        
        return jProgressBar1;
    }
    
    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        try {
            System.out.println("Clearing");
            jRadioButton2.setSelected(false);
            jRadioButton3.setSelected(false);
            String filePath = System.getProperty("user.dir");
            ReadTemplate readTemplate;
            readTemplate = new ReadTemplate(filePath + "/templates/ClearingRequest.xml");
            jTextArea1.setForeground(Color.black);
            jTextArea2.setBackground(Color.white);
            jTextArea1.setText(readTemplate.getTemplate());
            jTextArea2.setText("");
            jButton1.setText("SEND CLEARING");
            
        } catch (IOException ex) {
            Logger.getLogger(FrontEnd.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
        try {
            System.out.println("Trade");
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
            Logger.getLogger(FrontEnd.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jRadioButton3ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        System.out.println("Trade Confirmation");
        jRadioButton1.setSelected(false);
        jRadioButton3.setSelected(false);
        jTextArea1.setText("");
        jTextArea2.setText("");
        jButton1.setText("GET PAYLOAD");
        jTextArea2.setBackground(Color.white);
        queue = String.format("broadcast.%s.%s ;{mode: consume}",jTextField1.getText(),"TradeConfirmation");
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jProgressBar1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jProgressBar1PropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jProgressBar1PropertyChange

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrontEnd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrontEnd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrontEnd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrontEnd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrontEnd().setVisible(true);
            }
        });
    }
public float getProgress1(int value, int max) {
             return (float)value / (float)max;
            }

public void setRequestData(){
    queue = String.format("request.%s/request; { node: { type: topic }, create: never }",jTextField1.getText());
    reply_address = String.format("response/response.%s.queue_1; { create: receiver, node: { type: topic } }",jTextField1.getText());
    response_address = String.format("response.%s.queue_1; {create: receiver, assert: never,node: { type: queue, x-declare:"+
                           "{ auto-delete: true, exclusive: false," +
                           "arguments: { 'qpid.policy_type':" +
                           "ring,'qpid.max_count': 1000," +
                           "'qpid.max_size': 1000000 } }, x-bindings: [ { exchange: 'response', queue:'response.%s.queue_1',key:"+
                           "'response.%s.queue_1', } ] } }",jTextField1.getText(),jTextField1.getText(),jTextField1.getText());
}
private boolean verifyRadioIsSelected(){
    
    return  jRadioButton1.isSelected()|| jRadioButton2.isSelected()|| jRadioButton3.isSelected();
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox jComboBox1;
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
    // End of variables declaration//GEN-END:variables
}
