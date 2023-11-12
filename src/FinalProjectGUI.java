import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FinalProjectGUI extends JFrame implements ActionListener {
    private FinalProject tree;
    private JLabel kataLabel, terjemahanLabel, cariLabel, hasilLabel, imageLabel;
    private JTextField kataField, terjemahanField, cariField;
    private JButton addButton, cariButton, exitButton, clearButton;
    private JTextArea hasilArea;

    public FinalProjectGUI() {
        
        // create components
        kataLabel = new JLabel("Kata:");
        terjemahanLabel = new JLabel("Terjemahan:");
        cariLabel = new JLabel("Cari Kata:");
        hasilLabel = new JLabel("Hasil:");

        kataField = new JTextField(20);
        terjemahanField = new JTextField(20);
        cariField = new JTextField(20);

        addButton = new JButton("Tambah");
        cariButton = new JButton("Cari");
        exitButton = new JButton("Keluar");
        clearButton = new JButton("Clear");

        hasilArea = new JTextArea(10, 20);
        hasilArea.setEditable(false);
        hasilArea.setLineWrap(true);
        hasilArea.setWrapStyleWord(true);

        // set layout
        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        gc.gridx = 0;
        gc.gridy = 0;
        gc.insets = new Insets(5, 5, 5, 5);
        gc.anchor = GridBagConstraints.WEST;
        

        // add components
        add(kataLabel, gc);
        gc.gridx++;
        add(kataField, gc);
        gc.gridx = 0;
        gc.gridy++;
        add(terjemahanLabel, gc);
        gc.gridx++;
        add(terjemahanField, gc);
        gc.gridx = 0;
        gc.gridy++;
        add(addButton, gc);
        gc.gridx = 0;
        gc.gridy++;
        add(cariLabel, gc);
        gc.gridx++;
        add(cariField, gc);
        gc.gridx = 0;
        gc.gridy++;
        add(cariButton, gc);
        gc.gridx = 0;
        gc.gridy++;
        add(hasilLabel, gc);
        gc.gridx++;
        add(hasilArea, gc);
        gc.gridx = 0;
        gc.gridy++;
        add(exitButton, gc);
        gc.gridx++;
        add(clearButton, gc);


        // add action listener
        addButton.addActionListener(this);
        cariButton.addActionListener(this);
        exitButton.addActionListener(this);
        clearButton.addActionListener(this);
        
        // create FinalProject object
        tree = new FinalProject();
        tree.add("random", "acak");
        tree.add("school", "sekolah");
        tree.add("hallo", "halo");
        tree.add("morning", "pagi");
        tree.add("break", "berhenti sejenak");
        tree.add("eat", "Makan");
        tree.add("close", "tutup");
        tree.add("makanan", "eat");
        
        setTitle("Kamus");         // membuat judul
        setResizable(false);   //membuat window tdk dapat diperbesar/perkecil
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);


    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            String kata = kataField.getText();
            String terjemahan = terjemahanField.getText();
            boolean result = tree.add(kata, terjemahan);
            if (result) {
                JOptionPane.showMessageDialog(this, "Kata berhasil ditambahkan");
            } else {
                JOptionPane.showMessageDialog(this, "Kata dan terjemahannya sudah ada");
            }
        } else if (e.getSource() == cariButton) {
            String kata = cariField.getText();
            String result = tree.isExist(kata);
            if (result != null) {
                if (kata.equals("random")) {
                    hasilArea.setText("Ini adalah angka random = " + result);
                }else if(kata.equals("eat")){
                    hasilArea.setText(result);
                }else if(kata.equals("close")){
                    System.exit(0);
                } else {
                    hasilArea.setText("Terjemahan dari kata " + kata + " adalah " + result);
                }
                if(kata.equals("makanan") ){
                    ImageIcon imageIcon = new ImageIcon("makanan.jpeg");
                    imageLabel = new JLabel(imageIcon);
                    hasilArea.setLayout(new BorderLayout());
                    hasilArea.add(imageLabel, BorderLayout.CENTER);
                    hasilArea.setText(" ");
                    imageLabel.setIcon(imageIcon);
                }
            } else {
                hasilArea.setText("Terjemahan dari kata " + kata + " tidak ditemukan");
            }
        } else if (e.getSource() == exitButton) {
            System.exit(0);
        }else if (e.getSource()== clearButton){
            kataField.setText("");
            terjemahanField.setText("");
            cariField.setText("");
            hasilArea.setText("");
            imageLabel.setIcon(null);
        }
    }


    public static void main(String[] args) {
        new FinalProjectGUI();
    }
}

