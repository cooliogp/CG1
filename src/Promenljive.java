
import com.jogamp.opengl.util.texture.Texture;

public class Promenljive {
    // variables for random position of blueprint shapes
    public int 
        randomF,
        randomB,
        randomT,
        randomT2,
        randomR,
        randomL,
        randomL2,
        randomBot,
        randomBot2;

    public static final int BUFSIZE = 512;
    public int nameID = 0; // name ID for picking

    
    // initial position of the shapes on the blueprint

    public double 
            // LEFT
             leftX,
             leftY,
             leftZ,
             // LEFT
             leftTwoX,
             leftTwoY,
             leftTwoZ,
             // RIGHT
             rightX,
             rightY,
             rightZ,
             // TOP
             topX,
             topY,
             topZ,
             // TOP TWO
             topTwoX,
             topTwoY,
             topTwoZ,
             // BOTTOM
             bottomX,
             bottomY,
             bottomZ,
             // BOTTOM TWO
             bottomTwoX,
             bottomTwoY,
             bottomTwoZ,
             // FRONT
             frontX,
             frontY,
             frontZ,
             // BACK
             backX = 0,
             backY = 0,
             backZ = -1.5;

    // variable to travers through the blueprint
    public int travers = 0;

    // scaling increment/decrement
    public float scaleDelta = 0.1f;

    // initial scale of the inserted shapes into the blueprint
    public float 
            scaleLeft = 0.5f,
            scaleLeftTwo = 0.5f,
            scaleRight = 0.5f,
            scaleTop = 0.5f,
            scaleTopTwo = 0.5f,
            scaleBottom = 0.5f,
            scaleBottomTwo = 0.5f,
            scaleFront = 0.5f,
            scaleBack = 0.5f;

    // initial angle of the inserted shapes into the blueprint
    public int
            angleLeftY = 90,
            angleLeftX = 90,
            angleLeftZ = 90,
    
            angleLeftTwoY = 90,
            angleLeftTwoX = 90,
            angleLeftTwoZ = 90,
    
            angleRightX = 90,
            angleRightY = 90,
            angleRightZ = 90,
    
            angleTopX = 90,
            angleTopY = 90,
            angleTopZ = 90,
    
            angleTopTwoX = 90,
            angleTopTwoY = 90,
            angleTopTwoZ = 90,
    
            angleBottomX = 90,
            angleBottomY = 90,
            angleBottomZ = 90,
    
            angleBottomTwoX = 90,
            angleBottomTwoY = 90,
            angleBottomTwoZ = 90,
    
            angleFrontX = 90,
            angleFrontY = 90,
            angleFrontZ = 90,
    
            angleBackX = 90,
            angleBackY = 90,
            angleBackZ = 90;

    // rotation increment/decrement
    public float rotate = 1;

    public static final int
            LEFT_ID = 1,
            LEFT_TWO_ID = 2,
            RIGHT_ID = 3,
            TOP_ID = 4,
            TOP_TWO_ID = 5,
            BOTTOM_ID = 6,
            BOTTOM_TWO_ID = 7,
            FRONT_ID = 8,
            BACK_ID = 9;


    // blueprint shapes
    public final static int
            SPHERE = 1,
            CYLINDER = 2,
            CONE = 3,
            CUBE = 4,
            CUBOID = 5,
            TETRAHEDRON = 6,
            RECTANGULAR_PYRAMID = 7,
            PENTAGON_PYRAMID = 8,
            HEXAGON_PYRAMID = 9;

    public static final int FPS = 60;
    public int windowWidth = 640;
    public int windowHeight = 480;
    public boolean inSelectionMode = false;


    // palette shapes
    public final static int 
            SPHERE_ID = 10,
            CUBOID_ID = 11,
            CYLINDER_ID = 12,
            CUBE_ID = 13,
            TETRAHEDRON_ID = 14,
            CONE_ID = 15,
            RECTANGULAR_PYRAMID_ID = 16,
            PENTAGON_PYRAMID_ID = 17,
            HEXAGON_PYRAMID_ID = 18;

    public final static String[] shape = {" ", "SPHERE", "CYLINDER", "CONE", "CUBE", "CUBOID", "TETRAHEDRON",
            "RECTANGULAR_PYRAMID", "PENTAGON_PYRAMID", "HEXAGON_PYRAMID",
            "SPHERE", "CUBOID", "CYLINDER", "CUBE", "TETRAHEDRON", "CONE",
            "RECTANGULAR_PYRAMID", "PENTAGON_PYRAMID", "HEXAGON_PYRAMID"};
    
    public String[] textureFileNames = {
            "blue.png"
    };
    public Texture[] textures = new Texture[textureFileNames.length];

    public int currentAngleOfRotationX = 0;
    public int currentAngleOfRotationY = 0;
    public int currentAngleOfVisibleField = 55;

    public int angleDelta = 5;
    public float aspectP;
    public boolean gameFinished = false;
    public boolean newGame = true;

    public float translateX;
    public float translateY;
    public float translateZ;

    public float scale;
    public float scaleLeftShape;
    public float scaleLeftTwoShape;
    public float scaleRightShape;
    public float scaleTopShape;
    public float scaleTopTwoShape;
    public float scaleBottomShape;
    public float scaleBottomTwoShape;
    public float scaleFrontShape;
    public float scaleBackShape;

}
