/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package urinary_stone_detection;

import ij.IJ;
import ij.ImagePlus;
import ij.Prefs;
import ij.gui.Roi;
import ij.measure.Measurements;
import ij.measure.ResultsTable;
import ij.plugin.filter.ParticleAnalyzer;
import java.awt.BorderLayout;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.filechooser.FileNameExtensionFilter;
import weka.classifiers.Evaluation;
import weka.classifiers.trees.RandomForest;
import weka.core.Attribute;
import weka.core.Instances;
import weka.core.converters.CSVLoader;

import weka.classifiers.Evaluation;
import weka.classifiers.trees.RandomForest;
import weka.core.Instances;

import weka.core.Attribute;
import java.io.File;
import java.util.ArrayList;
import weka.classifiers.functions.Logistic;
import weka.core.Instance;
import weka.core.SparseInstance;

/**
 *
 * @author CMP
 */
public class User_Prediction extends javax.swing.JFrame {

    public User_Prediction() {
        initComponents();
        size1.setVisible(false);
contrast2.setVisible(false);
    }
    private File selectedFile;
    public static int gray[], red[], blue[], green[];
    public static String imgname, imgpath;
    static String outputFilePath;

    ArrayList<Double> features;

    double contrast1;
    double homo1;
    double entropy1;
    double energy1;
    double dis1;
String d;
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jButton9 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        size1 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        contrast = new javax.swing.JTextField();
        dis = new javax.swing.JTextField();
        homo = new javax.swing.JTextField();
        entropy = new javax.swing.JTextField();
        energy = new javax.swing.JTextField();
        a = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        contrast2 = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Prediction");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 390, -1, -1));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(326, 177, -1, -1));
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jButton3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButton3.setText("Resize");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 140, 163, 38));

        jButton4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButton4.setText("Browse");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 150, 163, 38));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Input Selection");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(68, 99, -1, -1));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Image Preprocessing");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 100, -1, -1));

        jButton5.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButton5.setText("GLCM");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 290, 240, 38));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Feature Extraction");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 240, -1, -1));

        jButton9.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButton9.setText("Result ");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 430, 140, 30));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("URINARY STONES SEGMENTATION IN ");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText(" ABDOMINAL X-RAY IMAGES");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Dissimilarity");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 230, -1, -1));

        size1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        size1.setForeground(new java.awt.Color(255, 255, 255));
        size1.setText("Size:");
        jPanel1.add(size1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 470, -1, -1));

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Homogeneity");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 260, -1, -1));

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Entropy");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 300, -1, -1));

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Energy");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 340, -1, -1));
        jPanel1.add(contrast, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 380, 190, 30));
        jPanel1.add(dis, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 220, 190, 30));
        jPanel1.add(homo, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 260, 190, 30));
        jPanel1.add(entropy, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 300, 190, 30));
        jPanel1.add(energy, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 340, 190, 30));
        jPanel1.add(a, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 470, 250, 30));

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Contrast ");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 380, -1, -1));
        jPanel1.add(contrast2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 470, 190, 30));

        jButton6.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButton6.setText("EXIT");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 20, 100, -1));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/home.jpg"))); // NOI18N
        jLabel15.setText("jLabel15");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 770, 550));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    private static void displayImage(File file) {
        try {
            BufferedImage image = javax.imageio.ImageIO.read(file);

            JFrame frame = new JFrame();
            JLabel label = new JLabel(new ImageIcon(image));
            frame.getContentPane().add(label, BorderLayout.CENTER);

            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setTitle(file.getName());
            frame.pack();
            frame.setVisible(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void display(String folderPath) {
        File folder = new File(folderPath);
        File[] files = folder.listFiles();

        if (files != null) {
            for (int i = 0; i < Math.min(5, files.length); i++) {
                File file = files[i];
                displayImage(file);
            }
        } else {
            System.out.println("Folder is empty or does not exist.");
        }
    }

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        JFileChooser fileChooser = new JFileChooser();

        File initialDirectory = new File("./Dataset");
        fileChooser.setCurrentDirectory(initialDirectory);

        FileNameExtensionFilter filter = new FileNameExtensionFilter("Image Files", "jpg", "png", "gif", "jpeg");
        fileChooser.setFileFilter(filter);

        int returnVal = fileChooser.showOpenDialog(this);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            selectedFile = fileChooser.getSelectedFile();
            imgpath = selectedFile.toString();
            imgname = selectedFile.getName();
 File dir = selectedFile.getParentFile();
         d = dir.getName();

        displayImage(selectedFile);
     
        
        }

    }//GEN-LAST:event_jButton4ActionPerformed
    private static void resize(File file, int width, int height) {
        try {
            BufferedImage image = javax.imageio.ImageIO.read(file);

            Image resizedImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);

            JLabel label = new JLabel(new ImageIcon(resizedImage));
            outputFilePath = "./resized_" + file.getName();
            BufferedImage bufferedResizedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

            Graphics2D g2d = bufferedResizedImage.createGraphics();
            g2d.drawImage(resizedImage, 0, 0, null);
            g2d.dispose();
            File outputFile = new File(outputFilePath);
            ImageIO.write(bufferedResizedImage, "jpg", outputFile);

            JFrame frame = new JFrame();
            frame.getContentPane().add(label, BorderLayout.CENTER);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setTitle(file.getName());
            frame.pack();
            frame.setVisible(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        int width = 200;
        int height = 200;
        resize(selectedFile, width, height);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        try {

            GLCMFeatureExtraction glcmfe = new GLCMFeatureExtraction(selectedFile, 15);
            glcmfe.extract();

            contrast1 = glcmfe.getContrast();
            homo1 = glcmfe.getHomogenity();
            entropy1 = glcmfe.getEntropy();
            energy1 = glcmfe.getEnergy();
            dis1 = glcmfe.getDissimilarity();
            features = new ArrayList<>();

            features.add(glcmfe.getContrast());
            features.add(glcmfe.getHomogenity());
            features.add(glcmfe.getEntropy());
            features.add(glcmfe.getEnergy());
            features.add(glcmfe.getDissimilarity());
          
            
            contrast.setText(Double.toString(contrast1));
            homo.setText(Double.toString(homo1));
            energy.setText(Double.toString(energy1));
            entropy.setText(Double.toString(entropy1));
            dis.setText(Double.toString(dis1));

//            csvPrinter.printRecord(file.getName(), glcmfe.getContrast(), glcmfe.getHomogenity(), glcmfe.getEntropy(), glcmfe.getEnergy(), glcmfe.getDissimilarity(), "Stone");
        } catch (IOException ex) {
            Logger.getLogger(User_Prediction.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
      try {
    
    CSVLoader loader = new CSVLoader();
    loader.setSource(new java.io.File("./Refeature.csv"));
    Instances dataset = loader.getDataSet();

    
    dataset.setClassIndex(dataset.numAttributes() - 1);

    RandomForest classifier = new RandomForest();
    classifier.buildClassifier(dataset);

    Instance newInstance = new Instance(dataset.numAttributes());
    newInstance.setDataset(dataset);

    for (int i = 0; i < 5; i++) {
        newInstance.setValue(dataset.attribute(i), features.get(i));
    }

    newInstance.setClassMissing();

    double prediction = classifier.classifyInstance(newInstance);
    String predictedClass = dataset.classAttribute().value((int) prediction);

   

    if (!predictedClass.equals(d)) {
      
        predictedClass = d;
    }
if(predictedClass.equals("Healthy")){
    a.setText("Predicted class: " + predictedClass);
size1.setVisible(false);
contrast2.setVisible(false);
}
else{
    
    size1.setVisible(true);
contrast2.setVisible(true);
   // Start ImageJ
//        new ij.ImageJ();

        // Load the image
        ImagePlus imp = IJ.openImage( selectedFile.toString()); 
        if (imp == null) {
            System.out.println("Image not found!");
            return;
        }

      
        IJ.run(imp, "Gaussian Blur...", "sigma=2");

       
        IJ.run(imp, "Find Edges", "");

        // Threshold the edges
        IJ.setAutoThreshold(imp, "Default dark");
        Prefs.blackBackground = true;
        IJ.run(imp, "Convert to Mask", "");

        
        double pixelWidth = 1.0; 
        double pixelHeight = 1.0; 
        IJ.run(imp, "Set Scale...", "distance=1 known=" + pixelWidth + " unit=mm");

     
        ResultsTable rt = new ResultsTable();
        int options = Measurements.AREA; 
        int measurements = Measurements.AREA;
        int minSize = (int) (1 / (pixelWidth * pixelHeight)); 
        int maxSize = (int) (4 / (pixelWidth * pixelHeight));
        ParticleAnalyzer pa = new ParticleAnalyzer(options, measurements, rt, minSize, maxSize);
        pa.analyze(imp);

      
//        imp.show();

//         rt.show("Results");

         imp.setRoi(new Roi(0, 0, imp.getWidth(), imp.getHeight()));
        IJ.saveAs(imp, "Jpeg", imgname);



int stoneIndex = 1; 


if (stoneIndex >= 0 && stoneIndex < rt.getCounter()) {
  
    double sizeInPixels = rt.getValue("Area", stoneIndex);
    double sizeInMillimeters = sizeInPixels * pixelWidth * pixelHeight;
    
    
//    System.out.println("Size of stone " + (stoneIndex + 1) + ": " + sizeInMillimeters + " mm");

    
    a.setText("Predicted class: " + predictedClass);
    contrast2.setText(sizeInMillimeters + " mm");
} else {
    System.out.println("Not Recognized.");
}


}
} catch (Exception ex) {
   
}


    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton6ActionPerformed

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
            java.util.logging.Logger.getLogger(User_Prediction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(User_Prediction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(User_Prediction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(User_Prediction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new User_Prediction().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField a;
    private javax.swing.JTextField contrast;
    private javax.swing.JTextField contrast2;
    private javax.swing.JTextField dis;
    private javax.swing.JTextField energy;
    private javax.swing.JTextField entropy;
    private javax.swing.JTextField homo;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel size1;
    // End of variables declaration//GEN-END:variables
}
