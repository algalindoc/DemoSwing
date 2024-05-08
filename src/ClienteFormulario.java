import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClienteFormulario extends JFrame {
    private JTextField nameField;
    private JTextField addressField;
    private JTextField emailField;
    private JPanel formPanel;
    private JLabel successLabel;

    public ClienteFormulario() {

        // Configuración inicial de la ventana
        setTitle("Creación de un cliente");
        setSize(600, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // Panel del formulario
        formPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        formPanel.add(new JLabel("Nombre"));
        nameField = new JTextField();
        formPanel.add(nameField);

        formPanel.add(new JLabel("Contraseña"));
        addressField = new JPasswordField();
        formPanel.add(addressField);

        formPanel.add(new JLabel("Email"));
        emailField = new JTextField();
        formPanel.add(emailField);

        add(formPanel, BorderLayout.CENTER);

        // Panel de botones
        JPanel buttonPanel = new JPanel();
        JButton createButton = new JButton("Create");
        createButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (nameField.getText().isEmpty() || addressField.getText().isEmpty()
                        || emailField.getText().isEmpty()) {
                    successLabel.setText("Por favor, rellene todos los campos");
                    successLabel.setForeground(Color.red);
                    return;
                } else {
                    successLabel.setText("Cliente " + nameField.getText() + " creado exitosamente!");
                    successLabel.setForeground(Color.blue);
                }
            }
        });
        buttonPanel.add(createButton);

        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        buttonPanel.add(cancelButton);

        add(buttonPanel, BorderLayout.SOUTH);

        // Etiqueta de éxito
        successLabel = new JLabel("", JLabel.CENTER);
        add(successLabel, BorderLayout.NORTH);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ClienteFormulario();
            }
        });
    }
}
