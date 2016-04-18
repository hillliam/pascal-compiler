package pascal;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.antlr.v4.gui.TreeViewer;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

/**
 *
 * @author liam
 */
public class treedispay {

    public static String inputFile = null;
    private ParseTree tree;
    private List<String> output;
    private TreeViewer a;
    private JTextField input2;
    /**
     * Creates new form treedispay
     */
    public treedispay() throws Exception {
        JFrame frame = new JFrame(inputFile + " Tree");
        JPanel panel = new JPanel();
        input2 = new JTextField();
        JButton go = new JButton("get subtree");
        input2.setVisible(true);

        panel.add(input2);
        panel.add(go);
        InputStream is = System.in;
        is = new FileInputStream(inputFile);

        ANTLRInputStream input = new ANTLRInputStream(is);

        pascalLexer lexer = new pascalLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        pascalParser parser = new pascalParser(tokens);

        tree = parser.program();
        System.out.println(tree.toStringTree(parser));
        output = Arrays.asList(parser.getRuleNames());
        System.out.println(output);
        a = new TreeViewer(output, tree);
        a.setVisible(true);
        a.setScale(1.0);
        a.setLocation(20, 0);
        panel.add(a);
        frame.add(panel);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(5000, 1500);
        frame.setVisible(true);
    }

    /**
     * @param args the command line arguments
     */
    public static void gui(String args[]) throws Exception {
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
            java.util.logging.Logger.getLogger(treedispay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(treedispay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(treedispay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(treedispay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        inputFile = args[0];
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new treedispay();
                } catch (Exception ex) {
                    Logger.getLogger(treedispay.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
