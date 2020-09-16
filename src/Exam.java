import com.jogamp.opengl.*;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.util.FPSAnimator;
import com.jogamp.opengl.util.awt.ImageUtil;
import com.jogamp.opengl.util.awt.TextRenderer;
import com.jogamp.opengl.util.texture.awt.AWTTextureIO;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.nio.IntBuffer;


public class Exam extends GLCanvas implements GLEventListener, KeyListener, MouseListener {

    private JCheckBox lightOnOff;
    private JComboBox<String> lightCombobox;

    enum LigthsTypesEnum {AMBIENT_LIGHTING, DIFFUSE_LIGHTING, SPECULAR_LIGHTUNG, AMBIENT_LIGTH};
    LigthsTypesEnum selectedLighting = LigthsTypesEnum.AMBIENT_LIGHTING;

    private JButton removeShape;
    private JButton addShape;
    private JButton finishGame;
    private JButton help;
    private JButton quitGame;
    private JButton newGameButton;

    private JFrame okvir;
    private Camera camera;

    private TextRenderer textRenderer;
    private TextRenderer textMatch;

    private GLCanvas canvas;
    private FPSAnimator animator;
    private final String TITLE = "Exam";
    private GLU glu;
    private IntBuffer selectBuffer;
    private int xCursor, yCursor;

   
    
    private Paleta p;
    private Promenljive pr;
    private Igra igra;
    private ProveraPoklapanja provera;
    private ObliciIgre obliciIgre;

    public Exam(Paleta paleta, Promenljive promenljive) {
    	p = paleta; 
    	pr = promenljive;
    	igra = new Igra(p, pr);
    	provera = new ProveraPoklapanja(p, pr);
    	obliciIgre = new ObliciIgre(p, pr);
    	
        GLProfile profile = GLProfile.getDefault();
        GLCapabilities caps = new GLCapabilities(profile);
        caps.setAlphaBits(8);
        caps.setDepthBits(24);
        caps.setDoubleBuffered(true);
        caps.setStencilBits(8);

        SwingUtilities.invokeLater(() -> {
            // Create the OpenGL rendering canvas
            canvas = new GLCanvas();
            canvas.setPreferredSize(new Dimension(pr.windowWidth, pr.windowHeight));
            canvas.addGLEventListener(this);
            canvas.addKeyListener(this);
            canvas.addMouseListener(this);
            canvas.setFocusable(true);
            canvas.requestFocus();
            canvas.requestFocusInWindow();

            animator = new FPSAnimator(canvas, Promenljive.FPS, true);

            okvir = new JFrame();

            removeShape = new JButton("Remove");
            addShape = new JButton("  Add ");
            finishGame = new JButton("Finish");
            quitGame = new JButton("Quit");
            help = new JButton("Help");
            newGameButton = new JButton("New Game");

            addShape.setPreferredSize(new Dimension(100, 20));
            removeShape.setPreferredSize(new Dimension(100, 20));
            finishGame.setPreferredSize(new Dimension(100, 20));
            help.setPreferredSize(new Dimension(100, 20));
            quitGame.setPreferredSize(new Dimension(100, 20));
            newGameButton.setPreferredSize(new Dimension(100, 20));

            
            lightOnOff = new JCheckBox("Turn Light ON/OFF", true);

            JPanel bottom = new JPanel();
            bottom.setLayout(new GridLayout(2, 2));

            JPanel front = new JPanel();
            front.setLayout(new GridLayout(1, 2));
            System.out.println(selectedLighting);
            
            lightCombobox = new JComboBox<>();
            lightCombobox.addItem("Ambient Light");
            lightCombobox.addItem("Specular Light");
            lightCombobox.addItem("Diffuse Light");
            lightCombobox.addItem("Global Ambient Light");
            //LigthsTypesEnum

            // adding listener to track which light is chosen selectedLight
            lightCombobox.addActionListener(e -> {
            int selectedIndex = lightCombobox.getSelectedIndex();
            switch(selectedIndex){
                case 0:
                    this.selectedLighting = LigthsTypesEnum.AMBIENT_LIGHTING;
                    break;
                case 1:
                    this.selectedLighting = LigthsTypesEnum.SPECULAR_LIGHTUNG;
                    break;
                case 2:
                    this.selectedLighting =LigthsTypesEnum.DIFFUSE_LIGHTING;
                    break;
                case 3:
                    this.selectedLighting = LigthsTypesEnum.AMBIENT_LIGTH;
                    break;
            }
            repaint();
            //System.out.println("REGISTERD !!!!!" + this.selectedLighting.toString());
            //System.out.println(this.selectedLighting);
        });

            JPanel row1 = new JPanel();
            row1.add(addShape);
            row1.add(removeShape);
            row1.add(lightCombobox);
            row1.add(lightOnOff);

            front.add(row1);

            JPanel row2 = new JPanel();


            row2.add(finishGame);
            row2.add(newGameButton);
            row2.add(quitGame);
            bottom.add(row2);

            okvir.add(bottom, BorderLayout.SOUTH);
            okvir.add(front, BorderLayout.NORTH);

            lightOnOff.setFocusable(false);

            addShape.addActionListener(e -> {
                if (e.getSource() == addShape) {
                    if (pr.travers == 1) {
                    	p.left_idn = pr.nameID;
                    } else if (pr.travers == 2) {
                    	p.left_two_idn = pr.nameID;
                    } else if (pr.travers == 3) {
                    	p.right_idn = pr.nameID;
                    } else if (pr.travers == 4) {
                    	p.top_idn = pr.nameID;
                    } else if (pr.travers == 5) {
                    	p.top_two_idn = pr.nameID;
                    } else if (pr.travers == 6) {
                    	p.bottom_idn = pr.nameID;
                    } else if (pr.travers == 7) {
                    	p.bottom_two_idn = pr.nameID;
                    } else if (pr.travers == 8) {
                    	p.front_idn = pr.nameID;
                    } else if (pr.travers == 9) {
                    	p.back_idn = pr.nameID;
                    }
                }
                addShape.setFocusable(false);
            });

            removeShape.addActionListener(e -> {
                if (e.getSource() == removeShape) {

                    if (pr.travers == 1) {
                        p.left_idn = pr.nameID;
                    } else if (pr.travers == 2) {
                        p.left_two_idn = 0;
                    } else if (pr.travers == 3) {
                        p.right_idn = 0;
                    } else if (pr.travers == 4) {
                        p.top_idn = 0;
                    } else if (pr.travers == 5) {
                        p.top_two_idn = 0;
                    } else if (pr.travers == 6) {
                        p.bottom_idn = 0;
                    } else if (pr.travers == 7) {
                        p.bottom_two_idn = 0;
                    } else if (pr.travers == 8) {
                        p.front_idn = 0;
                    } else if (pr.travers == 9) {
                        p.back_idn = 0;
                    }
                }
                removeShape.setFocusable(false);
            });

            finishGame.addActionListener(e -> {
                if (e.getSource() == finishGame) {
                    pr.gameFinished = true;
                    p.addShapeRed = 0;
                    p.addShapeGreen = 200 / 255f;
                    p.addShapeBlue = 1;
                    pr.currentAngleOfVisibleField = 110;
                    pr.translateY = -2;
                }
                finishGame.setFocusable(false);
            });

            help.addActionListener(e -> {
                if (e.getSource() == help) {

                    JOptionPane.showMessageDialog(okvir, "Instructions: \n" +
                                    "W - traverse through the blueprint\n" +
                                    "A - reduce the scale of the shape inserted into the blueprint\n" +
                                    "S - increase the scale of the shape inserted into the blueprint\n" +
                                    "Z - increase the scale of the blueprint\n" +
                                    "X - reduce the scale of the blueprint\n" +
                                    "I - move the blueprint (translate) on the z-axis in positive direction\n" +
                                    "O - move the blueprint (translate) on the z-axis in negative direction\n" +
                                    "J - move the blueprint (translate) on the x-axis in positive direction \n" +
                                    "K - move the blueprint (translate) on the x-axis in negative direction\n" +
                                    "N - move the blueprint (translate) on the y-axis in positive direction\n" +
                                    "M - move the blueprint (translate) on the y-axis in negative direction\n" +


                                    "Add Button - after selecting a shape from the palette, you can add it to the selected blueprint shape by the Add button\n" +
                                    "Remove Button - after selecting a shape from the palette, you can remove it from the selected blueprint shape by the Remove button\n" +

                                    "Finish Button - after the game finished, by pressing on the finish button, you can see your results\n" +
                                    "New Game Button - generate a new game\n" +
                                    "Quit Button - quit from the game \n" +
                                    "Light - you can enable/disable different light models by checking/unchecking  the light chekboxes (global ambient light, ambient, diffuse and specular)\n" +


                                    "+ (Numerical Keypad 9)- zoom in\n" +
                                    "- (Numerical Keypad 9)- zoom out\n" +
                                    "Left arrow - negative rotation around the x-axis of the blueprint\n" +
                                    "Right arrow - positive rotation around the x-axis of the blueprint \n" +
                                    "Up arrow - negative rotation around the y-axis of the blueprint\n" +
                                    "Down arrow - positive rotation around the y-axis of the blueprint\n" +
                                    "1 (Numerical Keypad 1) - positive rotation around the x-axis of the shape inserted into the blueprint\n" +
                                    "3 (Numerical Keypad 3)- negative rotation around the x-axis of the shape inserted into the blueprint\n" +
                                    "4 (Numerical Keypad 4)- positive rotation around the y-axis of the shape inserted into the blueprint\n" +
                                    "6 (Numerical Keypad 6)- negative rotation around the y-axis of the shape inserted into the blueprint\n" +
                                    "7 (Numerical Keypad 7)- positive rotation around the z-axis of the shape inserted into the blueprint\n" +
                                    "9 (Numerical Keypad 9)- negative rotation around the y-axis of the shape inserted into the blueprint\n"
                            , "Help", JOptionPane.INFORMATION_MESSAGE);
                }
                help.setFocusable(false);
            });

            quitGame.addActionListener(e -> {
                if (e.getSource() == quitGame) {
                    animator.stop();
                    System.exit(0);

                }
                quitGame.setFocusable(false);
            });

            newGameButton.addActionListener(e -> {
                if (e.getSource() == newGameButton) {
                	pr.newGame = true;
                	pr.gameFinished = false;
                }
                newGameButton.setFocusable(false);
            });

            okvir.getContentPane().add(canvas);

            okvir.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    new Thread(() -> {
                        if (animator.isStarted()) animator.stop();
                        System.exit(0);
                    }).start();
                }
            });

            camera = new Camera();
            camera.lookAt(-5, 0, 3, 0, 0, 0, 0, 1, 0);
            camera.setScale(15);

            okvir.setTitle(TITLE);
            okvir.pack();
            okvir.setVisible(true);
            animator.start(); // start the animation loop
        });


    }

    @Override
    public void init(GLAutoDrawable drawable) {
        GL2 gl = drawable.getGL().getGL2();      // get the OpenGL graphics context

        gl.glClearColor(0.95f, 0.95f, 1f, 0);


        gl.glEnable(GL2.GL_DEPTH_TEST);
        gl.glEnable(GL2.GL_LIGHTING);
        gl.glEnable(GL2.GL_LIGHT0);
        gl.glEnable(GL2.GL_NORMALIZE);
        gl.glEnable(GL2.GL_COLOR_MATERIAL);

        gl.glLightModeli(GL2.GL_LIGHT_MODEL_TWO_SIDE, 1);
        gl.glMateriali(GL2.GL_FRONT_AND_BACK, GL2.GL_SHININESS, 100);


        float ambient[] = {0.1f, 0.1f, 0.1f, 1};
        float[] diffuse = {1.0f, 1.0f, 1.0f, 1.0f};
        float[] specular = {1.0f, 1.0f, 1.0f, 1.0f};
        gl.glLightfv(GL2.GL_LIGHT0, GL2.GL_AMBIENT, ambient, 0);
        gl.glLightfv(GL2.GL_LIGHT1, GL2.GL_DIFFUSE, diffuse, 0);
        gl.glLightfv(GL2.GL_LIGHT2, GL2.GL_SPECULAR, specular, 0);

        gl.glClearDepth(1.0f);      // set clear depth value to farthest
        gl.glEnable(GL2.GL_DEPTH_TEST); // enables depth testing
        gl.glDepthFunc(GL2.GL_LEQUAL);  // the type of depth test to do
        gl.glHint(GL2.GL_PERSPECTIVE_CORRECTION_HINT, GL2.GL_NICEST); // best perspective correction
        gl.glShadeModel(GL2.GL_SMOOTH); // blends colors nicely, and smoothes out lighting
        gl.glPolygonMode(GL2.GL_FRONT_AND_BACK, GL2.GL_FILL);
        glu = GLU.createGLU(gl); // get GL Utilities

        for (int i = 0; i < pr.textureFileNames.length; i++) {
            try {
                URL textureURL;
                textureURL = getClass().getClassLoader().getResource("textures/" + pr.textureFileNames[i]);
                if (textureURL != null) {
                    BufferedImage img = ImageIO.read(textureURL);
                    ImageUtil.flipImageVertically(img);
                    pr.textures[i] = AWTTextureIO.newTexture(GLProfile.getDefault(), img, true);
                    pr.textures[i].setTexParameteri(gl, GL2.GL_TEXTURE_WRAP_S, GL2.GL_REPEAT);
                    pr.textures[i].setTexParameteri(gl, GL2.GL_TEXTURE_WRAP_T, GL2.GL_REPEAT);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        pr.textures[0].enable(gl);

        textRenderer = new TextRenderer(new Font("SansSerif", Font.PLAIN, 12));
        textMatch = new TextRenderer(new Font("SansSerif", Font.BOLD, 20));
    }

    @Override
    public void dispose(GLAutoDrawable drawable) {
    }

    @Override
    public void display(GLAutoDrawable drawable) {
        GL2 gl = drawable.getGL().getGL2();
        gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT);


        if (pr.inSelectionMode) {
        	obliciIgre.pickModels(drawable, igra,  selectBuffer,  xCursor,  yCursor,  glu);
        } else { // normal rendering
            p.palette( drawable,  pr.windowWidth,  pr.windowHeight,  pr.aspectP,  glu);
            obliciIgre.drawBlueprint(drawable, glu);
            
        }

        camera.apply(gl);
        lights(gl);

        float zero[] = {0, 0, 0, 1};

        if (this.selectedLighting == LigthsTypesEnum.AMBIENT_LIGTH) { 
            gl.glLightModelfv(GL2.GL_LIGHT_MODEL_AMBIENT, new float[]{0.1F, 0.1F, 0.1F, 1}, 0);
        } else {
            gl.glLightModelfv(GL2.GL_LIGHT_MODEL_AMBIENT, zero, 0);
        }

        gl.glMaterialfv(GL2.GL_FRONT_AND_BACK, GL2.GL_SPECULAR, new float[]{0.1F, 0.1F, 0.1F, 1}, 0);

        if (pr.gameFinished) {

            provera.printResult(drawable, textRenderer);
        }

        if (!pr.gameFinished) {

            provera.printMatch(drawable, textMatch);
        }


        if (pr.newGame) {
            igra.newGame();
            pr.newGame = false;
        }
    }

    @Override
    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        pr.windowWidth = width;
        pr.windowHeight = height;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {

            // X-rotation
        case KeyEvent.VK_NUMPAD1:

            if (pr.travers == 1) {
                if (pr.angleLeftX < 360) {
                    pr.angleLeftX += pr.angleDelta;
                    System.out.println(pr.angleLeftX);
                }
            } else if (pr.travers == 2) {
                if (pr.angleLeftTwoX < 360) {
                    pr.angleLeftTwoX += pr.angleDelta;
                    System.out.println(pr.angleLeftTwoX);
                }
            } else if (pr.travers == 3) {
                if (pr.angleRightX < 360) {
                    pr.angleRightX += pr.angleDelta;
                    System.out.println(pr.angleRightX);
                }
            } else if (pr.travers == 4) {
                if (pr.angleTopX < 360) {
                    pr.angleTopX += pr.angleDelta;
                    System.out.println(pr.angleTopX);
                }
            } else if (pr.travers == 5) {
                if (pr.angleTopTwoX < 360) {
                    pr.angleTopTwoX += pr.angleDelta;
                    System.out.println(pr.angleTopTwoX);
                }
            } else if (pr.travers == 6) {
                if (pr.angleBottomX < 360) {
                    pr.angleBottomX += pr.angleDelta;
                    System.out.println(pr.angleBottomX);
                }
            } else if (pr.travers == 7) {
                if (pr.angleBottomTwoX < 360) {
                    pr.angleBottomTwoX += pr.angleDelta;
                    System.out.println(pr.angleBottomTwoX);
                }
            } else if (pr.travers == 8) {
                if (pr.angleFrontX < 360) {
                    pr.angleFrontX += pr.angleDelta;
                    System.out.println(pr.angleFrontX);
                }
            } else if (pr.travers == 9) {
                if (pr.angleBackX < 360) {
                    pr.angleBackX += pr.angleDelta;
                    System.out.println(pr.angleBackX);
                }
            }
            break;
        case KeyEvent.VK_NUMPAD3:

            if (pr.travers == 1) {
                if (pr.angleLeftX > 0) {
                    pr.angleLeftX -= pr.angleDelta;
                    System.out.println(pr.angleLeftX);
                }
            } else if (pr.travers == 2) {
                if (pr.angleLeftTwoX > 0) {
                    pr.angleLeftTwoX -= pr.angleDelta;
                    System.out.println(pr.angleLeftTwoX);
                }
            } else if (pr.travers == 3) {
                if (pr.angleRightX > 0) {
                    pr.angleRightX -= pr.angleDelta;
                    System.out.println(pr.angleRightX);
                }
            } else if (pr.travers == 4) {
                if (pr.angleTopX > 0) {
                    pr.angleTopX -= pr.angleDelta;
                    System.out.println(pr.angleTopX);
                }
            } else if (pr.travers == 5) {
                if (pr.angleTopTwoX > 0) {
                    pr.angleTopTwoX -= pr.angleDelta;
                    System.out.println(pr.angleTopTwoX);
                }
            } else if (pr.travers == 6) {
                if (pr.angleBottomX > 0) {
                    pr.angleBottomX -= pr.angleDelta;
                    System.out.println(pr.angleBottomX);
                }
            } else if (pr.travers == 7) {
                if (pr.angleBottomTwoX > 0) {
                    pr.angleBottomTwoX -= pr.angleDelta;
                    System.out.println(pr.angleBottomTwoX);
                }
            } else if (pr.travers == 8) {
                if (pr.angleFrontX > 0) {
                    pr.angleFrontX -= pr.angleDelta;
                    System.out.println(pr.angleFrontX);
                }
            } else if (pr.travers == 9) {
                if (pr.angleBackX > 0) {
                    pr.angleBackX -= pr.angleDelta;
                    System.out.println(pr.angleBackX);
                }
            }

                break;

            // Y-rotation
            case KeyEvent.VK_NUMPAD4:

                if (pr.travers == 1) {
                    if (pr.angleLeftY < 360) {
                        pr.angleLeftY += pr.angleDelta;
                        System.out.println(pr.angleLeftY);
                    }
                } else if (pr.travers == 2) {
                    if (pr.angleLeftTwoY < 360) {
                        pr.angleLeftTwoY += pr.angleDelta;
                        System.out.println(pr.angleLeftTwoY);
                    }
                } else if (pr.travers == 3) {
                    if (pr.angleRightY < 360) {
                        pr.angleRightY += pr.angleDelta;
                        System.out.println(pr.angleRightY);
                    }
                } else if (pr.travers == 4) {
                    if (pr.angleTopY < 360) {
                        pr.angleTopY += pr.angleDelta;
                        System.out.println(pr.angleTopY);
                    }
                } else if (pr.travers == 5) {
                    if (pr.angleTopTwoY < 360) {
                        pr.angleTopTwoY += pr.angleDelta;
                        System.out.println(pr.angleTopTwoY);
                    }
                } else if (pr.travers == 6) {
                    if (pr.angleBottomY < 360) {
                        pr.angleBottomY += pr.angleDelta;
                        System.out.println(pr.angleBottomY);
                    }
                } else if (pr.travers == 7) {
                    if (pr.angleBottomTwoY < 360) {
                        pr.angleBottomTwoY += pr.angleDelta;
                        System.out.println(pr.angleBottomTwoY);
                    }
                } else if (pr.travers == 8) {
                    if (pr.angleFrontY < 360) {
                        pr.angleFrontY += pr.angleDelta;
                        System.out.println(pr.angleFrontY);
                    }
                } else if (pr.travers == 9) {
                    if (pr.angleBackY < 360) {
                        pr.angleBackY += pr.angleDelta;
                        System.out.println(pr.angleBackY);
                    }
                }
                break;
            case KeyEvent.VK_NUMPAD6:

                if (pr.travers == 1) {
                    if (pr.angleLeftY > 0) {
                        pr.angleLeftY -= pr.angleDelta;
                        System.out.println(pr.angleLeftY);
                    }
                } else if (pr.travers == 2) {
                    if (pr.angleLeftTwoY > 0) {
                        pr.angleLeftTwoY -= pr.angleDelta;
                        System.out.println(pr.angleLeftTwoY);
                    }
                } else if (pr.travers == 3) {
                    if (pr.angleRightY > 0) {
                        pr.angleRightY -= pr.angleDelta;
                        System.out.println(pr.angleRightY);
                    }
                } else if (pr.travers == 4) {
                    if (pr.angleTopY > 0) {
                        pr.angleTopY -= pr.angleDelta;
                        System.out.println(pr.angleTopY);
                    }
                } else if (pr.travers == 5) {
                    if (pr.angleTopTwoY > 0) {
                        pr.angleTopTwoY -= pr.angleDelta;
                        System.out.println(pr.angleTopTwoY);
                    }
                } else if (pr.travers == 6) {
                    if (pr.angleBottomY > 0) {
                        pr.angleBottomY -= pr.angleDelta;
                        System.out.println(pr.angleBottomY);
                    }
                } else if (pr.travers == 7) {
                    if (pr.angleBottomTwoY > 0) {
                        pr.angleBottomTwoY -= pr.angleDelta;
                        System.out.println(pr.angleBottomTwoY);
                    }
                } else if (pr.travers == 8) {
                    if (pr.angleFrontY > 0) {
                        pr.angleFrontY -= pr.angleDelta;
                        System.out.println(pr.angleFrontY);
                    }
                } else if (pr.travers == 9) {
                    if (pr.angleBackY > 0) {
                        pr.angleBackY -= pr.angleDelta;
                        System.out.println(pr.angleBackY);
                    }
                }

                break;

            // Z-rotation
            case KeyEvent.VK_NUMPAD7:

                if (pr.travers == 1) {
                    if (pr.angleLeftZ < 360) {
                        pr.angleLeftZ += pr.angleDelta;
                        System.out.println(pr.angleLeftZ);
                    }
                } else if (pr.travers == 2) {
                    if (pr.angleLeftTwoZ < 360) {
                        pr.angleLeftTwoZ += pr.angleDelta;
                        System.out.println(pr.angleLeftTwoZ);
                    }
                } else if (pr.travers == 3) {
                    if (pr.angleRightZ < 360) {
                        pr.angleRightZ += pr.angleDelta;
                        System.out.println(pr.angleRightZ);
                    }
                } else if (pr.travers == 4) {
                    if (pr.angleTopZ < 360) {
                        pr.angleTopZ += pr.angleDelta;
                        System.out.println(pr.angleTopZ);
                    }
                } else if (pr.travers == 5) {
                    if (pr.angleTopTwoZ < 360) {
                        pr.angleTopTwoZ += pr.angleDelta;
                        System.out.println(pr.angleTopTwoZ);
                    }
                } else if (pr.travers == 6) {
                    if (pr.angleBottomZ < 360) {
                        pr.angleBottomZ += pr.angleDelta;
                        System.out.println(pr.angleBottomZ);
                    }
                } else if (pr.travers == 7) {
                    if (pr.angleBottomTwoZ < 360) {
                        pr.angleBottomTwoZ += pr.angleDelta;
                        System.out.println(pr.angleBottomTwoZ);
                    }
                } else if (pr.travers == 8) {
                    if (pr.angleFrontZ < 360) {
                        pr.angleFrontZ += pr.angleDelta;
                        System.out.println(pr.angleFrontZ);
                    }
                } else if (pr.travers == 9) {
                    if (pr.angleBackZ < 360) {
                        pr.angleBackZ += pr.angleDelta;
                        System.out.println(pr.angleBackZ);
                    }
                }
                break;
            case KeyEvent.VK_NUMPAD9:

                if (pr.travers == 1) {
                    if (pr.angleLeftZ > 0) {
                        pr.angleLeftZ -= pr.angleDelta;
                        System.out.println(pr.angleLeftZ);
                    }
                } else if (pr.travers == 2) {
                    if (pr.angleLeftTwoZ > 0) {
                        pr.angleLeftTwoZ -= pr.angleDelta;
                        System.out.println(pr.angleLeftZ);
                    }
                } else if (pr.travers == 3) {
                    if (pr.angleRightZ > 0) {
                        pr.angleRightZ -= pr.angleDelta;
                        System.out.println(pr.angleRightZ);
                    }
                } else if (pr.travers == 4) {
                    if (pr.angleTopZ > 0) {
                        pr.angleTopZ -= pr.angleDelta;
                        System.out.println(pr.angleTopZ);
                    }
                } else if (pr.travers == 5) {
                    if (pr.angleTopTwoZ > 0) {
                        pr.angleTopTwoZ -= pr.angleDelta;
                        System.out.println(pr.angleTopTwoZ);
                    }
                } else if (pr.travers == 6) {
                    if (pr.angleBottomZ > 0) {
                        pr.angleBottomZ -= pr.angleDelta;
                        System.out.println(pr.angleBottomZ);
                    }
                } else if (pr.travers == 7) {
                    if (pr.angleBottomTwoZ > 0) {
                        pr.angleBottomTwoZ -= pr.angleDelta;
                        System.out.println(pr.angleBottomTwoZ);
                    }
                } else if (pr.travers == 8) {
                    if (pr.angleFrontZ > 0) {
                        pr.angleFrontZ -= pr.angleDelta;
                        System.out.println(pr.angleFrontZ);
                    }
                } else if (pr.travers == 9) {
                    if (pr.angleBackZ > 0) {
                        pr.angleBackZ -= pr.angleDelta;
                        System.out.println(pr.angleBackZ);
                    }
                }

                break;

            case KeyEvent.VK_S:

                if (pr.travers == 1) {
                    pr.scaleLeft += pr.scaleDelta;
                    System.out.println(pr.scaleLeft + "Left pr.scale");
                } else if (pr.travers == 2) {
                    pr.scaleLeftTwo += pr.scaleDelta;
                } else if (pr.travers == 3) {
                    pr.scaleRight += pr.scaleDelta;
                } else if (pr.travers == 4) {
                    pr.scaleTop += pr.scaleDelta;
                } else if (pr.travers == 5) {
                    pr.scaleTopTwo += pr.scaleDelta;
                } else if (pr.travers == 6) {
                    pr.scaleBottom += pr.scaleDelta;
                } else if (pr.travers == 7) {
                    pr.scaleBottomTwo += pr.scaleDelta;
                } else if (pr.travers == 8) {
                    pr.scaleFront += pr.scaleDelta;
                } else if (pr.travers == 9) {
                    pr.scaleBack += pr.scaleDelta;
                }

                break;
            case KeyEvent.VK_A:
                System.out.println(pr.travers);
                if (pr.travers == 1) {
                    pr.scaleLeft -= pr.scaleDelta;
                } else if (pr.travers == 2) {
                    pr.scaleLeftTwo -= pr.scaleDelta;
                } else if (pr.travers == 3) {
                    pr.scaleRight -= pr.scaleDelta;
                } else if (pr.travers == 4) {
                    pr.scaleTop -= pr.scaleDelta;
                } else if (pr.travers == 5) {
                    pr.scaleTopTwo -= pr.scaleDelta;
                } else if (pr.travers == 6) {
                    pr.scaleBottom -= pr.scaleDelta;
                } else if (pr.travers == 7) {
                    pr.scaleBottomTwo -= pr.scaleDelta;
                } else if (pr.travers == 8) {
                    pr.scaleFront -= pr.scaleDelta;
                } else if (pr.travers == 9) {
                    pr.scaleBack -= pr.scaleDelta;
                    System.out.println(pr.scaleBack);
                    System.out.println(pr.travers);
                }

                break;

            case KeyEvent.VK_W:
                pr.travers++;
                p.colorShape(pr.travers);
                if (pr.travers == 10) {
                    pr.travers = 0;
                }
                break;
            case KeyEvent.VK_UP:
                pr.currentAngleOfRotationX--;
                break;
            case KeyEvent.VK_DOWN:
                pr.currentAngleOfRotationX++;
                break;
            case KeyEvent.VK_LEFT:
                pr.currentAngleOfRotationY++;
                break;
            case KeyEvent.VK_RIGHT:
                pr.currentAngleOfRotationY--;

                break;
            case KeyEvent.VK_ADD:
                if (pr.currentAngleOfVisibleField > 1) {
                    pr.currentAngleOfVisibleField--;
                }
                break;
            case KeyEvent.VK_SUBTRACT:
                if (pr.currentAngleOfVisibleField < 179) {
                    pr.currentAngleOfVisibleField++;
                }
                break;

            case KeyEvent.VK_Z:
                pr.scale += 0.1;
                break;

            case KeyEvent.VK_X:
                pr.scale -= 0.1;
                break;

            case KeyEvent.VK_J:
                pr.translateX += 0.1;
                break;
            case KeyEvent.VK_K:
                pr.translateX -= 0.1;
                break;

            case KeyEvent.VK_M:
                pr.translateY += 0.1;
                break;
            case KeyEvent.VK_N:
                pr.translateY -= 0.1;
                break;
            case KeyEvent.VK_I:
                pr.translateZ += 0.1;
                break;
            case KeyEvent.VK_O:
                pr.translateZ -= 0.1;
                break;
            case KeyEvent.VK_ESCAPE:
                animator.stop();
                System.exit(0);
                break;
        }
    }


    @Override
    public void keyReleased(KeyEvent e) {

    }


    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        switch (e.getButton()) {
            case MouseEvent.BUTTON1: { // left button
                xCursor = e.getX();
                yCursor = e.getY();
                pr.inSelectionMode = true;
                break;
            }
            case MouseEvent.BUTTON3: { // right button
                break;
            }
        }
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


    private void lights(GL2 gl) {
         gl.glColor3d(0.5, 0.5, 0.5);
        float zero[] = {0, 0, 0, 1};
        gl.glMaterialfv(GL2.GL_FRONT_AND_BACK, GL2.GL_SPECULAR, zero, 0);

        if (lightOnOff.isSelected())
            gl.glDisable(GL2.GL_LIGHTING);
        else
            gl.glEnable(GL2.GL_LIGHTING);

        float ambient[] = {0.1f, 0.1f, 0.1f, 1};
        float[] diffuse = {1.0f, 1.0f, 1.0f, 1.0f};
        float[] specular = {1.0f, 1.0f, 1.0f, 1.0f};

        if (this.selectedLighting == LigthsTypesEnum.AMBIENT_LIGHTING) {
            gl.glMaterialfv(GL2.GL_FRONT_AND_BACK, GL2.GL_EMISSION, ambient, 0);
            gl.glEnable(GL2.GL_LIGHT0);
        } else {
            gl.glMaterialfv(GL2.GL_FRONT_AND_BACK, GL2.GL_EMISSION, zero, 0);
            gl.glDisable(GL2.GL_LIGHT0);
        }

        if (this.selectedLighting == LigthsTypesEnum.DIFFUSE_LIGHTING) {
            gl.glMaterialfv(GL2.GL_FRONT_AND_BACK, GL2.GL_EMISSION, diffuse, 0);
            gl.glEnable(GL2.GL_LIGHT1);
        } else {
            gl.glMaterialfv(GL2.GL_FRONT_AND_BACK, GL2.GL_EMISSION, zero, 0);
            gl.glDisable(GL2.GL_LIGHT1);
        }

        if (this.selectedLighting == LigthsTypesEnum.SPECULAR_LIGHTUNG) {
            float[] shiness = {5.0f};
            gl.glMaterialfv(GL2.GL_FRONT_AND_BACK, GL2.GL_EMISSION, specular, 0);
            gl.glMaterialfv(GL2.GL_FRONT_AND_BACK, GL2.GL_SHININESS, shiness, 0);
            gl.glEnable(GL2.GL_LIGHT2);
        } else {
            gl.glMaterialfv(GL2.GL_FRONT_AND_BACK, GL2.GL_EMISSION, zero, 0);
            gl.glDisable(GL2.GL_LIGHT2);
        }

        gl.glMaterialfv(GL2.GL_FRONT_AND_BACK, GL2.GL_EMISSION, zero, 0); // Turn off emission color!
    }

    public void writeText(String tekst, int x, int y) {
        textRenderer.beginRendering(pr.windowWidth, pr.windowHeight);
        textRenderer.setColor(0.3f, 0.3f, 0.5f, 1);
        textRenderer.draw(tekst, x, y);
        textRenderer.endRendering();
    }

    public void writeMatch(String text, int x, int y) {
        textMatch.beginRendering(pr.windowWidth, pr.windowHeight);
        textMatch.setColor(0.3f, 0.3f, 0.5f, 1);
        textMatch.draw(text, x, y);
        textMatch.endRendering();
    }

    public static void main(String[] args) {
    	Paleta p = new Paleta();
    	Promenljive pr = new Promenljive();
        new Exam(p, pr);
    }
}
