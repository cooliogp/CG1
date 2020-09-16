import com.jogamp.opengl.*;
import com.jogamp.opengl.glu.GLU;
import java.nio.IntBuffer;

public class ObliciIgre {
	private Paleta p;
    Promenljive pr;
	
	public ObliciIgre(Paleta paleta, Promenljive promenljive) {
		p = paleta; 
    	pr = promenljive;
	}
	
	public void addShape(GLAutoDrawable drawable, int nameID) {
        GL2 gl = drawable.getGL().getGL2();
        switch (nameID) {
            case Promenljive.SPHERE_ID:
                Shapes.uvSphere(gl);
                break;
            case Promenljive.CUBOID_ID:
                Shapes.cuboid(gl);
                break;
            case Promenljive.CYLINDER_ID:
                Shapes.uvCylinder(gl);
                break;
            case Promenljive.CUBE_ID:
                Shapes.cube(gl);
                break;
            case Promenljive.TETRAHEDRON_ID:
                Shapes.tetrahedron(gl);
                break;
            case Promenljive.CONE_ID:
                Shapes.uvCone(gl);
                break;
            case Promenljive.RECTANGULAR_PYRAMID_ID:
                Shapes.rectangularPyramid(gl);
                break;
            case Promenljive.PENTAGON_PYRAMID_ID:
                Shapes.pentagonPyramid(gl);
                break;
            case Promenljive.HEXAGON_PYRAMID_ID:
                Shapes.hexagonPyramid(gl);
                break;
        }
    }

    private void addLeftShape(GLAutoDrawable drawable, int nameID) {

        GL2 gl = drawable.getGL().getGL2();
        gl.glPushMatrix();
        gl.glColor3f(p.addShapeRed, p.addShapeGreen, p.addShapeBlue);
        gl.glTranslated(pr.leftX, pr.leftY, pr.leftZ);
        gl.glScalef(pr.scaleLeft, pr.scaleLeft, pr.scaleLeft);
        gl.glRotatef(pr.angleLeftZ, 0, 0, pr.rotate);
        gl.glRotatef(pr.angleLeftY, 0, pr.rotate, 0);
        gl.glRotatef(pr.angleLeftX, pr.rotate, 0, 0);
        gl.glPolygonMode(GL2.GL_FRONT_AND_BACK, GL2.GL_FILL);
        addShape(drawable, nameID);
        gl.glPopMatrix();

    }

    private void addLeftTwoShape(GLAutoDrawable drawable, int nameID) {

    	GL2 gl = drawable.getGL().getGL2();
        gl.glPushMatrix();
        gl.glColor3f(p.addShapeRed, p.addShapeGreen, p.addShapeBlue);
        gl.glTranslated(pr.leftTwoX, pr.leftTwoY, pr.leftTwoZ);
        gl.glScalef(pr.scaleLeftTwo, pr.scaleLeftTwo, pr.scaleLeftTwo);
        gl.glRotatef(pr.angleLeftTwoZ, 0, 0, pr.rotate);
        gl.glRotatef(pr.angleLeftTwoY, 0, pr.rotate, 0);
        gl.glRotatef(pr.angleLeftTwoX, pr.rotate, 0, 0);
        gl.glPolygonMode(GL2.GL_FRONT_AND_BACK, GL2.GL_FILL);
        addShape(drawable, nameID);
        gl.glPopMatrix();

    }

    private void addRightShape(GLAutoDrawable drawable, int nameID) {

    	GL2 gl = drawable.getGL().getGL2();
        gl.glPushMatrix();
        gl.glColor3f(p.addShapeRed, p.addShapeGreen, p.addShapeBlue);
        gl.glTranslated(pr.rightX, pr.rightY, pr.rightZ);
        gl.glScalef(pr.scaleRight, pr.scaleRight, pr.scaleRight);
        gl.glRotatef(pr.angleRightZ, 0, 0, pr.rotate);
        gl.glRotatef(pr.angleRightY, 0, pr.rotate, 0);
        gl.glRotatef(pr.angleRightX, pr.rotate, 0, 0);
        gl.glPolygonMode(GL2.GL_FRONT_AND_BACK, GL2.GL_FILL);
        addShape(drawable, nameID);
        gl.glPopMatrix();
    }

    private void addTopShape(GLAutoDrawable drawable, int nameID) {

    	GL2 gl = drawable.getGL().getGL2();
        gl.glPushMatrix();
        gl.glColor3f(p.addShapeRed, p.addShapeGreen, p.addShapeBlue);
        gl.glTranslated(pr.topX, pr.topY, pr.topZ);
        gl.glScalef(pr.scaleTop, pr.scaleTop, pr.scaleTop);
        gl.glRotatef(pr.angleTopZ, 0, 0, pr.rotate);
        gl.glRotatef(pr.angleTopY, 0, pr.rotate, 0);
        gl.glRotatef(pr.angleTopX, pr.rotate, 0, 0);
        gl.glPolygonMode(GL2.GL_FRONT_AND_BACK, GL2.GL_FILL);
        addShape(drawable, nameID);
        gl.glPopMatrix();
    }

    private void addTopTwoShape(GLAutoDrawable drawable, int nameID) {

    	GL2 gl = drawable.getGL().getGL2();
        gl.glPushMatrix();
        gl.glColor3f(p.addShapeRed, p.addShapeGreen, p.addShapeBlue);
        gl.glTranslated(pr.topTwoX, pr.topTwoY, pr.topTwoZ);
        gl.glScalef(pr.scaleTopTwo, pr.scaleTopTwo, pr.scaleTopTwo);
        gl.glRotatef(pr.angleTopTwoZ, 0, 0, pr.rotate);
        gl.glRotatef(pr.angleTopTwoY, 0, pr.rotate, 0);
        gl.glRotatef(pr.angleTopTwoX, pr.rotate, 0, 0);
        gl.glPolygonMode(GL2.GL_FRONT_AND_BACK, GL2.GL_FILL);
        addShape(drawable, nameID);
        gl.glPopMatrix();
    }

    private void addBottomShape(GLAutoDrawable drawable, int nameID) {

        GL2 gl = drawable.getGL().getGL2();
        gl.glPushMatrix();
        gl.glColor3f(p.addShapeRed, p.addShapeGreen, p.addShapeBlue);
        gl.glTranslated(pr.bottomX, pr.bottomY, pr.bottomZ);
        gl.glScalef(pr.scaleBottom, pr.scaleBottom, pr.scaleBottom);
        gl.glRotatef(pr.angleBottomZ, 0, 0, pr.rotate);
        gl.glRotatef(pr.angleBottomY, 0, pr.rotate, 0);
        gl.glRotatef(pr.angleBottomX, pr.rotate, 0, 0);
        gl.glPolygonMode(GL2.GL_FRONT_AND_BACK, GL2.GL_FILL);
        addShape(drawable, nameID);
        gl.glPopMatrix();
    }

    private void addBottomTwoShape(GLAutoDrawable drawable, int nameID) {

        GL2 gl = drawable.getGL().getGL2();
        gl.glPushMatrix();
        gl.glColor3f(p.addShapeRed, p.addShapeGreen, p.addShapeBlue);
        gl.glTranslated(pr.bottomTwoX, pr.bottomTwoY, pr.bottomTwoZ);
        gl.glScalef(pr.scaleBottomTwo, pr.scaleBottomTwo, pr.scaleBottomTwo);
        gl.glRotatef(pr.angleBottomTwoZ, 0, 0, pr.rotate);
        gl.glRotatef(pr.angleBottomTwoY, 0, pr.rotate, 0);
        gl.glRotatef(pr.angleBottomTwoX, pr.rotate, 0, 0);
        gl.glPolygonMode(GL2.GL_FRONT_AND_BACK, GL2.GL_FILL);
        addShape(drawable, nameID);
        gl.glPopMatrix();
    }

    private void addFrontShape(GLAutoDrawable drawable, int nameID) {

        GL2 gl = drawable.getGL().getGL2();
        gl.glPushMatrix();
        gl.glColor3f(p.addShapeRed, p.addShapeGreen, p.addShapeBlue);
        gl.glTranslated(pr.frontX, pr.frontY, pr.frontZ);
        gl.glScalef(pr.scaleFront, pr.scaleFront, pr.scaleFront);
        gl.glRotatef(pr.angleFrontZ, 0, 0, pr.rotate);
        gl.glRotatef(pr.angleFrontY, 0, pr.rotate, 0);
        gl.glRotatef(pr.angleFrontX, pr.rotate, 0, 0);
        gl.glPolygonMode(GL2.GL_FRONT_AND_BACK, GL2.GL_FILL);
        addShape(drawable, nameID);
        gl.glPopMatrix();
    }

    private void addBackShape(GLAutoDrawable drawable, int nameID) {

        GL2 gl = drawable.getGL().getGL2();
        gl.glPushMatrix();
        gl.glColor3f(p.addShapeRed, p.addShapeGreen, p.addShapeBlue);
        gl.glTranslated(pr.backX, pr.backY, pr.backZ);
        gl.glScalef(pr.scaleBack, pr.scaleBack, pr.scaleBack);
        gl.glRotatef(pr.angleBackZ, 0, 0, pr.rotate);
        gl.glRotatef(pr.angleBackY, 0, pr.rotate, 0);
        gl.glRotatef(pr.angleBackX, pr.rotate, 0, 0);
        gl.glPolygonMode(GL2.GL_FRONT_AND_BACK, GL2.GL_FILL);
        addShape(drawable, nameID);
        gl.glPopMatrix();
    }


    // The buffer is examined in processHits().

    public void pickModels(GLAutoDrawable drawable, Igra igra, IntBuffer selectBuffer, int xCursor, int yCursor, GLU glu) {
        GL2 gl = drawable.getGL().getGL2();

        igra.startPicking(drawable, selectBuffer);
        igra.palettePicking(drawable, glu,  xCursor,  yCursor);

        gl.glPushName(Promenljive.SPHERE_ID);
        p.paletteSphere(drawable);
        gl.glPopName();

        gl.glPushName(Promenljive.CUBOID_ID);
        p.paletteCuboid(drawable);
        gl.glPopName();

        gl.glPushName(Promenljive.CYLINDER_ID);
        p.paletteCylinder(drawable);
        gl.glPopName();

        gl.glPushName(Promenljive.TETRAHEDRON_ID);
        p.paletteTetrahedron(drawable);
        gl.glPopName();

        gl.glPushName(Promenljive.CUBE_ID);
        p.paletteCube(drawable);
        gl.glPopName();

        gl.glPushName(Promenljive.CONE_ID);
        p.paletteCone(drawable);
        gl.glPopName();

        gl.glPushName(Promenljive.RECTANGULAR_PYRAMID_ID);
        p.paletteRectangularPyramid(drawable);
        gl.glPopName();

        gl.glPushName(Promenljive.PENTAGON_PYRAMID_ID);
        p.palettePentagonPyramid(drawable);
        gl.glPopName();

        gl.glPushName(Promenljive.HEXAGON_PYRAMID_ID);
        p.paletteHexagonPyramid(drawable);
        gl.glPopName();

        gl.glPushMatrix();



        gl.glRotated(pr.currentAngleOfRotationX, 1, 0, 0);
        gl.glRotated(pr.currentAngleOfRotationY, 0, 1, 0);

        gl.glPushName(Promenljive.LEFT_ID);
        drawLeft(drawable);
        gl.glPopName();

        gl.glPushName(Promenljive.LEFT_TWO_ID);
        drawLeftTwo(drawable);
        gl.glPopName();

        gl.glPushName(Promenljive.RIGHT_ID);
        drawRight(drawable);
        gl.glPopName();

        gl.glPushName(Promenljive.TOP_ID);
        drawTop(drawable);
        gl.glPopName();

        gl.glPushName(Promenljive.TOP_TWO_ID);
        drawTopTwo(drawable);
        gl.glPopName();

        gl.glPushName(Promenljive.BOTTOM_ID);
        drawBottom(drawable);
        gl.glPopName();

        gl.glPushName(Promenljive.BOTTOM_TWO_ID);
        drawBottomTwo(drawable);
        gl.glPopName();

        gl.glPushName(Promenljive.FRONT_ID);
        drawFront(drawable);
        gl.glPopName();

        gl.glPushName(Promenljive.BACK_ID);
        drawBack(drawable);
        gl.glPopName();


        gl.glPopMatrix();
        gl.glPopMatrix();
        igra.endPicking(drawable, selectBuffer);
    } // end of pickModels()


    public void setObserver(GLU glu) {

        glu.gluLookAt(-5, 0f, 3f,
                0, 0, 0,
                0, 1, 0);
    }

    public void drawBlueprint(GLAutoDrawable drawable, GLU glu) {
        GL2 gl = drawable.getGL().getGL2();
        gl.glViewport(0 , 0, (int) (pr.windowWidth/ 1.2), pr.windowHeight);
        gl.glMatrixMode(GL2.GL_PROJECTION);
        gl.glLoadIdentity();
        glu.gluPerspective(pr.currentAngleOfVisibleField, 1.f * pr.windowWidth / pr.windowHeight, 1, 100);
        gl.glMatrixMode(GL2.GL_MODELVIEW);
        gl.glLoadIdentity();
        setObserver(glu);

        gl.glPushMatrix();
        gl.glTranslated(pr.translateX, pr.translateY, pr.translateZ);
        gl.glScalef(pr.scale, pr.scale, pr.scale);
        gl.glRotated(pr.currentAngleOfRotationX, 1, 0, 0);
        gl.glRotated(pr.currentAngleOfRotationY, 0, 1, 0);

        gl.glColor3f(1, 1, 1);
        gl.glPolygonMode(GL2.GL_FRONT_AND_BACK, GL2.GL_FILL);
        pr.textures[0].bind(gl);  // Says which texture to use.
        gl.glEnable(GL.GL_TEXTURE_2D);
        Shapes.cube(gl, 2, true);
        gl.glDisable(GL.GL_TEXTURE_2D);

        drawTop(drawable);
        drawTopTwo(drawable);
        drawRight(drawable);
        drawLeft(drawable);
        drawLeftTwo(drawable);
        drawBottom(drawable);
        drawBottomTwo(drawable);
        drawFront(drawable);
        drawBack(drawable);

        addLeftShape(drawable, p.left_idn);
        addLeftTwoShape(drawable, p.left_two_idn);
        addRightShape(drawable, p.right_idn);
        addTopShape(drawable, p.top_idn);
        addTopTwoShape(drawable, p.top_two_idn);
        addBottomShape(drawable, p.bottom_idn);
        addBottomTwoShape(drawable, p.bottom_two_idn);
        addFrontShape(drawable, p.front_idn);
        addBackShape(drawable, p.back_idn);

        gl.glPopMatrix();
    }

    public void drawShape(GLAutoDrawable drawable, int randomShape) {
        GL2 gl = drawable.getGL().getGL2();

        switch (randomShape) {
            case Promenljive.SPHERE:
                Shapes.uvSphere(gl);
                break;
            case Promenljive.CYLINDER:
                Shapes.uvCylinder(gl);
                break;
            case Promenljive.CONE:
                Shapes.uvCone(gl);
                break;
            case Promenljive.CUBE:
                Shapes.cube(gl);
                break;
            case Promenljive.CUBOID:
                Shapes.cuboid(gl);
                break;
            case Promenljive.TETRAHEDRON:
                Shapes.tetrahedron(gl);
                break;
            case Promenljive.RECTANGULAR_PYRAMID:
                Shapes.rectangularPyramid(gl);
                break;
            case Promenljive.PENTAGON_PYRAMID:
                Shapes.pentagonPyramid(gl);
                break;
            case Promenljive.HEXAGON_PYRAMID:
                Shapes.hexagonPyramid(gl);
                break;
        }
    }

    private void drawLeft(GLAutoDrawable drawable) {

        if (pr.randomL == Promenljive.CUBOID) {
        	pr.leftX = -1.5f;
        }

        GL2 gl = drawable.getGL().getGL2();
        gl.glPushMatrix();
        gl.glColor3f(p.redL, p.greenL, p.blueL);
        gl.glTranslated(pr.leftX, pr.leftY, pr.leftZ);
        gl.glPolygonMode(GL2.GL_FRONT_AND_BACK, GL2.GL_LINE);
        gl.glLineWidth(2);
        gl.glScalef(pr.scaleLeftShape, pr.scaleLeftShape, pr.scaleLeftShape);
        drawShape(drawable, pr.randomL);
        gl.glPopMatrix();
    }

    private void drawLeftTwo(GLAutoDrawable drawable) {

        if (pr.randomL2 == Promenljive.CUBOID) {
        	pr.leftTwoX = -1.5f;
        }

        GL2 gl = drawable.getGL().getGL2();
        gl.glPushMatrix();
        gl.glColor3f(p.redLeftTwo, p.greenLeftTwo, p.blueLeftTwo);
        gl.glTranslated(pr.leftTwoX, pr.leftTwoY, pr.leftTwoZ);
        gl.glPolygonMode(GL2.GL_FRONT_AND_BACK, GL2.GL_LINE);
        gl.glLineWidth(2);
        gl.glScalef(pr.scaleLeftTwoShape, pr.scaleLeftTwoShape, pr.scaleLeftTwoShape);
        drawShape(drawable, pr.randomL2);
        gl.glPopMatrix();
    }


    private void drawRight(GLAutoDrawable drawable) {

        if (pr.randomR == Promenljive.CUBOID) {
        	pr.rightX = 1.75f;
        }

        GL2 gl = drawable.getGL().getGL2();
        gl.glPushMatrix();
        gl.glColor3f(p.redR, p.greenR, p.blueR);
        gl.glPolygonMode(GL2.GL_BACK, GL2.GL_LINE);
        gl.glLineWidth(2);

        gl.glTranslated(pr.rightX, pr.rightY, pr.rightZ);
        gl.glScalef(pr.scaleRightShape, pr.scaleRightShape, pr.scaleRightShape);

        drawShape(drawable, pr.randomR);
        gl.glPopMatrix();
    }


    private void drawTop(GLAutoDrawable drawable) {
        GL2 gl = drawable.getGL().getGL2();
        gl.glPushMatrix();
        gl.glColor3f(p.redT, p.greenT, p.blueT);
        gl.glPolygonMode(GL2.GL_FRONT_AND_BACK, GL2.GL_LINE);
        gl.glLineWidth(2);

        gl.glTranslated(pr.topX, pr.topY, pr.topZ);
        gl.glScalef(pr.scaleTopShape, pr.scaleTopShape, pr.scaleTopShape);

        drawShape(drawable, pr.randomT);
        gl.glPopMatrix();
    }

    private void drawTopTwo(GLAutoDrawable drawable) {
        GL2 gl = drawable.getGL().getGL2();
        gl.glPushMatrix();
        gl.glColor3f(p.redTopTwo, p.greenTopTwo, p.blueTopTwo);
        gl.glPolygonMode(GL2.GL_FRONT_AND_BACK, GL2.GL_LINE);
        gl.glLineWidth(2);

        gl.glTranslated(pr.topTwoX, pr.topTwoY, pr.topTwoZ);
        gl.glScalef(pr.scaleTopTwoShape, pr.scaleTopTwoShape, pr.scaleTopTwoShape);

        drawShape(drawable, pr.randomT2);
        gl.glPopMatrix();
    }

    private void drawBottom(GLAutoDrawable drawable) {

        GL2 gl = drawable.getGL().getGL2();
        gl.glPushMatrix();
        gl.glColor3f(p.redB, p.greenB, p.blueB);
        gl.glPolygonMode(GL2.GL_BACK, GL2.GL_LINE);
        gl.glLineWidth(2);

        gl.glTranslated(pr.bottomX, pr.bottomY, pr.bottomZ);
        gl.glScalef(pr.scaleBottomShape, pr.scaleBottomShape, pr.scaleBottomShape);
        drawShape(drawable, pr.randomBot);
        gl.glPopMatrix();
    }

    private void drawBottomTwo(GLAutoDrawable drawable) {

        GL2 gl = drawable.getGL().getGL2();
        gl.glPushMatrix();
        gl.glColor3f(p.redBottomTwo, p.greenBottomTwo, p.blueBottomTwo);
        gl.glPolygonMode(GL2.GL_BACK, GL2.GL_LINE);
        gl.glLineWidth(2);

        gl.glTranslated(pr.bottomTwoX, pr.bottomTwoY, pr.bottomTwoZ);
        gl.glScalef(pr.scaleBottomTwoShape, pr.scaleBottomTwoShape, pr.scaleBottomTwoShape);
        drawShape(drawable, pr.randomBot2);
        gl.glPopMatrix();
    }

    private void drawFront(GLAutoDrawable drawable) {
        GL2 gl = drawable.getGL().getGL2();
        gl.glPushMatrix();
        gl.glColor3f(p.redF, p.greenF, p.blueF);
        gl.glPolygonMode(GL2.GL_BACK, GL2.GL_LINE);
        gl.glLineWidth(2);

        gl.glTranslated(pr.frontX, pr.frontY, pr.frontZ);
        gl.glScalef(pr.scaleFrontShape, pr.scaleFrontShape, pr.scaleFrontShape);

        drawShape(drawable, pr.randomF);
        gl.glPopMatrix();
    }

    private void drawBack(GLAutoDrawable drawable) {
        GL2 gl = drawable.getGL().getGL2();
        gl.glPushMatrix();
        gl.glColor3f(p.redBack, p.greenBack, p.blueBack);
        gl.glPolygonMode(GL2.GL_FRONT_AND_BACK, GL2.GL_LINE);
        gl.glLineWidth(2);

        gl.glTranslated(pr.backX, pr.backY, pr.backZ);
        gl.glScalef(pr.scaleBackShape, pr.scaleBackShape, pr.scaleBackShape);

        drawShape(drawable, pr.randomB);
        gl.glPopMatrix();
    }

}
