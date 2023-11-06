import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FinalProjectGUI extends JFrame implements ActionListener {
    private JLabel kataLabel, terjemahanLabel, cariLabel, hasilLabel;
    private JTextField kataField, terjemahanField, cariField;
    private JButton addButton, cariButton, exitButton;
    private JTextArea hasilArea;
    private FinalProject tree;

    public FinalProjectGUI() {
        // set title
        setTitle("Kamus");

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

        hasilArea = new JTextArea(10, 20);
        hasilArea.setEditable(false);

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

        // add action listener
        addButton.addActionListener(this);
        cariButton.addActionListener(this);
        exitButton.addActionListener(this);

        // create FinalProject object
        tree = new FinalProject();
        tree.add("random", "acak");
        tree.add("school", "sekolah");
        tree.add("hallo", "halo");
        tree.add("morning", "pagi");
        tree.add("break", "berhenti sejenak");
        tree.add("eat", "Makan");

        // make JFrame not resizable
        // setResizable(false);
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
                } else {
                    hasilArea.setText("Terjemahan dari kata " + kata + " adalah " + result);
                }
            } else {
                hasilArea.setText("Terjemahan dari kata " + kata + " tidak ditemukan");
            }
        } else if (e.getSource() == exitButton) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        FinalProjectGUI gui = new FinalProjectGUI();
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.pack();
        gui.setVisible(true);
    }
}

