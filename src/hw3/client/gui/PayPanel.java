/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hw3.client.gui;

import hw3.client.Controller;
import hw3.client.gui.serverclasses.Ticket;

/**
 *
 * @author Gerard
 */
public class PayPanel extends javax.swing.JPanel {

    private final MainFrame frame;

    /**
     * Creates new form PayPanel
     */
    PayPanel(MainFrame frame, String txt) {
        initComponents();
        this.frame = frame;
        this.flightTextArea.setText(txt);
        this.yourTicketLabel.setVisible(false);
        this.ticketTextArea.setVisible(false);


    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        flightTextArea = new javax.swing.JTextArea();
        creditCardTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        payButton = new javax.swing.JButton();
        yourTicketLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        ticketTextArea = new javax.swing.JTextArea();

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Book Flight Web Service");

        jLabel1.setText("Selected flight:");

        flightTextArea.setColumns(20);
        flightTextArea.setRows(5);
        jScrollPane1.setViewportView(flightTextArea);

        jLabel2.setText("Credit Card Number:");

        payButton.setText("Pay");
        payButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payButtonActionPerformed(evt);
            }
        });

        yourTicketLabel.setText("Your Ticket");

        ticketTextArea.setColumns(20);
        ticketTextArea.setRows(5);
        jScrollPane2.setViewportView(ticketTextArea);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(creditCardTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(payButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(yourTicketLabel))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(creditCardTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(payButton))
                .addGap(18, 18, 18)
                .addComponent(yourTicketLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void payButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_payButtonActionPerformed

        try {
            Ticket t = Controller.getInstance().pay(this.creditCardTextField.getText());
            yourTicketLabel.setVisible(true);
            ticketTextArea.setVisible(true);
            String str="Ticket paid with credit card number " + t.creditCardNumber+"\n";
            str+="Total price of ticket: " + t.totalPrice;
            ticketTextArea.setText(str);
            payButton.setEnabled(false);
            
        } catch (Exception e) {
            
        }


    }//GEN-LAST:event_payButtonActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField creditCardTextField;
    private javax.swing.JTextArea flightTextArea;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton payButton;
    private javax.swing.JTextArea ticketTextArea;
    private javax.swing.JLabel yourTicketLabel;
    // End of variables declaration//GEN-END:variables
}
