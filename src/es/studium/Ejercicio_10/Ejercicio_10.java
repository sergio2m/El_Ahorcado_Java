package es.studium.Ejercicio_10;

import java.awt.Button;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Random;


public class Ejercicio_10 extends Frame implements ActionListener,WindowListener
{
	//declaracion de elementos
	MenuBar barra = new MenuBar();
	Menu archivo = new Menu ("Archivo");
	Menu separador1 = new Menu ("|");
	Menu ayuda = new Menu ("Ayuda");
	MenuItem archivoNueva = new MenuItem("Nueva partida");
	MenuItem archivoSalir = new MenuItem("Salir");
	MenuItem ayudaAcerca = new MenuItem("Acerca de...");
	Panel panelMenu = new Panel(new GridLayout(4,1));
	Panel panelImagen = new Panel(new FlowLayout());
	Panel menu1 = new Panel(new FlowLayout(FlowLayout.CENTER,10,30));
	Panel menu2 = new Panel(new FlowLayout(FlowLayout.LEFT));
	Panel menu3 = new Panel(new FlowLayout(FlowLayout.LEFT));
	Panel botonera = new Panel(new GridLayout(3,9,1,1));
	Button jugar = new Button ("JUGAR");
	Button resolver = new Button ("RESOLVER");
	Button a = new Button ("a");
	Button b = new Button ("b");
	Button c = new Button ("c");
	Button d = new Button ("d");
	Button e = new Button ("e");
	Button f = new Button ("f");
	Button g = new Button ("g");
	Button h = new Button ("h");
	Button i = new Button ("i");
	Button j = new Button ("j");
	Button k = new Button ("k");
	Button l = new Button ("l");
	Button m = new Button ("m");
	Button n = new Button ("n");
	Button ñ = new Button ("ñ");
	Button o = new Button ("o");
	Button p = new Button ("p");
	Button q = new Button ("q");
	Button r = new Button ("r");
	Button s = new Button ("s");
	Button t = new Button ("t");
	Button u = new Button ("u");
	Button v = new Button ("v");
	Button w = new Button ("w");
	Button x = new Button ("x");
	Button y = new Button ("y");
	Button z = new Button ("z");
	Label pOculta = new Label ("Palabra Oculta");
	Label errores = new Label ("Número de errores");
	Label pOcultaTxt = new Label ("                        ");
	Label erroresTxt = new Label ("-");
	Label mensaje = new Label ("Indicaciones");
	Label mensajeTxt = new Label ("                                                     ");
	Canvas lienzo = new Canvas();
	
	//generacion de aleatorio y palabra secreta
	Random rnd = new Random();
	int aleatorio;
	//palabras 
	String [] palabras = {"triturar","olimpico","hongo","collar","inflar","fracasar",
			"fotografia","nacional","pavo","real","antena","loro","arroyo","planeta",
			"tierra","miercoles","semana","tomate","hormiga","playa"};
	String palabraSecreta;
	//variables
	String aciertos="";
	String aciertos2="";
	int contadorError;//contador de errores acumulados
	int contadorOportunidades;//contador de opotunidades restantes
	int contadorGanar=0;//controla si el jugador gana la partida
	boolean control=true;//controla si hay error
		
	public Ejercicio_10()
	{
		setTitle("EL AHORCADO");//titulo del frame
		setVisible(true);//el frame esta visible
		setSize(550,300);//dimension del frame
		setResizable(false);//fijar el tamaño del frame antes indicado
		//agrego la barra de menu
		setMenuBar(barra);
		//agrego item 
		barra.add(archivo);
		barra.add(separador1);
		barra.add(ayuda);
		archivo.add(archivoNueva);
		archivo.add(archivoSalir);
		ayuda.add(ayudaAcerca);	
		//nueva distribucion de componentes en el frame
		setLayout (new GridLayout(1,2));		
		//agrego resto componentes
		add(panelMenu);
		add(panelImagen);
		panelMenu.add(menu1);
		panelMenu.add(menu2);
		panelMenu.add(menu3);
		panelMenu.add(botonera);
		menu1.add(jugar);
		jugar.setBackground(Color.green);
		menu1.add(resolver);
		menu2.add(pOculta);
		menu2.add(pOcultaTxt);
		menu2.add(errores);
		menu2.add(erroresTxt);
		menu3.add(mensaje);
		menu3.add(mensajeTxt);
		botonera.add(a);
		botonera.add(b);
		botonera.add(c);
		botonera.add(d);
		botonera.add(e);
		botonera.add(f);
		botonera.add(g);
		botonera.add(h);
		botonera.add(i);
		botonera.add(j);
		botonera.add(k);
		botonera.add(l);
		botonera.add(m);
		botonera.add(n);
		botonera.add(ñ);
		botonera.add(o);
		botonera.add(p);
		botonera.add(q);
		botonera.add(r);
		botonera.add(s);
		botonera.add(t);
		botonera.add(u);
		botonera.add(v);
		botonera.add(w);
		botonera.add(x);
		botonera.add(y);
		botonera.add(z);
		//listener
		addWindowListener(this);
		jugar.addActionListener(this);
		resolver.addActionListener(this);
		a.addActionListener(this);
		b.addActionListener(this);
		c.addActionListener(this);
		d.addActionListener(this);
		e.addActionListener(this);
		f.addActionListener(this);
		g.addActionListener(this);
		h.addActionListener(this);
		i.addActionListener(this);
		j.addActionListener(this);
		k.addActionListener(this);
		l.addActionListener(this);
		m.addActionListener(this);
		n.addActionListener(this);
		ñ.addActionListener(this);
		o.addActionListener(this);
		p.addActionListener(this);
		q.addActionListener(this);
		r.addActionListener(this);
		s.addActionListener(this);
		t.addActionListener(this);
		u.addActionListener(this);
		v.addActionListener(this);
		w.addActionListener(this);
		x.addActionListener(this);
		y.addActionListener(this);
		z.addActionListener(this);
		archivoNueva.addActionListener(this);
		archivoSalir.addActionListener(this);
		ayudaAcerca.addActionListener(this);
		
	}
	//metodo comprobar si existe la letra
	public void comprobacion(char letra)
	{
		aciertos2="";
		control=true;
		for (int i=0;i<(palabraSecreta.length());i++)
		{
			if (((palabraSecreta.charAt(i))==letra)&&(contadorError<10))
			{	
				aciertos2+=letra;
				control=false;
				mensajeTxt.setText("Congratulation, pulsa otra letra");
				contadorGanar--;
				if(contadorGanar==0)
				{
					mensajeTxt.setText("MUY BIEN, HAS GANADO");
					jugar.setEnabled(true);
					jugar.setBackground(Color.green);
				}
			}
			else
			{
				aciertos2+=aciertos.charAt(i);
			}
		}
		if(control==true)
		{
			if (contadorError<10)
			{
				contadorError++;
				contadorOportunidades--;
				mensajeTxt.setText("Error, quedan "+(contadorOportunidades)+" intentos");
				erroresTxt.setText(Integer.toString(contadorError));
				if (contadorError==1)
				{
					pintar.hacerLinea(lienzo.getGraphics(),155,200,205,200);
				}
				if (contadorError==2)
				{
					pintar.hacerLinea(lienzo.getGraphics(),180,200,180,25);
				}
				if (contadorError==3)
				{
					pintar.hacerLinea(lienzo.getGraphics(),180,25,110,25);
				}
				if (contadorError==4)
				{
					pintar.hacerLinea(lienzo.getGraphics(),110,25,110,60);
				}
				if (contadorError==5)
				{
					pintar.hacerCirculo(lienzo.getGraphics(),98,60,25,25);
				}
				if (contadorError==6)
				{
					pintar.hacerLinea(lienzo.getGraphics(),110,85,110,150);
				}
				if (contadorError==7)
				{
					pintar.hacerLinea(lienzo.getGraphics(),110,100,90,125);
				}
				if (contadorError==8)
				{
					pintar.hacerLinea(lienzo.getGraphics(),110,100,130,125);
				}
				if (contadorError==9)
				{
					pintar.hacerLinea(lienzo.getGraphics(),110,150,90,175);
				}
				if (contadorError==10)
				{
					pintar.hacerLinea(lienzo.getGraphics(),110,150,130,175);
					mensajeTxt.setText("¡Lo siento, has perdido!");
					resolver.setBackground(Color.yellow);
				}		
			}
		}
		aciertos=aciertos2;
		pOcultaTxt.setText(aciertos);
	}
	
	public static void main(String[] args)
	{
		new Ejercicio_10();
	}
	
	public void windowActivated(WindowEvent arg0) 
	{
	}
	public void windowClosed(WindowEvent arg0)
	{
	}
	public void windowClosing(WindowEvent wc) 
	{		
		System.exit(0);		
	}
	public void windowDeactivated(WindowEvent arg0)
	{
	}
	public void windowDeiconified(WindowEvent arg0)
	{
	}
	public void windowIconified(WindowEvent arg0) 
	{	
	}
	public void windowOpened(WindowEvent arg0)
	{
	}
	public void actionPerformed(ActionEvent ae) 
	{
		if("Salir".equals(ae.getActionCommand()))
		{
			System.exit(0);	
		}
		try
		{
			if(("JUGAR".equals(ae.getActionCommand()))||("Nueva partida".equals(ae.getActionCommand())))
			{
				a.setEnabled(true);
				b.setEnabled(true);
				c.setEnabled(true);
				d.setEnabled(true);
				e.setEnabled(true);
				f.setEnabled(true);
				g.setEnabled(true);
				h.setEnabled(true);
				i.setEnabled(true);
				j.setEnabled(true);
				k.setEnabled(true);
				l.setEnabled(true);
				m.setEnabled(true);
				n.setEnabled(true);
				ñ.setEnabled(true);
				o.setEnabled(true);
				p.setEnabled(true);
				q.setEnabled(true);
				r.setEnabled(true);
				s.setEnabled(true);
				t.setEnabled(true);
				u.setEnabled(true);
				v.setEnabled(true);
				w.setEnabled(true);
				x.setEnabled(true);
				y.setEnabled(true);
				z.setEnabled(true);
				aleatorio = (int)(rnd.nextDouble()*20);
				palabraSecreta=palabras[aleatorio];
				contadorError=0;
				contadorOportunidades=10;
				contadorGanar=palabraSecreta.length();
				aciertos="";
				aciertos2="";
				//System.out.println(palabraSecreta);
				for (int i=0;i<palabraSecreta.length();i++)
				{
					aciertos+="*";
				}
				pOcultaTxt.setText(aciertos);
				erroresTxt.setText(Integer.toString(contadorError));
				mensajeTxt.setText("Pulse una letra");
				jugar.setEnabled(false);
				jugar.setBackground(Color.red);
				control=false;
				panelImagen.add(lienzo);
				lienzo.setSize(230,230);
			}
			if("a".equals(ae.getActionCommand())||"b".equals(ae.getActionCommand())
			||"c".equals(ae.getActionCommand())||"d".equals(ae.getActionCommand())
			||"e".equals(ae.getActionCommand())||"f".equals(ae.getActionCommand())
			||"g".equals(ae.getActionCommand())||"h".equals(ae.getActionCommand())
			||"i".equals(ae.getActionCommand())||"j".equals(ae.getActionCommand())
			||"k".equals(ae.getActionCommand())||"l".equals(ae.getActionCommand())
			||"m".equals(ae.getActionCommand())||"n".equals(ae.getActionCommand())
			||"ñ".equals(ae.getActionCommand())||"o".equals(ae.getActionCommand())
			||"p".equals(ae.getActionCommand())||"q".equals(ae.getActionCommand())
			||"r".equals(ae.getActionCommand())||"s".equals(ae.getActionCommand())
			||"t".equals(ae.getActionCommand())||"u".equals(ae.getActionCommand())
			||"v".equals(ae.getActionCommand())||"w".equals(ae.getActionCommand())
			||"x".equals(ae.getActionCommand())||"y".equals(ae.getActionCommand())
			||"z".equals(ae.getActionCommand()))
			{
				comprobacion((ae.getActionCommand()).charAt(0));//llamada al metodo "comprobacion"
				((Component) ae.getSource()).setEnabled(false);
			}
			if("RESOLVER".equals(ae.getActionCommand()))
			{
				pOcultaTxt.setText(palabraSecreta);
				jugar.setBackground(Color.green);
				jugar.setEnabled(true);
				resolver.setBackground(Color.lightGray);
				aleatorio = 0;
				palabraSecreta="";
			}
		}
		catch (NullPointerException npe)
		{ 
			mensajeTxt.setText("Pulse JUGAR");
		}
	}
}







