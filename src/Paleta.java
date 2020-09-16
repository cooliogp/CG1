import com.jogamp.opengl.*;
import com.jogamp.opengl.glu.GLU;


public class Paleta {
	
	// id from the palette shape inserted into the blueprint
    public int left_idn = 0;
    public int left_two_idn = 0;
    public int right_idn = 0;
    public int top_idn = 0;
    public int top_two_idn = 0;
    public int bottom_idn = 0;
    public int bottom_two_idn = 0;
    public int front_idn = 0;
    public int back_idn = 0;
    
    // color of the palette shape inserted into the blueprint - it will change when the user finished the game
    public float addShapeRed = 0.25f,
            addShapeGreen = 0.75f,
            addShapeBlue = 1f;


    public float defaultRed = 0f;
    public float defaultGreen = 0.5f;
    public float defaultBlue = 0.5f;

    public float redL = defaultRed;
    public float greenL = defaultGreen;
    public float blueL = defaultBlue;

    public float redLeftTwo = defaultRed;
    public float greenLeftTwo = defaultGreen;
    public float blueLeftTwo = defaultBlue;

    public float redT = defaultRed;
    public float greenT = defaultGreen;
    public float blueT = defaultBlue;

    public float redTopTwo = defaultRed;
    public float greenTopTwo = defaultGreen;
    public float blueTopTwo = defaultBlue;

    public float redB = defaultRed;
    public float greenB = defaultGreen;
    public float blueB = defaultBlue;

    public float redBottomTwo = defaultRed;
    public float greenBottomTwo = defaultGreen;
    public float blueBottomTwo = defaultBlue;

    public float redR = defaultRed;
    public float greenR = defaultGreen;
    public float blueR = defaultBlue;

    public float redF = defaultRed;
    public float greenF = defaultGreen;
    public float blueF = defaultBlue;

    public float redBack = defaultRed;
    public float greenBack = defaultGreen;
    public float blueBack = defaultBlue;
    
    // colors of the shapes on the palette
    public float paletteRed = 0.20f;
    public float paletteGreen = 0.75f;
    public float paletteBlue = 1f;
    
    public Paleta() {}
    
    public void palette(GLAutoDrawable drawable, int windowWidth, int windowHeight, float aspectP, GLU glu) {
        GL2 gl = drawable.getGL().getGL2();
        gl.glMatrixMode(GL2.GL_MODELVIEW);
        gl.glLoadIdentity();
        gl.glMatrixMode(GL2.GL_PROJECTION);
        gl.glLoadIdentity();

        gl.glViewport((int)(windowWidth / 1.3), 0, windowWidth / 4, windowHeight);

        aspectP = (float) windowHeight / ((float) windowWidth / 3);

        gl.glOrtho((float) -10 / 2, (float) 10 / 2,
                (-10 * aspectP) / 2,
                (10 * aspectP) / 2, 1, 11);

        gl.glMatrixMode(GL2.GL_MODELVIEW);

        paletteBackground(drawable);
        gl.glLoadIdentity();

        glu.gluLookAt(-1, 2, 5.0,
                0.0, 0.0, 0.0,
                0.0, 1.0, 0.0);


        gl.glPolygonMode(GL2.GL_FRONT_AND_BACK, GL2.GL_FILL);


        palettePentagonPyramid(drawable);
        paletteSphere(drawable);
        paletteCuboid(drawable);
        paletteCylinder(drawable);
        paletteCube(drawable);
        paletteTetrahedron(drawable);
        paletteCone(drawable);

        paletteRectangularPyramid(drawable);
        paletteHexagonPyramid(drawable);


    }
    
    public void paletteBackground(GLAutoDrawable drawable) {
        GL2 gl = drawable.getGL().getGL2();

        gl.glColor3f(0.5f, 0.6f, 1f);
        gl.glPolygonMode(GL2.GL_FRONT_AND_BACK, GL2.GL_LINE);
        gl.glPushMatrix();

        gl.glTranslated(-1.5f, 0.5f, -9);
        gl.glScalef(7f, 18, 0);

        Shapes.square(gl);


        //gl.glEnd();
        gl.glPopMatrix();
    }

    public void paletteSphere(GLAutoDrawable drawable) {
        GL2 gl = drawable.getGL().getGL2();
        gl.glColor3f(this.paletteRed, this.paletteGreen, this.paletteBlue);
        gl.glPolygonMode(GL2.GL_FRONT_AND_BACK, GL2.GL_LINE);
        gl.glPushMatrix();
        gl.glTranslated(-3f, 5f, 0);
        gl.glScalef(2f, 2f, 2f);
        Shapes.uvSphere(gl);
        gl.glPopMatrix();
    }


    public void paletteCone(GLAutoDrawable drawable) {
        GL2 gl = drawable.getGL().getGL2();
        gl.glColor3f(this.paletteRed, this.paletteGreen, this.paletteBlue);
        gl.glPolygonMode(GL2.GL_FRONT_AND_BACK, GL2.GL_LINE);
        gl.glPushMatrix();
        gl.glTranslated(-0.4f, 5f, 0);
        gl.glRotatef(-90, 1, 0, 0);
        gl.glScalef(2f, 2f, 2f);
        Shapes.uvCone(gl);
        gl.glPopMatrix();
    }

    public void paletteCylinder(GLAutoDrawable drawable) {
        GL2 gl = drawable.getGL().getGL2();
        gl.glColor3f(this.paletteRed, this.paletteGreen, this.paletteBlue);
        gl.glPolygonMode(GL2.GL_FRONT_AND_BACK, GL2.GL_LINE);
        gl.glPushMatrix();
        gl.glTranslated(-3f, 1f, 0);
        gl.glRotatef(-90, 1, 0, 0);
        gl.glScalef(2f, 2f, 2f);
        Shapes.uvCylinder(gl);
        gl.glPopMatrix();
    }

    public void paletteCuboid(GLAutoDrawable drawable) {
        GL2 gl = drawable.getGL().getGL2();
        gl.glColor3f(this.paletteRed, this.paletteGreen, this.paletteBlue);
        gl.glPolygonMode(GL.GL_FRONT_AND_BACK, GL2.GL_LINE);
        gl.glPushMatrix();
        gl.glTranslated(-1.5f, -7f, 0);
        gl.glScalef(2f, 2f, 2f);
        Shapes.cuboid(gl);
        gl.glPopMatrix();
    }


    public void paletteCube(GLAutoDrawable drawable) {
        GL2 gl = drawable.getGL().getGL2();
        gl.glColor3f(this.paletteRed, this.paletteGreen, this.paletteBlue);
        gl.glPolygonMode(GL.GL_FRONT_AND_BACK, GL2.GL_LINE);
        gl.glPushMatrix();
        gl.glTranslated(0f, 0.7f, 0);
        gl.glScalef(2f, 2f, 2f);
        Shapes.cube(gl);
        gl.glPopMatrix();
    }

    public void paletteTetrahedron(GLAutoDrawable drawable) {
        GL2 gl = drawable.getGL().getGL2();
        gl.glColor3f(this.paletteRed, this.paletteGreen, this.paletteBlue);
        gl.glPolygonMode(GL2.GL_FRONT_AND_BACK, GL2.GL_LINE);
        gl.glPushMatrix();
        gl.glTranslated(-3f, -2.2f, 0);
        gl.glScalef(2f, 2f, 2f);
        gl.glRotatef(30, 0, 1, 0);
        Shapes.tetrahedron(gl);
        gl.glPopMatrix();
    }


    public void paletteRectangularPyramid(GLAutoDrawable drawable) {
        GL2 gl = drawable.getGL().getGL2();
        gl.glColor3f(this.paletteRed, this.paletteGreen, this.paletteBlue);
        gl.glPolygonMode(GL2.GL_FRONT_AND_BACK, GL2.GL_LINE);
        gl.glPushMatrix();
        gl.glTranslated(-3f, 9f, 0);
        gl.glScalef(2f, 2f, 2f);
        Shapes.rectangularPyramid(gl);
        gl.glPopMatrix();
    }

    public void palettePentagonPyramid(GLAutoDrawable drawable) {
        GL2 gl = drawable.getGL().getGL2();
        gl.glColor3f(this.paletteRed, this.paletteGreen, this.paletteBlue);
        gl.glPolygonMode(GL2.GL_FRONT_AND_BACK, GL2.GL_LINE);
        gl.glPushMatrix();
        gl.glTranslated(0.3f, -2.5f, 0);
        gl.glScalef(2f, 2f, 2f);
        Shapes.pentagonPyramid(gl);
        gl.glPopMatrix();
    }

    public void paletteHexagonPyramid(GLAutoDrawable drawable) {
        GL2 gl = drawable.getGL().getGL2();
        gl.glColor3f(this.paletteRed, this.paletteGreen, this.paletteBlue);
        gl.glPolygonMode(GL2.GL_FRONT_AND_BACK, GL2.GL_LINE);
        gl.glPushMatrix();
        gl.glTranslated(-0.2f, 8.6f, 0);
        gl.glRotatef(45, 0, 1, 0);
        gl.glScalef(2f, 2f, 2f);
        Shapes.hexagonPyramid(gl);
        gl.glPopMatrix();
    }
    
    public void colorShape(int travers) {
        switch (travers) {
            case Promenljive.LEFT_ID:
                this.redL = 1;
                this.redLeftTwo = 0;
                this.redT = 0;
                this.redTopTwo = 0;
                this.redB = 0;
                this.redBottomTwo = 0;
                this.redR = 0;
                this.redF = 0;
                this.redBack = 0;
                break;
            case Promenljive.LEFT_TWO_ID:
                this.redL = 0;
                this.redLeftTwo = 1;
                this.redT = 0;
                this.redTopTwo = 0;
                this.redB = 0;
                this.redBottomTwo = 0;
                this.redR = 0;
                this.redF = 0;
                this.redBack = 0;
                break;
            case Promenljive.RIGHT_ID:
                this.redL = 0;
                this.redLeftTwo = 0;
                this.redT = 0;
                this.redTopTwo = 0;
                this.redB = 0;
                this.redBottomTwo = 0;
                this.redR = 1;
                this.redF = 0;
                this.redBack = 0;
                break;
            case Promenljive.TOP_ID:
                this.redL = 0;
                this.redLeftTwo = 0;
                this.redT = 1;
                this.redTopTwo = 0;
                this.redB = 0;
                this.redBottomTwo = 0;
                this.redR = 0;
                this.redF = 0;
                this.redBack = 0;
                break;

            case Promenljive.TOP_TWO_ID:
                this.redL = 0;
                this.redLeftTwo = 0;
                this.redT = 0;
                this.redTopTwo = 1;
                this.redB = 0;
                this.redBottomTwo = 0;
                this.redR = 0;
                this.redF = 0;
                this.redBack = 0;
                break;
            case Promenljive.BOTTOM_ID:
                this.redL = 0;
                this.redLeftTwo = 0;
                this.redT = 0;
                this.redTopTwo = 0;
                this.redB = 1;
                this.redBottomTwo = 0;
                this.redR = 0;
                this.redF = 0;
                this.redBack = 0;
                break;
            case Promenljive.BOTTOM_TWO_ID:
                this.redL = 0;
                this.redLeftTwo = 0;
                this.redT = 0;
                this.redTopTwo = 0;
                this.redB = 0;
                this.redBottomTwo = 1;
                this.redR = 0;
                this.redF = 0;
                this.redBack = 0;
                break;
            case Promenljive.FRONT_ID:
                this.redL = 0;
                this.redLeftTwo = 0;
                this.redT = 0;
                this.redTopTwo = 0;
                this.redB = 0;
                this.redBottomTwo = 0;
                this.redR = 0;
                this.redF = 1;
                this.redBack = 0;
                break;
            case Promenljive.BACK_ID:
                this.redL = 0;
                this.redLeftTwo = 0;
                this.redT = 0;
                this.redTopTwo = 0;
                this.redB = 0;
                this.redBottomTwo = 0;
                this.redR = 0;
                this.redF = 0;
                this.redBack = 1;
                break;
        }
    }

}
