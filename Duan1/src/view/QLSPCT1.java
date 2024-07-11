/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package view;

import java.awt.Image;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.ChatLieu;
import model.KichCo;
import model.Mau;
import model.SanPham;
import model.SanPhamChiTiet;
import model.XuatXu;
import service.SPService;
import service.SanPhamChiTietService;

/**
 *
 * @author 4bacu
 */
public class QLSPCT1 extends javax.swing.JDialog {

    /**
     * Creates new form QLSPCT1
     */
        SanPhamChiTietService spctsv = new SanPhamChiTietService();
    SanPham sp = new SanPham();
    int index = -1;
    DefaultTableModel model = new DefaultTableModel();
    DefaultTableModel model1 = new DefaultTableModel();
    SPService spsv = new SPService();
    public QLSPCT1(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setTitle("Sản phẩm chi tiết");
        Image icon = new ImageIcon(this.getClass().getResource("/vot.png")).getImage();
        this.setIconImage(icon);
        setLocationRelativeTo(null);
        setSize(900, 700);
        fillComboBox();
        model1 = (DefaultTableModel) tblsp.getModel();
        filltable1(spsv.getallbangspct());
        model = (DefaultTableModel) tblQuanLy1.getModel();
        filltable(spctsv.getAll());
    }
    private void filltable1(List<SanPham> list) {
        model = (DefaultTableModel) tblsp.getModel();
        model.setRowCount(0);
        for (SanPham Sp : list) {
            model.addRow(new Object[]{
                Sp.getId(),
                Sp.getTen(),
                Sp.getGiaban(),
                Sp.getMota(),
                Sp.isTrangthai() ? "Đang bán" : "Ngừng bán"
            });
        }
    }

    void fillComboBox() {

        DefaultComboBoxModel model = (DefaultComboBoxModel) cboMauSac.getModel();
        model.removeAllElements();
        try {
            List<Mau> list = spctsv.getMau();
            for (Mau m : list) {
                model.addElement(m);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Loi Mau");
        }
        DefaultComboBoxModel model1 = (DefaultComboBoxModel) cboKichThuoc.getModel();
        model1.removeAllElements();
        try {
            List<KichCo> list = spctsv.getKichCo();
            for (KichCo kc : list) {
                model1.addElement(kc);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Loi Kich Co");
        }
        DefaultComboBoxModel model2 = (DefaultComboBoxModel) cboChatLieu.getModel();
        model2.removeAllElements();
        try {
            List<ChatLieu> list = spctsv.getchatlieu();
            for (ChatLieu cl : list) {
                model2.addElement(cl);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Loi Chat Lieu");
        }
        DefaultComboBoxModel model3 = (DefaultComboBoxModel) cboXuatXu.getModel();
        model3.removeAllElements();
        try {
            List<XuatXu> list = spctsv.getxuatxu();
            for (XuatXu xx : list) {
                model3.addElement(xx);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Loi Xuat xu");
        }
    }
    private void filltable(List<SanPhamChiTiet> all) {
        model.setRowCount(0);
        for (SanPhamChiTiet sanPhamChiTiet : all) {
            model.addRow(sanPhamChiTiet.toDatarow());
        }
    }

    private void showdata(int index) {
        SanPhamChiTiet spct = spctsv.getAll().get(index);
        SoLuong1.setText(spct.getSanpham().getId() + "");
        txtMaSP1.setText(spct.getIdspct() + "");
        cboMauSac.setSelectedIndex(spct.getMau().getIdmau() - 1);
        cboChatLieu.setSelectedIndex(spct.getChatlieu().getIdchatlieu() - 1);
        cboKichThuoc.setSelectedIndex(spct.getKichco().getIdkichco() - 1);
        cboXuatXu.setSelectedIndex(spct.getXuatxu().getIdxuatxu() - 1);
        SoLuong.setText(spct.getSoluong() + "");
    }

    boolean checkdata() {
        if (txtMaSP1.getText().trim().isEmpty() || SoLuong.getText().trim().isEmpty() || SoLuong1.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "vui long dien day du thong tin");
            return false;
        }
        try {
            int idctsp = Integer.parseInt(txtMaSP1.getText());
            int soluong = Integer.parseInt(SoLuong.getText());
            int idsp = Integer.parseInt(SoLuong1.getText());
            return true;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "hãy kiểm tra lại Mã sản phẩm chi tiết,số lượng và mã sản phẩm của bạn phải là số");
            return false;
        }
    }

    boolean checktim() {
        try {
            int tim = Integer.parseInt(txtTimKiem.getText());
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Hãy Nhập Vào Đúng Số ID Sản Phẩm Chi Tiết");
            return false;
        }
    }   boolean checktimtheosp() {
        try {
            int tim = Integer.parseInt(jTextField1.getText());
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Hãy Nhập Vào Đúng Số ID Sản Phẩm");
            return false;
        }
    }

    private SanPhamChiTiet readform() {
        SanPham sp = new SanPham(Integer.parseInt(SoLuong1.getText()), "", WIDTH, "", rootPaneCheckingEnabled);
        int maspct = Integer.parseInt(txtMaSP1.getText());
        int soluong = Integer.parseInt(SoLuong.getText());
        KichCo kc = new KichCo(cboKichThuoc.getSelectedIndex() + 1, cboKichThuoc.getSelectedItem().toString());
        ChatLieu cl = new ChatLieu(cboChatLieu.getSelectedIndex() + 1, cboChatLieu.getSelectedItem().toString());
        Mau m = new Mau(cboMauSac.getSelectedIndex() + 1, cboMauSac.getSelectedItem().toString());
        XuatXu xx = new XuatXu(cboXuatXu.getSelectedIndex() + 1, cboXuatXu.getSelectedItem().toString());
        return new SanPhamChiTiet(maspct, sp, soluong, kc, cl, xx, m);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cboMauSac = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cboKichThuoc = new javax.swing.JComboBox<>();
        cboChatLieu = new javax.swing.JComboBox<>();
        cboXuatXu = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtMaSP1 = new javax.swing.JTextField();
        SoLuong = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        SoLuong1 = new javax.swing.JTextField();
        btnThem = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        tbnSua = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblsp = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblQuanLy1 = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        txtTimKiem = new javax.swing.JTextField();
        btnTim = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        cboMauSac.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel7.setText("Màu sắc");

        jLabel8.setText("Kích thước");

        cboKichThuoc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cboChatLieu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cboXuatXu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel9.setText("Chất liệu");

        jLabel10.setText("Xuất xứ");

        jLabel13.setText("Mã sản phẩm CT");

        SoLuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SoLuongActionPerformed(evt);
            }
        });

        jLabel5.setText("Số lượng");

        jLabel6.setText("Mã Sản Phẩm");

        SoLuong1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SoLuong1ActionPerformed(evt);
            }
        });

        btnThem.setText("Thêm sản phẩm Chi Tiết");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnXoa.setText("Xóa sản phẩm");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        tbnSua.setText("Sửa sản phẩm");
        tbnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbnSuaActionPerformed(evt);
            }
        });

        tblsp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã", "Tên sản phẩm", "Giá bán", "Mô tả", "Trạng thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblsp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblspMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblsp);

        tblQuanLy1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã SPCT", "Mã SP", "Xuất xứ", "Màu sắc", "Kích thước", "Chất liệu", "Số lượng "
            }
        ));
        tblQuanLy1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblQuanLy1MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblQuanLy1);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("Tìm kiếm SPCT:  ");

        btnTim.setText("Tìm kiếm");
        btnTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimActionPerformed(evt);
            }
        });

        jButton1.setText("Tìm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setText("Tìm kiếm SPCT Theo IDSP:  ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel7)
                            .addComponent(jLabel13)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(SoLuong1)
                            .addComponent(cboMauSac, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cboXuatXu, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cboChatLieu, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cboKichThuoc, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtMaSP1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(SoLuong, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(140, 140, 140))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(213, 213, 213)
                                .addComponent(btnThem)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnTim)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1)
                        .addGap(6, 6, 6)
                        .addComponent(jButton1)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tbnSua)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnXoa))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaSP1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cboMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cboKichThuoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(cboChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(cboXuatXu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SoLuong1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTim)
                    .addComponent(jButton1)
                    .addComponent(jLabel14)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tbnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SoLuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SoLuongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SoLuongActionPerformed

    private void SoLuong1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SoLuong1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SoLuong1ActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        if (checkdata()) {
            SanPhamChiTiet spct = this.readform();
            if (spctsv.getAll1(spct.getIdspct()) != null) {
                JOptionPane.showMessageDialog(this, "trung ma");
            } else {
                if (spctsv.addSanPhamChiTiet(spct) != 0) {
                    JOptionPane.showMessageDialog(this, "them thanh cong");
                    this.filltable(spctsv.getAll());
                } else {
                    JOptionPane.showMessageDialog(this, "them that bai");
                }
            }
        }

    }//GEN-LAST:event_btnThemActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        int index = tblQuanLy1.getSelectedRow();
        int id = (int) tblQuanLy1.getValueAt(index, 0);
        int hoi = JOptionPane.showConfirmDialog(this, "Bạn Có Chắc Là muốn xóa không");
        if (hoi == 0) {
            if (spctsv.xoaspct(id) != 0) {
                JOptionPane.showMessageDialog(this, "Xóa Thành Công");
                filltable(spctsv.getAll());
            } else {
                JOptionPane.showMessageDialog(this, "Xóa Thất Bại");
            }
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void tbnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbnSuaActionPerformed
        index = tblQuanLy1.getSelectedRow();
        //lấy ra đối tượng mới trên bảng
        SanPhamChiTiet spct = this.readform();
        int id = Integer.parseInt(tblQuanLy1.getValueAt(index, 0).toString());
        if (spctsv.update(spct, id) > 0) { //update được
            JOptionPane.showMessageDialog(this, "update thành công");
            this.filltable(spctsv.getAll());
        } else {
            JOptionPane.showMessageDialog(this, "update thất bai");
        }
    }//GEN-LAST:event_tbnSuaActionPerformed

    private void tblspMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblspMouseClicked

    }//GEN-LAST:event_tblspMouseClicked

    private void tblQuanLy1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblQuanLy1MouseClicked

        index = tblQuanLy1.getSelectedRow();
        showdata(index);
    }//GEN-LAST:event_tblQuanLy1MouseClicked

    private void btnTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimActionPerformed
        if (checktim()) {
            int ma = Integer.parseInt(txtTimKiem.getText());
            if (spctsv.findname(ma) != null) {
                int check = 0;
                //            filltable(spctsv.findname(ma));
                for (int i = 0; i < tblQuanLy1.getRowCount(); i++) {
                    int values = Integer.parseInt(tblQuanLy1.getValueAt(i, 0).toString());
                    if (values == ma) {
                        index = i;
                        check++;
                        break;//thoat ngay
                    }
                }
                if (check > 0) {
                    this.showdata(index);
                    tblQuanLy1.setRowSelectionInterval(index, index);
                } else {
                    JOptionPane.showMessageDialog(this, "Khong tim thay");
                }
            } else {
                JOptionPane.showMessageDialog(this, "khong tim thay");
            }
        }

    }//GEN-LAST:event_btnTimActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (checktimtheosp()) {
            int ma = Integer.parseInt(jTextField1.getText());
            if (spctsv.findnameidsp(ma) != null) {
                int check = 0;
                //            filltable(spctsv.findname(ma));
                for (int i = 0; i < tblQuanLy1.getRowCount(); i++) {
                    int values = Integer.parseInt(tblQuanLy1.getValueAt(i, 1).toString());
                    if (values == ma) {
                        index = i;
                        check++;
                        break;//thoat ngay
                    }
                }
                if (check > 0) {
                    this.showdata(index);
                    tblQuanLy1.setRowSelectionInterval(index, index);
                } else {
                    JOptionPane.showMessageDialog(this, "Khong tim thay");
                }
            } else {
                JOptionPane.showMessageDialog(this, "khong tim thay");
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(QLSPCT1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QLSPCT1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QLSPCT1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QLSPCT1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                QLSPCT1 dialog = new QLSPCT1(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField SoLuong;
    private javax.swing.JTextField SoLuong1;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTim;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cboChatLieu;
    private javax.swing.JComboBox<String> cboKichThuoc;
    private javax.swing.JComboBox<String> cboMauSac;
    private javax.swing.JComboBox<String> cboXuatXu;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable tblQuanLy1;
    private javax.swing.JTable tblsp;
    private javax.swing.JButton tbnSua;
    private javax.swing.JTextField txtMaSP1;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}

