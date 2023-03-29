package conversor;

import java.awt.AWTEvent;
import java.awt.AWTException;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.HeadlessException;
import java.awt.Panel;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.ObjectOutputStream.PutField;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.event.MouseInputAdapter;
import javax.swing.event.MouseInputListener;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class GraficosAplicacion extends JFrame {

	private JPanel panel;
	private JLabel texto;
	private JButton buttonConversor;
	private ActionListener actionConversor;
	private double transformDouble;
	private JTextField inputValor;
	private JTextPane outputValor;
	private JComboBox listaTipoDeConversion;
	private JButton buttonMonedas;
	private JButton buttonTemperatura;
	private JButton buttonLongitud;
	private JButton buttonVelocidad;
	private JButton buttonMasa;
	private JButton buttonCodigoBinario;

	private ActionListener selectTipoDeConversion;
	private ActionListener selectConversion;
	private Operaciones claseConversion;
	private SolesADolares sD = new SolesADolares();
	private DolaresASoles dS = new DolaresASoles();
	private SolesAEuros sE = new SolesAEuros();
	private EurosASoles eS = new EurosASoles();
	private CelsiusAKelvin cK = new CelsiusAKelvin();
	private KelvinACelsius kC = new KelvinACelsius();
	private CelciusAFahrenheit cAF = new CelciusAFahrenheit();
	private FahrenheitACelcius fC = new FahrenheitACelcius();
	private KelvinAFahrenheit kF = new KelvinAFahrenheit();
	private FahrenheitAKelvin fK = new FahrenheitAKelvin();
	private TextoABinario sB = new TextoABinario();
	private BinarioATexto bT = new BinarioATexto();
	private DecimalABinario dB = new DecimalABinario();
	private BinarioADecimal bD = new BinarioADecimal();
	private SolesALibrasEsterlinas sLE = new SolesALibrasEsterlinas();
	private LibrasEsterlinasASoles lES = new LibrasEsterlinasASoles();
	private MetroSegundoAKilometroHora mSKH = new MetroSegundoAKilometroHora();
	private KilometroHoraAMetroSegundo kHMS = new KilometroHoraAMetroSegundo();
	private MetrosAKilometros mAK = new MetrosAKilometros();
	private KilometrosAMetros kM = new KilometrosAMetros();
	private MetrosACentimetros mC = new MetrosACentimetros();
	private CentimetrosAMetros cM = new CentimetrosAMetros();
	private KilometrosACentimetros kAC = new KilometrosACentimetros();
	private CentimetrosAKilometros cAK = new CentimetrosAKilometros();
	private SolesAYenJapones sYJ = new SolesAYenJapones();
	private KilogramoAgramos kAG = new KilogramoAgramos();
	private GramoAKilogramo gAK = new GramoAKilogramo();
	private KilogramoATonelada kAT = new KilogramoATonelada();
	private ToneladaAKilogramo tAK = new ToneladaAKilogramo();
	private GramoATonelada gAT = new GramoATonelada();
	private ToneladaAGramos tAG = new ToneladaAGramos();
	private Operaciones conversionMonedas[] = { sD, dS, sE, eS, sLE, lES, sYJ };
	private Operaciones conversionTemperatura[] = { cK, kC, cAF, fC, kF, fK };
	private Operaciones conversionLongitud[] = { mAK, kM, mC, cM, kAC, cAK };
	private Operaciones conversionVelocidad[] = { mSKH, kHMS };
	private Operaciones conversionMasa[] = { kAG, gAK, kAT, tAK, gAT, tAG };
	private Operaciones conversionStringABinario[] = { sB, bT, dB, bD };
	private JButton buttonExit;
	private JButton buttonMinimizar;
	private JComboBox<Operaciones> listaConversiones;
	private JComboBox<Operaciones> listaConversiones2;
	private JComboBox<Operaciones> listaConversiones3;
	private JComboBox<Operaciones> listaConversiones4;
	private JComboBox<Operaciones> listaConversiones5;
	private JComboBox<Operaciones> listaConversionBinario;
	private String selectConversionLista;
	private int clickCount;
	private int listaSeleccionada = 0;
	private JLabel labelBotones;
	private boolean colorBotones;
	private MouseListener buttonHover;
	private JLabel titleBar;
	private MouseInputAdapter titleBarAction;
	private int x, y;
	private JLabel infoBinario;
	private JLabel simbolo;
	private JScrollPane scroll1;
	private JScrollPane scroll2;

	public GraficosAplicacion() {

		setSize(600, 400);
		setLocationRelativeTo(null);
		setTitle("CONVERSOR");
		setUndecorated(true);
		panel();
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	public void panel() {

		panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		panel.setBackground(Color.WHITE);
		getContentPane().add(panel);
		titleBar();
		simbolo();
		inputValor();
		outputValor();
		labelBotones();
		buttons();
		notas();
		buttonMinimizar();
		buttonExit();

	}

	public void titleBar() {

		titleBar = new JLabel("          CONVERSIONES");
		titleBar.setForeground(new Color(0, 0, 90));
		titleBar.setFont(new Font("Courier", Font.BOLD, 12));
		titleBar.setBackground(Color.WHITE);
		titleBar.setBorder(BorderFactory.createMatteBorder(1, 1, 0, 0, Color.black));
		titleBar.setBounds(0, 0, 600, 30);
		titleBar.setOpaque(true);
		titleBar.addMouseMotionListener(titleBarAction());
		titleBar.addMouseListener(titleBarAction());
		panel.add(titleBar);
	}

	public void simbolo() {
		simbolo = new JLabel("=");
		simbolo.setFont(new Font("Courier", Font.BOLD, 40));
		simbolo.setHorizontalAlignment(SwingConstants.CENTER);
		simbolo.setBackground(new Color(0, 0, 0, 0));
		simbolo.setOpaque(true);
		// simbolo.setBorder(BorderFactory.createLineBorder(Color.black));
		simbolo.setBounds(327, 210, 90, 39);
		panel.add(simbolo);
	}

	public MouseInputListener titleBarAction() {
		titleBarAction = new MouseInputAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				super.mousePressed(e);
				x = e.getX();
				y = e.getY();
			}

			@Override
			public void mouseDragged(MouseEvent e) {
				super.mouseDragged(e);
				int x_2 = e.getXOnScreen();
				int y_2 = e.getYOnScreen();

				setLocation(x_2 - x, y_2 - y);
			}

		};

		return titleBarAction;
	}

	public void inputValor() {

		inputValor = new JTextField();
		inputValor.setHorizontalAlignment(SwingConstants.CENTER);
		inputValor.setFont(new Font("Courier", Font.BOLD, 17));
		inputValor.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 150, 250)));
		scroll1 = new JScrollPane(inputValor);
		scroll1.setBounds(212, 210, 115, 40);
		scroll1.setVerticalScrollBarPolicy(scroll1.VERTICAL_SCROLLBAR_NEVER);
		panel.add(scroll1);

	}

	public void labelBotones() {
		labelBotones = new JLabel();
		labelBotones.setBounds(0, 20, 170, 380);
		labelBotones.setBackground(new Color(0, 0, 50));
		labelBotones.setOpaque(true);
		labelBotones.setHorizontalAlignment(SwingConstants.CENTER);
		labelBotones.setBorder(BorderFactory.createMatteBorder(0, 1, 1, 0, Color.black));
		panel.add(labelBotones);
	}

	public void buttons() {

		listaConversiones = new JComboBox<Operaciones>(conversionMonedas);
		listaConversiones.setVisible(true);
		listaConversiones.setBounds(250, 60, 250, 45);
		listaConversiones.setFont(new Font("Courier", Font.BOLD, 17));
		// listaConversiones.setAlignmentX(-50);
		listaConversiones.setFocusable(false);
		listaConversiones.setBackground(Color.WHITE);
		listaConversiones.setForeground(new Color(0, 0, 90));
		// listaConversiones.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new
		// Color(0,0,0,0)));

		panel.add(listaConversiones);
		listaConversiones.addActionListener(selectConversion(listaConversiones, conversionMonedas));

		listaConversiones2 = new JComboBox<Operaciones>(conversionTemperatura);
		listaConversiones2.setVisible(false);
		listaConversiones2.setBounds(250, 60, 250, 45);
		listaConversiones2.setFont(new Font("Courier", Font.BOLD, 17));
		listaConversiones2.setFocusable(false);
		listaConversiones2.setBackground(Color.WHITE);
		listaConversiones2.setForeground(new Color(0, 0, 90));
		panel.add(listaConversiones2);
		listaConversiones2.addActionListener(selectConversion(listaConversiones2, conversionTemperatura));

		listaConversiones3 = new JComboBox<Operaciones>(conversionLongitud);
		listaConversiones3.setVisible(false);
		listaConversiones3.setBounds(250, 60, 250, 45);
		listaConversiones3.setFont(new Font("Courier", Font.BOLD, 17));
		listaConversiones3.setFocusable(false);
		listaConversiones3.setBackground(Color.WHITE);
		listaConversiones3.setForeground(new Color(0, 0, 90));
		panel.add(listaConversiones3);
		listaConversiones3.addActionListener(selectConversion(listaConversiones3, conversionLongitud));

		listaConversiones4 = new JComboBox<Operaciones>(conversionVelocidad);
		listaConversiones4.setVisible(false);
		listaConversiones4.setBounds(250, 60, 250, 45);
		listaConversiones4.setFont(new Font("Courier", Font.BOLD, 17));
		listaConversiones4.setFocusable(false);
		listaConversiones4.setBackground(Color.WHITE);
		listaConversiones4.setForeground(new Color(0, 0, 90));
		panel.add(listaConversiones4);
		listaConversiones4.addActionListener(selectConversion(listaConversiones4, conversionVelocidad));

		listaConversiones5 = new JComboBox<Operaciones>(conversionMasa);
		listaConversiones5.setVisible(false);
		listaConversiones5.setBounds(250, 60, 250, 45);
		listaConversiones5.setFont(new Font("Courier", Font.BOLD, 17));
		listaConversiones5.setFocusable(false);
		listaConversiones5.setBackground(Color.WHITE);
		listaConversiones5.setForeground(new Color(0, 0, 90));
		panel.add(listaConversiones5);
		listaConversiones5.addActionListener(selectConversion(listaConversiones5, conversionMasa));

		listaConversionBinario = new JComboBox<Operaciones>(conversionStringABinario);
		listaConversionBinario.setBounds(180, 60, 250, 35);
		listaConversionBinario.setFocusable(false);
		listaConversionBinario.setVisible(false);
		listaConversionBinario.setBackground(Color.WHITE);
		listaConversionBinario.setForeground(new Color(0, 0, 90));
		panel.add(listaConversionBinario);
		listaConversionBinario.addActionListener(selectConversion(listaConversionBinario, conversionStringABinario));

		buttonMonedas = new JButton("MONEDAS");
		buttonMonedas.setBounds(25, 30, 120, 35);
		buttonMonedas.setFocusable(false);
		buttonMonedas.setFocusPainted(false);
		buttonMonedas.setFont(new Font("Courier", Font.BOLD, 13));

		labelBotones.add(buttonMonedas);
		buttonMonedas.addActionListener(actionButtons());

		buttonTemperatura = new JButton("TEMPERATURA");
		buttonTemperatura.setFont(new Font("Courier", Font.BOLD, 11));
		buttonTemperatura.setBounds(25, 90, 120, 35);
		labelBotones.add(buttonTemperatura);
		buttonTemperatura.addActionListener(actionButtons());

		buttonLongitud = new JButton("LONGITUD");
		buttonLongitud.setFont(new Font("Courier", Font.BOLD, 13));
		buttonLongitud.setBounds(25, 150, 120, 35);
		labelBotones.add(buttonLongitud);
		buttonLongitud.addActionListener(actionButtons());

		buttonVelocidad = new JButton("VELOCIDAD");
		buttonVelocidad.setFont(new Font("Courier", Font.BOLD, 13));
		buttonVelocidad.setBounds(25, 210, 120, 35);
		labelBotones.add(buttonVelocidad);
		buttonVelocidad.addActionListener(actionButtons());

		buttonMasa = new JButton("MASA");
		buttonMasa.setFont(new Font("Courier", Font.BOLD, 13));
		buttonMasa.setBounds(25, 270, 120, 35);
		labelBotones.add(buttonMasa);
		buttonMasa.addActionListener(actionButtons());

		buttonCodigoBinario = new JButton("BINARIO");
		buttonCodigoBinario.setBounds(25, 325, 120, 35);
		buttonCodigoBinario.setFont(new Font("Courier", Font.BOLD, 13));
		labelBotones.add(buttonCodigoBinario);
		buttonCodigoBinario.addActionListener(actionButtons());

		buttonConversor();
	}

	/*
	 * scroll1.setBounds(230, 210, 125, 40); scroll2.setBounds(390, 210, 125, 40);
	 */

	public ActionListener actionButtons() {

		ActionListener actionButtons = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (e.getActionCommand().equals("MONEDAS")) {
					simbolo.setVisible(true);
					scroll1.setBounds(212, 210, 115, 40);
					scroll2.setBounds(420, 210, 115, 40);
					listaConversiones.setSelectedIndex(0);
					listaConversiones2.setVisible(false);
					listaConversiones3.setVisible(false);
					listaConversiones4.setVisible(false);
					listaConversiones5.setVisible(false);
					listaConversionBinario.setVisible(false);
					listaConversiones.setVisible(true);
					// panel.remove(buttonConversor);
					buttonConversor.setBounds(300, 300, 150, 50);
				}

				if (e.getActionCommand().equals("TEMPERATURA")) {
					simbolo.setVisible(true);
					scroll1.setBounds(212, 210, 115, 40);
					scroll2.setBounds(420, 210, 115, 40);
					listaConversiones2.setSelectedIndex(0);
					listaConversiones.setVisible(false);
					listaConversiones3.setVisible(false);
					listaConversiones4.setVisible(false);
					listaConversiones5.setVisible(false);
					listaConversionBinario.setVisible(false);
					listaConversiones2.setVisible(true);
					// panel.remove(buttonConversor);
					buttonConversor.setBounds(300, 300, 150, 50);
				}

				if (e.getActionCommand().equals("LONGITUD")) {
					simbolo.setVisible(true);
					scroll1.setBounds(212, 210, 115, 40);
					scroll2.setBounds(420, 210, 115, 40);
					listaConversiones3.setSelectedIndex(0);
					listaConversiones.setVisible(false);
					listaConversiones4.setVisible(false);
					listaConversionBinario.setVisible(false);
					listaConversiones2.setVisible(false);
					listaConversiones5.setVisible(false);
					listaConversiones3.setVisible(true);
					// panel.remove(buttonConversor);
					buttonConversor.setBounds(300, 300, 150, 50);
				}

				if (e.getActionCommand().equals("VELOCIDAD")) {
					simbolo.setVisible(true);
					scroll1.setBounds(212, 210, 115, 40);
					scroll2.setBounds(420, 210, 115, 40);
					listaConversiones4.setSelectedIndex(0);
					listaConversiones.setVisible(false);
					listaConversiones3.setVisible(false);
					listaConversionBinario.setVisible(false);
					listaConversiones2.setVisible(false);
					listaConversiones5.setVisible(false);
					listaConversiones4.setVisible(true);
					// panel.remove(buttonConversor);
					buttonConversor.setBounds(300, 300, 150, 50);
				}

				if (e.getActionCommand().equals("MASA")) {
					simbolo.setVisible(true);
					scroll1.setBounds(212, 210, 115, 40);
					scroll2.setBounds(420, 210, 115, 40);
					listaConversiones5.setSelectedIndex(0);
					listaConversiones5.setVisible(true);
					listaConversiones.setVisible(false);
					listaConversiones3.setVisible(false);
					listaConversionBinario.setVisible(false);
					listaConversiones2.setVisible(false);
					listaConversiones4.setVisible(false);
					// panel.remove(buttonConversor);
					buttonConversor.setBounds(300, 300, 150, 50);
				}

				if (e.getActionCommand().equals("BINARIO")) {
					simbolo.setVisible(false);
					scroll2.setBounds(180, 100, 390, 120);
					scroll1.setBounds(180, 250, 390, 40);
					inputValor.setText("");
					outputValor.setText("");
					listaConversionBinario.setSelectedIndex(0);
					listaConversiones4.setVisible(false);
					listaConversiones3.setVisible(false);
					listaConversiones.setVisible(false);
					listaConversiones5.setVisible(false);
					listaConversiones2.setVisible(false);
					listaConversionBinario.setVisible(true);
					// buttonCodigoBinario.setBackground(Color.CYAN);
					// panel.remove(buttonConversor);
					buttonConversor.setBounds(325, 300, 100, 30);
					infoBinario.setText("LOS ESPACIOS TAMBIEN SERAN TRADUCIDOS COMO (00100000)");
					infoBinario.setVisible(true);
				}

				selectConversionLista = e.getActionCommand();

				infoBinario.setText("LOS ESPACIOS TAMBIEN SERAN TRADUCIDOS COMO (00100000)");
				infoBinario.setVisible(selectConversionLista == "BINARIO" ? true : false);

				System.out.println(e.getActionCommand());
			}
		};

		return actionButtons;
	}

	public ActionListener selectConversion(JComboBox<Operaciones> lista, Operaciones arrayOperaciones[]) {

		selectConversion = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				claseConversion = arrayOperaciones[lista.getSelectedIndex()];
				listaSeleccionada = lista.getSelectedIndex();
				System.out.println(lista.getSelectedIndex() + "Hola");

				if (selectConversionLista == "BINARIO") {
					inputValor.setText("");
					outputValor.setText("");

					if (listaSeleccionada == 0) {
						infoBinario.setText("LOS ESPACIOS (' ') TAMBIEN SERAN TRADUCIDOS COMO (00100000)");

					}

					if (listaSeleccionada == 1) {
						infoBinario.setText("");

					}
					if (listaSeleccionada == 2) {
						infoBinario.setText("");

					}

				}

			}

		};
		return selectConversion;
	}

	public void outputValor() {

		outputValor = new JTextPane();
		outputValor.setEditable(false);
		StyledDocument documentStyle = outputValor.getStyledDocument();
		SimpleAttributeSet centerAttribute = new SimpleAttributeSet();
		StyleConstants.setAlignment(centerAttribute, StyleConstants.ALIGN_CENTER);
		documentStyle.setParagraphAttributes(0, documentStyle.getLength(), centerAttribute, false);
		outputValor.setOpaque(true);
		outputValor.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 150, 250)));
		outputValor.setFont(new Font("Courier", Font.BOLD, 14));
		scroll2 = new JScrollPane(outputValor);
		scroll2.setBounds(420, 210, 115, 40);
		panel.add(scroll2);
	}

	public void buttonConversor() {

		buttonConversor = new JButton("CONVERTIR");
		buttonConversor.addActionListener(actionButtonConversor());
		buttonConversor.setBounds(300, 300, 150, 50);
		buttonConversor.setOpaque(false);
		buttonConversor.setContentAreaFilled(false);
		panel.add(buttonConversor);

	}

	public ActionListener actionButtonConversor() {

		actionConversor = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				try {

					if (selectConversionLista.equals("MONEDAS") || selectConversionLista.equals("TEMPERATURA")
							|| selectConversionLista.equals("VELOCIDAD") || selectConversionLista.equals("LONGITUD")
							|| selectConversionLista.equals("MASA")) {
						outputValor.setText(null);
						transformDouble = Double.parseDouble(inputValor.getText());
						claseConversion.setValor(transformDouble);
						outputValor.setText(claseConversion.conversion());
					}

					if (selectConversionLista.equals("BINARIO")) {

						if (listaSeleccionada == 0) {
							claseConversion.setValor(inputValor.getText());
							outputValor.setText(claseConversion.conversion());
							clickCount++;

							if (clickCount == 1) {
								sB.deleteString();
								clickCount--;
							}
						}

						if (listaSeleccionada == 1) {
							claseConversion.setValor(inputValor.getText());
							outputValor.setText(claseConversion.conversion());
							clickCount++;

							if (clickCount == 1) {
								bT.deleteString2();
								clickCount--;
							}
						}

						if (listaSeleccionada == 2) {
							claseConversion.setValor(inputValor.getText());
							outputValor.setText(claseConversion.conversion());
							clickCount++;

							if (clickCount == 1) {
								dB.deleteString3();
								clickCount--;
							}
						}

						if (listaSeleccionada == 3) {
							BinarioADecimal bD2 = new BinarioADecimal();
							bD2.setValor(inputValor.getText());
							outputValor.setText(bD2.conversion());
							clickCount++;

							if (clickCount == 1) {
								bD2.deleteString4();
								clickCount--;
							}
						}

					}
				} catch (NullPointerException ne) {
					try {
						outputValor.setText(null);
						transformDouble = Double.parseDouble(inputValor.getText());
						conversionMonedas[listaSeleccionada].setValor(transformDouble);
						outputValor.setText(conversionMonedas[listaSeleccionada].conversion());
					} catch (NumberFormatException nfe) {
						JOptionPane.showMessageDialog(null, "NO INGRESASTE NINGUN VALOR");
					}
				} catch (NumberFormatException nfe) {
					JOptionPane.showMessageDialog(null, "NO INGRESASTE NINGUN VALOR");
				}

			}
		};

		return actionConversor;
	}

	public void buttonMinimizar() {

		buttonMinimizar = new JButton("─");
		buttonMinimizar.setBounds(500, 0, 50, 30);
		buttonMinimizar.setBorderPainted(false);
		buttonMinimizar.setFocusable(false);
		buttonMinimizar.setFont(new Font("Courier", Font.BOLD, 28));
		buttonMinimizar.setHorizontalAlignment(SwingConstants.CENTER);
		buttonMinimizar.setOpaque(false);
		buttonMinimizar.setContentAreaFilled(false);
		titleBar.add(buttonMinimizar);
		buttonMinimizar.addActionListener(actionMinimizarAndExit());

	}

	public void buttonExit() {

		buttonExit = new JButton("×");
		buttonExit.setBounds(550, 0, 50, 30);
		buttonExit.setFocusable(false);
		buttonExit.setFont(new Font("Courier", Font.BOLD, 30));
		buttonExit.setHorizontalAlignment(SwingConstants.CENTER);
		buttonExit.setOpaque(false);
		buttonExit.setContentAreaFilled(false);
		buttonExit.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 1, Color.black));
		titleBar.add(buttonExit);
		buttonExit.addActionListener(actionMinimizarAndExit());

	}

	public ActionListener actionMinimizarAndExit() {

		ActionListener actionExit = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (e.getActionCommand() == "─") {

					setExtendedState(1);
				}
				if (e.getActionCommand() == "×") {

					System.exit(0);
				}

			}
		};
		return actionExit;
	}

	public void notas() {
		infoBinario = new JLabel();
		infoBinario.setForeground(new Color(70, 0, 0));
		infoBinario.setFont(new Font("Courier", Font.BOLD, 10));
		infoBinario.setBounds(180, 225, 390, 20);
		infoBinario.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(infoBinario);
		infoBinario.setVisible(false);

	}

}

