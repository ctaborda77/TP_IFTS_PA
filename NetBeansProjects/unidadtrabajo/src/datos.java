

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;


public class datos extends javax.swing.JFrame implements ClipboardOwner{
    
    public static final String URL = "jdbc:mysql://localhost/tecnicos";
    public static final String USSERNAME = "admin";
    public static final String PASSWD = "root";
    boolean auth = false;
    boolean btnM = false;
    boolean btnN = false;
    private String usuario,password;
    
    PreparedStatement ps;
    ResultSet rs;
    
    public static Connection conectar(){
        Connection conec = null;
        try {
            conec = DriverManager.getConnection(URL, USSERNAME, PASSWD);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return conec;
    }
    
    int filaSeleccionada;
    TableRowSorter trsfiltro;
  
    public void clearTxtBus() {
	txtBusqueda.setText("");
	}
    public void clearCajasNuevo(){
        comboBase.removeAllItems();
        movilN.setText("");
        telN.setText("");
        unidadN.setText("");
        nomN.setText("");
    }
    
    public datos() {
        initComponents();
        setLocationRelativeTo(null);
        mostrar();
        System.out.println(auth);
    }


    public void datos(String us, String pas){
        usuario = "Admin"; 
        password = "admin";
    }
    
    private void mostrar(){
        DefaultTableModel modelo = new DefaultTableModel();
        
        try {
            Statement stmt = this.conectar().createStatement();
            ResultSet consulta = stmt.executeQuery("SELECT ID,Movil,Telefono,UnidadOperativa,Nombre_Apellido,NOMBRE_BASE FROM unidad_trabajo U INNER JOIN bases B ON U.BaseAdministrativa=B.ID_BASE");
            modelo.setColumnIdentifiers(new Object[]{"Id","M�vil","Tel�fono",
                "Unidad Operativa","Nombre y Apellido","Base Administrativa"});
            while(consulta.next()){
            modelo.addRow(new Object[]{consulta.getString("ID"),
                consulta.getString("Movil"),
                consulta.getString("Telefono"),
                consulta.getString("UnidadOperativa"),
                consulta.getString("Nombre_Apellido"),
                consulta.getString("NOMBRE_BASE")});
            }
            table.setModel(modelo);
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        copiar = new javax.swing.JMenuItem();
        vistaModif = new javax.swing.JDialog();
        jLabel13 = new javax.swing.JLabel();
        movilM = new javax.swing.JTextField();
        telM = new javax.swing.JTextField();
        unidadM = new javax.swing.JTextField();
        nomM = new javax.swing.JTextField();
        baseM = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        modifGuardar = new javax.swing.JButton();
        modifCancelar = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        idM = new javax.swing.JTextField();
        vistaLogin = new javax.swing.JDialog();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        txtPasswd = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        btn_Login = new javax.swing.JButton();
        btnCancelarLogin = new javax.swing.JButton();
        vistaNuevo = new javax.swing.JDialog();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        movilN = new javax.swing.JTextField();
        telN = new javax.swing.JTextField();
        unidadN = new javax.swing.JTextField();
        nomN = new javax.swing.JTextField();
        bntNewRegistro = new javax.swing.JButton();
        btnCancelarNuevo = new javax.swing.JButton();
        comboBase = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtBusqueda = new javax.swing.JTextField();
        bustec = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        select = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnModif = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();

        copiar.setText("copiar");
        copiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copiarActionPerformed(evt);
            }
        });
        jPopupMenu1.add(copiar);

        vistaModif.setLocation(new java.awt.Point(450, 200));
        vistaModif.setMinimumSize(new java.awt.Dimension(485, 400));

        jLabel13.setText("M�vil:");

        baseM.setEditable(false);
        baseM.setBackground(new java.awt.Color(153, 153, 153));

        jLabel14.setText("Tel�fono:");

        jLabel15.setText("Unidad Operativa:");

        jLabel16.setText("Nombre y Apellido:");

        jLabel17.setText("Base Administrativa:");

        modifGuardar.setText("Guardar");
        modifGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifGuardarActionPerformed(evt);
            }
        });

        modifCancelar.setText("Cancelar");
        modifCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifCancelarActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel18.setText("Modificar campos....");

        jLabel7.setText("Id:");

        idM.setEditable(false);
        idM.setBackground(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout vistaModifLayout = new javax.swing.GroupLayout(vistaModif.getContentPane());
        vistaModif.getContentPane().setLayout(vistaModifLayout);
        vistaModifLayout.setHorizontalGroup(
            vistaModifLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, vistaModifLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel18)
                .addGap(135, 135, 135))
            .addGroup(vistaModifLayout.createSequentialGroup()
                .addGroup(vistaModifLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(vistaModifLayout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addComponent(modifGuardar)
                        .addGap(112, 112, 112)
                        .addComponent(modifCancelar))
                    .addGroup(vistaModifLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(vistaModifLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, vistaModifLayout.createSequentialGroup()
                                .addGroup(vistaModifLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel16)
                                    .addComponent(jLabel17))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(vistaModifLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(baseM, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(nomM, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, vistaModifLayout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addGroup(vistaModifLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(vistaModifLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(telM)
                                    .addComponent(movilM)
                                    .addComponent(unidadM, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(vistaModifLayout.createSequentialGroup()
                                        .addComponent(idM, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        vistaModifLayout.setVerticalGroup(
            vistaModifLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(vistaModifLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(vistaModifLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(idM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(vistaModifLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(movilM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(vistaModifLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(telM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addGap(18, 18, 18)
                .addGroup(vistaModifLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(unidadM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addGap(18, 18, 18)
                .addGroup(vistaModifLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nomM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addGap(18, 18, 18)
                .addGroup(vistaModifLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(baseM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addGap(47, 47, 47)
                .addGroup(vistaModifLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(modifGuardar)
                    .addComponent(modifCancelar))
                .addGap(49, 49, 49))
        );

        vistaLogin.setLocation(new java.awt.Point(500, 250));
        vistaLogin.setMinimumSize(new java.awt.Dimension(320, 340));
        vistaLogin.setResizable(false);

        jLabel3.setText("Usuario:");

        jLabel4.setText("Contrase�a: ");

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/if_Login.png"))); // NOI18N

        btn_Login.setText("Login");
        btn_Login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_LoginActionPerformed(evt);
            }
        });

        btnCancelarLogin.setText("Cancelar");
        btnCancelarLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarLoginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout vistaLoginLayout = new javax.swing.GroupLayout(vistaLogin.getContentPane());
        vistaLogin.getContentPane().setLayout(vistaLoginLayout);
        vistaLoginLayout.setHorizontalGroup(
            vistaLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(vistaLoginLayout.createSequentialGroup()
                .addGroup(vistaLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(vistaLoginLayout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(vistaLoginLayout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(vistaLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(vistaLoginLayout.createSequentialGroup()
                                .addComponent(btn_Login)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnCancelarLogin))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, vistaLoginLayout.createSequentialGroup()
                                .addGroup(vistaLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addGroup(vistaLoginLayout.createSequentialGroup()
                                        .addGap(22, 22, 22)
                                        .addComponent(jLabel3)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(vistaLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtPasswd))))))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        vistaLoginLayout.setVerticalGroup(
            vistaLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(vistaLoginLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(vistaLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(vistaLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtPasswd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(vistaLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Login)
                    .addComponent(btnCancelarLogin))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        vistaNuevo.setLocation(new java.awt.Point(450, 200));
        vistaNuevo.setMinimumSize(new java.awt.Dimension(485, 400));
        vistaNuevo.setPreferredSize(new java.awt.Dimension(434, 365));

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel8.setText("Ingreso de Nuevo Registro");

        jLabel9.setText("M�vil:");

        jLabel10.setText("Tel�fono:");

        jLabel11.setText("Unidad Operativa:");

        jLabel12.setText("Nombre y Apellido:");

        jLabel19.setText("Base Administrativa:");

        bntNewRegistro.setText("Registrar");
        bntNewRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntNewRegistroActionPerformed(evt);
            }
        });

        btnCancelarNuevo.setText("Cancelar");
        btnCancelarNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarNuevoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout vistaNuevoLayout = new javax.swing.GroupLayout(vistaNuevo.getContentPane());
        vistaNuevo.getContentPane().setLayout(vistaNuevoLayout);
        vistaNuevoLayout.setHorizontalGroup(
            vistaNuevoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(vistaNuevoLayout.createSequentialGroup()
                .addGroup(vistaNuevoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(vistaNuevoLayout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(bntNewRegistro)
                        .addGap(72, 72, 72)
                        .addComponent(btnCancelarNuevo))
                    .addGroup(vistaNuevoLayout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(jLabel8))
                    .addGroup(vistaNuevoLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(vistaNuevoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel19)
                            .addComponent(jLabel11)
                            .addComponent(jLabel10)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(vistaNuevoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(movilN)
                            .addComponent(nomN)
                            .addComponent(unidadN)
                            .addComponent(telN)
                            .addComponent(comboBase, 0, 186, Short.MAX_VALUE))))
                .addContainerGap(58, Short.MAX_VALUE))
        );
        vistaNuevoLayout.setVerticalGroup(
            vistaNuevoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(vistaNuevoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addGap(29, 29, 29)
                .addGroup(vistaNuevoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(movilN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(vistaNuevoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(telN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(vistaNuevoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(unidadN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(vistaNuevoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(nomN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(vistaNuevoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(comboBase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addGroup(vistaNuevoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bntNewRegistro)
                    .addComponent(btnCancelarNuevo))
                .addContainerGap(54, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Unidad de Trabajo");
        setLocation(new java.awt.Point(300, 250));
        setMinimumSize(new java.awt.Dimension(560, 360));

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));

        jLabel1.setBackground(new java.awt.Color(51, 102, 255));
        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setText("N� Tel�fono");

        txtBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBusquedaKeyTyped(evt);
            }
        });

        bustec.setBackground(new java.awt.Color(204, 204, 204));
        bustec.setComponentPopupMenu(jPopupMenu1);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        select.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "M�vil", "Unidad Operativa", "Nombre T�cnico", "Base T�cnica" }));
        select.setToolTipText("");

        jLabel2.setFont(new java.awt.Font("Dialog", 3, 14)); // NOI18N
        jLabel2.setText("Filtrar por....");

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fusion2.png"))); // NOI18N

        btnModif.setText("Modificar");
        btnModif.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModifActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 537, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addComponent(jLabel2))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(select, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(30, 30, 30)
                                        .addComponent(jLabel1)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtBusqueda, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                                    .addComponent(bustec))))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnModif, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnNuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(select, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(bustec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNuevo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnEliminar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnModif)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    public void filtro(){
        
        switch (select.getSelectedIndex()){
            case 0:
                trsfiltro.setRowFilter(RowFilter.regexFilter(txtBusqueda.getText(),1));
                break;
            case 1:
                trsfiltro.setRowFilter(RowFilter.regexFilter(txtBusqueda.getText(),3));
                break;
            case 2:
                trsfiltro.setRowFilter(RowFilter.regexFilter(txtBusqueda.getText(),4));
                break;
            case 3:
                trsfiltro.setRowFilter(RowFilter.regexFilter(txtBusqueda.getText(),5));
                break;
        }
    }
    
    

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        try {
            filaSeleccionada = table.getSelectedRow();
            bustec.setText(table.getValueAt(filaSeleccionada, 2).toString());
            clearTxtBus();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Debe seleccionar una fila...");
        }
        
    }//GEN-LAST:event_tableMouseClicked

    private void copiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_copiarActionPerformed
        setClipboard(bustec.getText());
    }//GEN-LAST:event_copiarActionPerformed

    private void btnModifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModifActionPerformed
        btnM=true;
        try {
            filaSeleccionada = table.getSelectedRow();
            idM.setText(table.getValueAt(filaSeleccionada, 0).toString());
            movilM.setText(table.getValueAt(filaSeleccionada, 1).toString());
            telM.setText(table.getValueAt(filaSeleccionada, 2).toString());
            unidadM.setText(table.getValueAt(filaSeleccionada, 3).toString());
            nomM.setText(table.getValueAt(filaSeleccionada, 4).toString());
            baseM.setText(table.getValueAt(filaSeleccionada, 5).toString());
            if (auth==true){
                this.vistaModif.setVisible(true);
            }else{
                this.vistaLogin.setVisible(true);
            }
            System.out.println(auth);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Debe seleccionar una fila...");
            btnM=false;
        }

    }//GEN-LAST:event_btnModifActionPerformed

    private void modifCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifCancelarActionPerformed
        this.vistaModif.setVisible(false);
    }//GEN-LAST:event_modifCancelarActionPerformed

    private void modifGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifGuardarActionPerformed
        Connection conec = null;
        
        try {
            conec = conectar();
            ps = conec.prepareStatement("UPDATE unidad_trabajo AS u INNER JOIN bases AS b ON u.BaseAdministrativa=b.ID_BASE SET Movil=?,Telefono=?,UnidadOperativa=?,Nombre_Apellido=?,NOMBRE_BASE=? WHERE ID =? ");
            ps.setString(1,movilM.getText().toUpperCase());
            ps.setString(2,telM.getText().toUpperCase());
            ps.setString(3,unidadM.getText().toUpperCase());
            ps.setString(4,nomM.getText().toUpperCase());
            ps.setString(5,baseM.getText().toUpperCase());
            ps.setString(6,idM.getText());
            
            int res = ps.executeUpdate();
            if (res > 0){
                JOptionPane.showMessageDialog(null, "Registro actualizado...");
            }else {
                JOptionPane.showMessageDialog(null, "Error al actualizar registro");
            }
            conec.close();
            this.vistaModif.setVisible(false);
            mostrar();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar registro");
        }
    }//GEN-LAST:event_modifGuardarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
    
        try {
            Connection conec = null;
            filaSeleccionada = table.getSelectedRow();

            conec = conectar();
            ps = conec.prepareStatement("DELETE FROM unidad_trabajo WHERE ID =? ");
            ps.setInt(1,Integer.parseInt(table.getValueAt(filaSeleccionada, 0).toString()));
            if (auth==true){

            int p = JOptionPane.showConfirmDialog(null,"�Desea eliminar el registro?",
                "Delete",JOptionPane.YES_NO_OPTION );
            if (p==0){
            int res = ps.executeUpdate();
            
            if (res > 0){
                JOptionPane.showMessageDialog(null, "Registro eliminado...");
            }else {
                JOptionPane.showMessageDialog(null, "Error al eliminar registro");
            }}
            conec.close();
            mostrar();
            }else {
            this.vistaLogin.setVisible(true);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Debe seleccionar una fila...");
        }
        
        
    }//GEN-LAST:event_btnEliminarActionPerformed
                                   

    private void btnCancelarLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarLoginActionPerformed
        this.vistaLogin.setVisible(false);
    }//GEN-LAST:event_btnCancelarLoginActionPerformed

    private void txtBusquedaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBusquedaKeyTyped
        txtBusqueda.addKeyListener(new KeyAdapter(){
            public void keyReleased(final KeyEvent e){
                String cadena = (txtBusqueda.getText()).toUpperCase();
                txtBusqueda.setText(cadena);
                repaint();
                filtro();
            }
        });
        trsfiltro = new TableRowSorter(this.table.getModel());
        this.table.setRowSorter(trsfiltro);
    }//GEN-LAST:event_txtBusquedaKeyTyped

    private void btn_LoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_LoginActionPerformed
    datos(usuario, password);
    if(usuario.equals(txtUsuario.getText()) && password.equals(txtPasswd.getText())){
         auth=true;
         System.out.println("btnM: "+btnM);
         System.out.println("auth: "+auth);
         if (btnM==true){
             this.vistaModif.setVisible(true);
         } else 
             if (btnN==true){
             this.vistaNuevo.setVisible(true);
         } else {
            Connection conec = null;
            filaSeleccionada = table.getSelectedRow();
            int p = JOptionPane.showConfirmDialog(null,"�Desea eliminar el registro?",
                "Delete",JOptionPane.YES_NO_OPTION );
            if (p==0){
            try {
                conec = conectar();
                ps = conec.prepareStatement("DELETE FROM unidad_trabajo WHERE ID =? ");
                ps.setInt(1,Integer.parseInt(table.getValueAt(filaSeleccionada, 0).toString()));
            
            int res = ps.executeUpdate();
            if (res > 0){
                JOptionPane.showMessageDialog(null, "Registro eliminado...");
            }else {
                JOptionPane.showMessageDialog(null, "Error al eliminar registro");
            }
            conec.close();
            mostrar();
             } catch (Exception e) {
                 System.out.println(e);
             }
            }

            }
         System.out.println(auth);
         this.vistaLogin.setVisible(false);
        }else if(txtUsuario.getText().equals("") && txtPasswd.getText().equals("")){
            JOptionPane.showMessageDialog(this,"Usuario y/o Contrase�a estan vacios\nIngr�selos por favor.");
            this.vistaLogin.setVisible(true);
            txtUsuario.setFocusable(true);
        }else if(txtUsuario.getText().equals("")){
            JOptionPane.showMessageDialog(this,"Usuario est� vacio\nIngr�selo por favor.");
            this.vistaLogin.setVisible(true);
            txtUsuario.setFocusable(true);
        }else if(txtPasswd.getText().equals("")){
            JOptionPane.showMessageDialog(this,"Contrase�a est� vacio\nIngr�selo por favor.");
            this.vistaLogin.setVisible(true);
            txtPasswd.setFocusable(true);
        }else if(txtUsuario.getText().compareTo(usuario)!=0 && txtPasswd.getText().compareTo(password)!=0){
            JOptionPane.showMessageDialog(this,"Usuario y/o Contrase�a no v�lidos\nIngr�se nuevamente.");
            this.vistaLogin.setVisible(true);
            txtUsuario.setFocusable(true);
        }else if(txtUsuario.getText().compareTo(usuario)!=0){
            JOptionPane.showMessageDialog(this,"Usuario no v�lido\nIngr�se nuevamente.");
            this.vistaLogin.setVisible(true);
            txtUsuario.setFocusable(true);
        }else if(txtPasswd.getText().compareTo(password)!=0){
            JOptionPane.showMessageDialog(this,"Contrase�a no v�lida\nIngr�se nuevamente.");
            this.vistaLogin.setVisible(true);
            txtPasswd.setFocusable(true);
        }
    }//GEN-LAST:event_btn_LoginActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        btnN = true;    
        Connection conec = null;
        conec = conectar();
        clearCajasNuevo();
        System.out.println("auth: "+auth);
        
        try {
            ps = conec.prepareStatement("SELECT * FROM bases WHERE 1");
            rs = ps.executeQuery();
            comboBase.addItem("Seleccione una opci�n");
            while(rs.next()){
                comboBase.addItem(rs.getString("NOMBRE_BASE"));
            }
            if (auth==true){
                this.vistaNuevo.setVisible(true);
               
                if(conec!=null){
                    try {
                        conec.close();
                        rs.close();
                        conec=null;
                        rs=null;
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null,e);
                    }
                }
            }else{
                this.vistaLogin.setVisible(true);
            }
            System.out.println(auth);

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null,e);
            }
                
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void bntNewRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntNewRegistroActionPerformed
        Connection conec = null;
        ResultSet rs=null;
        conec = conectar();
        String idbase="";
        try {
            String msg = comboBase.getSelectedItem().toString();
            System.out.println("SELECT ID_BASE FROM bases WHERE NOMBRE_BASE='"+msg+"'");
            
            Statement stmt = this.conectar().createStatement();
            rs = stmt.executeQuery("SELECT ID_BASE,NOMBRE_BASE FROM bases WHERE NOMBRE_BASE='"+msg+"'");
            if (rs!=null){
                while(rs.next()){
                    idbase=rs.getString(1); 
                }
            }
            int idbaseInt = Integer.parseInt(idbase);
            System.out.println(idbaseInt);

            ps = conec.prepareStatement("INSERT INTO unidad_trabajo (Movil,Telefono,UnidadOperativa,Nombre_Apellido,BaseAdministrativa) VALUES (?,?,?,?,?)");
            ps.setString(1,movilN.getText().toUpperCase());
            ps.setString(2,telN.getText().toUpperCase());
            ps.setString(3,unidadN.getText().toUpperCase());
            ps.setString(4,nomN.getText().toUpperCase());
            ps.setInt(5,idbaseInt);
                 
            int res = ps.executeUpdate();
            System.out.println(comboBase.getSelectedIndex());
            if (res > 0 && comboBase.getSelectedIndex()!=0){
                JOptionPane.showMessageDialog(null, "Nuevo registro creado...");
            conec.close();
            this.vistaNuevo.setVisible(false);
            mostrar();
            }else {
                JOptionPane.showMessageDialog(null, "Debe seleccionar una Base Administrativa");
            }

        } catch (Exception e) {
            System.err.println(e);
            JOptionPane.showMessageDialog(null, "Error al crear registros");
        }
    }//GEN-LAST:event_bntNewRegistroActionPerformed

    private void btnCancelarNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarNuevoActionPerformed
         this.vistaNuevo.setVisible(false);
    }//GEN-LAST:event_btnCancelarNuevoActionPerformed
           



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
            java.util.logging.Logger.getLogger(datos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(datos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(datos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(datos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new datos().setVisible(true);
            }
        });
    }
    
    public void setClipboard (String texto) {
        StringSelection txt = new StringSelection(texto);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(txt, this);
    }
    
    
     
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField baseM;
    private javax.swing.JButton bntNewRegistro;
    private javax.swing.JButton btnCancelarLogin;
    private javax.swing.JButton btnCancelarNuevo;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModif;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btn_Login;
    private javax.swing.JTextField bustec;
    private javax.swing.JComboBox<String> comboBase;
    private javax.swing.JMenuItem copiar;
    private javax.swing.JTextField idM;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton modifCancelar;
    private javax.swing.JButton modifGuardar;
    private javax.swing.JTextField movilM;
    private javax.swing.JTextField movilN;
    private javax.swing.JTextField nomM;
    private javax.swing.JTextField nomN;
    private javax.swing.JComboBox<String> select;
    private javax.swing.JTable table;
    private javax.swing.JTextField telM;
    private javax.swing.JTextField telN;
    private javax.swing.JTextField txtBusqueda;
    private javax.swing.JPasswordField txtPasswd;
    private javax.swing.JTextField txtUsuario;
    private javax.swing.JTextField unidadM;
    private javax.swing.JTextField unidadN;
    private javax.swing.JDialog vistaLogin;
    private javax.swing.JDialog vistaModif;
    private javax.swing.JDialog vistaNuevo;
    // End of variables declaration//GEN-END:variables

    @Override
    public void lostOwnership(Clipboard clipboard, Transferable contents) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
