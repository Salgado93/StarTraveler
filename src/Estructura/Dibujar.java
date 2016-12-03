/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructura;


import edu.uci.ics.jung.algorithms.layout.CircleLayout;
import edu.uci.ics.jung.graph.DirectedSparseGraph;
import edu.uci.ics.jung.visualization.VisualizationImageServer;
import edu.uci.ics.jung.visualization.VisualizationViewer;
import java.awt.Dimension;
import javax.swing.JFrame;
import org.apache.commons.collections15.Transformer;

/**()
 *
 * @author daniel
 */
public class Dibujar {
    Grafo grafo = new Grafo();
    private DirectedSparseGraph dibujo = new DirectedSparseGraph();    
    
    public Dibujar() {  
    }
    
    public void dibujarGrafo(Grafo grafo) {
        for (int i = 0; i < grafo.getVertices().size(); i++) {
            dibujo.addVertex(grafo.getVertices().get(i).getValor());
        }
        for (int i = 0; i < grafo.getAristas().size(); i++) {
            Arista a = (Arista)grafo.getAristas().get(i).getValor();
            dibujo.addEdge(a.getPesoString(), a.getPuntoA(),a.getPuntoB());
        }
        
        VisualizationViewer<String, String> vv =
            new VisualizationViewer<String, String>(new CircleLayout<String, String>(dibujo),
            new Dimension(400, 400));
        //Agrega el peso al label de la arista.
        vv.getRenderContext().setEdgeLabelTransformer(new Transformer<String, String>() {
        @Override
        public String transform(String arg0) {
            return arg0;
        }
        });
        
        
        JFrame ventanaGrafo = new JFrame();
        ventanaGrafo.getContentPane().add(vv);
        ventanaGrafo.pack();
                    
        ventanaGrafo.pack();
        ventanaGrafo.setAlwaysOnTop(true);
        ventanaGrafo.setVisible(true);
    }
    
    
}
