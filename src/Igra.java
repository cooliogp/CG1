import com.jogamp.opengl.*;
import com.jogamp.opengl.glu.GLU;
import com.sun.opengl.util.BufferUtil;

import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.Collections;

public class Igra {
	private Paleta p;
    Promenljive pr;
	
	public Igra(Paleta paleta, Promenljive promenljive) {
		p = paleta; 
    	pr = promenljive;
	}
	
	 public void newGame() {
	        ArrayList<Integer> list = new ArrayList<>();
	        for (int i = 1; i < 10; i++) {
	            list.add(i);
	        }

	        Collections.shuffle(list);

	        pr.randomF = list.get(0);
	        pr.randomB = list.get(1);
	        pr.randomT = list.get(2);
	        pr.randomT2 = list.get(3);
	        pr.randomR = list.get(4);
	        pr.randomL = list.get(5);
	        pr.randomL2 = list.get(6);
	        pr.randomBot = list.get(7);
	        pr.randomBot2 = list.get(8);


	        // default values

	        pr.currentAngleOfRotationX = 0;
	        pr.currentAngleOfRotationY = 0;
	        pr.currentAngleOfVisibleField = 55;

	        pr.translateX = 0;
	        pr.translateY = 0;
	        pr.translateZ = 0;

	        pr.scale = 1;

	        pr.nameID = 0;
	        p.left_idn = 0;
	        p.left_two_idn = 0;
	        p.right_idn = 0;
	        p.top_idn = 0;
	        p.top_two_idn = 0;
	        p.bottom_idn = 0;
	        p.bottom_two_idn = 0;
	        p.front_idn = 0;
	        p.back_idn = 0;
	        p.addShapeRed = 1f;
	        p.addShapeGreen = 102 / 255f;
	        p.addShapeBlue = 0f;

	        p.redL = p.defaultRed;
	        p.greenL = p.defaultGreen;
	        p.blueL = p.defaultBlue;

	        p.redLeftTwo = p.defaultRed;
	        p.greenLeftTwo = p.defaultGreen;
	        p.blueLeftTwo = p.defaultBlue;

	        p.redT = p.defaultRed;
	        p.greenT = p.defaultGreen;
	        p.blueT = p.defaultBlue;

	        p.redTopTwo = p.defaultRed;
	        p.greenTopTwo = p.defaultGreen;
	        p.blueTopTwo = p.defaultBlue;

	        p.redB = p.defaultRed;
	        p.greenB = p.defaultGreen;
	        p.blueB = p.defaultBlue;

	        p.redBottomTwo = p.defaultRed;
	        p.greenBottomTwo = p.defaultGreen;
	        p.blueBottomTwo = p.defaultBlue;

	        p.redR = p.defaultRed;
	        p.greenR = p.defaultGreen;
	        p.blueR = p.defaultBlue;

	        p.redF = p.defaultRed;
	        p.greenF = p.defaultGreen;
	        p.blueF = p.defaultBlue;

	        p.redBack = p.defaultRed;
	        p.greenBack = p.defaultGreen;
	        p.blueBack = p.defaultBlue;

	        // LEFT
	        pr.leftX = -1.25;
	        pr.leftY = 0.5;
	        pr.leftZ = 0;

	        pr.scaleLeftShape = 0.5f;

	        // LEFT TWO
	        pr.leftTwoX = -1.25;
	        pr.leftTwoY = -0.5;
	        pr.leftTwoZ = 0;

	        pr.scaleLeftTwoShape = 0.5f;

	        // RIGHT
	        pr.rightX = 1.4;
	        pr.rightY = 0;
	        pr.rightZ = 0.5;

	        pr.scaleRightShape = 0.75f;

	        // TOP
	        pr.topX = -0.5;
	        pr.topY = 1.5;
	        pr.topZ = 0.5;

	        pr.scaleTopShape = 1;

	        // TOP TWO
	        pr.topTwoX = 0.5;
	        pr.topTwoY = 1.5;
	        pr.topTwoZ = -0.5;

	        pr.scaleTopTwoShape = 1;

	        // BOTTOM
	        pr.bottomX = 1;
	        pr.bottomY = -1.63;
	        pr.bottomZ = 0.5f;

	        pr.scaleBottomShape = 1.25f;

	        // BOTTOM TWO
	        pr.bottomTwoX = -1;
	        pr.bottomTwoY = -1.63;
	        pr.bottomTwoZ = -0.5f;

	        pr.scaleBottomTwoShape = 1.25f;

	        // FRONT
	        pr.frontX = -0.25;
	        pr.frontY = 0;
	        pr.frontZ = 1.75;

	        pr.scaleFrontShape = 1.5f;

	        // BACK
	        pr.backX = 0;
	        pr.backY = 0;
	        pr.backZ = -1.9;

	        pr.scaleBackShape = 1.75f;

	        pr.travers = 0;

	        pr.scaleDelta = 0.05f;
	        pr.scaleLeft = 0.5f;
	        pr.scaleLeftTwo = 0.5f;
	        pr.scaleRight = 0.5f;
	        pr.scaleTop = 0.5f;
	        pr.scaleTopTwo = 0.5f;
	        pr.scaleBottom = 0.5f;
	        pr.scaleBottomTwo = 0.5f;
	        pr.scaleFront = 0.5f;
	        pr.scaleBack = 0.5f;


	        pr.angleLeftY = 90;
	        pr.angleLeftX = 90;
	        pr.angleLeftZ = 90;

	        pr.angleLeftTwoY = 90;
	        pr.angleLeftTwoX = 90;
	        pr.angleLeftTwoZ = 90;

	        pr.angleRightX = 90;
	        pr.angleRightY = 90;
	        pr.angleRightZ = 90;

	        pr.angleTopX = 90;
	        pr.angleTopY = 90;
	        pr.angleTopZ = 90;

	        pr.angleTopTwoX = 90;
	        pr.angleTopTwoY = 90;
	        pr.angleTopTwoZ = 90;

	        pr.angleBottomX = 90;
	        pr.angleBottomY = 90;
	        pr.angleBottomZ = 90;

	        pr.angleFrontX = 90;
	        pr.angleFrontY = 90;
	        pr.angleFrontZ = 90;

	        pr.angleBackX = 90;
	        pr.angleBackY = 90;
	        pr.angleBackZ = 90;
	    }
	 
	 public void startPicking(GLAutoDrawable drawable, IntBuffer selectBuffer) {
         GL2 gl = drawable.getGL().getGL2();
         selectBuffer = BufferUtil.newIntBuffer(Promenljive.BUFSIZE);
         gl.glSelectBuffer(Promenljive.BUFSIZE, selectBuffer);
         gl.glRenderMode(GL2.GL_SELECT); // switch to selection mode
         gl.glInitNames(); // make an empty name stack
         gl.glMatrixMode(GL2.GL_MODELVIEW); // restore model view
     } // end of startPicking()

     public void palettePicking(GLAutoDrawable drawable, GLU glu, int xCursor, int yCursor) {
         GL2 gl = drawable.getGL().getGL2();
         gl.glMatrixMode(GL2.GL_PROJECTION);
         gl.glPushMatrix();
         gl.glLoadIdentity();
         int[] viewport = new int[4];
         float[] projMatrix = new float[16];
         gl.glGetIntegerv(GL2.GL_VIEWPORT, viewport, 0);
         //x,y=0, width andd height
         viewport[0] = (int) (pr.windowWidth / 1.3);
         viewport[1] = 0;
         viewport[2] = pr.windowWidth / 4;
         viewport[3] = pr.windowHeight;
         gl.glGetFloatv(GL2.GL_PROJECTION_MATRIX, projMatrix, 0);
         glu.gluPickMatrix((double) xCursor, (double) (viewport[3] - yCursor),
                 1.0, 1.0, viewport, 0);

         gl.glMultMatrixf(projMatrix, 0); // following code from "OpenGL Distilled"
         gl.glOrtho((float) -10 / 2, (float) 10 / 2,
                 (-10 * pr.aspectP) / 2,
                 (10 * pr.aspectP) / 2, 1, 11);

         gl.glMatrixMode(GL2.GL_MODELVIEW);
         gl.glLoadIdentity();
         glu.gluLookAt(-1, 2, 5.0,
                 0.0, 0.0, 0.0,
                 0.0, 1.0, 0.0);

     }


     public void endPicking(GLAutoDrawable drawable, IntBuffer selectBuffer) {
         GL2 gl = drawable.getGL().getGL2();
         // restore original projection matrix
         gl.glMatrixMode(GL2.GL_PROJECTION);
         gl.glPopMatrix();
         gl.glMatrixMode(GL2.GL_MODELVIEW);
         gl.glFlush();
         // return to normal rendering mode, and process hits
         int numHits = gl.glRenderMode(GL2.GL_RENDER);
         processHits(numHits, drawable, selectBuffer);
         pr.inSelectionMode = false;
     } // end of endPicking()

     public void processHits(int numHits, GLAutoDrawable drawable, IntBuffer selectBuffer) {
         if (numHits == 0)
             return; // no hits to process

         float smallestZ = -1.0f;
         boolean isFirstLoop = true;
         int offset = 0;
         /* iterate through the hit records, saving the smallest z value and the name ID associated with it */


         for (int i = 0; i < numHits; i++) {
             int numNames = selectBuffer.get(offset);
             offset++;
             // minZ and maxZ are taken from the Z buffer
             float minZ = getDepth(offset, selectBuffer);
             offset++;

             // store the smallest z value
             if (isFirstLoop) {
                 smallestZ = minZ;
                 isFirstLoop = false;
             } else {
                 if (minZ < smallestZ)
                     smallestZ = minZ;
             }
             offset++;

             for (int j = 0; j < numNames; j++) {
                 pr.nameID = selectBuffer.get(offset);
                 System.out.print(idToString(pr.nameID) + "\n");


                 if (j == (numNames - 1)) {
 // if the last one (the top element on the stack)
                     if (smallestZ == minZ)
                      {
                     }
                 }
                 offset++;
             }
         }
     } // end of processHits()
     
     private float getDepth(int offset, IntBuffer selectBuffer) {
         long depth = (long) selectBuffer.get(offset); // large -ve number
         return (1.0f + ((float) depth / 0x7fffffff));
         // return as a float between 0 and 1
     } // end of getDepth()
     
     private String idToString(int nameID) {
         if (nameID == Promenljive.LEFT_ID)
             return "left";
         else if (nameID == Promenljive.LEFT_TWO_ID)
             return "left_two";
         else if (nameID == Promenljive.RIGHT_ID)
             return "right";
         else if (nameID == Promenljive.TOP_ID)
             return "top";
         else if (nameID == Promenljive.TOP_TWO_ID)
             return "top_two";
         else if (nameID == Promenljive.BACK_ID)
             return "back";
         else if (nameID == Promenljive.BOTTOM_ID)
             return "bottom";
         else if (nameID == Promenljive.BOTTOM_TWO_ID)
             return "bottom_two";
         else if (nameID == Promenljive.FRONT_ID)
             return "front";
         else if (nameID == Promenljive.SPHERE_ID)
             return "palette_sphere";
         else if (nameID == Promenljive.CUBOID_ID)
             return "palette_cuboid";
         else if (nameID == Promenljive.TETRAHEDRON_ID)
             return "palette_tetrahedron";
         else if (nameID == Promenljive.CUBE_ID)
             return "palette_cube";
         else if (nameID == Promenljive.CONE_ID)
             return "palette_cone";
         else if (nameID == Promenljive.CYLINDER_ID)
             return "palette_cylinder";
         else if (nameID == Promenljive.RECTANGULAR_PYRAMID_ID)
             return "palette_RECTANGULAR_PYRAMID";
         else if (nameID == Promenljive.PENTAGON_PYRAMID_ID)
             return "palette_PENTAGON_PYRAMID";
         else if (nameID == Promenljive.HEXAGON_PYRAMID_ID)
             return "palette_HEXAGON_PYRAMID";
         // we should not reach this point
         return "nameID " + nameID;
     } // end of idToString()

}
