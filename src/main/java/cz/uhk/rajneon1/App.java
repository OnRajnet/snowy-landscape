package cz.uhk.rajneon1;

import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.util.FPSAnimator;

import javax.swing.*;

/**
 * Created by Intel on 16.04.2018.
 */
public class App {

    public static void main(String[] args) {
        new App().setup(1000, 1000);
    }

    public void setup(int w, int h) {

        GLProfile profile = GLProfile.get(GLProfile.GL2);
        GLCapabilities capabilities = new GLCapabilities(profile);
        GLCanvas canvas = new GLCanvas(capabilities);
        MyRenderer renderer = new MyRenderer(w, h);
        canvas.setSize(w, h);
        canvas.addGLEventListener(renderer);
        canvas.addMouseListener(renderer);
        canvas.addMouseMotionListener(renderer);
        canvas.addMouseWheelListener(renderer);
        canvas.addKeyListener(renderer);

        JFrame frame = new JFrame("Ondrej Rajnet - PGRF2 - Snowy landscape");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(w, h);
        frame.add(canvas);
        frame.setVisible(true);

        FPSAnimator animator = new FPSAnimator(canvas, 60, true);
        animator.start();

    }
}
