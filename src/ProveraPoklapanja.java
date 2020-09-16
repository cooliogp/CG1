import com.jogamp.opengl.*;
import com.jogamp.opengl.util.awt.TextRenderer;


public class ProveraPoklapanja {
	private Paleta p;
    Promenljive pr;
	
	public ProveraPoklapanja(Paleta paleta, Promenljive promenljive) {
		p = paleta; 
    	pr = promenljive;
	}
	
	public void writeText(String tekst, int x, int y, TextRenderer textRenderer) {
        textRenderer.beginRendering(pr.windowWidth, pr.windowHeight);
        textRenderer.setColor(0.3f, 0.3f, 0.5f, 1);
        textRenderer.draw(tekst, x, y);
        textRenderer.endRendering();
    }
	
	public void writeMatch(String text, int x, int y, TextRenderer textMatch) {
        textMatch.beginRendering(pr.windowWidth, pr.windowHeight);
        textMatch.setColor(0.3f, 0.3f, 0.5f, 1);
        textMatch.draw(text, x, y);
        textMatch.endRendering();
    }
	
	public void printMatch(GLAutoDrawable drawable, TextRenderer textMatch) {

        if (pr.travers == 1) {
            if (Promenljive.shape[pr.randomL].equals(Promenljive.shape[p.left_idn]))
                if (leftScaleCheck(pr.scaleLeft).equals("appropriate") && rotationCheck(pr.randomL, pr.angleLeftX, pr.angleLeftY, pr.angleLeftZ).equals("correct")) {
                    writeMatch("Well Done! Correct Promenljive.shape, rotation and scaling.",
                            (int) (pr.windowWidth / 4f), pr.windowHeight - 40, textMatch);
                }
        } else if (pr.travers == 2) {
            if (Promenljive.shape[pr.randomL2].equals(Promenljive.shape[p.left_two_idn]))
                if (leftTwoScaleCheck(pr.scaleLeftTwo).equals("appropriate") && rotationCheck(pr.randomL2, pr.angleLeftTwoX, pr.angleLeftTwoY, pr.angleLeftTwoZ).equals("correct")) {
                    writeMatch("Well Done! Correct Promenljive.shape, rotation and scaling.",
                            (int) (pr.windowWidth / 4f), pr.windowHeight - 40, textMatch);
                }
        } else if (pr.travers == 3) {

            if (Promenljive.shape[pr.randomR].equals(Promenljive.shape[p.right_idn]))
                if (rightScaleCheck(pr.scaleRight).equals("appropriate")
                        && rotationCheck(pr.randomR, pr.angleRightX, pr.angleRightY, pr.angleRightZ).equals("correct")) {
                    writeMatch("Well Done! Correct Promenljive.shape, rotation and scaling.",
                            (int) (pr.windowWidth / 4f), pr.windowHeight - 40, textMatch);
                }
        } else if (pr.travers == 4) {
            if (Promenljive.shape[pr.randomT].equals(Promenljive.shape[p.top_idn]))
                if (topScaleCheck(pr.scaleTop).equals("appropriate")
                        && rotationCheck(pr.randomT, pr.angleTopX, pr.angleTopY, pr.angleTopZ).equals("correct")) {
                    writeMatch("Well Done! Correct Promenljive.shape, rotation and scaling.",
                            (int) (pr.windowWidth / 4f), pr.windowHeight - 40, textMatch);
                }

        } else if (pr.travers == 5) {
            if (Promenljive.shape[pr.randomT2].equals(Promenljive.shape[p.top_two_idn]))
                if (topTwoScaleCheck(pr.scaleTopTwo).equals("appropriate")
                        && rotationCheck(pr.randomT2, pr.angleTopTwoX, pr.angleTopTwoY, pr.angleTopTwoZ).equals("correct")) {
                    writeMatch("Well Done! Correct Promenljive.shape, rotation and scaling.",
                            (int) (pr.windowWidth / 4f), pr.windowHeight - 40, textMatch);
                }

        } else if (pr.travers == 6) {
            if (Promenljive.shape[pr.randomBot].equals(Promenljive.shape[p.bottom_idn]))
                if (bottomTwoScaleCheck(pr.scaleBottom).equals("appropriate")
                        && rotationCheck(pr.randomBot, pr.angleBottomX, pr.angleBottomY, pr.angleBottomZ).equals("correct")) {
                    writeMatch("Well Done! Correct Promenljive.shape, rotation and scaling.",
                            (int) (pr.windowWidth / 4f), pr.windowHeight - 40, textMatch);
                }

        } else if (pr.travers == 7) {
            if (Promenljive.shape[pr.randomBot2].equals(Promenljive.shape[p.bottom_two_idn]))
                if (bottomTwoScaleCheck(pr.scaleBottomTwo).equals("appropriate")
                        && rotationCheck(pr.randomBot2, pr.angleBottomTwoX, pr.angleBottomTwoY, pr.angleBottomTwoZ).equals("correct")) {
                    writeMatch("Well Done! Correct Promenljive.shape, rotation and scaling.",
                            (int) (pr.windowWidth / 4f), pr.windowHeight - 40, textMatch);
                }

        } else if (pr.travers == 8) {
            if (Promenljive.shape[pr.randomF].equals(Promenljive.shape[p.front_idn]))
                if (frontScaleCheck(pr.scaleFront).equals("appropriate")
                        && rotationCheck(pr.randomF, pr.angleFrontX, pr.angleFrontY, pr.angleFrontZ).equals("correct")) {
                    writeMatch("Well Done! Correct Promenljive.shape, rotation and scaling.",
                            (int) (pr.windowWidth / 4f), pr.windowHeight - 40, textMatch);
                }

        } else if (pr.travers == 9) {
            if (Promenljive.shape[pr.randomB].equals(Promenljive.shape[p.back_idn]))
                if (backScaleCheck(pr.scaleBack).equals("appropriate")
                        && rotationCheck(pr.randomB, pr.angleBackX, pr.angleBackY, pr.angleBackZ).equals("correct")) {
                    writeMatch("Well Done! Correct Promenljive.shape, rotation and scaling.",
                            (int) (pr.windowWidth / 4f), pr.windowHeight - 40, textMatch);
                }
        }
    }

    public void printResult(GLAutoDrawable drawable, TextRenderer textRenderer) {
        writeText("RESULT: " + matchedShape() + "/9 Promenljive.shape matched correctly", (int) (pr.windowWidth / 3.5f), pr.windowHeight - 40, textRenderer);

        writeText("Left One: blueprint Promenljive.shape: " +
                        Promenljive.shape[pr.randomL] +
                        " - matched Promenljive.shape: " +
                        Promenljive.shape[p.left_idn] + " Scaling: " +
                        leftScaleCheck(pr.scaleLeft) +
                        " Rotation: " + rotationCheck(pr.randomL, pr.angleLeftX, pr.angleLeftY, pr.angleLeftZ),
                (int) (pr.windowWidth / 3.5f),
                pr.windowHeight - 60, textRenderer);

        writeText("Left Two: blueprint Promenljive.shape: " +
                        Promenljive.shape[pr.randomL2] +
                        " - matched Promenljive.shape: " +
                        Promenljive.shape[p.left_two_idn] + " Scaling: " +
                        leftTwoScaleCheck(pr.scaleLeftTwo) +
                        " Rotation: " + rotationCheck(pr.randomL2, pr.angleLeftTwoX, pr.angleLeftTwoY, pr.angleLeftTwoZ),
                (int) (pr.windowWidth / 3.5f),
                pr.windowHeight - 80, textRenderer);

        writeText("Right: blueprint Promenljive.shape: " +
                        Promenljive.shape[pr.randomR] +
                        " - matched Promenljive.shape: " +
                        Promenljive.shape[p.right_idn] + " Scaling: " +
                        rightScaleCheck(pr.scaleRight) +
                        " Rotation: " + rotationCheck(pr.randomR, pr.angleRightX, pr.angleRightY, pr.angleRightZ),
                (int) (pr.windowWidth / 3.5f),
                pr.windowHeight - 100, textRenderer);

        writeText("Top One: blueprint Promenljive.shape: " +
                        Promenljive.shape[pr.randomT] +
                        " - matched Promenljive.shape: " +
                        Promenljive.shape[p.top_idn] + " Scaling: " +
                        topScaleCheck(pr.scaleTop) +
                        " Rotation: " + rotationCheck(pr.randomT, pr.angleTopX, pr.angleTopY, pr.angleTopZ),
                (int) (pr.windowWidth / 3.5f),
                pr.windowHeight - 120, textRenderer);

        writeText("Top Two: blueprint Promenljive.shape: " +
                        Promenljive.shape[pr.randomT2] +
                        " - matched Promenljive.shape: " +
                        Promenljive.shape[p.top_two_idn] + " Scaling: " +
                        topTwoScaleCheck(pr.scaleTopTwo) +
                        " Rotation: " + rotationCheck(pr.randomT2, pr.angleTopTwoX, pr.angleTopTwoY, pr.angleTopTwoZ),
                (int) (pr.windowWidth / 3.5f),
                pr.windowHeight - 140, textRenderer);

        writeText("Bottom One: blueprint Promenljive.shape: " +
                        Promenljive.shape[pr.randomBot] +
                        " - matched Promenljive.shape: " +
                        Promenljive.shape[p.bottom_idn] + " Scaling: " +
                        bottomScaleCheck(pr.scaleBottom) +
                        " Rotation: " + rotationCheck(pr.randomBot, pr.angleBottomX, pr.angleBottomY, pr.angleBottomZ),
                (int) (pr.windowWidth / 3.5f),
                pr.windowHeight - 160, textRenderer);

        writeText("Bottom Two: blueprint Promenljive.shape: " +
                        Promenljive.shape[pr.randomBot2] +
                        " - matched Promenljive.shape: " +
                        Promenljive.shape[p.bottom_two_idn] + " Scaling: " +
                        bottomTwoScaleCheck(pr.scaleBottomTwo) +
                        " Rotation: " + rotationCheck(pr.randomBot2, pr.angleBottomTwoX, pr.angleBottomTwoY, pr.angleBottomTwoZ),
                (int) (pr.windowWidth / 3.5f),
                pr.windowHeight - 180, textRenderer);

        writeText("Front: blueprint Promenljive.shape: " +
                        Promenljive.shape[pr.randomF] +
                        " - matched Promenljive.shape: " +
                        Promenljive.shape[p.front_idn] + " Scaling: " +
                        frontScaleCheck(pr.scaleFront) +
                        " Rotation: " + rotationCheck(pr.randomF, pr.angleFrontX, pr.angleFrontY, pr.angleFrontZ),
                (int) (pr.windowWidth / 3.5f),
                pr.windowHeight - 200, textRenderer);

        writeText("Back: blueprint Promenljive.shape: " +
                        Promenljive.shape[pr.randomB] +
                        " - matched Promenljive.shape: " +
                        Promenljive.shape[p.back_idn] + " Scaling: " +
                        backScaleCheck(pr.scaleBack) +
                        " Rotation: " + rotationCheck(pr.randomB, pr.angleBackX, pr.angleBackY, pr.angleBackZ),
                (int) (pr.windowWidth / 3.5f),
                pr.windowHeight - 220, textRenderer);
    }

    private int matchedShape() {

        int match = 0;

        if (Promenljive.shape[pr.randomL].equals(Promenljive.shape[p.left_idn])) {
            match++;
        }
        if (Promenljive.shape[pr.randomL2].equals(Promenljive.shape[p.left_two_idn])) {
            match++;
        }
        if (Promenljive.shape[pr.randomR].equals(Promenljive.shape[p.right_idn])) {
            match++;
        }
        if (Promenljive.shape[pr.randomT].equals(Promenljive.shape[p.top_idn])) {
            match++;
        }
        if (Promenljive.shape[pr.randomT2].equals(Promenljive.shape[p.top_two_idn])) {
            match++;
        }
        if (Promenljive.shape[pr.randomBot].equals(Promenljive.shape[p.bottom_idn])) {
            match++;
        }
        if (Promenljive.shape[pr.randomBot2].equals(Promenljive.shape[p.bottom_two_idn])) {
            match++;
        }
        if (Promenljive.shape[pr.randomF].equals(Promenljive.shape[p.front_idn])) {
            match++;
        }
        if (Promenljive.shape[pr.randomB].equals(Promenljive.shape[p.back_idn])) {
            match++;
        }
        return match;
    }

    public String leftScaleCheck(double scale) {

        double scaling = Math.round(scale * 100.0) / 100.0;

        String text;
        if (scaling == 0.5) {
            text = "appropriate";
        } else {
            text = "not appropriate";
        }
        return text;
    }

    public String leftTwoScaleCheck(double scale) {

        double scaling = Math.round(scale * 100.0) / 100.0;

        String text;
        if (scaling == 0.5) {
            text = "appropriate";
        } else {
            text = "not appropriate";
        }
        return text;
    }

    public String rightScaleCheck(double scale) {

        double scaling = Math.round(scale * 100.0) / 100.0;

        String text;
        if (scaling == 0.75) {
            text = "appropriate";
        } else {
            text = "not appropriate";
        }
        return text;
    }

    public String topScaleCheck(double scale) {

        double scaling = Math.round(scale * 100.0) / 100.0;

        String text;
        if (scaling == 1.0) {
            text = "appropriate";
        } else {
            text = "not appropriate";
        }
        return text;
    }


    public String topTwoScaleCheck(double scale) {

        double scaling = Math.round(scale * 100.0) / 100.0;

        String text;
        if (scaling == 1.0) {
            text = "appropriate";
        } else {
            text = "not appropriate";
        }
        return text;
    }

    public String bottomScaleCheck(double scale) {

        double scaling = Math.round(scale * 100.0) / 100.0;

        String text;
        if (scaling == 1.25) {
            text = "appropriate";
        } else {
            text = "not appropriate";
        }
        return text;
    }

    public String bottomTwoScaleCheck(double scale) {

        double scaling = Math.round(scale * 100.0) / 100.0;

        String text;
        if (scaling == 1.25) {
            text = "appropriate";
        } else {
            text = "not appropriate";
        }
        return text;
    }

    public String frontScaleCheck(double scale) {

        double scaling = Math.round(scale * 100.0) / 100.0;

        String text;
        if (scaling == 1.5) {
            text = "appropriate";
        } else {
            text = "not appropriate";
        }
        return text;
    }

    public String backScaleCheck(double scale) {

        double scaling = Math.round(scale * 100.0) / 100.0;

        String text;
        if (scaling == 1.75) {
            text = "appropriate";
        } else {
            text = "not appropriate";
        }
        return text;
    }

    public String rotationCheck(int shape, int angleX, int angleY, int angleZ) {

        // shape #:
        // 1 - SPHERE
        // 2 - CYLINDER
        // 3 - CONE
        // 4 - CUBE
        // 5 - CUBOID
        // 6 - TETRAHEDRON
        // 7 - RECTANGULAR_PYRAMID
        // 8 - PENTAGON_PYRAMID
        // 9 - HEXAGON_PYRAMID


        String text;
        if (shape == 1) {
            text = "correct";
        } else if (shape == 2) {
            // x and y
            if ((angleX == 0 || angleX == 360 || angleX == 180) && (angleY == 0 || angleY == 360 || angleY == 180)) {
                text = "correct";
            } else {
                text = "incorrect";
            }
        } else if (shape == 6) {
            // x, y and z
            if ((angleX == 180 && angleY == 180 && angleZ == 180) ||
                    ((angleX == 0 || angleX == 360 || angleX == 180) &&
                            (angleY == 0 || angleY == 360 || angleY == 180)
                            && (angleZ == 0 || angleZ == 360))) {
                text = "correct";
            } else {
                text = "incorrect";
            }
        } else if (shape == 3) {
            // x, y and z
            if ((angleX == 180 && angleY == 180) || ((angleX == 0 || angleX == 360) && (angleY == 0 || angleY == 360))) {
                text = "correct";
            } else {
                text = "incorrect";
            }
        } else if (shape == 5) {
            // x, y and z
            if (((angleX == 0 || angleX == 360 || angleX == 180 || angleX == 270 || angleX == 90) &&
                    (angleY == 0 || angleY == 360 || angleY == 180) &&
                    (angleZ == 0 || angleZ == 360 || angleZ == 180))) {
                text = "correct";
            } else {
                text = "incorrect";
            }
        } else if (shape == 4) {
            // x, y and z
            if (((angleX == 0 || angleX == 360 || angleX == 180 || angleX == 270 || angleX == 90) &&
                    (angleY == 0 || angleY == 360 || angleY == 180 || angleY == 270 || angleY == 90) &&
                    (angleZ == 0 || angleZ == 360 || angleZ == 180 || angleZ == 270 || angleZ == 90))) {
                text = "correct";
            } else {
                text = "incorrect";
            }
        } else if (shape == 7) {
            // x, y and z
            if (((angleX == 0) &&
                    (angleY == 0 || angleY == 90 || angleY == 180 || angleY == 270 || angleY == 360) &&
                    (angleZ == 0 || angleZ == 360)) ||
                    ((angleX == 90) && (angleY == 90) && (angleZ == 90)) ||
                    ((angleX == 90) && (angleY == 270) && (angleZ == 270)) ||
                    ((angleX == 180) && (angleY == 0 || angleY == 90 || angleY == 180 || angleY == 270 || angleY == 360) && (angleZ == 180))) {
                text = "correct";
            } else {
                text = "incorrect";
            }
        } else if (shape == 8) {
            // x, y and z
            if (((angleY == 0 || angleY == 360) &&
                    (angleX == 0 || angleX == 360) &&
                    (angleZ == 0 || angleZ == 360))) {
                text = "correct";
            } else {
                text = "incorrect";
            }
        } else if (shape == 9) {
            // x, y and z
            if (((angleY == 0 || angleY == 360 || angleY == 180) &&
                    (angleX == 0 || angleX == 360) &&
                    (angleZ == 0 || angleZ == 360))) {
                text = "correct";
            } else {
                text = "incorrect";
            }
        } else {
            text = "incorrect";
        }
        return text;
    }
	
	
}
