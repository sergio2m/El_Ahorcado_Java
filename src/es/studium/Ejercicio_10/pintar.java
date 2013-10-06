package es.studium.Ejercicio_10;

import java.awt.Color;
import java.awt.Graphics;

public class pintar
{
	public static void hacerLinea(Graphics g,int x1,int y1, int x2, int y2)
	{
		g.drawLine(x1, y1, x2, y2);
	}
	public static void hacerCirculo(Graphics g,int x1,int y1, int x2, int y2)
	{
		g.setColor (Color.red);
		g.fillOval(x1, y1, x2, y2);
	}
}

