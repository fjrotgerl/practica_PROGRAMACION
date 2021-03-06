import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Kekko on 23/05/2017.
 */
public class Main {

    static JFrame frame = new JFrame();
    static JMenuBar jmb = new JMenuBar();

    static LoginForm lf = new LoginForm();
    static InicioForm iniF = new InicioForm();
    static AñadirTematicaForm atF = new AñadirTematicaForm();
    static AñadirSocioForm asf = new AñadirSocioForm();
    static BajaAltaSocioForm esF = new BajaAltaSocioForm();

    static DataBase db = new DataBase();

    public static void main(String[] args) throws Exception {
        JPanel panel = new JPanel();

        panel.setLayout(new CardLayout());
        panel.add(atF.getTematicaPanel(), "añadirTematicaPanel");
        panel.add(lf.getLoginPanel(), "loginPanel");
        panel.add(asf.getAñadirSociPanel(), "añadirSociPanel");
        panel.add(iniF.getInicioPanel(), "inicioPanel");
        panel.add(esF.getEliminarSocioPanel(), "eliminarSociPanel");

        // Em torna un objecte de tipus Layout
        // Hi ha que fer un cast a castLayout
        CardLayout cl = (CardLayout) panel.getLayout();
        cl.show(panel,"loginPanel");
        frame.setTitle("Login");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);
        frame.setContentPane(panel);
        centreWindow(frame);

    }

    // Cream la barra superior
    public static void initMenu(final JFrame frame) {
        frame.setJMenuBar(jmb);

        JMenu mLibros = new JMenu("Libros");
        jmb.add(mLibros);
        JMenuItem mLibroAñadir = new JMenuItem("Añadir un libro nuevo...");
        JMenuItem mLibroBorrar = new JMenuItem("Borrar un libro existente...");
        JMenuItem mLibroModificar = new JMenuItem("Modificar un libro existente...");
        JMenuItem mTematicaAñadir = new JMenuItem("Añadir una temática nueva...");
        mLibros.add(mLibroAñadir);
        mLibros.add(mLibroBorrar);
        mLibros.add(mLibroModificar);
        mLibros.addSeparator();
        mLibros.add(mTematicaAñadir);

        mTematicaAñadir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) Main.frame.getContentPane().getLayout();
                cl.show(Main.frame.getContentPane(),"añadirTematicaPanel");
                Main.configSimple(Main.frame,"Añadir temática");
            }
        });


        JMenu mSocios = new JMenu("Socios");
        jmb.add(mSocios);
        JMenuItem miSocioAñadir = new JMenuItem("Añadir un socio nuevo...");
        JMenuItem miSocioBajaAlta = new JMenuItem("Dar de baja/alta un socio existente...");
        JMenuItem miSocioModificar = new JMenuItem("Modificiar un socio existente...");
        mSocios.add(miSocioAñadir);
        mSocios.add(miSocioBajaAlta);
        mSocios.add(miSocioModificar);


        miSocioAñadir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) Main.frame.getContentPane().getLayout();
                cl.show(Main.frame.getContentPane(),"añadirSociPanel");
                Main.configSimple(Main.frame,"Añadir socio");

            }
        });

        miSocioBajaAlta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                esF.makeTable();
                CardLayout cl = (CardLayout) Main.frame.getContentPane().getLayout();
                cl.show(Main.frame.getContentPane(),"eliminarSociPanel");
                Main.configSimple(Main.frame,"Eliminar socio");

            }
        });

        JMenu mOpciones = new JMenu("Opciones");
        jmb.add(mOpciones);
        JMenuItem mOpcionCerrarSesion = new JMenuItem("Cerrar sesión");
        JMenuItem mOpcionCambiarUsuario = new JMenuItem("Cambiar de usuario");
        mOpciones.add(mOpcionCambiarUsuario);
        mOpciones.add(mOpcionCerrarSesion);

        jmb.setVisible(true);
    }

    // Centram la finestra
    public static void centreWindow(Window frame) {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
        frame.setLocation(x, y);
    }

    public static void configSimple(JFrame frame, String titol) {
        CardLayout cl = (CardLayout) frame.getContentPane().getLayout();
        frame.setTitle(titol);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    public static void cancelButton() {
        CardLayout cl = (CardLayout) frame.getContentPane().getLayout();
        cl.show(frame.getContentPane(),"inicioPanel");
        configSimple(frame,"Inicio");
    }
}
