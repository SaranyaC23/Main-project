package urinary_stone_detection;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.classifiers.bayes.NaiveBayes;
import weka.classifiers.functions.Logistic;
import weka.classifiers.functions.SMO;
import weka.classifiers.lazy.IBk;
import weka.classifiers.trees.J48;


import weka.core.Instances;
import weka.core.converters.CSVLoader;
import weka.core.Instances;
import weka.core.Instance;

import weka.classifiers.Evaluation;
import weka.classifiers.lazy.IBk;
import weka.core.converters.CSVLoader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import weka.classifiers.trees.RandomForest;
/**
import java.awt.MediaTracker;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author CMP
 */
public class Feature_Extraction extends javax.swing.JFrame {

    /**
     * Creates new form ImageSelection
     */
    public Feature_Extraction() {
        initComponents();
        File feature = new File("./Features.csv");
         File refeature = new File("./Refeature.csv");
if (feature.exists() && feature.delete()&& refeature.exists() && refeature.delete()) {
    System.out.println("Original file deleted successfully.");
} else {
    System.out.println("Failed to delete the original file.");
}
        
    }
    public String path = "./Dataset/";
    private File input;
    static String input_path = "./Input";
    public static String imgname, imgpath;

    String Stone_path = path + "Stone";
    String Preprocessed_HealthyPath = "./Preprocessed/Healthy";
    String Healthy_path = path + "Healthy";
    String Preprocessed_StonePath = "./Preprocessed/Stone";

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton3 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(326, 177, -1, -1));

        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jButton5.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButton5.setText("GLCM");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 110, 160, 30));

        jButton2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButton2.setText("Next");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 490, 120, 30));

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, 610, 300));

        jButton3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButton3.setText("Display");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 110, 120, 30));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("URINARY STONES SEGMENTATION IN ");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("FEATURE EXTRACTION");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, -1, -1));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText(" ABDOMINAL X-RAY IMAGES");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/home.jpg"))); // NOI18N
        jLabel6.setText("jLabel6");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 710, 550));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 716, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 549, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


   

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
try {
    BufferedWriter writer = new BufferedWriter(new FileWriter("./Features.csv", true)); 

    CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT.withHeader("Image Name", "Contrast", "Homogeneity", "Entropy", "Energy", "Dissimilarity", "Label"));
            
    File[] files = new File(Preprocessed_HealthyPath).listFiles();
    if (files != null) {
        for (File file : files) {
            if (file.isFile()) {
                GLCMFeatureExtraction glcmfe = new GLCMFeatureExtraction(file, 15);
                glcmfe.extract();
                csvPrinter.printRecord(file.getName(), glcmfe.getContrast(), glcmfe.getHomogenity(), glcmfe.getEntropy(), glcmfe.getEnergy(), glcmfe.getDissimilarity(), "Healthy");
            }
        }
    }

    File[] files1 = new File(Preprocessed_StonePath).listFiles();
    if (files1 != null) {
        for (File file : files1) {
            if (file.isFile()) {
                GLCMFeatureExtraction glcmfe = new GLCMFeatureExtraction(file, 15);
                glcmfe.extract();
                
                csvPrinter.printRecord(file.getName(), glcmfe.getContrast(), glcmfe.getHomogenity(), glcmfe.getEntropy(), glcmfe.getEnergy(), glcmfe.getDissimilarity(), "Stone");
           
            
            }
        }
    }

    csvPrinter.flush();
    csvPrinter.close();
    writer.close();
    JOptionPane.showMessageDialog(this, "Feature Extracted");
} catch (IOException ex) {
   System.out.println(ex);
} 
           try {
          
            String inputFilePath = "./Features.csv";
  
            String outputFilePath = "./Refeature.csv";

            
            CSVParser parser = new CSVParser(new FileReader(inputFilePath), CSVFormat.DEFAULT);
            List<CSVRecord> records = parser.getRecords();
            parser.close();

        
            List<List<String>> updatedRecords = new ArrayList<>();
            for (CSVRecord record : records) {
                List<String> updatedRecord = new ArrayList<>();
                for (int i = 1; i < record.size(); i++) {
                    updatedRecord.add(record.get(i));
                }
                updatedRecords.add(updatedRecord);
            }

           
            Collections.shuffle(updatedRecords);

        
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath));
            CSVPrinter printer = new CSVPrinter(writer, CSVFormat.DEFAULT);
            for (List<String> updatedRecord : updatedRecords) {
                printer.printRecord(updatedRecord);
            }
            printer.close();

            System.out.println("CSV processing completed successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
     

        
     /*   String url = "jdbc:mysql://localhost:3306/stone_detection";
        String user = "root";
        String password = "";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO glcm (filename, contrast, homogeneity, entropy, energy, dissimilarity, label) VALUES (?, ?, ?, ?, ?, ?, ?)");
             BufferedReader reader = new BufferedReader(new FileReader(csvFilePath));
             CSVParser csvParser = CSVFormat.DEFAULT.parse(reader)) {

            for (CSVRecord csvRecord : csvParser) {
                 String filename = csvRecord.get(0);
                String contrast = String.valueOf(csvRecord.get(1));
                String homogeneity = String.valueOf(csvRecord.get(2));
                String entropy = String.valueOf(csvRecord.get(3));
                String energy = String.valueOf(csvRecord.get(4));
                String dissimilarity = String.valueOf(csvRecord.get(5));
                String label = csvRecord.get(6);

              
                stmt.setString(1, filename);
                stmt.setString(2, contrast);
                stmt.setString(3, homogeneity);
                stmt.setString(4, entropy);
                stmt.setString(5, energy);
                stmt.setString(6, dissimilarity);
                stmt.setString(7, label);

              

                // Execute the INSERT statement
                stmt.executeUpdate();
            }

            System.out.println("Data inserted into the database successfully!");
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        
            */


    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
     
        new LR_Classification().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        
       BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader("./features.csv"));
            String line;
            while ((line = reader.readLine()) != null) {
                jTextArea1.append(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } 
      
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(Feature_Extraction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Feature_Extraction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Feature_Extraction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Feature_Extraction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Feature_Extraction().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
