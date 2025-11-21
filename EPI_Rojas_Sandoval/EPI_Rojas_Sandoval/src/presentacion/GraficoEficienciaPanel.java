
package presentacion;

import java.awt.*;
import java.util.*;
import javax.swing.JPanel;

public class GraficoEficienciaPanel extends JPanel {
    
    private final java.util.List<Double> datosCorriente; 
    private final java.util.List<Double> datosEficiencia; 

    public GraficoEficienciaPanel() {
        datosCorriente = new ArrayList<>();
        datosEficiencia = new ArrayList<>();
        setBackground(Color.WHITE); // Fondo blanco para claridad
    }

    public void añadirDato(double corriente, double eficiencia) {
        datosCorriente.add(corriente);
        datosEficiencia.add(eficiencia * 100.0); 
        repaint();
    }


    public void limpiar() {
        datosCorriente.clear();
        datosEficiencia.clear();
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int ancho = getWidth(), alto = getHeight(), margen = 40;
        int x0 = margen, y0 = alto - margen;
        int anchoG = ancho - 2 * margen, altoG = alto - 2 * margen;

        // Ejes X e Y
        g2.setColor(Color.BLACK);
        g2.drawLine(x0, y0, ancho - margen, y0); // Eje X horizontal
        g2.drawLine(x0, y0, x0, margen); // Eje Y vertical

        // Títulos de los ejes
        g2.setFont(new Font("Arial", Font.BOLD, 12));
        g2.drawString("Corriente (A)", x0 + anchoG / 2 - 40, alto - 10);
        
        // Eje Y (Eficiencia) - rotación
        g2.rotate(-Math.PI / 2);
        g2.drawString("Eficiencia (%)", -altoG / 2 - 20, 15);
        g2.rotate(Math.PI / 2);

        if (datosCorriente.isEmpty()) {
            g2.drawString("Ejecuta la simulación para generar el gráfico", x0 + 20, y0 / 2);
            return;
        }

        // Determinar límites máximos de los datos
        double maxC = Collections.max(datosCorriente) * 1.1;
        double maxE = Collections.max(datosEficiencia) * 1.1;
        if (maxC == 0) maxC = 1;
        if (maxE == 0) maxE = 1;

        // Dibujar puntos y líneas
        g2.setColor(Color.BLUE);
        g2.setStroke(new BasicStroke(2)); // Grosor de línea
        int px = -1, py = -1;

        for (int i = 0; i < datosCorriente.size(); i++) {
            // Normalizar datos a las dimensiones del panel
            int x = x0 + (int) ((datosCorriente.get(i) / maxC) * anchoG);
            int y = y0 - (int) ((datosEficiencia.get(i) / maxE) * altoG);

            // Dibujar punto
            g2.fillOval(x - 3, y - 3, 6, 6);

            // Dibujar línea (si hay punto anterior)
            if (px != -1) {
                g2.drawLine(px, py, x, y);
            }
            
            // Etiqueta del Eje Y
            if (i == datosCorriente.size() -1) {
                 g2.setColor(Color.DARK_GRAY);
                 g2.drawString(String.format("%.1f %%", datosEficiencia.get(i)), x + 5, y);
            }

            px = x;
            py = y;
        }
    }

}
