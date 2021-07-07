package assignment_java2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Demo_QLNV extends javax.swing.JFrame implements Runnable {

    private Interface_Nhanvien qlnv;
    DefaultTableModel model;
    List<Nhanvien> ds;
    String fileName = "src/assignment_java2/qlnv.txt";
    int index = 0;

    public Demo_QLNV() {
        initComponents();
        this.qlnv = new Qly_Nhanvien();
        this.model = (DefaultTableModel) this.tblNV.getModel();
        this.ds = this.qlnv.display();
        Thread t2 = new Thread(this);
        t2.start();
    }

    private void loadTable() {
        this.model.setRowCount(0);
        for (Nhanvien nv : this.ds) {
            Object[] rowTable = new Object[]{
                nv.getId(),
                nv.getName(),
                nv.getAge(),
                nv.getEmail(),
                nv.getSalary()
            };
            this.model.addRow(rowTable);
        }
    }

    private Nhanvien getData() {
        String id = this.txtID.getText();
        String name = this.txtName.getText();
        String email = this.txtEmail.getText();
        String tuoi = this.txtAge.getText();
        String luong = this.txtSalary.getText();
        if (id.length() == 0 || name.length() == 0 || email.length() == 0 || tuoi.length() == 0 || luong.length() == 0) {
            JOptionPane.showMessageDialog(this, "Do not null");
            return null;
        }
        if (id.length() != 7) {
            JOptionPane.showMessageDialog(this, "Press wrong ID");
            return null;
        }
        if (!email.matches("\\w+@\\w+\\.\\w+")) {
            JOptionPane.showMessageDialog(this, "Press wrong Email");
            return null;
        }

        try {
            double age = Double.parseDouble(tuoi);
            double salary = Double.parseDouble(luong);
            if (age < 16 || age > 55) {
                JOptionPane.showMessageDialog(this, "Press wrong Age");
                return null;
            }
            if (salary < 5000000) {
                JOptionPane.showMessageDialog(this, "Press wrong Salary");
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Press value of : ");
        }
        double age = Double.parseDouble(tuoi);
        double salary = Double.parseDouble(luong);
        Nhanvien nv = new Nhanvien(id, name, age, email, salary);
        return nv;

    }

    private void showDetail() {
        Nhanvien nv = this.ds.get(this.index);
        this.txtID.setText(nv.getId());
        this.txtName.setText(nv.getName());
        this.txtEmail.setText(nv.getEmail());
        this.txtSalary.setText(nv.getSalary() + "");
        this.txtAge.setText(nv.getAge() + "");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lblID = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        lblAge = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        lblSalary = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        txtAge = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtSalary = new javax.swing.JTextField();
        btnNew = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnFind = new javax.swing.JButton();
        btnOpen = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblNV = new javax.swing.JTable();
        btnFirst = new javax.swing.JButton();
        btnBetween1 = new javax.swing.JButton();
        btnBetween2 = new javax.swing.JButton();
        btnLast = new javax.swing.JButton();
        txtRecord = new javax.swing.JTextField();
        btnObj = new javax.swing.JButton();
        lblClock = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản Lý Nhân Viên\n");
        setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        setLocation(new java.awt.Point(300, 20));

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        jLabel1.setText("Quản Lý Nhân Viên");

        lblID.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lblID.setText("Mã Nhân Viên ");

        lblName.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lblName.setText("Họ và Tên");

        lblAge.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lblAge.setText("Tuổi");

        lblEmail.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lblEmail.setText("Email");

        lblSalary.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lblSalary.setText("Lương");

        btnNew.setText("New");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnFind.setText("Find");
        btnFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindActionPerformed(evt);
            }
        });

        btnOpen.setText("Open");
        btnOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpenActionPerformed(evt);
            }
        });

        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        tblNV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Nhân Viên", "Họ và Tên", "Tuổi", "Email", "Lương"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblNV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblNVMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblNV);

        btnFirst.setText("|<");
        btnFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFirstActionPerformed(evt);
            }
        });

        btnBetween1.setText("<<");
        btnBetween1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBetween1ActionPerformed(evt);
            }
        });

        btnBetween2.setText(">>");
        btnBetween2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBetween2ActionPerformed(evt);
            }
        });

        btnLast.setText(">|");
        btnLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLastActionPerformed(evt);
            }
        });

        txtRecord.setForeground(new java.awt.Color(255, 0, 51));
        txtRecord.setText("Record : ");

        btnObj.setText("Object");
        btnObj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObjActionPerformed(evt);
            }
        });

        lblClock.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        lblClock.setForeground(new java.awt.Color(255, 0, 51));
        lblClock.setText("00:00:00");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(215, 215, 215)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblName)
                                    .addComponent(lblID)
                                    .addComponent(lblAge)
                                    .addComponent(lblEmail)
                                    .addComponent(lblSalary))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtName)
                                        .addComponent(txtAge, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtSalary, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(7, 7, 7)
                                                .addComponent(btnBetween1)
                                                .addGap(26, 26, 26)
                                                .addComponent(btnBetween2)))
                                        .addGap(16, 16, 16)
                                        .addComponent(btnLast)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                                        .addComponent(txtRecord, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(78, 78, 78)
                                .addComponent(btnFirst)))
                        .addGap(87, 87, 87))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnObj)
                    .addComponent(btnExit)
                    .addComponent(btnOpen)
                    .addComponent(btnFind)
                    .addComponent(btnSave)
                    .addComponent(btnNew)
                    .addComponent(btnDelete)
                    .addComponent(lblClock, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblID)
                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)
                        .addComponent(btnNew)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblName)
                                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(btnSave)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblAge)
                                    .addComponent(txtAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(btnDelete)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblEmail)
                                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(37, 37, 37)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtSalary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblSalary)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(btnFind)
                                .addGap(31, 31, 31)
                                .addComponent(btnOpen)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnFirst)
                            .addComponent(btnBetween1)
                            .addComponent(btnBetween2)
                            .addComponent(btnLast)
                            .addComponent(txtRecord, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnExit)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(btnObj)))
                        .addGap(35, 35, 35))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(lblClock, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        this.txtID.setText("");
        this.txtEmail.setText("");
        this.txtAge.setText("");
        this.txtName.setText("");
        this.txtSalary.setText("");

    }//GEN-LAST:event_btnNewActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        int chooseRow = this.tblNV.getSelectedRow();
        Nhanvien nv = this.getData();
        if (chooseRow == -1) {
            if (nv == null) {
                return;
            }
            for (Nhanvien nv1 : this.ds) {
                if (nv1.getId().equalsIgnoreCase(this.txtID.getText())) {
                    JOptionPane.showMessageDialog(this, "ID do not repeat");
                    return;
                }
            }
            this.qlnv.insert(nv);
            loadTable();
        } else {
            if (nv == null) {
                return;
            }
            ds.set(chooseRow, nv);
            loadTable();
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int chooseRow = this.tblNV.getSelectedRow();
        if (chooseRow == -1) {
            return;
        }

        this.qlnv.delete(chooseRow);
        loadTable();
        JOptionPane.showMessageDialog(this, "Delete is successful");
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirstActionPerformed
        int index = 0;
        showDetail();
        getRecord();

    }//GEN-LAST:event_btnFirstActionPerformed

    private void btnObjActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObjActionPerformed
        this.qlnv.virtualObject();
        loadTable();
    }//GEN-LAST:event_btnObjActionPerformed
    private void getRecord() {
        this.txtRecord.setText("Record :" + (index + 1) + " of " + this.ds.size());
    }
    private void tblNVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNVMouseClicked
        int chooseRow = this.tblNV.getSelectedRow();
        if (chooseRow == -1) {
            return;
        }
        this.txtAge.setText(this.tblNV.getValueAt(chooseRow, 2).toString());
        this.txtEmail.setText(this.tblNV.getValueAt(chooseRow, 3).toString());
        this.txtID.setText(this.tblNV.getValueAt(chooseRow, 0).toString());
        this.txtName.setText(this.tblNV.getValueAt(chooseRow, 1).toString());
        this.txtSalary.setText(this.tblNV.getValueAt(chooseRow, 4).toString());
    }//GEN-LAST:event_tblNVMouseClicked

    private void btnBetween1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBetween1ActionPerformed
        if (index > 0) {
            index--;
            showDetail();
            getRecord();
        }
    }//GEN-LAST:event_btnBetween1ActionPerformed

    private void btnBetween2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBetween2ActionPerformed
        if (index < ds.size() - 1) {
            index++;
            showDetail();
            getRecord();
        }
    }//GEN-LAST:event_btnBetween2ActionPerformed

    private void btnLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastActionPerformed
        index = this.ds.size() - 1;
        showDetail();
        getRecord();
    }//GEN-LAST:event_btnLastActionPerformed

    private void btnFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindActionPerformed
        String nv = JOptionPane.showInputDialog("Press ID need find ");
        for (int i = 0; i < this.ds.size(); i++) {
            Nhanvien nvien = this.ds.get(i);
            if (nvien.getId().equalsIgnoreCase(nv)) {
                index = i;
                showDetail();
                break;
            } else {
                JOptionPane.showMessageDialog(this, "ID is not valid");
                break;
            }
        }

    }//GEN-LAST:event_btnFindActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        try {
            FileOutputStream fos = new FileOutputStream(this.fileName);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(this.ds);
            oos.close();
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.exit(0);
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpenActionPerformed
        try {
            FileInputStream fos = new FileInputStream(this.fileName);
            ObjectInputStream oos = new ObjectInputStream(fos);
            this.ds = (List<Nhanvien>) oos.readObject();
            for (Nhanvien nv : this.ds) {
                this.qlnv.insert(nv);
                break;
            }
            oos.close();
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        loadTable();
    }//GEN-LAST:event_btnOpenActionPerformed

    public static void main(String args[]) {

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
            java.util.logging.Logger.getLogger(Demo_QLNV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Demo_QLNV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Demo_QLNV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Demo_QLNV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Demo_QLNV().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBetween1;
    private javax.swing.JButton btnBetween2;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnFind;
    private javax.swing.JButton btnFirst;
    private javax.swing.JButton btnLast;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnObj;
    private javax.swing.JButton btnOpen;
    private javax.swing.JButton btnSave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAge;
    private javax.swing.JLabel lblClock;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblSalary;
    private javax.swing.JTable tblNV;
    private javax.swing.JTextField txtAge;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtRecord;
    private javax.swing.JTextField txtSalary;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
        while (true) {
            Calendar day = Calendar.getInstance();        
            int minutes = day.get(Calendar.MINUTE);
            int second = day.get(Calendar.SECOND);
            String time =  minutes + ":" + second;
            this.lblClock.setText(time);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}
