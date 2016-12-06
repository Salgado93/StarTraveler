/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructura;


import edu.uci.ics.jung.algorithms.layout.CircleLayout;
import edu.uci.ics.jung.graph.DirectedSparseGraph;
import edu.uci.ics.jung.visualization.VisualizationViewer;
import edu.uci.ics.jung.visualization.control.DefaultModalGraphMouse;
import edu.uci.ics.jung.visualization.control.ModalGraphMouse;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Paint;
import javax.swing.JFrame;
import org.apache.commons.collections15.Transformer;

/**()
 *
 * @author daniel
 */
public class Dibujar {
    Grafo grafo = new Grafo();
    private DirectedSparseGraph<String, String> dibujo = new DirectedSparseGraph<String, String>();
    
    public Dibujar() {  
    }
    
    public void dibujarGrafo(Grafo grafo) {
        for (int i = 0; i < grafo.getVertices().size(); i++) {
            Estrella e = (Estrella)grafo.getVertices().get(i).getValor();
            dibujo.addVertex(e.toString());
        }
        for (int i = 0; i < grafo.getAristas().size(); i++) {
            Arista a = (Arista)grafo.getAristas().get(i).getValor();
            dibujo.addEdge(a.getPesoString(),a.getPuntoA().toString() , a.getPuntoB().toString());
        }
        
        VisualizationViewer<String, String> vv =
            new VisualizationViewer<String, String>(new CircleLayout<String, String>(dibujo),
            new Dimension(800, 600));
        
        //Agrega el peso al label de la arista.
        vv.getRenderContext().setEdgeLabelTransformer(new Transformer<String, String>() {
        @Override
        public String transform(String arg0) {
            return arg0;
        }
        });
        //Agrega el id al label del vertice.
        vv.getRenderContext().setVertexLabelTransformer(new Transformer<String, String>() {
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
    public void dibujarCamino(Grafo grafo) {
        for (int i = 0; i < grafo.getVertices().size(); i++) {
            Estrella e = (Estrella)grafo.getVertices().get(i).getValor();
            dibujo.addVertex(e.toString());
        }
        for (int i = 0; i < grafo.getAristas().size(); i++) {
            Arista a = (Arista)grafo.getAristas().get(i).getValor();
            dibujo.addEdge(a.getPesoString(),a.getPuntoA().toString() , a.getPuntoB().toString());
        }
        
        VisualizationViewer<String, String> vv =
            new VisualizationViewer<String, String>(new CircleLayout<String, String>(dibujo),
            new Dimension(800, 600));
        
        //Agrega el peso al label de la arista.
        vv.getRenderContext().setEdgeLabelTransformer(new Transformer<String, String>() {
        @Override
        public String transform(String arg0) {
            return arg0;
        }
        });
        //Agrega el id al label del vertice.
        vv.getRenderContext().setVertexLabelTransformer(new Transformer<String, String>() {
        @Override
        public String transform(String arg0) {
            return arg0;
        }
        });
        
        Transformer<String, Paint> edgePaint = new Transformer<String, Paint>() {
            public Paint transform(String s) {
                Color color = null;
                for (int i = 0; i < grafo.getAristas().size(); i++) {
                    if (s.equals(((Arista)grafo.getAristas().get(i).getValor()).getPesoString())) {
                        color = ((Arista)grafo.getAristas().get(i).getValor()).getColor();
                    }
                    else{
                        if (s.equals("0")) {
                            color = Color.BLUE;
                        }
                    }
                }
                return color;
            }
        };
        vv.getRenderContext().setEdgeDrawPaintTransformer(edgePaint);
        

        JFrame ventanaGrafo = new JFrame();
        ventanaGrafo.getContentPane().add(vv);
        ventanaGrafo.pack();
                    
        ventanaGrafo.pack();
        ventanaGrafo.setAlwaysOnTop(true);
        ventanaGrafo.setVisible(true);
    }
    
    
}
