import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LZWForm extends javax.swing.JFrame {

    /**
     * Creates new form LZWForm
     */
    public LZWForm() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        DataEntered = new javax.swing.JTextField();
        CompressButton = new javax.swing.JButton();
        DecompressButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        CompressResult = new javax.swing.JLabel();
        DecompressResult = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        DataEntered.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DataEnteredActionPerformed(evt);
            }
        });

        CompressButton.setText("Compress");
        CompressButton.setToolTipText("Press This Button To Compress The Data");
        CompressButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CompressButtonActionPerformed(evt);
            }
        });

        DecompressButton.setText("Decompress");
        DecompressButton.setToolTipText("Press This Button To Decompress The Data");
        DecompressButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DecompressButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tempus Sans ITC", 3, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("LZ W Compressor");
        jLabel1.setToolTipText("");

        CompressResult.setText("Copmress Result");
        CompressResult.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                CompressResultAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        DecompressResult.setText("Decompress Result");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(CompressButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(DecompressButton, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(CompressResult, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(DataEntered)
                    .addComponent(DecompressResult, javax.swing.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(DataEntered, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(CompressButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(CompressResult, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                .addGap(26, 26, 26)
                .addComponent(DecompressButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(DecompressResult, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CompressButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CompressButtonActionPerformed
        Files f;
        f = new Files();
        String data = DataEntered.getText();
        String Dictionary [][];
        Dictionary = new String [100][2];
        int CompressedData [];
        CompressedData = new int [40];
        int z=0;
        String temp="";
        char tmp;
        //Diciotnary Intialization******************************
        for(int e=65;e<=90;e++)
        {
            
            tmp = (char)e;
            temp += tmp;
            Dictionary[z][0]=temp;
            Dictionary[z][1]=Integer.toString(e);
            z++;
            temp="";
        }
        for(int e=97;e<=122;e++)
        {
            tmp = (char)e;
            temp += tmp;
            Dictionary[z][0]=temp;
            Dictionary[z][1]=Integer.toString(e);
            z++;
            temp="";
        }
        //******************************************************
        int iteration =0;
        int pointer=0;
        int CurrentNewEntitiy = 128;
        String find ="";
        int index;        
        boolean isfound= false;
        for(int i=0;i<=data.length();i++)
        {
            int counter=0;
            if(i>=data.length())
            {
                break;
            }else
            {
                find += data.charAt(i);
            }
            //*******************************************************************************
            for(int c=0;c<100;c++)
            {
                
                
                if(find.equals(Dictionary[c][0]))
                {
                    index=Integer.parseInt(Dictionary[c][1]);
                    CompressedData[pointer]=index; 
                    System.out.println(iteration + "-" + find);
                    isfound = true;
                    i++;
                    if(i>=data.length())
                    {
                        if(find.length()==1)
                        {
                            /*Dictionary[z][0] = find;
                            char ch = find.charAt(0);
                            Dictionary[z][1] = Integer.toString(ch);
                            CompressedData[pointer]=(int)ch;
                            z++;
                            pointer++;*/
                            break;
                        }
                        else
                        {
                            //System.out.println("(isfound==true)???");
                            /*Dictionary[z][0] = find;
                            Dictionary[z][1] = Integer.toString(CurrentNewEntitiy); //To convert to integer again do this : integer.parseint(String)
                            CompressedData[pointer]=CurrentNewEntitiy;
                            CurrentNewEntitiy++;
                            z++;
                            pointer++;*/
                            break;
                        }

                    }
                    i--;
                    if(counter>0)
                    {
                        i++;  
                        if(data.length()>(i+1))
                        {
                            find+=data.charAt(i+1);                        
                            counter++;
                            c=0;
                        }
                                                  
                        
                    }else
                    {
                        find+=data.charAt(i+1);  
                        counter++;
                        c=0;
                    }
                          
                    }else
                    {                        
                        isfound=false;
                    }
                
            }
            
            
            //*******************************************************************************
            if(isfound==true)
            {
                i++;
                if(i>=data.length())
                {
                    if(find.length()==1)
                    {
                        /*Dictionary[z][0] = find;
                        char ch = find.charAt(0);
                        Dictionary[z][1] = Integer.toString(ch);
                        CompressedData[pointer]=(int)ch;
                        z++;
                        pointer++;*/
                        break;
                    }
                    else
                    {
                        //System.out.println("(isfound==true)???");
                        /*Dictionary[z][0] = find;
                        Dictionary[z][1] = Integer.toString(CurrentNewEntitiy); //To convert to integer again do this : integer.parseint(String)
                        CompressedData[pointer]=CurrentNewEntitiy;
                        CurrentNewEntitiy++;
                        z++;
                        pointer++;*/
                        break;
                    }
                    
                }
                i--;
                
            }
            //*******************************************************************************
            if(isfound==false)
            { 
                    //System.out.println("(isfound==false)???");
                    Dictionary[z][0] = find;
                    Dictionary[z][1] = Integer.toString(CurrentNewEntitiy); //To convert to integer again do this : integer.parseint(String)
                    //CompressedData[pointer]=CurrentNewEntitiy;
                    CurrentNewEntitiy++;
                    z++;
                    pointer++; 
                    //counter=0;
                    find = "";
                    iteration++;

            }
            //*******************************************************************************
            
        }
        for(int o=0;o<100;o++)
        {
        if(Dictionary[o][1]==null)
        {
            break;
            //System.out.print("Null");
        }else
        {
            System.out.print(Dictionary[o][0]);
            int now = Integer.parseInt(Dictionary[o][1]);
            System.out.println(now);
        }
        
        }        
        String Result="";
        String Dict="";
        for(int u=0;u<20;u++)
        {
            if(CompressedData[u]==0)
            {
                
            }else
                Result += CompressedData[u] + "-";
        }
        CompressResult.setText(Result);        
        f.openFile();
        try {
            f.addRecord(Result);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LZWForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
            
    }//GEN-LAST:event_CompressButtonActionPerformed

    private void DataEnteredActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DataEnteredActionPerformed
            
    }//GEN-LAST:event_DataEnteredActionPerformed

    private void CompressResultAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_CompressResultAncestorAdded
        
    }//GEN-LAST:event_CompressResultAncestorAdded

    private void DecompressButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DecompressButtonActionPerformed
        String Dictionary [][];
        Dictionary = new String [100][2];        
        int z=0;
        String temp="";
        char tmp;
        //Diciotnary Intialization******************************
        for(int e=65;e<=90;e++)
        {
            
            tmp = (char)e;
            temp += tmp;
            Dictionary[z][0]=temp;
            Dictionary[z][1]=Integer.toString(e);
            z++;
            temp="";
        }
        for(int e=97;e<=122;e++)
        {
            tmp = (char)e;
            temp += tmp;
            Dictionary[z][0]=temp;
            Dictionary[z][1]=Integer.toString(e);
            z++;
            temp="";
        }
        //******************************************************
    }//GEN-LAST:event_DecompressButtonActionPerformed

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
            java.util.logging.Logger.getLogger(LZWForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LZWForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LZWForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LZWForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LZWForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CompressButton;
    private javax.swing.JLabel CompressResult;
    private javax.swing.JTextField DataEntered;
    private javax.swing.JButton DecompressButton;
    private javax.swing.JLabel DecompressResult;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
