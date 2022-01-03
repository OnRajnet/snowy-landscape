package cz.uhk.rajneon1;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.glu.GLU;
import cz.uhk.rajneon1.model.Snowflake;
import cz.uhk.rajneon1.model.Surface;
import cz.uhk.rajneon1.model.landscape.Landscape;
import cz.uhk.rajneon1.model.landscape.Snowstorm;
import cz.uhk.rajneon1.model.landscape_components.LandscapeComponent;

import java.awt.event.*;

/**
 * Created by Intel on 16.04.2018.
 */
public class MyRenderer implements GLEventListener, MouseListener, MouseMotionListener, MouseWheelListener, KeyListener {

    private float landscapeWidth = 500;
    private float landscapeHeight = 500;

    private int w, h, dx, dy, ox, oy;
    private float zoom = 0f;
    private float m[] = new float[16];

    private GL2 gl;
    private GLU glu;

    private Landscape landscape = new Landscape(landscapeWidth, landscapeHeight);
    private Snowstorm snowstorm = new Snowstorm(landscapeWidth, landscapeHeight);

    public MyRenderer(int w, int h) {
        this.w = w;
        this.h = h;
    }

    @Override
    public void init(GLAutoDrawable drawable) {
        gl = drawable.getGL().getGL2();
        glu = new GLU();

        gl.glEnable(GL2.GL_DEPTH_TEST);
        gl.glPolygonMode(GL2.GL_FRONT_AND_BACK, GL2.GL_FILL);
        gl.glDisable(GL2.GL_LIGHTING);
        gl.glMatrixMode(GL2.GL_MODELVIEW);
        gl.glLoadIdentity();

        gl.glLoadIdentity();
        gl.glGetFloatv(GL2.GL_MODELVIEW_MATRIX, m, 0);
    }

    @Override
    public void dispose(GLAutoDrawable drawable) {

    }

    @Override
    public void display(GLAutoDrawable drawable) {
        gl = drawable.getGL().getGL2();

        gl.glClearColor(0f, 0f, 0f, 1f);
        gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT);
        gl.glMatrixMode(GL2.GL_MODELVIEW);

        gl.glLoadIdentity();
        gl.glRotatef(dx, 0, 0, 1);
        gl.glRotatef(dy, 0, 1, 0);
        gl.glScalef(1 + zoom, 1 + zoom, 1 + zoom);
        zoom = 0;
        gl.glMultMatrixf(m, 0);
        gl.glGetFloatv(GL2.GL_MODELVIEW_MATRIX, m, 0);
        dx = 0;
        dy = 0;

        gl.glMatrixMode(GL2.GL_PROJECTION);
        gl.glLoadIdentity();
        glu.gluPerspective(45f, w / (float) h, 0.1f, 1000.0f);

        glu.gluLookAt(100, 0, 20, 0, 0, 0, 0, 0, 1);

        snowstorm.getSnowflakes().forEach(snowflake -> {
//            gl.glPointSize(4);
            gl.glBegin(GL2.GL_POINTS);
            gl.glColor3f(1f, 1f, 1f);
            gl.glVertex3f(snowflake.getX(), snowflake.getY(), snowflake.getZ());
            gl.glEnd();
        });

        landscape.getComponents().forEach(landscapeComponent ->
                landscapeComponent.getSurfaces().forEach(surface -> {
                    gl.glBegin(GL2.GL_TRIANGLE_STRIP);
                    gl.glColor3f(surface.getR(), surface.getG(), surface.getB());
                    gl.glVertex3f(surface.getFirst().getX(), surface.getFirst().getY(), surface.getFirst().getZ());
                    gl.glVertex3f(surface.getSecond().getX(), surface.getSecond().getY(), surface.getSecond().getZ());
                    gl.glVertex3f(surface.getThird().getX(), surface.getThird().getY(), surface.getThird().getZ());
                    gl.glVertex3f(surface.getForth().getX(), surface.getForth().getY(), surface.getForth().getZ());
                    gl.glEnd();
                }));

        snowstorm.generateNewSnowflake();

        for (Snowflake snowflake : snowstorm.getSnowflakes()) {
            boolean falls = true;
            for (LandscapeComponent landscapeComponent : landscape.getComponents()) {
                for (Surface surface : landscapeComponent.getSurfaces()) {
                    if (surface.isColliding(snowflake)) falls = false;
                }
            }
            if (falls) snowflake.fall();
        }
    }

    @Override
    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        w = width;
        h = height;

        drawable.getGL().getGL2().glViewport(0, 0, width, height);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        ox = e.getX();
        oy = e.getY();
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        dx = e.getX() - ox;
        dy = e.getY() - oy;
        ox = e.getX();
        oy = e.getY();
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        if (e.getWheelRotation() > 0) {
            zoom -= 0.5;
        } else {
            zoom += 0.5;
        }
    }
}
